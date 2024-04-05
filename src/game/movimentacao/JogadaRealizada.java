package game.movimentacao;

import java.util.List;

import game.enums.Pecas;
import game.pecas.PecaBase;

public class JogadaRealizada {
	private Jogada jogada;
	private PecaBase pecaMovida;
	private PecaBase pecaCapturada;
	
	public JogadaRealizada(Jogada jogada, PecaBase pecaMovida, PecaBase pecaCapturada) {
		setJogada(jogada);
		setPecaCapturada(pecaCapturada);
		setPecaMovida(pecaMovida);
	}

	public Jogada getJogada() {
		return jogada;
	}

	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}

	public PecaBase getPecaMovida() {
		return pecaMovida;
	}

	public void setPecaMovida(PecaBase pecaMovida) {
		this.pecaMovida = pecaMovida;
	}

	public PecaBase getPecaCapturada() {
		return pecaCapturada;
	}

	public void setPecaCapturada(PecaBase pecaCapturada) {
		this.pecaCapturada = pecaCapturada;
	}
	
	@Override
	public String toString() {
		List<Character> colunasValidas = List.of('a','b','c','d','e','f','g','h');
		String casaMovida = "" + pecaMovida.getNome().charAt(0) + "" + colunasValidas.get(jogada.getPosicaoInicial().getColuna()) + "" + jogada.getPosicaoInicial().getLinha();
		String acao = pecaCapturada.getPeca().equals(Pecas.EMPTY_HOUSE) ? "->" : "X" + pecaCapturada.getNome().charAt(0); 
		String casaCapturada = colunasValidas.get(jogada.getPosicaoFinal().getColuna()) + "" + jogada.getPosicaoFinal().getLinha();;
		return casaMovida + acao + casaCapturada;
	}

}
