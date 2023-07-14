package application;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int number = random.nextInt(101);
		int tries = 1;
		boolean wrong = true;

		System.out.println("Bem Vindo ao Jogo da Adivinhação");
		System.out.println("Você tem 7 tentativas para adivinhar o número misterioso");
		
		while(wrong && tries <= 7) {
			System.out.println("\nTentativa de número " + tries);
			tries++;
			System.out.print("Digite um número entre 0 e 100: ");
			int guess = sc.nextInt();
			
			if(guess > 100 || guess < 0) {
				System.out.println("Você deve digitar um número entre 0 e 100");
				tries--;
				continue;
			}
			else {
				if(guess > number) {
					System.out.println("O número que você digitou é maior que o número misterioso");
					if(tries > 7) {
						System.out.println("\nTentativas Expiradas, você perdeu");
					}
				}
				else if(guess < number) {
					System.out.println("O número que você digitou é menor que o número misterioso");
					if(tries > 7) {
						System.out.println("\nTentativas Expiradas, você perdeu");
					}
				}
				else {
					System.out.println("\nParabéns, você venceu !! O número que você digitou é o número misterioso");
					wrong = false;
				}
			}
			
		}
		
		sc.close();

	}

}
