package p_6ku;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author pinker on 13/02/2018
 */
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import java.util.Random;

public class StatsTest {
  @Test
  public void testGetMinAvgMax() {
    int discard = 2;
    double[][] data = {{800,1200,2100,4100,1300,700}, {1000,1500,4500,5000,5800,2000,1500}};
    double[][] expect = {{2100,3100,4100}, {4500,5100,5800}, {2100,4300,5800}};
    double[][] actual = Stats.getMinAvgMax(discard , data);
    assertArrayEquals(expect, actual);
  }
  @Test
  public void testRandom4() {
    testRandom(500, 500, 1000, 200);
  }
  private void testRandom(int arrays, int lenMin, int lenMax, int discard) {
    Random rnd = new Random();
    double[][] data = rnd
      .ints(arrays, lenMin+2*discard, lenMax+2*discard)
      .mapToObj(len -> rnd.ints(len, 0, 10000).mapToDouble(i -> i)
      .toArray())
      .toArray(double[][]::new);
    double[][] expect = getMinAvgMax(discard, data);
    double[][] actual = Stats.getMinAvgMax(discard, data);
    assertEquals("bad result array length:", expect.length, actual.length);
    for (int i = 0; i < expect.length; i++) {
      assertArrayEquals("bad result array "+i, expect[i], actual[i], 1e-6);
    }
  }

  private static double[][] getMinAvgMax(int discard, double[][] data) {
    int len = data.length;
    double[][] stats = new double[len+1][];
    stats[len] = new double[]{Double.MAX_VALUE, 0, Double.MIN_VALUE};
    int total = 0;
    for (int i = 0; i < len; i++) {
      stats[i] = new double[]{Double.MAX_VALUE, 0, Double.MIN_VALUE};
      int count = 0;
      for (int j = discard; j < data[i].length - discard; j++) {
        if (data[i][j] < stats[i][0]) stats[i][0] = data[i][j]; // min
        if (data[i][j] > stats[i][2]) stats[i][2] = data[i][j]; // max
        if (data[i][j] < stats[len][0]) stats[len][0] = data[i][j]; // total min
        if (data[i][j] > stats[len][2]) stats[len][2] = data[i][j]; // total max
        stats[i][1] += data[i][j]; // sum
        stats[len][1] += data[i][j]; // total sum
        count++;
      }
      stats[i][1] /= count; // avg
      total += count;
    }
    stats[len][1] /= total; // total avg
    return stats;
  }
}

