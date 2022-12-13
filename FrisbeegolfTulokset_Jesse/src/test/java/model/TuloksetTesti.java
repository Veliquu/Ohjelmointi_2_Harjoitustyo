package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.Date;

class TuloksetTesti {
		// Testataan hetPaiva()-metodia
		@Test
		public void getKelovllinenPaiva() {
			Tulokset tulokset = new Tulokset();
			String kelvollinenPaiva = "2022-10-25";
			Date paiva = java.sql.Date.valueOf(kelvollinenPaiva);
			tulokset.setPaiva(paiva);
			assertEquals(java.sql.Date.valueOf("2022-10-25"), tulokset.getPaiva());
		}
		
		// Testataan setTulos()-metosia
		@Test
		public void setKelvollinenTulos() {
			Tulokset tulokset = new Tulokset();
			tulokset.setTulos(6);
			assertEquals(6, tulokset.getTulos());
		}
		// TEstataan setRata()-metodia
		@Test
		public void setKelvollinenRata() {
			Tulokset tulos = new Tulokset();
			tulos.setRata("Malminniitty");
			assertEquals("Malminniitty", tulos.getRata());
		}

	}

