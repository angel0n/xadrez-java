package game.pecas;

import java.util.ArrayList;
import java.util.List;

import game.enums.Jogadores;
import game.enums.Pecas;
import game.movimentacao.Jogada;
import game.movimentacao.Posicao;

public class King extends PecaBase{

	public King(Pecas peca, Jogadores jogador, Posicao posicao) {
		super(peca, jogador, posicao);
	}
	
	@Override
	public List<Jogada> obterJogadasPossiveis(List<List<PecaBase>> tabuleiro) {
		List<Jogada> jogadasPossiveis = new ArrayList<Jogada>();
		
		List<Jogada> jogadasFrente = obterJogadasFrente(tabuleiro);
		List<Jogada> jogadasTras = obterJogadasTras(tabuleiro);
		List<Jogada> jogadasLaterais = obterJogadasLaterais(tabuleiro);
		
		if(jogadasFrente.size() > 0) jogadasPossiveis.addAll(jogadasFrente);
		if(jogadasTras.size() > 0) jogadasPossiveis.addAll(jogadasTras);
		if(jogadasLaterais.size() > 0) jogadasPossiveis.addAll(jogadasLaterais);
		return jogadasPossiveis;
	}
	
	private List<Jogada> obterJogadasFrente(List<List<PecaBase>> tabuleiro){
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		
		List<Jogada> jogadas = new ArrayList<Jogada>();
		
		int novaLinha = linha + 1; 
		
		if(novaLinha <= 7) {
			Pecas pecaFrontal = tabuleiro.get(novaLinha).get(coluna).getPeca();
			if(pecaFrontal.equals(Pecas.EMPTY_HOUSE) || pecaFrontal.getNome().endsWith(inimigo)) {
				Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna));
				jogadas.add(jogada);
			}
			
			if((coluna + 1) <= 7) {
				Pecas pecaDireita = tabuleiro.get(novaLinha).get(coluna + 1).getPeca();
				if(pecaDireita.equals(Pecas.EMPTY_HOUSE) || pecaDireita.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna + 1));
					jogadas.add(jogada);
				}
			}
			
			if((coluna - 1) >= 0) {
				Pecas pecaDireita = tabuleiro.get(novaLinha).get(coluna - 1).getPeca();
				if(pecaDireita.equals(Pecas.EMPTY_HOUSE) || pecaDireita.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna - 1));
					jogadas.add(jogada);
				}
			}
		}
		
		return jogadas;
	}
	
	private List<Jogada> obterJogadasTras(List<List<PecaBase>> tabuleiro){
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		
		List<Jogada> jogadas = new ArrayList<Jogada>();
		
		int novaLinha = linha - 1; 
		
		if(novaLinha >= 0) {
			Pecas pecaFrontal = tabuleiro.get(novaLinha).get(coluna).getPeca();
			if(pecaFrontal.equals(Pecas.EMPTY_HOUSE) || pecaFrontal.getNome().endsWith(inimigo)) {
				Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna));
				jogadas.add(jogada);
			}
			
			if((coluna + 1) <= 7) {
				Pecas pecaDireita = tabuleiro.get(novaLinha).get(coluna + 1).getPeca();
				if(pecaDireita.equals(Pecas.EMPTY_HOUSE) || pecaDireita.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna + 1));
					jogadas.add(jogada);
				}
			}
			
			if((coluna - 1) >= 0) {
				Pecas pecaDireita = tabuleiro.get(novaLinha).get(coluna - 1).getPeca();
				if(pecaDireita.equals(Pecas.EMPTY_HOUSE) || pecaDireita.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna - 1));
					jogadas.add(jogada);
				}
			}
		}
		
		return jogadas;
	}
	
	private List<Jogada> obterJogadasLaterais(List<List<PecaBase>> tabuleiro){
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		
		if((coluna + 1) <= 7) {
			Pecas pecaDireita = tabuleiro.get(linha).get(coluna + 1).getPeca();
			if(pecaDireita.equals(Pecas.EMPTY_HOUSE) || pecaDireita.getNome().endsWith(inimigo)) {
				Jogada jogada = new Jogada(getPosicao(), new Posicao(linha, coluna + 1));
				jogadas.add(jogada);
			}
		}
		
		if((coluna - 1) >= 0) {
			Pecas pecaDireita = tabuleiro.get(linha).get(coluna - 1).getPeca();
			if(pecaDireita.equals(Pecas.EMPTY_HOUSE) || pecaDireita.getNome().endsWith(inimigo)) {
				Jogada jogada = new Jogada(getPosicao(), new Posicao(linha, coluna - 1));
				jogadas.add(jogada);
			}
		}
		
		return jogadas;
	}
}
