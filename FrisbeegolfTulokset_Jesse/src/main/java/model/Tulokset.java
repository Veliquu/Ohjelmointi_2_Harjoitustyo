package model;

public class Tulokset {
	
	private int id;
	private String date;
	private String rata;
	private double tuuli;
	private int tulos;
	public Tulokset(int id, String date, String rata, double tuuli, int tulos) {
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
		this.tuuli = 0.0;
		this.tulos = 0;
	}
	public int getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public String getRata() {
		return rata;
	}
	public double getTuuli() {
		return tuuli;
	}
	public int getTulos() {
		return tulos;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setRata(String rata) {
		this.rata = rata;
	}
	public void setTuuli(double tuuli) {
		this.tuuli = tuuli;
	}
	public void setTulos(int tulos) {
		this.tulos = tulos;
	}
	@Override
	public String toString() {
		return "Tulokset: id = "+ id + ", päiväys =" + date + ", rata = " + rata + ", tuuli = " + tuuli +  "m/s" + ", tulos = " + tulos;    
	}
	
	

}
