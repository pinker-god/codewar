package kata;

public class Money {
  public static int calculateYears(double principal, double interest, double tax, double desired) {
    // your code
    if (desired == principal)
      return 0;
    double curCapital = principal;
    int year=0;
    while (curCapital < desired) {
      curCapital += curCapital * interest * (1 - tax);
      year++;
    }
    return year;
  }

  public static void main(String[] args) {

  }

}
