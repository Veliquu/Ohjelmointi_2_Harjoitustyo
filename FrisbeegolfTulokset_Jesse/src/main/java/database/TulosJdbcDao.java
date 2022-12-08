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
			String sqlSelect = "SELECT id, paiva, UPPER (rata) as rata, tuuli, tulos FROM tulos; ";
			
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTulos(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTulos(Tulokset tulos) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
