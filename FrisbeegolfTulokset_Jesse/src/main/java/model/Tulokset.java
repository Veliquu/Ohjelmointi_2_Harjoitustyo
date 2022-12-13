package model;

import java.sql.Date;


public class Tulokset {
	
	private int id;
	private Date paiva;
	private String rata;
	private String tuuli;
	private int tulos;
	public Tulokset(Date paiva, String rata, String tuuli, int tulos) {
		super();
		this.id = 0;
		this.paiva = paiva;
		this.rata = rata;
		this.tuuli = tuuli;
		this.tulos = tulos;
	}
	public Tulokset(int id, Date paiva, String rata, String tuuli, int tulos) {
		super();
		this.id = id;
		this.paiva = paiva;
		this.rata = rata;
		this.tuuli = tuuli;
		this.tulos = tulos;
	}
	public Tulokset() {
		super();
		this.id = 0;
		this.paiva = null;
		this.rata = null;
		this.tuuli = null;
		this.tulos = 0;
	}
	public int getId() {
		return id;
	}
	public Date getPaiva() {
		return paiva;
	}
	public String getRata() {
		return rata;
	}
	public String getTuuli() {
		return tuuli;
	}
	public int getTulos() {
		return tulos;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPaiva(Date paiva) {
		this.paiva = paiva;
	}
	public void setRata(String rata) {
		this.rata = rata;
	}
	public void setTuuli(String tuuli) {
		this.tuuli = tuuli;
	}
	public void setTulos(int tulos) {
		this.tulos = tulos;
	}
	@Override
	public String toString() {
		return "id = "+ id + ", päiväys =" + paiva + ", rata = " + rata + ", tuuli = " + tuuli + ", tulos = " + tulos;    
	}
	
	

}
