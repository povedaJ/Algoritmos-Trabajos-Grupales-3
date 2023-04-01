package domain;

import java.util.HashSet;
import java.util.Set;

import java.util.concurrent.ThreadLocalRandom;
public class Probabilistic {
    public double BirthdayParadox(int people){

        int n = people;
        final int trials = 100000;
        int birthdayMatches = 0;

        // Monte Carlo simulation
        for (int i = 0; i < trials; i++) {
            if (sampleHasMatch(people)) {
                birthdayMatches++;
            }
        }

        double prob = (double) birthdayMatches / trials * 100;
        System.out.println("Birthday Paradox Probability for "+people+" persons: " +util.Utility.format(prob)+"%\n");

        // System.out.printf("Sample size: %d %n", people);
        //System.out.printf("Number of trials: %,d %n", trials);
       // System.out.printf("Probability of a match: %.2f%% %n", prob+"\n");
   return prob;
    }


   public boolean sampleHasMatch(int sampleSize) {
        final int daysInYear = 365;
        boolean[] days = new boolean[daysInYear];
        for (int i = 0; i < sampleSize; i++) {

            // Choose index of a random birthday.
            int j = ThreadLocalRandom.current().nextInt(days.length);

            // If index was previously chosen, there is a match.
            if (days[j]) {
                return true;
            }

            days[j] = true;
        }
        return false;
    }
}

