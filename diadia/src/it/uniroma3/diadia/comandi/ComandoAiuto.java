package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	static final public String[] ELENCO_COMANDI = {"vai", "aiuto", "fine","prendi","posa","guarda"};
	private IO io;
	private final static String NOME = "aiuto";




	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub

		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			this.io.mostraMessaggio(ELENCO_COMANDI[i]+" ");
		this.io.mostraMessaggio("");
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

	public void setIo(IO io) {
		this.io = io;
	}
}
