package codeAbbey;
/*
In this task we are going to implement the primes generator.
Primes are positive integers which have no other divisors except 1 and itself.

Input data will contain the amount of primes to print in the first line.
Next line will contain indices of array of primes for which values should be printed. They will be in range from 1 to 200000.
Answer should contain prime numbers corresponding the specified positions of the array.

Example:

input data:
4
7 1 199999 4

answer:
17 2 2750131 7
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumbers {

    public static void main(String[] args) throws IOException {
        // считываем входные данные
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfNumbers = Integer.parseInt(reader.readLine());
        String[] numbersString = reader.readLine().split(" ");
        reader.close();

        int[] enteredNums = new int[amountOfNumbers];
        int numberOfPrimes = 0;
        // преобразуем в числовой вид и находим максимальный индекс (самый большой номер простого числа)
        for (int i = 0; i < amountOfNumbers; i++) {
            enteredNums[i] = Integer.parseInt(numbersString[i]);
            numberOfPrimes = enteredNums[i] > numberOfPrimes ? enteredNums[i] : numberOfPrimes;
        }
        // заполняем массив до максимального индекса
        int[] primes = getPrimeNumbers(numberOfPrimes);
        // вывод в консоль простых чисел с заданными номерами
        for (int i = 0; i < amountOfNumbers; i++) {
            System.out.print(primes[(enteredNums[i]) - 1] + " ");
        }
    }

    // метод, который заполняет массив простыми числами
    private static int[] getPrimeNumbers(int numberOfPrimes) {
        int[] primes = new int[numberOfPrimes];
        int counter = 0;
        int checkPrime = 1;
        while (true) {
            if (isPrime(checkPrime)) {
                primes[counter] = checkPrime;
                // счётчик, который увеличивается в том случае, если добавляем в массив простое число
                counter++;
            }
            checkPrime++;
            if (counter == numberOfPrimes) break; //когда массив заполнен простыми числами
        }
        return primes;
    }

    // метод, проверяющий, является ли число простым
    private static boolean isPrime(int checkPrime) {
        if (checkPrime < 2) return false;
        // вспоминаем теорию чисел и понимаем, что переберать надо только числа, не превосходящие корня из искомого
        // что значительно ускоряет работу алгоритма
        for (int i = 2; i <= Math.sqrt(checkPrime); i++) {
            if (checkPrime % i == 0) {
                return false;
            }
        }
        return true;
    }
}
