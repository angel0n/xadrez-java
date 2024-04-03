package game.movimentacao;

public class Jogada {
	private Posicao posicaoInicial;
	private Posicao posicaoFinal;
	
	public Jogada(Posicao posicaoInicial, Posicao posicaoFinal) {
		this.setPosicaoInicial(posicaoInicial);
		this.setPosicaoFinal(posicaoFinal);
	}

	public Posicao getPosicaoInicial() {
		return posicaoInicial;
	}

	public void setPosicaoInicial(Posicao posicaoInicial) {
		this.posicaoInicial = posicaoInicial;
	}

	public Posicao getPosicaoFinal() {
		return posicaoFinal;
	}

	public void setPosicaoFinal(Posicao posicaoFinal) {
		this.posicaoFinal = posicaoFinal;
	}
	
	@Override
	public String toString() {
		return "(" + this.posicaoInicial.getLinha() + "," + this.posicaoInicial.getColuna() + ") (" + this.posicaoFinal.getLinha() + "," + this.posicaoFinal.getColuna() + ")";
	}
}
