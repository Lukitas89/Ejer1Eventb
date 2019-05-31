/*
 * Parte 1: Hacer un programa donde la computadora piensa el numero y un humano lo trate de adivinar.
 */
package adivinador;

/**
 *
 * @author Lucas Savina
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Adivinador {

    public static void main(String[] args) {
        Random gen = new Random();
        int target = 0;
        while (hasDupes(target = (gen.nextInt(9000) + 1000)));
        String targetStr = target + "";
        boolean guessed = false;
        Scanner input = new Scanner(System.in);
        int guesses = 0;
        do {
            int bien = 0;
            int regular = 0;
            System.out.print("Adivina un número de 4 dígitos sin dígitos duplicados: ");
            int guess;
            try {
                guess = input.nextInt();
                if (hasDupes(guess) || guess < 1000) {
                    continue;
                }
            } catch (InputMismatchException e) {
                continue;
            }
            guesses++;
            String guessStr = guess + "";
            for (int i = 0; i < 4; i++) {
                if (guessStr.charAt(i) == targetStr.charAt(i)) {
                    bien++;
                } else if (targetStr.contains(guessStr.charAt(i) + "")) {
                    regular++;
                }
            }
            if (bien == 4) {
                guessed = true;
            } else {
                System.out.println(regular + " Regular y " + bien + " Bien.");
            }
        } while (!guessed);
        System.out.println("Ganaste después de  " + guesses + " conjeturas");
    }

    public static boolean hasDupes(int num) {
        boolean[] digs = new boolean[10];
        while (num > 0) {
            if (digs[num % 10]) {
                return true;
            }
            digs[num % 10] = true;
            num /= 10;
        }
        return false;
    }
}
