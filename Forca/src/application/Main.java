package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = "D:\\Java Games\\Forca\\palavras.txt";
		Random random = new Random();
		
		System.out.println("BEM VINDO AO JOGO DA FORCA");
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String word = br.readLine();
			String words = " ";
			while(word != null) {
				words = words +  word + " ";
				word = br.readLine();			
			}
			String []vectWords = words.trim().split(" ");
			for(int i = 0; i< vectWords.length; i++) {
			}
			
			String wordRandom = vectWords[random.nextInt(vectWords.length)];
			System.out.println(wordRandom);
			String rightVect [] = new String[wordRandom.length()];
			
			for(int i=0; i<wordRandom.length(); i++) {
				rightVect[i] = " _ ";
			}

			boolean wrongAnswer = true;
			int tries = 7;
			while(wrongAnswer) {
				int control = 0;
				for(int i=0; i<wordRandom.length(); i++) {
					System.out.print( rightVect[i]);
				}
				System.out.println();
				System.out.print("Digite a letra: ");
				char guess = sc.next().charAt(0);
				String guessStr = String.valueOf(guess);
				tries--; // tentativa consumida
				
				for(int i = 0; i<wordRandom.length(); i++) {
					if(wordRandom.charAt(i) == guessStr.toUpperCase().charAt(0) || wordRandom.charAt(i) == guessStr.toLowerCase().charAt(0)) {
						rightVect[i] = " " + guessStr.toUpperCase() + " ";
						tries++; // tentativa regenerada pelo acerto
					}
				}
				for(int i = 0; i<wordRandom.length(); i++) {
					if(rightVect[i].equals(" _ ")) {
						control++;
					}
				}
				if(control == 0) {
					for(int i=0; i<wordRandom.length(); i++) {
						System.out.print( rightVect[i]);
					}
					System.out.println("\n VOCÊ GANHOU !!");
					break;
				}
				if(tries == 0) {
					System.out.println("\n VOCÊ PERDEU, TENTATIVAS EXPIRADAS !!");
					break;
				}
				
			}
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
