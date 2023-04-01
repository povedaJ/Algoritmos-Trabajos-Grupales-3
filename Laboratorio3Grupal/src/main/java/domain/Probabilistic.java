package domain;

import java.util.HashSet;
import java.util.Set;

public class Probabilistic {
    public void BirthdayParadox (int people) {
        int n = people; // number of people in the group
        int trials = 1000000; // number of trials
        int count = 0; // count of trials where at least two people have the same birthday

        for (int i = 0; i < trials; i++) {
            Set<Integer> birthdays = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int day = (int) (Math.random() * 365) + 1; // generate a random birthday
                if (birthdays.contains(day)) {
                    count++;


                }
            }
        }
    }
}
