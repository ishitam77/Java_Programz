/*Develop and test an object-oriented application to simulate the rolling of two dice. The application
should use an object of Random class once to roll the first die and again to roll the second die. The sum
of the two values should then be calculated. Each die can show an integer value from 1 to 6, so the sum
of the values will vary from 2 to 12, with 7 being the most frequent sum, and 2 and 12 the least frequent
(verify using code). Your application should roll the dice 1296 times. Use a one-dimensional array to tally
the number of times each possible sum appears. Display the results in a tabular format showing the sum
in one column and the number of times each possible sum occurs in a trial of 1296 times in another
column and compute the Chi-square value, where O and E are respectively observed
and expected number of occurrences of the events (2 to 12) and conclude whether the dice are
unbiased. (Chi-square value at 5% level of significance for ten degrees of freedom is 18.307).*/

import java.util.Random;

public class Dice_Game {
    public static void main(String args[]) {
        Random rand = new Random();
        int resl[] = new int[11];

        for (int i = 0; i < 1296; i++) {
            int roll1 = rand.nextInt(6) + 1;
            int roll2 = rand.nextInt(6) + 1;
            int total = roll1 + roll2;
            resl[total-2]++;
        }

        System.out.println("Sum\t\tFrequency");
        System.out.println("--------------------");
        for (int i = 2; i <= 12; i++) {
            System.out.println(i + "\t\t" + resl[i-2]);
        }

        double expect[] = new double[11];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                int total = i + j;
                expect[total-2] = (expect[total-2] + (1.0/36 * 1296));
            }
        }

        double chiSq = 0;
        for (int i = 0; i < 11; i++) {
            double temp = resl[i] - expect[i];
            chiSq = (chiSq + ( (temp * temp) / expect[i]));
        }

        System.out.println("Chi-square value: " + chiSq);

        if (chiSq < 18.307) {
            System.out.println("The dice are unbiased!!");
        } else {
            System.out.println("The dice are biased!!");
        }
    }
}
