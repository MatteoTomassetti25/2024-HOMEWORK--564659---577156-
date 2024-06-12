package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	StanzaMagica s1 = new StanzaMagica("testMagica", 1);
	Attrezzo spada = new Attrezzo("spada", 4);
	Attrezzo laser = new Attrezzo("laser", 1);
	
	
	@Test
	public void TestComportamentoMagico_sottoSoglia() {
		s1.addAttrezzo(spada);
		assertTrue(s1.hasAttrezzo(spada.getNome()));
	}
	
	@Test
	public void TestComprtamentoMagico_sopraSoglia() {
		s1.addAttrezzo(spada);
		assertTrue(s1.hasAttrezzo(spada.getNome()));
		s1.addAttrezzo(laser);
		assertFalse(s1.hasAttrezzo(laser.getNome()));
	}

}
