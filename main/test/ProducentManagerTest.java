package main.test;

import static org.junit.Assert.*;
import java.util.List;


import org.junit.Test;

import main.domain.Producent;
import main.sevice.ProducentManager;

public class ProducentManagerTest {
	ProducentManager producentManager = new ProducentManager();
	
	//dane przykladowe
	private final static String przedsiebiorstwo_1 = "Firma Jamtom";
	private final static int znizka_1 = 20;
	private final static float kwotazamowienia_1 = 26900.99F;
	
	private final static String przedsiebiorstwo_2 = "La Rive";
	private final static int znizka_2 = 30;
	private final static float kwotazamowienia_2 = 7876.99F;
	

	@Test
	public void testAddProducent() { //testowanie dodawania 
		Producent producent = new Producent(przedsiebiorstwo_1, znizka_1, kwotazamowienia_1);
		
		producentManager.deleteAllProducentStmt(); // czyszczenie bazy
		assertEquals(1,producentManager.addProducent(producent)); // dodanie do bazy i spr czy zwroci true
		
		List<Producent> prod = producentManager.getAllProducent(); // pusta lista producentow
		Producent producentRetrieved = prod.get(0); // pobranie pierwszego z listy 
		
		assertEquals(przedsiebiorstwo_1, producentRetrieved.getPrzedsiebiorstwo()); //spr czy jest ok
		assertEquals(znizka_1, producentRetrieved.getZnizka());
	}

	@Test
	public void testDeleteAllProducentStmt() {
		Producent producent = new Producent(przedsiebiorstwo_1, znizka_1, kwotazamowienia_1);
		
		producentManager.addProducent(producent); // dodajemy do bazy
		producentManager.deleteAllProducentStmt(); // usuwamy wszystko 
		List<Producent> prodss = producentManager.getAllProducent(); // tworzymy liste
		assertEquals(0,prodss.size()); // spr czy lista jest pusta 
	}

	@Test
	public void testGetAllProducent() {
		producentManager.deleteAllProducentStmt();
		Producent producent = new Producent(przedsiebiorstwo_1, znizka_1, kwotazamowienia_1);
		Producent producent2 = new Producent(przedsiebiorstwo_2, znizka_2, kwotazamowienia_2);
				
		producentManager.addProducent(producent); // 9 razy dodajemy
		producentManager.addProducent(producent);
		producentManager.addProducent(producent);
		producentManager.addProducent(producent);
		producentManager.addProducent(producent);
		producentManager.addProducent(producent);
		producentManager.addProducent(producent);
		producentManager.addProducent(producent);
		producentManager.addProducent(producent);
		
		List<Producent> prod = producentManager.getAllProducent(); // lista 9 elem
		assertEquals(9,prod.size());
		producentManager.deleteAllProducentStmt();
		producentManager.addProducent(producent);
		producentManager.addProducent(producent2);
	}

}
