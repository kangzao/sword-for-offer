package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2021-05-26 3:55 下午
 */
public class _142_DetectCycle {

  public ListNode detectCycle(ListNode head) {
    //快慢指针，快指针一次走两步，慢指针一次走一步
    /**
     假设从head到环入口需要走的步数为a，环的步数为b
     当fast和slow第一次相遇：
     f = 2s
     f = s + nb
     可以推导出：s = nb f = 2nb,意味着第一次相遇时slow走了nb步，fast走了2nb步数
     从head出发走的步数：k = a + nb,当slow和fast第一次相遇后，再让slow走a步即可
     目前不知道a的大小

     第二次相遇:
     slow不动，slow走过的路程：nb
     将fast移动到head节点，此时：f = 0，s = nb
     然后f和s同时移动，相遇点：
     f = x  s = nb + x
     推导出 x就是a 即：环的入口
     */
    ListNode fast = head, slow = head;
    while (true) {
      if (fast == null || fast.next == null) {
        return null;
      }
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        break;
      }
    }
    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }

}
