package kata;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Xbonacci {

  public double[] xbonacci(double[] signature, int n) {
    double result[] = Arrays.copyOf(signature, n);
    double sum = 0;
    for (int i = signature.length; i < n; i++) {
      sum = 0;
      for (int j = i - 1; j > i - signature.length - 1; j--) {
        sum += result[j];
      }
      result[i] = sum;
    }
    return result;
  }
}
