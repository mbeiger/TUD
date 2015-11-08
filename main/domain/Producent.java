package main.domain;

public class Producent {
	private int idProducent;
	private String przedsiebiorstwo;
	private int znizka;
	private float kwotazamowienia;
	
	public Producent() {
		super();
	}

	
	public Producent(String przedsiebiorstwo, int znizka, float kwotazamowienia) {
		super();
		this.przedsiebiorstwo = przedsiebiorstwo;
		this.znizka = znizka;
		this.kwotazamowienia = kwotazamowienia;
	}
	
	public Producent(int idProducent, String przedsiebiorstwo, int znizka, float kwotazamowienia) {
		super();
		this.idProducent = idProducent;
		this.przedsiebiorstwo = przedsiebiorstwo;
		this.znizka = znizka;
		this.kwotazamowienia = kwotazamowienia;
	}

	public int getIdProducent() {
		return idProducent;
	}

	public void setIdProducent(int idProducent) {
		this.idProducent = idProducent;
	}

	public String getPrzedsiebiorstwo() {
		return przedsiebiorstwo;
	}

	public void setPrzedsiebiorstwo(String przedsiebiorstwo) {
		this.przedsiebiorstwo = przedsiebiorstwo;
	}

	public int getZnizka() {
		return znizka;
	}

	public void setZnizka(int znizka) {
		this.znizka = znizka;
	}

	public float getKwotaZamowienia() {
		return kwotazamowienia;
	}

	public void setKwotaZamowienia(float kwotazamowienia) {
		this.kwotazamowienia = kwotazamowienia;
	}
}
