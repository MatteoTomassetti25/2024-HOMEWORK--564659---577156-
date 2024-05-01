package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private String attrezzoSpeciale;

	public StanzaBloccata(String nome, String direzione, String attrezzo) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoSpeciale = attrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
	
		if(direzioneBloccata.equals(direzione) && !hasAttrezzo(attrezzoSpeciale)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);

	}


	@Override
	public String getDescrizione() {
		if(hasAttrezzo(attrezzoSpeciale)) {
			return super.toString();
		}
		return toString();
	}


	@Override
	public String toString() {
		return "direzione bloccata";
	}
}
