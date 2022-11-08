package com.company.linkedlist;

public class LinkedList {
  @Override
  public String toString() {
    return "LinkedList{" +
      "head=" + head +
      '}';
  }

  private Node head;

  public static class Node {
    @Override
    public String toString() {
      return "Node{" +
        "data=" + data +
        ", next=" + next +
        '}';
    }

    int data;
    Node next;

    public int getData() {
      return data;
    }

    public Node(int data) { this.data = data ; }
  }

  public void addToFront(int data) {
    Node newNode = new Node(data);
    if(head == null) {
      head = newNode;
      return;
    }
    // if a head exists, set the newNode's next to continue the chain
    // set new node has LL's new head
    newNode.next = head;
    head = newNode;
  }

  public int getHead() {
    return this.head.data;
  }

  public Node getTail() {
    Node current = head;
    while (current.next != null) {
      current = current.next;
    }
    return current;
  }

  public void addToTail(int data) {
    Node currentTail = this.getTail();
    currentTail.next = new Node(data);
  }

  public void clear() {
    this.head = null;
  }

  public int size() {
  if(head == null) return 0;
    Node current = head;
    int size = 1;
    while (current.next != null) {
      size++;
    current = current.next;
  }
    return size;
  }

  public void deleteValue(int value) {
    Node current = head;
    if(current.getData() == value) {
      head = current.next;
      return;
    }
    Node next;

    while(current.next != null) {
      if(current.next.getData() == value) {
        current.next = current.next.next;
      }
      current = current.next;
    }
  }



  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    l1.addToFront(2);
    l1.addToFront((1));
    l1.addToFront(0);
    l1.addToTail(3);
    l1.deleteValue(2);
    System.out.println(l1);
  }
}
