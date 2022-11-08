package com.company.linkedlist;

import java.util.ArrayList;

public class MiddleOfLinkedList {
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
      return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
    }
  }

  public static ListNode middleNode(ListNode head) {
    ArrayList<ListNode> nodeValues = new ArrayList<>();
    ListNode current = head;
    while (current != null) {
      nodeValues.add(current);
      current = current.next;
    }
    return nodeValues.get(nodeValues.size() / 2);
  }
//    // System.out.println(length);
//    // iterate through LinkedList again till midpoint
//    current = head;
//    // int count = 0;
//    int midpoint = length / 2;
//    while(current.next != null) {
//      if (midpoint == 0) {
//        // head = current;
//        System.out.println("made it");
//        return current;
//      }
//      midpoint--;
//      current = current.next;
//    }
//    return current;


  public static void main(String[] args) {
    String s1 = Integer.toString(3);
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(6);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    System.out.println(middleNode(l1));
  }

}
