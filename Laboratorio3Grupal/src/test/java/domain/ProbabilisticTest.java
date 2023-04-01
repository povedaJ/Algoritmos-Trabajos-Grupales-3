package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProbabilisticTest {

    @Test
    public void testBirthdayParadox() {
        Probabilistic pb = new Probabilistic();
        pb.BirthdayParadox(30);
        pb.BirthdayParadox(23);
        pb.BirthdayParadox(57);
        pb.BirthdayParadox(10);
        pb.BirthdayParadox(85);
        System.out.println(  pb.BirthdayParadox(5));

    }
}