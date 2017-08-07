package arigothm;

import java.util.*;

public class Josephus {
  //这种方法好简单!充分利用周期的思想.约瑟夫问题的两种解体思路:一种是这种周期思想,另一种是双向连表.
  public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
    int position = 0;
    List<T> result = new ArrayList<>();
    List<T> input = new ArrayList<>(items);
    while (input.size() > 0) {
      position = (position + k - 1) % input.size();
      result.add(input.remove(position));
    }
    return result;
  }

  private static <T> List<T> method1(List<T> items, int k) {
    List<T> result = new ArrayList<>();
    if (items.size() == 0)
      return result;
    List<T> eles = new ArrayList<>(items);
    //循环连表
    Node root = new Node(1);
    Node head = root;
    Node temp;
    for (int i = 2; i <= items.size(); i++) {
      temp = new Node(i);
      head.next = temp;
      temp.pre = head;
      head = head.next;
    }
    head.next = root;
    root.pre = head;
    head = root;
    while (eles.size() >= 1) {
      //移动k-1步
      for (int j = 1; j < k; j++) {
        head = head.next;
      }
      //第k个出列,由于eles中的size式不断减小的,故取items中的元素.
      int index = head.ele;
      eles.remove(items.get(index - 1));
      result.add(items.get(index - 1));
      head.pre.next = head.next;
      head.next.pre = head.pre;
      head = head.next;
    }
    result.addAll(eles);
    return result;
  }

  static class Node {
    Node pre;
    Node next;
    int ele;

    public Node(int ele) {
      this.ele = ele;
    }
  }
}
