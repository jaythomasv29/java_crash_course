package com.company.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
  private LinkedList linkedList;

  @BeforeEach
  void setUp() {
    linkedList = new LinkedList();
    linkedList.addToFront(2);
    linkedList.addToFront((1));
    linkedList.addToFront(0);
    linkedList.addToTail(3);
    linkedList.addToTail(4);
  }

  @Test
  public void addToFrontTest() {
    linkedList.addToFront(99);
    Assertions.assertEquals(99, linkedList.getHead());
  }

  @Test void linkedListSizeTest() {
    Assertions.assertEquals(5, linkedList.size());
  }

  @Test void addToTailTest() {
    linkedList.addToTail(100);
    Assertions.assertEquals(100, linkedList.getTail().getData());
  }

  @Test void clearLinkedListTest() {
    linkedList.clear();
    Assertions.assertEquals(0, linkedList.size());
  }



}