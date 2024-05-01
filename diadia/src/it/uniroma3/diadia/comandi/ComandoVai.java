package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{

	private String direzione;
	private final static String NOME = "vai";
	private IO io;


	public void comandoVai(String direzione) {
		this.direzione = direzione;
	}

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub

		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza stanzaProssima = null;
		
		//caso direzione non immessa
		if(this.direzione == null) {
			io.mostraMessaggio("dove vuoi adare?   non mi hai dato la direzione!");
			return;
		}
		
		//caso della stanza non esistente nella direzione data
		
		stanzaProssima = stanzaCorrente.getStanzaAdiacente(direzione);
		
		if(stanzaProssima == null) {
			io.mostraMessaggio("direzione inesistente");
			return;
		}
		
		//caso dello spostamento
		
		partita.setStanzaCorrente(stanzaProssima);
		io.mostraMessaggio(partita.getStanzaCorrente().toString());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1); //diminuisoi cfu
		

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.direzione = parametro;
	}

	public  String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.direzione;
	}

	public IO getIo() {
		return io;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}
	
	
	



}
