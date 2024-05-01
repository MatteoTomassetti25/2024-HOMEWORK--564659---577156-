package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {

	Stanza stanzaCorrente = new Stanza("test");
	Attrezzo spada = new Attrezzo("spada", 5);
	Attrezzo laser = new Attrezzo("laser", 10);
	Comando comando = new ComandoPrendi();
	Partita partita = new Partita();
	Borsa borsa = new Borsa(); 
	IO io = new IOConsole();
	
	@Before
	public void setUp() {
		comando.setIo(io);
	}
	
	
	@Test
	public void TestComandoPrendi_oggetto_nullo() {
		comando.setParametro("nullo");
		partita.setStanzaCorrente(stanzaCorrente);
		partita.getGiocatore().setBorsa(borsa);
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("nullo"));
	}
	
	@Test
	public void TestComandoPrendi_nomeDiverso() {
		comando.setParametro("nullo");
		//partita.setStanzaCorrente(stanzaCorrente);
		//partita.getGiocatore().setBorsa(borsa);
		partita.setStanzaCorrente(stanzaCorrente);
		partita.getStanzaCorrente().addAttrezzo(spada);
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("nullo"));
	}
	
	@Test
	public void TestComandoPrendi() {
		comando.setParametro(spada.getNome());
		partita.getStanzaCorrente().addAttrezzo(spada);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(spada.getNome()));
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(spada.getNome()));
	}

}
