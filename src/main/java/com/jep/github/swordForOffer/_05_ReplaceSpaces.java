package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/11/27
 * @create 2019-11-27 10:12 AM
 *
 *
 * 将一个字符串中的空格替换成 "%20"。
      Input:
      "A B"

      Output:
      "A%20B"
 */
public class _05_ReplaceSpaces {

  public static String replaceSpaces(StringBuilder str) {
    //因为一个空格要替换成三个字符（%20），因此当遍历到一个空格时，需要在尾部填充两个任意字符
    int P1 = str.length() - 1;
    for (int i = 0; i <= P1; i++) {
      if (str.charAt(i) == ' ') {
        //末尾补齐两个空格
        str.append("  ");
      }
    }
    //令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，
    // 就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
    int P2 = str.length() - 1;
    while (P1 >= 0) {
      System.out.println(str.toString());
      char c = str.charAt(P1--);
      if (c == ' ') {
        str.setCharAt(P2--, '0');
        str.setCharAt(P2--, '2');
        str.setCharAt(P2--, '%');
      } else {
        str.setCharAt(P2--, c);
      }
    }
    return str.toString();


  }


  public static void main(String args[]) {
    StringBuilder stringBuilder = new StringBuilder(" e  re  a p ");
    System.out.println(replaceSpaces(stringBuilder));
    StringBuilder stringBuilder1 = new StringBuilder("who  are u");
    System.out.println(replaceSpaces(stringBuilder1));
  }

}
