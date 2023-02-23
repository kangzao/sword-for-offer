package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-19 3:06 下午
 *
 *
 * 给定一个非负整数num。对于0 ≤ i ≤ num 范围中的每个数字i，计算其二进制数中的 1 的数目并将它们作为数组返回。

    示例 1:

    输入: 2
    输出: [0,1,1]
    示例2:

    输入: 5
    输出: [0,1,1,2,1,2]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/counting-bits
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _338_CountBits {

  /**
   * x=(1001011101) 2进制
   *
   * =(605)  10进制
   *
   *
   * x' = (100101110)  2进制 =(302) 10进制
   *
   *
   * 可以发现 x'与x 只有一位不同，这是因为x' 可以看做x移除最低有效位的结果。
   *
   * 这样，我们就有了下面的状态转移函数：
   *
   *
   * P(x)=P(x/2)+(x mod 2)
   *
   * 取模优化：x % 2^N == x & (2^N - 1)
   */

  public int[] countBits(int num) {
    //f[i] = f[i - 1] >> 2 + (i mod 2)  i mod 2表示2的二进制中的最后一位
    int[] nums = new int[num + 1];
    nums[0] = 0;
    for (int i = 1; i <= num; i++) {
      nums[i] = nums[i >> 1] + (i & 1);
    }
    return nums;

  }

  public static void main(String args[]) {

  }

}
