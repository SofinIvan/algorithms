import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
We are given strings containing brackets of 4 types - round (), square [], curly {} and angle <> ones.
The goal is to check, whether brackets are in correct sequence.
I.e. any opening bracket should have closing bracket of the same type somewhere further by the string,
and bracket pairs should not overlap, though they could be nested:
(a+[b*c] - {d/3})  - here square and curly brackets are nested in the round ones
(a+[b*c) - 17]     - here square brackets overlap with round ones which does not make sense

Input data will contain number of testcases in the first line.
Then specified number of lines will follow each containing a test-case in form of a character sequence.
Answer should contain 1 (if bracket order is correct) or 0 (if incorrect) for each of test-cases, separated by spaces.

input data:
4
(a+[b*c]-{d/3})
(a + [b * c) - 17]
(((a * x) + [b] * y) + c
auf(zlo)men [gy<psy>] four{s}

answer:
1 0 0 1

короткий перевод - надо проверить корректность расстановки скобок в строке
если в строке скобки расставлены корректно - вернуть единицу
если не корректно  - вернуть нуль
*/

public class MatchingBrackets {

    //можно добавить разных других парных символов в массив - проверка будет работать
    private static char[] brackets = {'(', ')', '<', '>', '{', '}', '[', ']'};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int linesCount = Integer.parseInt(reader.readLine());
        String[] lines = new String[linesCount];
        for (int i = 0; i < linesCount; i++) {
            lines[i] = reader.readLine();
        }
        reader.close();
        int[] bracketsCondition = isBracketsOk(lines);
        for (int i = 0; i < bracketsCondition.length; i++) {
            System.out.print(bracketsCondition[i] + " ");
        }
    }

    //метод анализа скобок, корректно ли они расставлены
    private static int[] isBracketsOk(String[] lines) {
        char[] line;
        int[] result = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            line = lines[i].toCharArray();
            ArrayList<Character> listOfBrackets = new ArrayList<>();
            //анализируем, является ли символ скобкой (если да, добавляем в лист для анализа)
            for (int j = 0; j < line.length; j++) {
                if (isBracket(line[j])) listOfBrackets.add(line[j]);
            }
            //проверяем, все ли скобки парные, если находим две парные скобки рядом, удаляем,
            for (int j = 0; j < listOfBrackets.size() - 1; j++) {
                if (isPairOfBrackets(listOfBrackets.get(j), listOfBrackets.get(j + 1))) {
                    listOfBrackets.remove(j);  //дважды удаляем элемент, т.к. надо удалить две парных скобки,
                    listOfBrackets.remove(j);  //при удалении уменьшается размер ArrayList, поэтому снова j, а не j+1
                    // сбрасываем счетчик j до -1, т.к. в конце цикла счётчик увеличится на 1,
                    // чтобы получился нуль для продолжения проверки, если удалили одну пару скобок
                    j = -1;
                }
            }
            //если скобок в листе не осталось, расстановка скобок корректна
            result[i] = listOfBrackets.size() == 0 ? 1 : 0;
        }
        return result;
    }

    //являются ли скобки парными
    private static boolean isPairOfBrackets(char f1, char f2) {
        for (int k = 0; k < brackets.length - 1; k += 2) {
            if (f1 == brackets[k] && f2 == brackets[k + 1]) return true;
        }
        return false;
    }

    //является ли символ скобкой
    private static boolean isBracket(char c) {
        for (int k = 0; k < brackets.length; k++) {
            if (c == brackets[k]) return true;
        }
        return false;
    }
}
