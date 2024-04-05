package start;

import java.util.Scanner;

import game.Game;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(true);
        
        while(game.getJogando()) {
        	System.out.print("\033[H\033[2J");
            System.out.flush();
        	game.desenhaTabuleiro();
    		game.buscarJogadasPossiveis();
    		
    		Scanner scanner = new Scanner(System.in);
    		
    		System.out.println("O movimento deve ser informado como no padrão: A2A4, sendo A2 a casa inicial e A4 a casa de destino ");
    		System.out.print("Escolha a sua jogada: ");
    		
    		scanner.hasNextLine();
    		String userInput = scanner.nextLine();

    		game.realizarMovimentacao(userInput);
            scanner.close();
        }
	}

}
