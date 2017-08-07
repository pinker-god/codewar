package arigothm;

import java.math.BigInteger;

/**
 * @author Marko Bekhta
 */
public class TriangularNumbers {

  public static BigInteger numberOfDots(BigInteger n) {
    return n.add(BigInteger.valueOf(1)).multiply(n).divide(BigInteger.valueOf(2));
  }

}
