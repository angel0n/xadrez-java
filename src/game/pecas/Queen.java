package game.pecas;

import java.util.ArrayList;
import java.util.List;

import game.enums.Jogadores;
import game.enums.Pecas;
import game.movimentacao.Jogada;
import game.movimentacao.Posicao;

public class Queen extends PecaBase{

	public Queen(Pecas peca, Jogadores jogador, Posicao posicao) {
		super(peca, jogador, posicao);
	}
	
	@Override
	public List<Jogada> obterJogadasPossiveis(List<List<PecaBase>> tabuleiro) {
		List<Jogada> jogadasPermitidas = new ArrayList<Jogada>();
		
		List<Jogada> jogadasFrontais = obterJogadasFrontais(tabuleiro);
		List<Jogada> jogadasTras = obterJogadasTras(tabuleiro);
		List<Jogada> jogadasDireita = obterJogadasDireita(tabuleiro);
		List<Jogada> jogadasEsquerda = obterJogadasEsquerdas(tabuleiro);
		List<Jogada> jogadasDiagonaisFrente = obterJogadasDiagonaisFrente(tabuleiro);
		List<Jogada> jogadasDiagonaisTras = obterJogadasDiagonaisTras(tabuleiro);
		
		if(jogadasFrontais.size() > 0) jogadasPermitidas.addAll(jogadasFrontais);
		if(jogadasTras.size() > 0) jogadasPermitidas.addAll(jogadasTras);
		if(jogadasDireita.size() > 0) jogadasPermitidas.addAll(jogadasDireita);
		if(jogadasEsquerda.size() > 0) jogadasPermitidas.addAll(jogadasEsquerda);
		if(jogadasDiagonaisFrente.size() > 0) jogadasPermitidas.addAll(jogadasDiagonaisFrente);
		if(jogadasDiagonaisTras.size() > 0) jogadasPermitidas.addAll(jogadasDiagonaisTras);
		return jogadasPermitidas;
	}
	
	
	private List<Jogada> obterJogadasFrontais(List<List<PecaBase>> tabuleiro) {
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
	
	private List<Jogada> obterJogadasDiagonaisFrente(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		
		Boolean direitaBloqueada = false;
		Boolean EsquerdaBloqueada = false;
		for(int i = 1; i <= 7; i++) {
			int novaLinha = linha + i;
			if(novaLinha > 7 ) break;
			
			if((coluna + i) <= 7 && !direitaBloqueada) {
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(coluna + i).getPeca();	
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna + i));
					jogadas.add(jogada);
				}
				
				if(!pecaCapturada.equals(Pecas.EMPTY_HOUSE)) {
					direitaBloqueada = true;
				}
			}
			
			if((coluna - i) >= 0 && !EsquerdaBloqueada) {
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(coluna - i).getPeca();
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna + i));
					jogadas.add(jogada);
				}
				if(!pecaCapturada.equals(Pecas.EMPTY_HOUSE)) {
					EsquerdaBloqueada = true;
				}
			}
		}
		
		return jogadas;
	}
	
	private List<Jogada> obterJogadasDiagonaisTras(List<List<PecaBase>> tabuleiro) {
		int linha = getPosicao().getLinha();
		int coluna = getPosicao().getColuna();
		String inimigo = getJogador().equals(Jogadores.BRANCO) ? "B" : "W";
		List<Jogada> jogadas = new ArrayList<Jogada>();
		
		Boolean direitaBloqueada = false;
		Boolean EsquerdaBloqueada = false;
		for(int i = 1; i <= 7; i++) {
			int novaLinha = linha - i;
			if(novaLinha < 0 ) break;
			
			if((coluna + i) <= 7 && !direitaBloqueada) {
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(coluna + i).getPeca();	
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna + i));
					jogadas.add(jogada);
				}
				
				if(!pecaCapturada.equals(Pecas.EMPTY_HOUSE)) {
					direitaBloqueada = true;
				}
			}
			
			if((coluna - i) >= 0 && !EsquerdaBloqueada) {
				Pecas pecaCapturada = tabuleiro.get(novaLinha).get(coluna - i).getPeca();
				if(pecaCapturada.equals(Pecas.EMPTY_HOUSE) || pecaCapturada.getNome().endsWith(inimigo)) {
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna + i));
					jogadas.add(jogada);
				}
				if(!pecaCapturada.equals(Pecas.EMPTY_HOUSE)) {
					EsquerdaBloqueada = true;
				}
			}
		}
		
		return jogadas;
	}

}
