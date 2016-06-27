package CodeAbbey.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sofin-IN on 31.05.2016.
 */
public class SumOfDigits {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int linesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < linesCount; i++) {
            String[] lines;
            int A_multiply_B_plus_C;

            lines = (reader.readLine()).split(" ");
            int a = Integer.parseInt(lines[0]);
            int b = Integer.parseInt(lines[1]);
            int c = Integer.parseInt(lines[2]);
            A_multiply_B_plus_C = a * b + c;
            System.out.print(getSumOfDigits(A_multiply_B_plus_C) + " ");
        }
        reader.close();
    }

    private static int getSumOfDigits(int c) {
        int result = 0;
        while (c > 0) {
            result += c % 10;
            c /= 10;
        }
        return result;
    }
}


