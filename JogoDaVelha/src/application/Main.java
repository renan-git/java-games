package application;

import java.util.Scanner;
import entities.Player;
import entities.Board;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Bem vindo ao Jogo da Velha");
		System.out.print("\nDigite o nome do primeiro jogador: ");
		String name1 = sc.nextLine();
		System.out.print("Digite o nome do segundo jogador: ");
		String name2 = sc.nextLine();

		Player player1 = new Player(name1.trim(), 'X');
		Player player2 = new Player(name2.trim(), 'O');
		Board board = new Board();
		
		System.out.println();
		System.out.println(board.showBoard());

		boolean game = true;
		int plays = 0;
		while (game) {
			System.out.println(player1.getName() + ", informe a posicao que deseja colocar o " + player1.getSymbol());
			System.out.print("Linha: ");
			int line = sc.nextInt();
			System.out.print("Coluna: ");
			int column = sc.nextInt();
			if ((line >= 4 || column >= 4) || (column == 0 && line == 0)
					|| (board.getBoard()[line][column].equals("X ")) || (board.getBoard()[line][column].equals("O "))) {
				System.out.println("\nPosicao Invalida, perdeu a vez");
				System.out.println(board.showBoard());
			} else {
				plays++;
				board.setBoard(line, column, player1.getSymbol());
				System.out.println(board.showBoard());
				
				if (board.finalGame(player1.getSymbol())) {
					System.out.println(player1.getName().toUpperCase() + " VENCEU O JOGO DA VELHA !!");
					break;
				}
			}
			if (plays == 9) {
				System.out.println("DEU VELHA, JOGO EMPATADO");
				break;
			}
			System.out.println(player2.getName() + ", informe a posicao que deseja colocar o " + player2.getSymbol());
			System.out.print("Linha: ");
			line = sc.nextInt();
			System.out.print("Coluna: ");
			column = sc.nextInt();
			if ((line >= 4 || column >= 4) || (column == 0 && line == 0)
					|| (board.getBoard()[line][column].equals("X ")) || (board.getBoard()[line][column].equals("O "))) {
				System.out.println("\nPosicao Invalida, perdeu a vez");
				System.out.println(board.showBoard());
			} else {
				plays++;
				board.setBoard(line, column, player2.getSymbol());
				System.out.println(board.showBoard());
				
				if (board.finalGame(player2.getSymbol())) {
					System.out.println(player2.getName().toUpperCase() + " VENCEU O JOGO DA VELHA !!");
					break;
				}
			}
			if (plays == 9) {
				System.out.println("DEU VELHA, JOGO EMPATADO");
				game = false;
			}
		}
		sc.close();
	}

}
