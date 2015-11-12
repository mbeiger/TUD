package main.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;


import main.domain.Producent;
import main.domain.Towar;
import main.sevice.ProducentManager;
import main.sevice.TowarManager;


public class TowarManagerTest {

	TowarManager towarManager = new TowarManager();
	ProducentManager producentManager = new ProducentManager();
	//dane przykladowe
	private final static String model_1 = "Klawiatura";
	private final static int liczba_1 = 3000;
	private final static float cena_1 = 150.00F;

	
	private final static String model_2 = "Konsola";
	private final static int liczba_2 = 200;
	private final static float cena_2 = 800.50F;

	
	private final static String model_3 = "Ekran";
	private final static int liczba_3 = 1200;
	private final static float cena_3 = 850.00F;
	
	
	@Test
	public void testDeleteOneTowar() {
		List<Producent> prod = producentManager.getAllProducent(); //pobieramy wszystkich producentow z bazy
		Producent p1 = prod.get(0); //pobieramy producenta nr 0
		towarManager.deleteAllTowar(); //usuwamy wszystko
		assertEquals(1,towarManager.addTowar(new Towar(model_1,liczba_1,cena_1,p1))); //dodajemy prod nr 1 i nr 3
		assertEquals(1,towarManager.addTowar(new Towar(model_3,liczba_3,cena_3,p1)));

		List<Towar> towar = towarManager.getAllTowar(); //lista wszystkich towarow
		assertEquals(2,towar.size()); // spr czy ma dwa elementy bo tyle dodalismy
		Towar towarFromTable = towar.get(0); // pobieramy elem nr 0
		towarManager.deleteOneTowar(towarFromTable); // usuwamy elem nr 0
		
		List<Towar> towar2 = towarManager.getAllTowar(); // pobieramy wszystkie
		assertEquals(1,towar2.size()); // spr czy mamy tylko jeden element
		towarManager.deleteAllTowar(); // czyscimy baze
		
	}

	@Test
	public void testUpdateOneTowar() {
		towarManager.deleteAllTowar();  //czyscimy baze
		List<Producent> prod = producentManager.getAllProducent(); //pobieramy wszystkich prod z bazy
		Producent p1 = prod.get(0); //pobieramy prod nr 0
		
		Towar towar1 = new Towar(model_1,liczba_1,cena_1,p1); //tworzymy
		Towar towar2 = new Towar(model_2,liczba_2,cena_2,p1);
		towarManager.addTowar(towar1);
		towarManager.addTowar(towar2); // dodajemy do bazy
		List<Towar> towar0 = towarManager.getAllTowar(); // pobieramy towary z bazy
		Towar towarr0 = towar0.get(1); // pobieramy nr 1 towar
		
		towarManager.updateOneTowar(towar1,towarr0); // update robimy
		
		List<Towar> towar = towarManager.getAllTowar(); //pobieramy znowu towary
		Towar towarUnchanged = towar.get(0); 
		Towar towarChanged = towar.get(1);
	
		assertEquals(model_1, towarUnchanged.getModel());
		assertEquals(model_1, towarChanged.getModel()); // porownujemy czy zmieniony model sie zgadza
	}

	@Test
	public void testAddTowar() {
		List<Producent> prod = producentManager.getAllProducent(); //pobieramy wszystkich prod  z bazy
		Producent p1 = prod.get(0); // pobieramy prod nr 0
		towarManager.deleteAllTowar(); //czyszczenie bazy
		assertEquals(1,towarManager.addTowar(new Towar(model_1,liczba_1,cena_1,p1))); // doadajemy towar 
		assertEquals(1,towarManager.addTowar(new Towar(model_2,liczba_2,cena_2,p1)));
		
		List<Towar> towar = towarManager.getAllTowar(); // tworzymy liste 
		Towar towarRetrived = towar.get(0); // pobieramy elem nr 0
	
		assertEquals(model_1, towarRetrived.getModel()); // patrzymy czy model pobrany z bazy=zmienna 
		assertEquals(liczba_1, towarRetrived.getLiczba());
		assertEquals(cena_1, towarRetrived.getCena(), 0.0f);
		assertEquals(p1.getIdProducent(), towarRetrived.getIdProducent()); 
	}

