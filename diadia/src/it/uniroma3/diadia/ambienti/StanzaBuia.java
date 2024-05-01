package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String attrezzoSpeciale;

	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoSpeciale = attrezzo;
	}


	@Override
	public String getDescrizione() {

		if(hasAttrezzo(attrezzoSpeciale)) {
			return super.toString();
		}

		return this.toString();

	}

	@Override
	public String toString() {
		return "qui c'è buio pesto";
	}
}
