package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProbabilisticTest {

    @Test
    public void testBirthdayParadox() {
        Probabilistic pb = new Probabilistic();

        System.out.println("Birthday Paradox Probability for "+30+" persons: "
                +util.Utility.format(pb.BirthdayParadox(30))+"%\n");
        System.out.println("Birthday Paradox Probability for "+23+" persons: "
                +util.Utility.format(pb.BirthdayParadox(23))+"%\n");
        System.out.println("Birthday Paradox Probability for "+57+" persons: "
                +util.Utility.format(pb.BirthdayParadox(57))+"%\n");
        System.out.println("Birthday Paradox Probability for "+10+" persons: "
                +util.Utility.format(pb.BirthdayParadox(10))+"%\n");
        System.out.println("Birthday Paradox Probability for "+85+" persons: "
                +util.Utility.format(pb.BirthdayParadox(85))+"%\n");


    }
}