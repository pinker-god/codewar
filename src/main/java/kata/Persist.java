package kata;

class Persist {

  public static int persistence(long n) {
    String[] nums = Long.toString(n).split("");
    if (nums.length == 1)
      return 0;
    long prod = 1;
    for (String num : nums) {
      prod *= Integer.parseInt(num);
    }
    return 1 + persistence(prod);
  }

  private static int method1(long n) {
    int count = 1;
    if (n < 10)
      return 0;
    long m = getMutiply(n);
    while (m >= 10) {
      count++;
      m = getMutiply(m);
    }
    return count;
  }

  public static long getMutiply(long n) {
    int m = (int) (n % 10);
    while ((n /= 10) > 0) {
      m *= n % 10;
    }
    return m;
  }
}
