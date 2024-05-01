package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private String nomeAttrezzo;
	private final static String NOME = "posa";
	private IO io;

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);

		if(a!=null && partita.getStanzaCorrente().getNumeroAttrezzi()<10) {
			
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			
		}
		else {
			io.mostraMessaggio("Non c'e' spazio nella stanza per poter inserire questo attrezzo o inesistente!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
		this.nomeAttrezzo = parametro;
	}

	public  String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

	public IO getIo() {
		return io;
	}

	public void setIo(IO io) {
		this.io = io;
	}
	
	

}
