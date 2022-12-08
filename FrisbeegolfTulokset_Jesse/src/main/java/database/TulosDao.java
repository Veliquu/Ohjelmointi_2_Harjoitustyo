package database;

import java.util.List;

import model.Tulokset;

public interface TulosDao {
	
	public List<Tulokset> findAll(); // Haetaan kaikki tulokset tietokannasta listaksi
	
	public boolean updateTulos(Tulokset tulos); // Päivittää tuloksen tiedot
	
	public boolean addTulos(Tulokset tulos); // Lisätään tulos teitokantaan
	
	public boolean removeTulos(int id); // Poistetaan tulos tietokannasta
	
}
