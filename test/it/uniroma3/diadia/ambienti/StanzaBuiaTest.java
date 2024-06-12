package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	Stanza s1 = new StanzaBuia("testBuia", "lanterna");
	Attrezzo lanterna = new Attrezzo("lanterna", 3);
	
	
	@Test
	public void TestStanzaBuia_noSpeciale() {
		
		assertEquals("qui c'è buio pesto", s1.getDescrizione());
		
	}
	
	@Test
	public void TestStanzaBuia_siSpaciale() {
		s1.addAttrezzo(lanterna);
		assertNotEquals("qui c'è buio pesto", s1.getDescrizione());
		
	}
	
	
}
