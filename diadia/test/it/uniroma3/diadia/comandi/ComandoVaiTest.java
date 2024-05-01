package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoVaiTest {

	Partita partita = new Partita();
	Stanza stanzaCorrente = new Stanza("test");
	Stanza stanzaAdiacente = new Stanza("test adiacente");
	Comando comando = new ComandoVai();
	IO io = new IOConsole();


	@Before
	public void setUP() {
		comando.setIo(io);
	}


	@Test
	public void TestComandoVai_direzione_nulla() {

		partita.setStanzaCorrente(stanzaCorrente);

		this.comando.esegui(partita);

		assertEquals("test", partita.getStanzaCorrente().getNome());
	}


	@Test
	public void TestComandoVai_stanzaNulla() {

		this.comando.setParametro("est");
		partita.setStanzaCorrente(stanzaCorrente);

		this.comando.esegui(partita);
		assertEquals("test", partita.getStanzaCorrente().getNome());

	}

	@Test
	public void TestComandoVai() {

		this.comando.setParametro("est");
		partita.setStanzaCorrente(stanzaCorrente);
		partita.getStanzaCorrente().impostaStanzaAdiacente("est", stanzaAdiacente);

		this.comando.esegui(partita);
		assertEquals("test adiacente", partita.getStanzaCorrente().getNome());

	}


}
