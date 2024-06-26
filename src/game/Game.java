package game;

import java.util.ArrayList;
import java.util.List;

import game.enums.Jogadores;
import game.enums.Pecas;
import game.movimentacao.Jogada;
import game.movimentacao.JogadaRealizada;
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
	private List<JogadaRealizada> jogadasRealizadas;
	
	public Game(Boolean jogando){
		this.setJogando(jogando);
		setJogador(Jogadores.BRANCO);
		tabuleiroInicial();
		setJogadasRealizadas(new ArrayList<JogadaRealizada>());
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
			if(movimento.equals("exit")) {
				setJogando(false);
				return;
			}
			if(movimento.equals("voltar")) {
				desfazerUltimoMovimento();
				return;
			}
			if(movimento.length() != 4) {
				throw new Exception();
			}
			
			String casaInicial = movimento.substring(0, 2).toUpperCase();
			String casaFinal = movimento.substring(2).toUpperCase();
			
			Posicao posicaoInicial = stringToPosicao(casaInicial);
			Posicao posicaoFinal = stringToPosicao(casaFinal);
			
			Jogada jogada = new Jogada(posicaoInicial, posicaoFinal);
			Jogada jogadaSelecionada = buscaJogadaSelecionada(jogada);
			
			PecaBase pecaSelecionada = tabuleiro.get(jogadaSelecionada.getPosicaoInicial().getLinha()).get(jogadaSelecionada.getPosicaoInicial().getColuna());
			
			if(!pecaSelecionada.getJogador().equals(getJogador())) {
				throw new Exception();
			}
			
			atualizaPosicaoTabuleiro(jogadaSelecionada);
			desenhaTabuleiro();
			buscarJogadasPossiveis();
			trocaJogador();
			
		} catch (Exception e) {
			System.out.println("Movimento invalido!");
		}
	}
	
	public void desfazerUltimoMovimento() {
		try {
			if(jogadasRealizadas.size() <= 0 ) throw new Exception();
			
			JogadaRealizada jogada = jogadasRealizadas.get(jogadasRealizadas.size() - 1);
			List<List<PecaBase>> novoTabuleiro = new ArrayList<List<PecaBase>>(tabuleiro);
			
			jogada.getPecaCapturada().setPosicao(jogada.getJogada().getPosicaoFinal());
			jogada.getPecaMovida().setPosicao(jogada.getJogada().getPosicaoInicial());
			
			if(jogada.getJogada().getPosicaoInicial().getLinha() != jogada.getJogada().getPosicaoFinal().getLinha()) {
				List<PecaBase> linhaOrigem = new ArrayList<PecaBase>(novoTabuleiro.get(jogada.getJogada().getPosicaoInicial().getLinha()));
				List<PecaBase> linhaDestinho = new ArrayList<PecaBase>(novoTabuleiro.get(jogada.getJogada().getPosicaoFinal().getLinha()));
				
				linhaOrigem.set(jogada.getJogada().getPosicaoInicial().getColuna(), jogada.getPecaMovida());
				linhaDestinho.set(jogada.getJogada().getPosicaoFinal().getColuna(), jogada.getPecaCapturada());
				
				novoTabuleiro.set(jogada.getJogada().getPosicaoInicial().getLinha(), linhaOrigem);
				novoTabuleiro.set(jogada.getJogada().getPosicaoFinal().getLinha(), linhaDestinho);
			}else {
				List<PecaBase> linha = new ArrayList<PecaBase>(novoTabuleiro.get(jogada.getJogada().getPosicaoInicial().getLinha()));
				
				linha.set(jogada.getJogada().getPosicaoInicial().getColuna(), jogada.getPecaMovida());
				linha.set(jogada.getJogada().getPosicaoFinal().getColuna(), jogada.getPecaCapturada());
				
				novoTabuleiro.set(jogada.getJogada().getPosicaoInicial().getLinha(), linha);
			}
			
			this.tabuleiro = novoTabuleiro;
			jogadasRealizadas.remove(jogadasRealizadas.size() - 1);
			
			buscarJogadasPossiveis();
			trocaJogador();
			desenhaTabuleiro();
		} catch (Exception e) {
			System.out.println("Não foi possível desfazer o ultimo movimento!");
		}
	}
	
	public void exibirTodasAsJogadasRealizadas() {
		System.out.print(jogadasRealizadas.toString());
	}
	
	private void trocaJogador() {
		if(getJogador().equals(Jogadores.BRANCO)) {
			setJogador(Jogadores.PRETO);
		}else {
			setJogador(Jogadores.BRANCO);
		}
	}
	
	private Jogada buscaJogadaSelecionada(Jogada jogada) throws Exception {
		Jogada jogadaSelecionada =  null;
		for(Jogada jogadaPossivel : getJogadasPossiveis()) {
			if(jogadaPossivel.equals(jogada)){
				jogadaSelecionada = jogadaPossivel;
			}
		}
		if(jogadaSelecionada == null) {
			throw new Exception();
		}
		return jogadaSelecionada;
	}
	
	private void atualizaPosicaoTabuleiro(Jogada jogada ) {
		PecaBase pecaSelecionada = tabuleiro.get(jogada.getPosicaoInicial().getLinha()).get(jogada.getPosicaoInicial().getColuna());
		PecaBase pecaCapturada = tabuleiro.get(jogada.getPosicaoFinal().getLinha()).get(jogada.getPosicaoFinal().getColuna()); 
		pecaSelecionada.setPosicao(jogada.getPosicaoFinal());
		List<List<PecaBase>> novoTabuleiro = new ArrayList<List<PecaBase>>(tabuleiro);
		
		if(jogada.getPosicaoInicial().getLinha() != jogada.getPosicaoFinal().getLinha()) {
			List<PecaBase> linhaOrigem = new ArrayList<PecaBase>(novoTabuleiro.get(jogada.getPosicaoInicial().getLinha()));
			List<PecaBase> linhaDestinho = new ArrayList<PecaBase>(novoTabuleiro.get(jogada.getPosicaoFinal().getLinha()));
			
			linhaOrigem.set(jogada.getPosicaoInicial().getColuna(), new EmptyHouse());
			linhaDestinho.set(jogada.getPosicaoFinal().getColuna(), pecaSelecionada);
			
			novoTabuleiro.set(jogada.getPosicaoInicial().getLinha(), linhaOrigem);
			novoTabuleiro.set(jogada.getPosicaoFinal().getLinha(), linhaDestinho);
		}else {
			List<PecaBase> linha = new ArrayList<PecaBase>(novoTabuleiro.get(jogada.getPosicaoInicial().getLinha()));
			linha.set(jogada.getPosicaoInicial().getColuna(), new EmptyHouse());
			linha.set(jogada.getPosicaoFinal().getColuna(), pecaSelecionada);
			
			novoTabuleiro.set(jogada.getPosicaoInicial().getLinha(), linha);
		}
		
		this.tabuleiro = novoTabuleiro;
		
		JogadaRealizada jogadaRealizada = new JogadaRealizada(jogada, pecaSelecionada, pecaCapturada);
		this.jogadasRealizadas.add(jogadaRealizada);
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

	public List<JogadaRealizada> getJogadasRealizadas() {
		return jogadasRealizadas;
	}

	public void setJogadasRealizadas(List<JogadaRealizada> jogadasRealizadas) {
		this.jogadasRealizadas = jogadasRealizadas;
	}
}
