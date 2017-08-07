package arigothm;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;


public class TriangularNumbersTest {
    @Test
    public void numberOfDots() {
        Assert.assertEquals(BigInteger.valueOf(1L), TriangularNumbers.numberOfDots(BigInteger.valueOf(1L)));
        Assert.assertEquals(BigInteger.valueOf(3L), TriangularNumbers.numberOfDots(BigInteger.valueOf(2L)));
        Assert.assertEquals(BigInteger.valueOf(6L), TriangularNumbers.numberOfDots(BigInteger.valueOf(3L)));
        Assert.assertEquals(BigInteger.valueOf(10L), TriangularNumbers.numberOfDots(BigInteger.valueOf(4L)));
    }
}
