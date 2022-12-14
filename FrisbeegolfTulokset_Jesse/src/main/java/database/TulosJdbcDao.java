package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tulokset;

public class TulosJdbcDao implements TulosDao{

	@Override
	public List<Tulokset> findAll() {
		Connection connection = null; // tietokantayhteys
		PreparedStatement statement = null; // sql-lause
		ResultSet resultset = null; // select-lauseen tulostaulu
		List<Tulokset> tuloksetLista = new ArrayList<Tulokset>(); // tyhjä tuloslista
		Tulokset tulos = null;
		
		try {
			// Yhteyden luominen
			connection = Database.getDBConnection();
			
			// Luodaan komento, jolla haetaan kaikki rivit tulos taulusta
			String sqlSelect = "SELECT id, paiva, UPPER (rata) as rata, tuuli, tulos FROM tulos ORDER By paiva DESC; ";
			
			// VAlmistellaan komento:
			statement = connection.prepareStatement(sqlSelect);
			
			// Lähetetään SELECt-komento tietokantapalvelimelle suoritettavaksi
			resultset = statement.executeQuery();

			// Käydään tulostaulu rivi riviltä läpi ja  luetaan readTulos()-metodilla			
		while (resultset.next()) {
			tulos = readTulos(resultset);
			
			tuloksetLista.add(tulos);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Database.closeDBConnection(resultset, statement, connection);
		}
	
		return tuloksetLista;
	}

	private Tulokset readTulos(ResultSet resultset) {
		// Haetaan yhden asiakkaan tiedot tulostaulun aktiiviselta tietoriviltä
		try {
			int id = resultset.getInt("id");
			Date paiva = resultset.getDate("paiva");
			String rata = resultset.getString("rata");
			String tuuli = resultset.getString("tuuli");
			int tulos = resultset.getInt("tulos");
			
			// Luodaan ja palautetaan uusi tulos
			return new Tulokset(id, paiva, rata, tuuli, tulos);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean addTulos(Tulokset tulos) {
		Connection connection = null;
		PreparedStatement stmInsert = null;
		boolean updateSuccessed = false;
		
		try {
			// Luodaan yhteys tietokantaan
			connection = Database.getDBConnection();
			// Luodaan komento, joka luo uuden tuloksen tietokannan tauluun
			String sqlInsert = "INSERT INTO tulos (paiva, rata, tuuli, tulos) VALUES (?, ?, ?, ?);";
			// Valmistellaan komento
			stmInsert = connection.prepareStatement(sqlInsert);
			// Asetetaan pareametrisoidun komennon parametrit yksi kerrallaan
			// ID generoituu automaattisesti, joten sitä ei ole insertissä
			stmInsert.setDate(1, tulos.getPaiva());
			stmInsert.setString(2, tulos.getRata());
			stmInsert.setString(3, tulos.getTuuli());
			stmInsert.setInt(4, tulos.getTulos());
			// Lähetetään komento suoritettavaksi
			int rowAffected = stmInsert.executeUpdate();
			if (rowAffected == 1) updateSuccessed = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeDBConnection(stmInsert, connection);
		}
		return updateSuccessed;
	}

	@Override
	public boolean removeTulos(int id) {
		Connection connection = null;
		PreparedStatement stmDelete = null;
		boolean updateSuccessed = false;
		
		try {
			// Luodaan tietokantayhteys
			connection = Database.getDBConnection();
			// Komento, jolla poistetaan tulos tietokannasta
			String sqlDelete = "DELETE FROM tulos WHERE id = ?;";
			stmDelete = connection.prepareStatement(sqlDelete);
			// ASetetaan parametrisoidun delete-komennon parametri
			stmDelete.setInt(1, id);
			// Lähetetään komento suoritetavaksi tietokantaan
			int rowAffected = stmDelete.executeUpdate();
			if(rowAffected == 1) updateSuccessed = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeDBConnection(stmDelete, connection);
		}
		return updateSuccessed;
	}

	@Override
	public List<Tulokset> findById(int id) {
		Connection connection = null;
		PreparedStatement stmUpdate = null;
		ResultSet resultset = null;
		List<Tulokset> foundTulos = new ArrayList<Tulokset>();
		Tulokset tulos = null;
		try {
			// Luodaan yhteys tietokantaan
			connection = Database.getDBConnection();
			// Komento jolla etsitään tulos tietokannasta
			String sqlUpdate = "SELECT * FROM tulos WHERE id = ?";
			stmUpdate = connection.prepareStatement(sqlUpdate);
			stmUpdate.setInt(1, id);
			// Lähetetään komento suoritettavaksi tietokantaan
			resultset = stmUpdate.executeQuery();
			
			while (resultset.next()) {
				tulos = readTulos(resultset);
				
				foundTulos.add(tulos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeDBConnection(stmUpdate, connection);
		}
		return foundTulos;

	}
	public boolean updateTulos(Tulokset tulos) {
		Connection connection = null;
		PreparedStatement stmUpdate = null;
		boolean updateSuccessed = false;
		
		
		try {
			// Luodaan yhteys tietokantaan
			connection = Database.getDBConnection();
			// Luodaan komento, joka luo uuden tuloksen tietokannan tauluun
			String sqlInsert = "UPDATE tulos SET paiva = ?, rata = ?, tuuli = ?, tulos = ? WHERE id=?";
			// Valmistellaan komento
			stmUpdate = connection.prepareStatement(sqlInsert);
			// Asetetaan pareametrisoidun komennon parametrit yksi kerrallaan
			// ID generoituu automaattisesti, joten sitä ei ole insertissä
			stmUpdate.setDate(1, tulos.getPaiva());
			stmUpdate.setString(2, tulos.getRata());
			stmUpdate.setString(3, tulos.getTuuli());
			stmUpdate.setInt(4, tulos.getTulos());
			stmUpdate.setInt(5, tulos.getId());
			// Lähetetään komento suoritettavaksi
			int rowAffected = stmUpdate.executeUpdate();
			if (rowAffected == 1) updateSuccessed = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updateSuccessed;
	}
		
}
