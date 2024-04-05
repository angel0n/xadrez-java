package game;

import java.util.ArrayList;
import java.util.List;

import game.enums.Jogadores;
import game.enums.Pecas;
import game.movimentacao.Jogada;
import game.movimentacao.Posicao;
import game.pecas.Bishop;
import game.pecas.EmptyHouse;
import game.pecas.King;
import game.pecas.Knight;
import game.pecas.Pawn;
import game.pecas.PecaBase;
import game.pecas.Queen;
import game.pecas.Rook;

public class Game {
	private Boolean jogando;
	private List<List<PecaBase>> tabuleiro;
	private Jogadores jogador;
	private List<Jogada> jogadasPossiveis;
	
	public Game(Boolean jogando){
		this.setJogando(jogando);
		setJogador(Jogadores.BRANCO);
		tabuleiroInicial();
	}
	
	private void tabuleiroInicial() {
		if(this.tabuleiro == null) this.tabuleiro = new ArrayList<List<PecaBase>>();

		List<PecaBase> linha8 = List.of(new Rook(Pecas.ROOK_BLACK, Jogadores.PRETO, new Posicao(7, 0)), new Knight(Pecas.KNIGHT_BLACK, Jogadores.PRETO, new Posicao(7, 1)), new Bishop(Pecas.BISHOP_BLACK, Jogadores.PRETO, new Posicao(7, 2)), new King(Pecas.KING_BLACK, Jogadores.PRETO, new Posicao(7, 3)), new Queen(Pecas.QUEEN_BLACK, Jogadores.PRETO, new Posicao(7, 4)), new Bishop(Pecas.BISHOP_BLACK, Jogadores.PRETO, new Posicao(7, 5)), new Knight(Pecas.KNIGHT_BLACK, Jogadores.PRETO, new Posicao(7, 6)), new Rook(Pecas.ROOK_BLACK, Jogadores.PRETO, new Posicao(7, 7)));
		List<PecaBase> linha7 = List.of(new Pawn(Pecas.PAWN_BLACK, Jogadores.PRETO, new Posicao(6,0)), new Pawn(Pecas.PAWN_BLACK, Jogadores.PRETO, new Posicao(6,1)), new Pawn(Pecas.PAWN_BLACK, Jogadores.PRETO, new Posicao(6,2)), new Pawn(Pecas.PAWN_BLACK, Jogadores.PRETO, new Posicao(6,3)), new Pawn(Pecas.PAWN_BLACK, Jogadores.PRETO, new Posicao(6,4)), new Pawn(Pecas.PAWN_BLACK, Jogadores.PRETO, new Posicao(6,5)), new Pawn(Pecas.PAWN_BLACK, Jogadores.PRETO, new Posicao(6,6)), new Pawn(Pecas.PAWN_BLACK, Jogadores.PRETO, new Posicao(6,7)));
		List<PecaBase> linha6 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha5 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha4 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha3 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha2 = List.of(new Pawn(Pecas.PAWN_WHITE, Jogadores.BRANCO, new Posicao(1,0)), new Pawn(Pecas.PAWN_WHITE, Jogadores.BRANCO, new Posicao(1,1)), new Pawn(Pecas.PAWN_WHITE, Jogadores.BRANCO, new Posicao(1,2)), new Pawn(Pecas.PAWN_WHITE, Jogadores.BRANCO, new Posicao(1,3)), new Pawn(Pecas.PAWN_WHITE, Jogadores.BRANCO, new Posicao(1,4)), new Pawn(Pecas.PAWN_WHITE, Jogadores.BRANCO, new Posicao(1,5)), new Pawn(Pecas.PAWN_WHITE, Jogadores.BRANCO, new Posicao(1,6)), new Pawn(Pecas.PAWN_WHITE, Jogadores.BRANCO, new Posicao(1,7)));
		List<PecaBase> linha1 = List.of(new Rook(Pecas.ROOK_WHITE, Jogadores.BRANCO, new Posicao(0, 0)), new Knight(Pecas.KNIGHT_WHITE, Jogadores.BRANCO, new Posicao(0, 1)), new Bishop(Pecas.BISHOP_WHITE, Jogadores.BRANCO, new Posicao(0, 2)), new King(Pecas.KING_WHITE, Jogadores.BRANCO, new Posicao(0, 3)), new Queen(Pecas.QUEEN_WHITE, Jogadores.BRANCO, new Posicao(0, 4)), new Bishop(Pecas.BISHOP_WHITE, Jogadores.BRANCO, new Posicao(0, 5)), new Knight(Pecas.KNIGHT_WHITE, Jogadores.BRANCO, new Posicao(0, 6)), new Rook(Pecas.ROOK_WHITE, Jogadores.BRANCO, new Posicao(0, 7)));
		tabuleiro.add(linha1);
		tabuleiro.add(linha2);
		tabuleiro.add(linha3);
		tabuleiro.add(linha4);
		tabuleiro.add(linha5);
		tabuleiro.add(linha6);
		tabuleiro.add(linha7);
		tabuleiro.add(linha8);
	}
	
