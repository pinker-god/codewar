package kata;

import java.util.*;

public class SmileFaces {


  public static int countSmileys(List<String> arr) {
    char[] faces = new char[]{':', ';', '-', '~', ')', 'D'};
    List<Character> eyes = Arrays.asList(':', ';');
    List<Character> nose = Arrays.asList('-', '~');
    List<Character> mouth = Arrays.asList(')', 'D');
    Arrays.sort(faces);
    int count = 0;
    boolean vailid;
    char key;
    int[] sort;
    for (String temp : arr) {
      vailid = true;
      sort = new int[temp.length()];
      for (int i = 0; i < temp.length(); i++) {
        key = temp.charAt(i);
        if (Arrays.binarySearch(faces, key) < 0) {
          vailid = false;
          break;
        }
        if (eyes.contains(key))
          sort[i] = 1;
        else if (nose.contains(key))
          sort[i] = 2;
        else
          sort[i] = 3;
      }
      for (int i = 0; i < sort.length - 1; i++) {
        if (sort[i] > sort[i + 1])
          vailid = false;
        if (sort[i] == sort[i + 1])
          vailid = false;
      }
      if (vailid)
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println((int) ':');
    System.out.println((int) ';');
    System.out.println((int) '-');
    System.out.println((int) '~');
    System.out.println((int) ')');
    System.out.println((int) 'D');
  }
}
