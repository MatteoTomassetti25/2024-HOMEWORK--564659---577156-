package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	Borsa b = new Borsa();
	Borsa b1 = new Borsa();
	Attrezzo a = new Attrezzo("spada", 5);
	Attrezzo c = new Attrezzo("cannone", 20);
	Attrezzo d = new Attrezzo("bastone", 2);
	Attrezzo piombo = new Attrezzo("piombo", 10);
	Attrezzo ps = new Attrezzo("ps", 5);
	Attrezzo piuma = new Attrezzo("piuma", 1);
	Attrezzo libro = new Attrezzo("libro", 5);
	Attrezzo falce = new Attrezzo("falce", 4);
	
	public boolean controllaliste(List<?> l1, List<?> l2){
		if(l1.size()!=l2.size())
			return false;
		for(int i=0; i<l1.size();i++) {
			if(!l1.get(i).equals(l2.get(i)))
				return false;
		}
		return true;
	}



	@Test
	public void TestAddAttrezzoMinoreDiPesoMax() {
		assertTrue(b.addAttrezzo(a));
	}

	@Test
	public void TestAddAttrezzoMaggioreDiPesoMax() {
		assertFalse(b.addAttrezzo(c));
	}

	@Test
	public void TestAddAttrezzo_piuAttrezzi() {
		assertTrue(b.addAttrezzo(a));
		assertTrue(b.addAttrezzo(d));
		assertTrue(b.hasAttrezzo(a.getNome()));
		assertTrue(b.hasAttrezzo(d.getNome()));
	}

	@Test
	public void TestGetAttrezzo() {
		b.addAttrezzo(a);
		assertEquals(a, b.getAttrezzo("spada"));
	}

	@Test
	public void TestGetAttrezzo_vuoto() {
		assertNull(b.getAttrezzo("spada"));
	}

	@Test
	public void TestGetAttrezzo_Attrezzo_non_presente() {
		b.addAttrezzo(a);
		assertNull(b.getAttrezzo("vuoto"));
	}

	@Test
	public void TestGetPeso() {
		b.addAttrezzo(a);
		assertEquals(5, b.getPeso());
	}

	@Test
	public void TestIsEmpty() {
		assertTrue(b.isEmpty());
	}

	@Test
	public void TestIsEmpty_borsa_non_vuota() {
		b.addAttrezzo(a);
		assertFalse(b.isEmpty());
	}

	@Test
	public void TestRemoveAttrezzo() {
		b.addAttrezzo(a);
		b.removeAttrezzo(a.getNome());
		assertTrue(b.isEmpty());
	}
	@Test
	public void TestRemoveAttrezzo_piuAttrezzi(){
		b.addAttrezzo(a);
		b.addAttrezzo(d);
		b.removeAttrezzo(a.getNome());
		assertFalse(b.isEmpty());
		assertFalse(b.hasAttrezzo(a.getNome()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		b1.addAttrezzo(ps);
		b1.addAttrezzo(libro);
		List<Attrezzo> ex = new ArrayList<>();
		ex.add(libro);
		ex.add(ps);
		assertTrue(this.controllaliste(ex, b1.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoDiversoPeso() {
		b1.addAttrezzo(piuma);
		b1.addAttrezzo(libro);
		List<Attrezzo> ex = new ArrayList<>();
		ex.add(piuma);
		ex.add(libro);
		assertTrue(this.controllaliste(ex, b1.getContenutoOrdinatoPerPeso()));
	}
	
	
	public boolean controllaSet(Set<Attrezzo> m1, Set<Attrezzo> m2) {
		if(m1.size()!=m2.size())
			return false;
		Iterator<Attrezzo> iter1 = m1.iterator();
		Iterator<Attrezzo> iter2 = m2.iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!iter1.next().equals(iter2.next()))
				return false;
		}
		return true;
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomeStessoPeso() {
		b1.addAttrezzo(ps);
		b1.addAttrezzo(libro);

		Set<Attrezzo> e = new TreeSet<>();
		e.add(libro);
		e.add(ps);
		assertTrue(this.controllaSet(e, b1.getContenutoOrdinatoPerNome()));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomePesoDiverso() {
		b1.addAttrezzo(libro);
		b1.addAttrezzo(piuma);

		Set<Attrezzo> e = new TreeSet<>();
		e.add(libro);
		e.add(piuma);
		
		assertTrue(this.controllaSet(e, b1.getContenutoOrdinatoPerNome()));
	}
	
	public boolean controllaMap(Map<Integer, Set<Attrezzo>> m1, Map<Integer, Set<Attrezzo>> m2) {
		if(m1.size()!=m2.size())
			return false;
		
		Iterator<Integer> iter1 = m1.keySet().iterator();
		Iterator<Integer> iter2 = m2.keySet().iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!this.controllaSet(m1.get(iter1.next()), m2.get(iter2.next()))) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiSingleton() {
		b1.addAttrezzo(piuma);
		b1.addAttrezzo(libro);

		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> sing1 = new TreeSet<>();
		Set<Attrezzo> sing2 = new TreeSet<>();
		
		sing1.add(piuma);
		sing2.add(libro);
		
		e.put(2, sing1);
		e.put(3, sing2);
		
		System.out.println(e);
		System.out.println(b1.getContenutoRaggruppatoPerPeso());
		assertTrue(this.controllaMap(e, b1.getContenutoRaggruppatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiGruppi() {
		b1.addAttrezzo(piuma);
		b1.addAttrezzo(libro);
		b1.addAttrezzo(piombo);
		b1.addAttrezzo(falce);

		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> sing1 = new HashSet<>();
		Set<Attrezzo> sing2 = new HashSet<>();
		
		sing1.add(piuma);
		sing2.add(libro);
		sing2.add(piombo);
		sing1.add(falce);
		
		e.put(2, sing1);
		e.put(3, sing2);
		
		System.out.println(e);
		System.out.println(b1.getContenutoRaggruppatoPerPeso());
		assertFalse(this.controllaMap(e, b1.getContenutoRaggruppatoPerPeso()));
	}

	
}
