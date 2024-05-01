package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	
	private int contatoreAttrezziPosati; //mostra il numero di attrezzi aggiunti
	private int sogliaMagica;  //numero prima che si attivi la stanza magica
	final static private int SOGLIA_MAGICA_DEFAULT = 3; //soglia di default

	
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.sogliaMagica = soglia;
		this.contatoreAttrezziPosati = 0;
		}
	
	public StanzaMagica(String nome) {
		this(nome,SOGLIA_MAGICA_DEFAULT);
		// TODO Auto-generated constructor stub
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		
		StringBuilder nomeInvertito; //uso stringBuilder perchè è classe modificabile d string
		int pesoX2 = attrezzo.getPeso()*2;
		
		//inverto il nome
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		//restituisco il nuovo attrezzo
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2); 
		
		return attrezzo;
		
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		this.contatoreAttrezziPosati++;
		
		if(this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		
			
		return super.addAttrezzo(attrezzo);
	}

}
