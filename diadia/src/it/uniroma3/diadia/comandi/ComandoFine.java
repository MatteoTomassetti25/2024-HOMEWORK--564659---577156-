package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	private final static String NOME = "fine";
	private IO io;

	

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		
		partita.setFinita();
		io.mostraMessaggio("Grazie di aver giocato!");
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
	
	public String getNome() {
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
