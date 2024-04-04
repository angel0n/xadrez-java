package game.pecas;

import java.util.ArrayList;
import java.util.List;

import game.enums.Jogadores;
import game.enums.Pecas;
import game.movimentacao.Jogada;
import game.movimentacao.Posicao;

public class Rook extends PecaBase{
	public Rook(Pecas peca, Jogadores jogador, Posicao posicao) {
		super(peca, jogador, posicao);
	}
	
	@Override
	public List<Jogada> obterJogadasPossiveis(List<List<PecaBase>> tabuleiro) {
		List<Jogada> jogadasPermitidas = new ArrayList<Jogada>();
		
		List<Jogada> jogadasFrontais = obterJogadasFrente(tabuleiro);
		List<Jogada> jogadasTras = obterJogadasTras(tabuleiro);
		List<Jogada> jogadasDireita = obterJogadasDireita(tabuleiro);
		List<Jogada> jogadasEsquerda = obterJogadasEsquerdas(tabuleiro);
		
		if(jogadasFrontais.size() > 0) jogadasPermitidas.addAll(jogadasFrontais);
		if(jogadasTras.size() > 0) jogadasPermitidas.addAll(jogadasTras);
		if(jogadasDireita.size() > 0) jogadasPermitidas.addAll(jogadasDireita);
		if(jogadasEsquerda.size() > 0) jogadasPermitidas.addAll(jogadasEsquerda);
		return jogadasPermitidas;
	}
	
	private List<Jogada> obterJogadasFrente(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		
		for(int novaLinha = linha + 1; novaLinha < 8; novaLinha++) {
			Boolean isEmptHouse = tabuleiro.get(novaLinha).get(coluna).getPeca().equals(Pecas.EMPTY_HOUSE);
			Boolean isInimigo = tabuleiro.get(novaLinha).get(coluna).getPeca().getNome().endsWith(inimigo);
			
			if(!isEmptHouse && !isInimigo) break;
			
			Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna));
			jogadas.add(jogada);
			
			if(isInimigo) break;
		}
		
		return jogadas;
	}
	
	private List<Jogada> obterJogadasTras(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		
		for(int novaLinha = linha - 1; novaLinha >= 0; novaLinha--) {
			Boolean isEmptHouse = tabuleiro.get(novaLinha).get(coluna).getPeca().equals(Pecas.EMPTY_HOUSE);
			Boolean isInimigo = tabuleiro.get(novaLinha).get(coluna).getPeca().getNome().endsWith(inimigo);
			
			if(!isEmptHouse && !isInimigo) break;
			
			Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna));
			jogadas.add(jogada);
			
			if(isInimigo) break;
		}
		
		return jogadas;
	}
	
	private List<Jogada> obterJogadasDireita(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		
		for(int novaColuna = coluna + 1; novaColuna < 8; novaColuna++) {
			Boolean isEmptHouse = tabuleiro.get(linha).get(novaColuna).getPeca().equals(Pecas.EMPTY_HOUSE);
			Boolean isInimigo = tabuleiro.get(linha).get(novaColuna).getPeca().getNome().endsWith(inimigo);
			
			if(!isEmptHouse && !isInimigo) break;
			
			Jogada jogada = new Jogada(getPosicao(), new Posicao(linha, novaColuna));
			jogadas.add(jogada);
			
			if(isInimigo) break;
		}
		
		return jogadas;
	}
	
	private List<Jogada> obterJogadasEsquerdas(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		
		for(int novaColuna = coluna - 1; novaColuna >= 0; novaColuna--) {
			Boolean isEmptHouse = tabuleiro.get(linha).get(novaColuna).getPeca().equals(Pecas.EMPTY_HOUSE);
			Boolean isInimigo = tabuleiro.get(linha).get(novaColuna).getPeca().getNome().endsWith(inimigo);
			
			if(!isEmptHouse && !isInimigo) break;
			
			Jogada jogada = new Jogada(getPosicao(), new Posicao(linha, novaColuna));
			jogadas.add(jogada);
			
			if(isInimigo) break;
		}
		
		return jogadas;
	}
}
