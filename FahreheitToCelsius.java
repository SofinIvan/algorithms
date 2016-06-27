package CodeAbbey.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sofin-IN on 26.04.2016.
 */
public class FahreheitToCelsius {
    final static int FAHRENHEIGHT_ZERO = 32;
    final static int FAHRENHEIGHT_BOIL = 212;
    final static int CELSIUS_ZERO = 0;
    final static int CELSIUS_BOIL = 100;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        reader.close();

        String[] lines = line.split(" ");
        int numberOfLines = Integer.parseInt(lines[0]);
        double scaleInterval = (FAHRENHEIGHT_BOIL - FAHRENHEIGHT_ZERO) / (double) (CELSIUS_BOIL - CELSIUS_ZERO);

        for (int i = 0; i < numberOfLines; i++) {
            int tempInFahrenheight = Integer.parseInt(lines[i + 1]);
            int tempInCelsius = 0;
            if (tempInFahrenheight >= FAHRENHEIGHT_ZERO)
                tempInCelsius = (int) Math.round((tempInFahrenheight - FAHRENHEIGHT_ZERO) / scaleInterval);
            else if (tempInFahrenheight < FAHRENHEIGHT_ZERO & tempInFahrenheight >= 0)
                tempInCelsius = -(int) Math.round(Math.abs((tempInFahrenheight - FAHRENHEIGHT_ZERO) / scaleInterval));
            else if (tempInFahrenheight < 0)
                tempInCelsius = (int) Math.round((tempInFahrenheight - FAHRENHEIGHT_ZERO) / scaleInterval);
            System.out.print(tempInCelsius + " ");
        }
    }
}
