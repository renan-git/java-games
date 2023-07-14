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

		System.out.println("Bem Vindo ao Jogo da Adivinha��o");
		System.out.println("Voc� tem 7 tentativas para adivinhar o n�mero misterioso");
		
		while(wrong && tries <= 7) {
			System.out.println("\nTentativa de n�mero " + tries);
			tries++;
			System.out.print("Digite um n�mero entre 0 e 100: ");
			int guess = sc.nextInt();
			
			if(guess > 100 || guess < 0) {
				System.out.println("Voc� deve digitar um n�mero entre 0 e 100");
				tries--;
				continue;
			}
			else {
				if(guess > number) {
					System.out.println("O n�mero que voc� digitou � maior que o n�mero misterioso");
					if(tries > 7) {
						System.out.println("\nTentativas Expiradas, voc� perdeu");
					}
				}
				else if(guess < number) {
					System.out.println("O n�mero que voc� digitou � menor que o n�mero misterioso");
					if(tries > 7) {
						System.out.println("\nTentativas Expiradas, voc� perdeu");
					}
				}
				else {
					System.out.println("\nParab�ns, voc� venceu !! O n�mero que voc� digitou � o n�mero misterioso");
					wrong = false;
				}
			}
			
		}
		
		sc.close();

	}

}
