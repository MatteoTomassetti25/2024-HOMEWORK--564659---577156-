package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Labirinto labirinto;
	Partita p;
	Stanza s;

	@Before
	public void setUp() {
		 labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		 p = new Partita(labirinto);
		 s = new Stanza("Stanza");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLab().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		p.getLab().setStanzaCorrente(s);
		assertEquals(s, p.getLab().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		
		assertFalse(p.isFinita());
	}
	

}
