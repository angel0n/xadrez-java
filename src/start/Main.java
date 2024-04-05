package start;

import java.util.Scanner;

import game.Game;

public class Main {
	public static void main(String[] args) {
		Game game = new Game(true);
		Scanner scanner = new Scanner(System.in);
		game.desenhaTabuleiro();
		game.buscarJogadasPossiveis();
        System.out.println("Para encerrar o jogo escreva exit");
        while(game.getJogando()) {    		
    		System.out.println("O movimento deve ser informado como no padrão: A2A4, sendo A2 a casa inicial e A4 a casa de destino ");
    		System.out.println("Jogador: " + game.getJogador().name());
    		System.out.print("Escolha a sua jogada: ");
    		
    		scanner.hasNextLine();
    		String userInput = scanner.nextLine();

    		game.realizarMovimentacao(userInput);    		
        }
        scanner.close();
	}
}
