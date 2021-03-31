package com.jep.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @author: enping.jep
 * @create: 2021-03-30 4:46 下午
 * 最近使用过的数据应该是是「有用的」，很久都没用过的数据应该是无用的，内存满了就优先删那些很久没用过的数据。
 */
public class LRUCache {

  private final Map<Integer, DLinkedNode> map;
  private DLinkedNode head;
  private DLinkedNode tail;
  private final int capacity;


  public LRUCache(int capacity) {
    map = new HashMap<>(capacity + 2);
    this.capacity = capacity;
    // 使用伪头部和伪尾部节点
    head = new DLinkedNode();
    tail = new DLinkedNode();
    head.post = tail;
    tail.pre = head;
  }

  public int get(int key) {
    DLinkedNode node = map.get(key);
    if (node == null) {
      return -1;
    }
    // 如果 key 存在，先通过哈希表定位，再移到头部
    moveToHead(node);
    return node.value;
  }

  //将节点移动到头部
  public void moveToHead(DLinkedNode node) {
    //先移除节点
    removeNode(node);
    //添加到头部
    addToHead(node);
  }

  //移除节点
  public void removeNode(DLinkedNode node) {
    node.pre.post = node.post;
    node.post.pre = node.pre;
  }

  //添加到头部
  public void addToHead(DLinkedNode node) {
    node.pre = head;
    node.post = head.post;
    head.post.pre = node;
    head.post = node;

  }


  public void put(int key, int value) {
    DLinkedNode node = map.get(key);
    if (node == null) {
      //如果key不存在，创建新的节点
      DLinkedNode newNode = new DLinkedNode(key, value);
      //添加进hash表
      map.put(key, newNode);
      //添加到双向链表的头部
      addToHead(newNode);
      if (map.size() > capacity) {
        //如果超出容量，删除链表的尾部节点
        DLinkedNode last = removeTail();
        map.remove(last.key);
      }
    } else {
      //如果key存在，找到该值，重新赋值，再移动到头部
      node.value = value;
      moveToHead(node);

    }

  }

  public DLinkedNode removeTail() {
    DLinkedNode last = tail.pre;
    removeNode(last);
    return last;

  }

  public static void main(String args[]) {
    /**
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     *
     * [null,null,null,1,null,-1,null,-1,3,4]
     */

    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println(lruCache.get(1));
    lruCache.put(3, 3);
    System.out.println(lruCache.get(2));
    lruCache.put(4, 4);
    System.out.println(lruCache.get(1));
    System.out.println(lruCache.get(3));
    System.out.println(lruCache.get(4));


  }
}

class DLinkedNode {

  Integer key;
  Integer value;
  DLinkedNode pre;
  DLinkedNode post;

  public DLinkedNode() {

  }

  public DLinkedNode(Integer key, Integer value) {
    this.value = value;
    this.key = key;
  }

  //新增元素放到头部
  public void moveToHead(DLinkedNode head) {
    this.post = head;
    head.pre = this;
  }


  //新增元素放到，返回头结点
  public void moveToTail(DLinkedNode tail) {
    this.post = tail;
    this.pre = tail.pre;
    tail.pre.post = this;
    tail.pre = this;

  }


  public void removeNode() {
    this.pre.post = this.post;
    this.post.pre = this.pre;
  }
}
