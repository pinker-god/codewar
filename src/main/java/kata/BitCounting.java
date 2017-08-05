package kata;

public class BitCounting {

  public static int countBits(int n) {
    // Show me the code!
    return method3(n);

  }

  private static int method3(int n) {
    int ret = n % 2;
    while ((n /= 2) > 0) {
      ret += n % 2;
    }
    return ret;
  }

  private static int method2(int n) {
    return Integer.bitCount(n);
  }

  private static int method1(int n) {
    String str = Integer.toBinaryString(n);
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '1')
        count++;
    }
    return count;
  }

}
