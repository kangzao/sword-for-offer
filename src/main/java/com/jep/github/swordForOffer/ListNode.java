package com.jep.github.swordForOffer;

/**
 * 结点对象
 */
public class ListNode {

  int val; // 结点的值
  ListNode next; // 下一个结点

  public void printNode() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.val).append("->");
    ListNode nxt = this.next;
    while (nxt != null) {
      stringBuilder.append(nxt.val).append("->");
      nxt = nxt.next;
    }
    System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
  }

}

