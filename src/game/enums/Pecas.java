package game.enums;

public enum Pecas {
	ROOK_BLACK("RB"),
	KNIGHT_BLACK("NB"),
	BISHOP_BLACK("BB"),
	KING_BLACK("KB"),
	QUEEN_BLACK("QB"),
	PAWN_BLACK("PB"),
	ROOK_WHITE("RW"),
	KNIGHT_WHITE("NW"),
	BISHOP_WHITE("BW"),
	KING_WHITE("KW"),
	QUEEN_WHITE("QW"),
	PAWN_WHITE("PW"),
	EMPTY_HOUSE("[]");
	
	private String nome;
	
	Pecas(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
