package program;

import java.util.List;

import database.TulosDao;
import database.TulosJdbcDao;
import model.Tulokset;

public class KokeiluOhjelma {

	public static void main(String[] args) {
		
		TulosDao tulosdao = new TulosJdbcDao();
		
		List<Tulokset> tuloksetLista = tulosdao.findAll();
		Tulokset tulokset = null;
		for (int i = 0; i < tuloksetLista.size(); i++){
			tulokset = tuloksetLista.get(i);
			System.out.println(tulokset);
		}
	}

}
