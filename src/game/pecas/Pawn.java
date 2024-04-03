package game.pecas;

import java.util.ArrayList;
import java.util.List;

import game.enums.Jogadores;
import game.enums.Pecas;
import game.movimentacao.Jogada;
import game.movimentacao.Posicao;

public class Pawn extends PecaBase{
	public Pawn(Pecas peca, Jogadores jogador, Posicao posicao) {
		super(peca, jogador, posicao);
	}
	
	@Override
	public List<Jogada> obterJogadasPossiveis(List<List<PecaBase>> tabuleiro) {
		List<Jogada> jogadasPermitidas = new ArrayList<Jogada>();
		
		Jogada avancoNormal = obterAvancosNormais(tabuleiro);
		Jogada avancoDuplo =  obterAvancosDuplos(tabuleiro);
		List<Jogada> capturas = obterCapturas(tabuleiro);
		
		if(avancoNormal != null) jogadasPermitidas.add(avancoNormal);
		if(avancoDuplo != null) jogadasPermitidas.add(avancoDuplo);
		if(capturas.size() > 0 ) jogadasPermitidas.addAll(capturas);
		
		return jogadasPermitidas;
	}
	
	private Jogada obterAvancosNormais(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		
		if(getJogador().equals(Jogadores.BRANCO)) {
			if(linha < 7) {
				if(tabuleiro.get(linha + 1).get(coluna).getPeca().equals(Pecas.EMPTY_HOUSE)) {
					Posicao posicaoDestino = new Posicao(linha + 1, coluna);
					return new Jogada(getPosicao(), posicaoDestino);
				}
			}
		}
		
		if(getJogador().equals(Jogadores.PRETO)) {
			if(linha > 0) {
				if(tabuleiro.get(linha - 1).get(coluna).getPeca().equals(Pecas.EMPTY_HOUSE)) {
					Posicao posicaoDestino = new Posicao(linha - 1, coluna);
					return new Jogada(getPosicao(), posicaoDestino);
				}
			}
		}
		
		return null;
	}
	
	private Jogada obterAvancosDuplos(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		
		if(getJogador().equals(Jogadores.BRANCO)) {
			if(linha == 1) {
				if(tabuleiro.get(linha + 2).get(coluna).getPeca().equals(Pecas.EMPTY_HOUSE)) {
					Posicao posicaoDestino = new Posicao(linha + 2, coluna);
					return new Jogada(getPosicao(), posicaoDestino);
				}
			}
		}
		
		if(getJogador().equals(Jogadores.PRETO)) {
			if(linha == 6) {
				if(tabuleiro.get(linha - 2).get(coluna).getPeca().equals(Pecas.EMPTY_HOUSE)) {
					Posicao posicaoDestino = new Posicao(linha - 2, coluna);
					return new Jogada(getPosicao(), posicaoDestino);
				}
			}
		}
		
		return null;
	}
	
	private List<Jogada> obterCapturas(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		List<Jogada> jogadas = new ArrayList<>();
		
		if(getJogador().equals(Jogadores.BRANCO)) {
			if(linha < 7) {
				if(coluna < 7 ) {
					Pecas pecaCapturadaDireita = tabuleiro.get(linha + 1).get(coluna + 1).getPeca();
					if(pecaCapturadaDireita.getNome().endsWith("B")) {
						Jogada jogada = new Jogada(getPosicao(), new Posicao(linha + 1, coluna + 1));
						jogadas.add(jogada);
					}
				}
				
				if(coluna > 0) {
					Pecas pecaCapturadaEsquerda = tabuleiro.get(linha + 1).get(coluna - 1).getPeca();
					if(pecaCapturadaEsquerda.getNome().endsWith("B")) {
						Jogada jogada = new Jogada(getPosicao(), new Posicao(linha + 1, coluna - 1));
						jogadas.add(jogada);
					}
				}
			}
		}
		
		if(getJogador().equals(Jogadores.PRETO)) {
			if(linha > 0) {
				if(coluna < 7 ) {
					Pecas pecaCapturadaDireita = tabuleiro.get(linha - 1).get(coluna + 1).getPeca();
					if(pecaCapturadaDireita.getNome().endsWith("B")) {
						Jogada jogada = new Jogada(getPosicao(), new Posicao(linha - 1, coluna + 1));
						jogadas.add(jogada);
					}
				}
				
				if(coluna > 0) {
					Pecas pecaCapturadaEsquerda = tabuleiro.get(linha - 1).get(coluna - 1).getPeca();
					if(pecaCapturadaEsquerda.getNome().endsWith("B")) {
						Jogada jogada = new Jogada(getPosicao(), new Posicao(linha - 1, coluna - 1));
						jogadas.add(jogada);
					}
				}
			}
		}
		return jogadas;
	}
	
}
