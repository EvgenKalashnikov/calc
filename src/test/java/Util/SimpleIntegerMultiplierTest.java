package Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class SimpleIntegerMultiplierTest {

    @Test
    void multiplyAlgFirst() {
        String first = "102345678911032130123021301230";
        String second = "-12304567891101234023404657076580";
        Assertions.assertEquals(
                SimpleIntegerMultiplier.multiplyAlgFirst(first, second),
                SimpleIntegerMultiplier.multiplyAlgSecond(first, second));

        String result = "-1259319354521642658835306727867043356854239703802799358193400";
        Assertions.assertEquals(SimpleIntegerMultiplier.multiplyAlgFirst(first,second), result);

        String notNumber = "123123h321";
        Assertions.assertThrows(NumberFormatException.class, () -> SimpleIntegerMultiplier.multiplyAlgFirst(first, notNumber));

        String emptyString = "";
        Assertions.assertThrows(NumberFormatException.class, () -> SimpleIntegerMultiplier.multiplyAlgFirst(first, emptyString));
        long start = System.nanoTime();
        for (int i = 0; i <1_000_0 ; i++) {
            SimpleIntegerMultiplier.multiplyAlgFirst(first,second);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    void multiplyAlgSecond() {
        String first = "102345678911032130123021301230";
        String second = "-12304567891101234023404657076580";
        Assertions.assertEquals(
                SimpleIntegerMultiplier.multiplyAlgFirst(first, second),
                SimpleIntegerMultiplier.multiplyAlgSecond(first, second));

        String result = "-1259319354521642658835306727867043356854239703802799358193400";
        Assertions.assertEquals(SimpleIntegerMultiplier.multiplyAlgSecond(first,second), result);

        String notNumber = "123123h321";
        Assertions.assertThrows(NumberFormatException.class, () -> SimpleIntegerMultiplier.multiplyAlgSecond(first,notNumber));

        String emptyString = "";
        Assertions.assertThrows(NumberFormatException.class, () -> SimpleIntegerMultiplier.multiplyAlgSecond(first,emptyString));

    }

    @Test
    void timeTestMultiplyAlgSecond(){
        String first = String.valueOf(new Random().nextLong()).replaceFirst("-","");
        String second = String.valueOf(new Random().nextLong()).replaceFirst("-","");
        long start = System.nanoTime();
        for (int i = 0; i <1_000_0 ; i++) {
            SimpleIntegerMultiplier.multiplyAlgSecond(first,second);
        }
        long firstTimeMark = System.nanoTime() - start;

        long secondStart = System.nanoTime();
        for (int i = 0; i <1_000_0 ; i++) {
            SimpleIntegerMultiplier.multiplyAlgSecond(first.repeat(4),second.repeat(4));
        }
        long secondTimeMark = System.nanoTime() - start;
        Assertions.assertTrue(secondTimeMark / firstTimeMark < 5);
    }

}