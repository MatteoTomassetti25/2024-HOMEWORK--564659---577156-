package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePesoAtt;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> nome2attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAttuale;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.nome2attrezzi = new HashMap<String, Attrezzo>(); // speriamo bastino...
		this.numeroAttrezzi = 0;
		this.pesoAttuale = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.nome2attrezzi.put(attrezzo.getNome(), attrezzo);
		this.pesoAttuale+=attrezzo.getPeso();
		this.numeroAttrezzi++;
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo != null && this.nome2attrezzi.containsKey(nomeAttrezzo))
			a = this.nome2attrezzi.get(nomeAttrezzo);
		return a;
	}
	public int getPeso() {
		return this.pesoAttuale;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

		if(nomeAttrezzo!=null){
			a = this.nome2attrezzi.remove(nomeAttrezzo);
			this.numeroAttrezzi--;
		}
			
		return a;
	}
	
	
//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
//		Attrezzo a = null;
//
//		if(nomeAttrezzo!=null){
//			int i = 0;
//			for(Attrezzo att : this.attrezzi) {
//				if(att != null) {
//					if(att.getNome().equals(nomeAttrezzo)) {
//						a = att;
//						this.attrezzi[i] = null;
//						this.numeroAttrezzi--;
//					}
//				}
//				i++;
//
//			}
//		}
//		return a;
//	}
	
//	public Attrezzo removeAttrezzo1(String nome) {
//		if (nome == null) {
//			return null;
//		}
//		for (int ind = 0; ind < this.numeroAttrezzi; ind++) {
//			Attrezzo corrente = attrezzi[ind];
//			if (corrente == null) {
//				continue;
//			}
//			if (corrente.getNome() != null && corrente.getNome().equals(nome)) {
//				Attrezzo eliminato = new Attrezzo(corrente.getNome(), corrente.getPeso());
//				attrezzi[ind] = null;
//				this.numeroAttrezzi--;
//				return eliminato;	
//			}
//		}
//		return null;
//	}
	

	//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
	//		Attrezzo a = null;
	//		if(nomeAttrezzo != null) {
	//			int i=0;
	//			for(Attrezzo elemento : attrezzi) {
	//				if(elemento != null)
	//				if(elemento.getNome().equals(nomeAttrezzo)) {
	//					attrezzi[i]= null;
	//					numeroAttrezzi--;
	//				}i++;
	//			}return a;
	//		}return a;
	//	}

//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
//		Attrezzo attrezzo = null;
//		if(nomeAttrezzo != null) {
//			for(int i =0; i<attrezzi.length; i++) {
//				attrezzo = attrezzi[i];
//				Attrezzo elimina = attrezzi[i];
//				if(attrezzi[i] != null && attrezzi[i].getNome().equals(nomeAttrezzo)) {
//					attrezzi[i] = attrezzi[i+1];
//					numeroAttrezzi--;
//					elimina = null;
//					return attrezzo;
//				}
//
//			}
//		}return attrezzo;
//	}
	
//	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
//		Attrezzo a = null;
//		int i=0;
//
//		// ---> TODO (implementare questo metodo) <---
//		if (isEmpty()) {
//			System.out.println("La borsa è vuota!!!");
//		}	
//		else {
//			a = getAttrezzo(nomeAttrezzo); //mi salvo il riferimento dell'attrezzo qui 
//			//ora devo rimuovere l'attrezzo dalla borsa
//			if (a != null) {
//				//io devo entrare nel while sia quando è null sia quando non è uguale
//				while(attrezzi[i] == null || !attrezzi[i].getNome().equals(a.getNome())) {
//					i++;
//				}
//				this.attrezzi[i] = null;
//				this.numeroAttrezzi--;
//
//			}
//			else 
//				System.out.println("L'attrezzo non c'è!!");
//		}
//
//		return a;
//	}
	

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerPeso().toString());
			s.append("\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	//test matteo
//	public void stampaAttrezzi(){
//		Attrezzo attrezzo;
//		for(int i=0; i<numeroAttrezzi;i++){
//			attrezzo=this.attrezzi[i];
//			if(attrezzo != null){
//				System.out.println("attrezzo nella borsa: "+attrezzo);
//			}
//		}
//	}
	
	public Collection<Attrezzo>  getNomiPesoAttrezzi(){
		return this.nome2attrezzi.values();
	}
	
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> sortedPeso = new ArrayList<Attrezzo>(this.nome2attrezzi.values());
		ComparatorePesoAtt cmp = new ComparatorePesoAtt();
		Collections.sort(sortedPeso,cmp);
		return sortedPeso;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		TreeSet<Attrezzo> sortedNome = new TreeSet<Attrezzo>(this.nome2attrezzi.values());
		return sortedNome;
	}
	
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> att2Peso = new TreeMap<Integer, Set<Attrezzo>>();
		for(Attrezzo a : this.nome2attrezzi.values()){
			if(att2Peso.containsKey(a.getPeso())) {
				att2Peso.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> s = new HashSet<Attrezzo>();
				s.add(a);
				att2Peso.put(a.getPeso(), s);
			}
		}
		
		
		
		return att2Peso;
	}


	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatorePesoAtt cmp =new ComparatorePesoAtt();
		TreeSet<Attrezzo> sortedPeso = new TreeSet<Attrezzo>(cmp);
		
		sortedPeso.addAll(this.nome2attrezzi.values());
		
		return sortedPeso;
	}
	
}