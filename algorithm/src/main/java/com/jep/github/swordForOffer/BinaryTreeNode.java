package com.jep.github.swordForOffer;

public class BinaryTreeNode {

  int value;
  BinaryTreeNode left = null;
  BinaryTreeNode right = null;
  BinaryTreeNode father = null;

  public BinaryTreeNode() {
  }

  public BinaryTreeNode(int data) {
    this.value = data;
  }

  @Override
  public String toString() {
    return value + "";
  }
}