package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProbabilisticTest {

    @Test
    public void testBirthdayParadox() {
        Probabilistic pb = new Probabilistic();
        pb.BirthdayParadox(30);
    }
}