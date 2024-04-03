package game.pecas;

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
		return super.obterJogadasPossiveis(tabuleiro);
	}
}
