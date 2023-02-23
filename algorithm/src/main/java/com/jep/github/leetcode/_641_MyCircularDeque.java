package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-03-17 4:14 PM
 * https://juejin.im/post/5c95d2515188252dab3ebfc5
 * https://leetcode-cn.com/problems/design-circular-deque/solution/shu-zu-shi-xian-de-xun-huan-shuang-duan-dui-lie-by/
 *
 * （1）指针后移的时候，索引 + 1，要取模；
   （2）指针前移的时候，为了循环到数组的末尾，需要先加上数组的长度，然后再对数组长度取模。
 */
public class _641_MyCircularDeque {


  private int[] ring;//环形数组

  private int capacity;//数组容量

  private int head;//指向第一个元素

  private int tail;//指向最后一个元素的下一个元素

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int n : ring) {
      stringBuilder.append(n).append(",");
    }
    return stringBuilder.toString();
  }

  /**
   * Initialize your data structure here. Set the size of the deque to be k.
   */
  public _641_MyCircularDeque(int k) {
    capacity = k + 1; // 因为环形队列需要一个空位判断队列为空
    ring = new int[capacity];
  }


  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    //head始终指向第一个元素,head直接指向队尾
    head = (head - 1 + capacity) % capacity;
    ring[head] = value;
    return true;
  }


  /**
   * Adds an item at the rear of Deque. Return true if the operation is successful.
   */
  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    ring[tail] = value;
    tail = (tail + 1) % capacity;
    return true;
  }


  /**
   * Deletes an item from the front of Deque. Return true if the operation is successful.
   */
  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    head = (head + 1) % capacity;
    return true;
  }

  /**
   * Deletes an item from the rear of Deque. Return true if the operation is successful.
   */
  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    tail = (tail - 1 + capacity) % capacity;
    return true;
  }

  /**
   * Get the front item from the deque.
   */
  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return ring[head];
  }

  /**
   * Get the last item from the deque.
   */
  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    // 当 rear 为 0 时防止数组越界
    return ring[(tail - 1 + capacity) % capacity];
  }

  /**
   * Checks whether the circular deque is empty or not.
   */
  public boolean isEmpty() {
    return head == tail;
  }

  /**
   * Checks whether the circular deque is full or not.
   */
  public boolean isFull() {
    return (tail + 1) % capacity == head;
  }


  public static void main(String args[]) {
    _641_MyCircularDeque myCircularDeque = new _641_MyCircularDeque(5);

    myCircularDeque.insertFront(1);
    myCircularDeque.insertFront(2);
    myCircularDeque.insertFront(3);
    System.out.println(myCircularDeque);
    myCircularDeque.deleteFront();
    System.out.println(myCircularDeque);
    myCircularDeque.deleteLast();
    myCircularDeque.insertFront(4);
    myCircularDeque.insertLast(5);

    myCircularDeque.insertFront(6);
    myCircularDeque.insertFront(7);
    myCircularDeque.insertFront(8);
    System.out.println(myCircularDeque);
  }

}
