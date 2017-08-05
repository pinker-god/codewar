package kata;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by xd031 on 2017/8/4.
 */
public class Kata {
  public static int[] invert(int[] array) {
    int[] result = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = ~array[i] + 1;
    }
    return result;
  }

  public static int TripleDouble(long num1, long num2) {
    List<String> num = findTripleNumber(num1);

    return isDoubleNumber(num2, num);
  }

  private static int isDoubleNumber(long num2, List<String> num) {
    String[] str = Long.toString(num2).split("");
    for (String temp : num) {
      for (int i = 0; i < str.length - 1; i++) {
        if (temp.equals(str[i]) && temp.equals(str[i + 1]) && ((i + 2) == str.length || !temp.equals(str[i + 2])))
          return 1;
      }
    }
    return 0;
  }

  static List<String> findTripleNumber(long num) {
    String[] str = Long.toString(num).split("");
    System.out.println(Arrays.toString(str));
    List<String> list = new ArrayList<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(str[0]);
    for (int i = 1; i < str.length; i++) {
      if (str[i].equals(queue.peek()))
        queue.offer(str[i]);
      else {
        if (queue.size() == 3)
          list.add(queue.poll());
        queue.clear();
        queue.add(str[i]);
      }
    }
    return list;
  }

  public static String createPhoneNumber(int[] numbers) {
    return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
  }

  private static String method1(int[] numbers) {
    StringBuilder builder = new StringBuilder();
    builder.append("(");
    for (int i = 0; i < 3; i++) {
      builder.append(numbers[i]);
    }
    builder.append(") ");
    for (int i = 3; i < 6; i++) {
      builder.append(numbers[i]);
    }
    builder.append("-");
    for (int i = 6; i < numbers.length; i++) {
      builder.append(numbers[i]);
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    System.out.println(createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
  }
}
