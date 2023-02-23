package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @create: 2021-06-28 5:45 下午
 */
public class _62_LastRemaining {

  public int lastRemaining(int n, int m) {
    /**
     假设n=5,m=3
     0 1 2 3 4  第一次删除2
     3 4 0 1    第二次删除0,注意到：删除后，3的位置向左移动了m位
     1 3 4      第三次删除4
     1 3        第四次删除1 还剩下两个元素
     3          最后得到3
     3是最后剩下的，实际上是求3在原数组中的的索引位置

     最终剩下一个人时的安全位置肯定为0，反推安全位置在人数为n时的编号
     人数为1： 0
     人数为2： (0+m) % 2
     人数为3： ((0+m) % 2 + m) % 3
     人数为4： (((0+m) % 2 + m) % 3 + m) % 4
     这里的 +m 可以理解为向右移动 m 位，取余是在到达尾部还需移动时，将其移到首位
     */
    //还剩下i个元素，倒着推
    int result = 0;
    for (int i = 2; i <= n; i++) {
      result = (result + m) % i;
    }
    return result;
  }

}
