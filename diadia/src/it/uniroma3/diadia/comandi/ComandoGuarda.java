package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoGuarda implements Comando{
	
	private Stanza stanzaCorrente;
	
	private final static String NOME = "guarda";
	
	private IO io;

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		
		stanzaCorrente = partita.getStanzaCorrente();
		
		if(stanzaCorrente != null) {
			io.mostraMessaggio(partita.getStanzaCorrente().toString());
			io.mostraMessaggio(partita.getGiocatore().toString());
		}
		else {
			io.mostraMessaggio("Qualcosa non va la stanza corrente è nulla");
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	public  String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	public IO getIo() {
		return io;
	}

	public void setIo(IO io) {
		this.io = io;
	}
	
	

}
