package main.domain;

public class Towar {
	private int idTowar;
	private String model;
	private int liczba;
	private float cena;
	private int idProducent;
	private Producent producent;
	
	public Towar(String model, int liczba, float cena, Producent producent) {
		super();
		this.model = model;
		this.liczba = liczba;
		this.cena = cena;
		this.producent = producent;
		this.idProducent = producent.getIdProducent();
	}

	public Producent getProducent() {
		return producent;
	}

	public void setProducent(Producent producent) {
		this.producent = producent;
	}

	public Towar(){
		super();
	}
	
	public Towar(String model, int liczba, float cena, int idProducent) {
		super();
		this.model = model;
		this.liczba = liczba;
		this.cena = cena;
		this.idProducent = idProducent;
	}
	
	public int getIdTowar() {
		return idTowar;
	}
	public void setIdTowar(int idTowar) {
		this.idTowar = idTowar;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getLiczba() {
		return liczba;
	}
	public void setLiczba(int liczba) {
		this.liczba = liczba;
	}
	public float getCena() {
		return cena;
	}
	public void setCena(float cena) {
		this.cena = cena;
	}
	public int getIdProducent() {
		return idProducent;
	}
	public void setIdProducent(int idProducent) {
		this.idProducent = idProducent;
	}

}