	@SuppressWarnings("unused")
	private void tabuleiroInicialTeste() {
		if(this.tabuleiro == null) this.tabuleiro = new ArrayList<List<PecaBase>>();

		List<PecaBase> linha8 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha7 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha6 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha5 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new Queen(Pecas.QUEEN_BLACK, Jogadores.PRETO, new Posicao(4, 3)),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha4 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha3 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha2 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		List<PecaBase> linha1 = List.of(new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse(),new EmptyHouse());
		tabuleiro.add(linha1);
		tabuleiro.add(linha2);
		tabuleiro.add(linha3);
		tabuleiro.add(linha4);
		tabuleiro.add(linha5);
		tabuleiro.add(linha6);
		tabuleiro.add(linha7);
		tabuleiro.add(linha8);
	}
	
	public void desenhaTabuleiro() {
		System.out.println("-----------------------------");
		for(int l = 7; l >= 0; l--) {
			System.out.print(l + 1);
			System.out.print(" | ");
			for(int c = 0; c < 8; c++) {
				System.out.print(tabuleiro.get(l).get(c).getNome());
				System.out.print(" ");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("-----------------------------");
		System.out.println("  | A  B  C  D  E  F  G  H  |");
	}
	
	public void buscarJogadasPossiveis() {
		List<Jogada> jogadasPossiveis = new ArrayList<>();
		
		for(int linha = 0; linha < 8; linha++) {
			for(int coluna = 0; coluna < 8; coluna++) {
				List<Jogada> lista = tabuleiro.get(linha).get(coluna).obterJogadasPossiveis(tabuleiro);
				jogadasPossiveis.addAll(lista);
			}
		}
		
		setJogadasPossiveis(jogadasPossiveis);
		System.out.println("Numero de jogadas Possiveis: " + jogadasPossiveis.size());
	}
	
	public void realizarMovimentacao(String movimento) {
		try {
			if(movimento.length() != 4) {
				throw new Exception();
			}
			
			String casaInicial = movimento.substring(0, 2).toUpperCase();
			String casaFinal = movimento.substring(2).toUpperCase();
			
			Posicao posicaoInicial = stringToPosicao(casaInicial);
			Posicao posicaoFinal = stringToPosicao(casaFinal);
			
			Jogada jogada = new Jogada(posicaoInicial, posicaoFinal);
			
			Jogada jogadaSelecionada =  null;
			
			for(Jogada jogadaPossivel : getJogadasPossiveis()) {
				if(jogadaPossivel.equals(jogada)){
					jogadaSelecionada = jogadaPossivel;
				}
			}
			
			if(jogadaSelecionada == null) {
				throw new Exception();
			}
			
			PecaBase pecaSelecionada = tabuleiro.get(jogadaSelecionada.getPosicaoInicial().getLinha()).get(jogadaSelecionada.getPosicaoInicial().getColuna());
			pecaSelecionada.setPosicao(jogadaSelecionada.getPosicaoFinal());
			
			List<List<PecaBase>> novoTabuleiro = new ArrayList<List<PecaBase>>(tabuleiro);
			
			List<PecaBase> linhaOrigem = new ArrayList<PecaBase>(novoTabuleiro.get(jogadaSelecionada.getPosicaoInicial().getLinha()));
			List<PecaBase> linhaDestinho = new ArrayList<PecaBase>(novoTabuleiro.get(jogadaSelecionada.getPosicaoFinal().getLinha()));
			
			linhaOrigem.set(jogadaSelecionada.getPosicaoInicial().getColuna(), new EmptyHouse());
			linhaDestinho.set(jogadaSelecionada.getPosicaoFinal().getColuna(), pecaSelecionada);
			
			novoTabuleiro.set(jogadaSelecionada.getPosicaoInicial().getLinha(), linhaOrigem);
			novoTabuleiro.set(jogadaSelecionada.getPosicaoFinal().getLinha(), linhaDestinho);
			
			this.tabuleiro = novoTabuleiro;
			
			desenhaTabuleiro();
			buscarJogadasPossiveis();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Movimento invalido!");
		}
	}
	
	private Posicao stringToPosicao(String casa) throws Exception {
		char colunaAlpha = casa.charAt(0);
		int linha = Integer.parseInt(casa.substring(1)) - 1 ;
		List<Character> colunasValidas = List.of('A','B','C','D','E','F','G','H');
		
		if(!colunasValidas.contains(colunaAlpha) || linha < 0 || linha > 7) {
			throw new Exception();
		}
		
		int coluna = colunasValidas.indexOf(colunaAlpha);
		
		return new Posicao(linha, coluna);
	}

	public Boolean getJogando() {
		return jogando;
	}

	public void setJogando(Boolean jogando) {
		this.jogando = jogando;
	}

	public Jogadores getJogador() {
		return jogador;
	}

	public void setJogador(Jogadores jogador) {
		this.jogador = jogador;
	}

	public List<Jogada> getJogadasPossiveis() {
		return jogadasPossiveis;
	}

	public void setJogadasPossiveis(List<Jogada> jogadasPossiveis) {
		this.jogadasPossiveis = jogadasPossiveis;
	}
}
