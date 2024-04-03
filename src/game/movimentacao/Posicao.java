package game.movimentacao;

public class Posicao {
	private int linha;
	private int coluna;
	
	public Posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		if(linha > 7) linha = 7;
		if(linha < 0) linha = 0;
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		if(coluna > 7) coluna = 7;
		if(coluna < 0) coluna = 0;
		this.coluna = coluna;
	}
}
