package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	
	private String parametro;
	private final static String NOME = "non valido";
	private IO io;

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		
		
			io.mostraMessaggio("Non hai inserito nessun comando valido");
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
		this.parametro = parametro;
		
	}

	public  String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.parametro;
	}

	public IO getIo() {
		return io;
	}

	public void setIo(IO io) {
		this.io = io;
	}
	
	

}
