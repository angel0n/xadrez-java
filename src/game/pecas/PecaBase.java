package game.pecas;

import java.util.ArrayList;
import java.util.List;

import game.enums.Jogadores;
import game.enums.Pecas;
import game.movimentacao.Jogada;
import game.movimentacao.Posicao;

public class PecaBase {
	private Pecas peca;
	private Jogadores jogador;
	private Posicao posicao;
	
	public PecaBase(Pecas peca, Jogadores jogador, Posicao posicao) {
		this.setJogador(jogador);
		this.setPeca(peca);
		this.posicao = posicao;
	}
	
	public List<Jogada> obterJogadasPossiveis(List<List<PecaBase>> tabuleiro){
		return new ArrayList<Jogada>();
	}
	
	public String getNome() {
		return this.getPeca().getNome();
	}

	public Pecas getPeca() {
		return peca;
	}

	public void setPeca(Pecas peca) {
		this.peca = peca;
	}

	public Jogadores getJogador() {
		return jogador;
	}

	public void setJogador(Jogadores jogador) {
		this.jogador = jogador;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
}
