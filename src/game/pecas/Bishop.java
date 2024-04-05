package game.pecas;

import java.util.ArrayList;
import java.util.List;

import game.enums.Jogadores;
import game.enums.Pecas;
import game.movimentacao.Jogada;
import game.movimentacao.Posicao;

public class Bishop extends PecaBase{

	public Bishop(Pecas peca, Jogadores jogador, Posicao posicao) {
		super(peca, jogador, posicao);
	}
	
	@Override
	public List<Jogada> obterJogadasPossiveis(List<List<PecaBase>> tabuleiro) {
		List<Jogada> jogadasPossiveis = new ArrayList<Jogada>();
		
		List<Jogada> jogadasFrente = obterJogadasFrente(tabuleiro);
		List<Jogada> jogadasTras = obterJogadasTras(tabuleiro);
		
		if(jogadasFrente.size() > 0) jogadasPossiveis.addAll(jogadasFrente);
		if(jogadasTras.size() > 0) jogadasPossiveis.addAll(jogadasTras);
		return jogadasPossiveis;
	}
	
	private List<Jogada> obterJogadasFrente(List<List<PecaBase>> tabuleiro) {
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
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna - i));
					jogadas.add(jogada);
				}
				if(!pecaCapturada.equals(Pecas.EMPTY_HOUSE)) {
					EsquerdaBloqueada = true;
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
		if(linha == 7) {
			String teste ="";
		}
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
					Jogada jogada = new Jogada(getPosicao(), new Posicao(novaLinha, coluna - i));
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
