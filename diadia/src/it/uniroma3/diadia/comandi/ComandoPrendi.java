package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	private String nomeAttrezzo;
	private final static String NOME = "prendi";
	private IO io;

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if( a!=null && partita.getGiocatore().getBorsa().getPeso()+a.getPeso()<10) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(a);
		} 
		else {
			io.mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa o inesistente!");
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
