/*
 * M: La classe Stanza rappresenta una stanza in un gioco di ruolo. Una stanza è un luogo fisico nel gioco, collegato ad altre stanze attraverso delle uscite. Ogni uscita è associata a una direzione.

    NUMERO_MASSIMO_DIREZIONI, NUMERO_MASSIMO_ATTREZZI: Queste sono costanti statiche che rappresentano rispettivamente il numero massimo di direzioni e il numero massimo di attrezzi che una stanza può contenere.

    nome, attrezzi, numeroAttrezzi, stanzeAdiacenti, numeroStanzeAdiacenti, direzioni: Questi sono i campi privati che rappresentano rispettivamente il nome della stanza, l’array degli attrezzi nella stanza, il numero corrente di attrezzi nella stanza, l’array delle stanze adiacenti, il numero corrente di stanze adiacenti, e l’array delle direzioni delle stanze adiacenti.

    Stanza(String nome): Questo è il costruttore della classe. Prende una stringa come input per il nome della stanza, inizializza il nome della stanza, imposta il numero di stanze adiacenti e il numero di attrezzi a zero, e inizializza gli array delle direzioni, delle stanze adiacenti, e degli attrezzi.

    impostaStanzaAdiacente(String direzione, Stanza stanza): Questo metodo imposta una stanza adiacente in una certa direzione. Se la direzione esiste già, aggiorna la stanza adiacente in quella direzione. Altrimenti, se il numero di stanze adiacenti è inferiore al numero massimo di direzioni, aggiunge la nuova direzione e la stanza adiacente.

    getStanzaAdiacente(String direzione): Questo metodo restituisce la stanza adiacente in una certa direzione.

    getNome(), getDescrizione(), getAttrezzi(): Questi sono metodi getter per il nome della stanza, la descrizione della stanza, e gli attrezzi nella stanza.

    addAttrezzo(Attrezzo attrezzo): Questo metodo aggiunge un attrezzo alla stanza. Se il numero di attrezzi è inferiore al numero massimo di attrezzi, aggiunge l’attrezzo e incrementa il numero di attrezzi.

    toString(): Questo metodo restituisce una rappresentazione stringa della stanza, includendo il nome della stanza, le uscite, e gli attrezzi contenuti nella stanza.

 */
package it.uniroma3.diadia.ambienti;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Map<String,Attrezzo> nome2attrezzi;
	private int numeroAttrezzi;
	private Map<String, Stanza> direzioni2stanze;
	private int numeroStanzeAdiacenti;
//	private Set<String> direzioni;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
//		this.direzioni = new HashSet<String>();
		this.direzioni2stanze = new HashMap<String, Stanza>();
		this.nome2attrezzi = new HashMap<String,Attrezzo>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean aggiornato = false;
		if (this.direzioni2stanze.containsKey(direzione)) {
			this.direzioni2stanze.put(direzione, stanza);
			aggiornato = true;
		}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni2stanze.put(direzione, stanza);
				this.numeroStanzeAdiacenti++;
			}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		if (this.direzioni2stanze.containsKey(direzione))
			stanza = this.direzioni2stanze.get(direzione);
		return stanza;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Collection<Attrezzo> getAttrezzi() {
		return this.nome2attrezzi.values();
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!=null && this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.nome2attrezzi.put(attrezzo.getNome(),attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		risultato.append(this.getDirezioni().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.getAttrezzi().toString());
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.nome2attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if (this.nome2attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.nome2attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null) {
			this.nome2attrezzi.remove(attrezzo.getNome(), attrezzo);
			this.numeroAttrezzi--;

			return true;
		}

		return false;
	}

	public Set<String> getDirezioni() {
		return this.direzioni2stanze.keySet();
	}

	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}

	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}


	@Override
	public boolean equals(Object o) {
		Stanza that = (Stanza)o;
		return this.getNome().equals(that.getNome());
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}



}