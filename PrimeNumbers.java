package codeAbbey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfNumbers = Integer.parseInt(reader.readLine());
        String[] numbersString = reader.readLine().split(" ");
        reader.close();

        int[] enteredNums = new int[amountOfNumbers];
        int numberOfPrimes = 0;

        for (int i = 0; i < amountOfNumbers; i++) {
            enteredNums[i] = Integer.parseInt(numbersString[i]);
            numberOfPrimes = enteredNums[i] > numberOfPrimes ? enteredNums[i] : numberOfPrimes;
        }
        int[] primes = getPrimeNumbers(numberOfPrimes);
        for (int i = 0; i < amountOfNumbers; i++) {
            System.out.print(primes[(enteredNums[i]) - 1] + " ");
        }
    }

    private static int[] getPrimeNumbers(int numberOfPrimes) {
        int[] primes = new int[numberOfPrimes];
        int counter = 0;
        int checkPrime = 1;
        while (true) {
            if (isPrime(checkPrime)) {
                primes[counter] = checkPrime;
                counter++;
            }
            checkPrime++;
            if (counter == numberOfPrimes) break;
        }
        return primes;
    }

    private static boolean isPrime(int checkPrime) {
        if (checkPrime < 2) return false;
        for (int i = 2; i <= Math.sqrt(checkPrime); i++) {
            if (checkPrime % i == 0) {
                return false;
            }
        }
        return true;
    }
}
