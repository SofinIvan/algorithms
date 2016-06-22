package CodeAbbey.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lineForReverse = reader.readLine();
        System.out.println(sbReverse(lineForReverse));
    }

    //при помощи цикла
    private static String reverse(String lineForReverse) {
        char[] reversoide = lineForReverse.toCharArray();
        for (int i = 0; i < reversoide.length / 2; i++) {
            char temp = reversoide[i];
            reversoide[i] = reversoide[reversoide.length - 1 - i];
            reversoide[reversoide.length - 1 - i] = temp;
        }
        return new String(reversoide);
    }

    //самый простой путь для того, чтобы сделать реверс строки, используем StringBuilder
    private static String sbReverse(String lineForReverse) {
        StringBuilder sb = new StringBuilder(lineForReverse);
        return String.valueOf(sb.reverse());
    }
}