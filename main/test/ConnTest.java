package main.test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.sevice.Conn;

public class ConnTest {
	Conn connManager = new Conn();
	@Test
	public void test() {
		assertNotNull(connManager.getConnection());
	}

}