	@Test
	public void testDeleteAllTowar() {
		List<Producent> prod = producentManager.getAllProducent(); // pobieramy wszystich prod z bazy
		Producent p1 = prod.get(0); // pobieramy prod nr 0
		assertEquals(1,towarManager.addTowar(new Towar(model_1,liczba_1,cena_1,p1))); // dodajemy nowy towar
		towarManager.deleteAllTowar(); //czyscimy baze
		List<Towar> towar = towarManager.getAllTowar(); //pobiera elem z bazy
		assertEquals(0,towar.size()); // spr czy pusta
	}

	@Test
	public void testDeleteProducentFromTowar() {
		towarManager.deleteAllTowar(); //czyscimy baze
		List<Producent> prod = producentManager.getAllProducent(); // lista producentow z bazy
		Producent p1 = prod.get(0); // pobiera nr 0 producenta
		Towar towar = new Towar(model_1,liczba_1,cena_1,p1); // definiujemy obiekt nowy towar
		towarManager.addTowar(towar); // do bazy ten towar
		assertEquals(p1.getIdProducent(), towar.getIdProducent()); 
		towarManager.deleteProducentFromTowar(model_1); //ususwamy prod gdzie model = model1
		
		List<Towar> towar1 = towarManager.getAllTowar(); // pobieramy towary z bazy
		Towar towar2 = towar1.get(0); // pobieramy tow 0
		
		assertEquals(0, towar2.getIdProducent());
		towarManager.deleteAllTowar();
	}

	@Test
	public void testGetTowarWithProd() {
		towarManager.deleteAllTowar(); // czyscimy baze
		List<Producent> prod = producentManager.getAllProducent(); // lista producentow
		Producent p1 = prod.get(0); // pobieramy prod nr 0 
		Producent p2 = prod.get(1); // pobieramy prod nr 1
		assertEquals(1,towarManager.addTowar(new Towar(model_1,liczba_1,cena_1,p1))); // patrzymy czy sie dodali
		assertEquals(1,towarManager.addTowar(new Towar(model_2,liczba_2,cena_2,p1)));
		assertEquals(1,towarManager.addTowar(new Towar(model_3,liczba_3,cena_3,p2)));
		
		List<Towar> towar = towarManager.getTowarWithProd("Firma Jamtom"); // pobierz towar o tej nazwie
		assertEquals(2,towar.size()); // spr czy mamy dwa towary z tej samej firmy
		
		List<Towar> towar2 = towarManager.getTowarWithProd("La Rive");
		assertEquals(1,towar2.size());
		towarManager.deleteAllTowar();
	}

	@Test
	public void testGetAllTowar() {
		towarManager.deleteAllTowar(); // czyscimy baze
		List<Producent> prod = producentManager.getAllProducent(); // lista producentow
		Producent p1 = prod.get(0); // pobieramy prod nr 0
		towarManager.deleteAllTowar(); // czyscimy baze znowu
		assertEquals(1,towarManager.addTowar(new Towar(model_3,liczba_3,cena_3,p1))); // spr czy dodali sie
		assertEquals(1,towarManager.addTowar(new Towar(model_1,liczba_1,cena_1,p1)));
		assertEquals(1,towarManager.addTowar(new Towar(model_2,liczba_2,cena_2,p1)));
		assertEquals(1,towarManager.addTowar(new Towar(model_1,liczba_1,cena_1,p1)));
		assertEquals(1,towarManager.addTowar(new Towar(model_2,liczba_2,cena_2,p1)));
		
		List<Towar> towar = towarManager.getAllTowar(); // lista towarow 
		assertEquals(5,towar.size()); // spr czy jest ich tyle ile dodalismy 
		towarManager.deleteAllTowar();
	}

}
