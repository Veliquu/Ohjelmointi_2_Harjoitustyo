package model;

import java.sql.Date;

public class Tulokset {
	
	private int id;
	private Date date;
	private String rata;
	private String tuuli;
	private int tulos;
	public Tulokset(int id, Date date, String rata, String tuuli, int tulos) {
		super();
		this.id = id;
		this.date = date;
		this.rata = rata;
		this.tuuli = tuuli;
		this.tulos = tulos;
	}
	public Tulokset() {
		super();
		this.id = 0;
		this.date = null;
		this.rata = null;
		this.tuuli = null;
		this.tulos = 0;
	}
	public int getId() {
		return id;
	}
	public Date getDate() {
		return date;
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
	public void setDate(Date date) {
		this.date = date;
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
		return "id = "+ id + ", päiväys =" + date + ", rata = " + rata + ", tuuli = " + tuuli + ", tulos = " + tulos;    
	}
	
	

}
