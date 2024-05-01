package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {

	Stanza stanzaCorrente = new Stanza("test");
	Attrezzo spada = new Attrezzo("spada", 5);
	Attrezzo laser = new Attrezzo("laser", 10);
	Partita partita = new Partita();
	Comando comando = new ComandoPosa();
	IO io = new IOConsole();
	
	@Before
	public void setUp() {
		comando.setIo(io);
	}
	
	
	@Test
	public void TestComandoPosa_oggettoNullo() {
		
		comando.setParametro("spada");
		comando.esegui(partita);
		assertNull(partita.getStanzaCorrente().getAttrezzo("nullo"));
	}
	
	@Test
	public void TestComandoPosa_oggettoNomeDiverso() {
		
		comando.setParametro("spada");
		partita.getGiocatore().getBorsa().addAttrezzo(laser);
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("spada"));
	}
	
	
	@Test
	public void TestComandoPosa() {
		
		comando.setParametro(spada.getNome());
		partita.getGiocatore().getBorsa().addAttrezzo(spada);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(spada.getNome()));
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(spada.getNome()));
	}
	

}
