package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	Stanza s1 = new StanzaBloccata("testBuia", "nord", "chiave");
	Stanza sAd = new Stanza("test2");
	Attrezzo chiave = new Attrezzo("chiave", 3);
	
	@Test
	public void TestSanzaBloccata_noSpeciale() {
		s1.impostaStanzaAdiacente("nord", sAd);
		assertEquals(s1.getDescrizione(), s1.getStanzaAdiacente("nord").toString());
		
	}
	
	@Test
	public void TestSanzaBloccata_siSpeciale() {
		s1.impostaStanzaAdiacente("nord", sAd);
		s1.addAttrezzo(chiave);
		assertEquals(sAd.getDescrizione(), s1.getStanzaAdiacente("nord").toString());
		
	}

}
