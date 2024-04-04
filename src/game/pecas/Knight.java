package game.pecas;

import java.util.ArrayList;
import java.util.List;

import game.enums.Jogadores;
import game.enums.Pecas;
import game.movimentacao.Jogada;
import game.movimentacao.Posicao;

public class Knight extends PecaBase{

	public Knight(Pecas peca, Jogadores jogador, Posicao posicao) {
		super(peca, jogador, posicao);
	}
	
	@Override
	public List<Jogada> obterJogadasPossiveis(List<List<PecaBase>> tabuleiro) {
		List<Jogada> jogadas = new ArrayList<Jogada>();
		
		List<Jogada> jogadasFrente = obterJogadasFrente(tabuleiro);
		List<Jogada> jogadasTras = obterJogadasTras(tabuleiro);
		List<Jogada> jogadasDireita = obterJogadasDireita(tabuleiro);
		List<Jogada> jogadasEsquerda = obterJogadasEsquerda(tabuleiro);
		
		if(jogadasFrente.size() > 0) jogadas.addAll(jogadasFrente); 
		if(jogadasTras.size() > 0) jogadas.addAll(jogadasTras); 
		if(jogadasDireita.size() > 0) jogadas.addAll(jogadasDireita); 
		if(jogadasEsquerda.size() > 0) jogadas.addAll(jogadasEsquerda); 
		return jogadas;
	}
	
	
	private List<Jogada> obterJogadasFrente(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		if((linha + 2) <= 7) {
			int novaLinha = linha + 2;
			if((coluna + 1) <= 7) {
				int novaColuna = coluna + 1;
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(novaColuna).getPeca();
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, novaColuna));
					jogadas.add(jogada);					
				}
			}
			if((coluna - 1) >= 0) {
				int novaColuna = coluna - 1;
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(novaColuna).getPeca();
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, novaColuna));
					jogadas.add(jogada);					
				}
			}
		}
		return jogadas;
	}
	
	private List<Jogada> obterJogadasTras(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		if((linha - 2) >= 0) {
			int novaLinha = linha - 2;
			if((coluna + 1) <= 7) {
				int novaColuna = coluna + 1;
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(novaColuna).getPeca();
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, novaColuna));
					jogadas.add(jogada);
				}
			}
			if((coluna - 1) >= 0) {
				int novaColuna = coluna - 1;
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(novaColuna).getPeca();
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, novaColuna));
					jogadas.add(jogada);
				}
			}
		}
		return jogadas;
	}
	
	private List<Jogada> obterJogadasDireita(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		if((coluna + 2) <= 7) {
			int novaColuna = coluna + 2;
			if((linha + 1) <= 7) {
				int novaLinha = linha + 1;
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(novaColuna).getPeca();
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, novaColuna));
					jogadas.add(jogada);
				}
			}
			if((linha - 1) >= 0) {
				int novaLinha = linha - 1;
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(novaColuna).getPeca();
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, novaColuna));
					jogadas.add(jogada);
				}
			}
		}
		return jogadas;
	}
	
	private List<Jogada> obterJogadasEsquerda(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		if((coluna - 2) >= 0) {
			int novaColuna = coluna - 2;
			if((linha + 1) <= 7) {
				int novaLinha = linha + 1;
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(novaColuna).getPeca();
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, novaColuna));
					jogadas.add(jogada);
				}
			}
			if((linha - 1) >= 0) {
				int novaLinha = linha - 1;
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(novaColuna).getPeca();
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, novaColuna));
					jogadas.add(jogada);
				}
			}
		}
		return jogadas;
	}
}
