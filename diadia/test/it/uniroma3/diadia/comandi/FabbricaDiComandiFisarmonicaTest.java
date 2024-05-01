package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonicaTest {
	private IO io;
	FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica(io);
	Comando comandoAtteso;
	
	
	@Test
	public void TestComandoNonValido() {
		comandoAtteso = new ComandoNonValido();
		//verifico con un istruzione che non funziona
		assertEquals(comandoAtteso.getNome(), fabbrica.costruisciComando("ciao").getNome());
		
	}
	
	@Test
	public void TestComando_conParametro() {
		comandoAtteso = new ComandoPrendi();
		comandoAtteso.setParametro("spada");
		Comando corrente = fabbrica.costruisciComando("prendi spada");
		//verifico con un istruzione che non funziona
		assertEquals(comandoAtteso.getNome(), corrente.getNome());
		assertEquals(comandoAtteso.getParametro(), corrente.getParametro());
		
	}
	
	@Test
	public void TestComando_senzaParametro() {
		comandoAtteso = new ComandoAiuto();
		assertEquals(comandoAtteso.getNome(), fabbrica.costruisciComando("aiuto").getNome());
		
	}

	
}
