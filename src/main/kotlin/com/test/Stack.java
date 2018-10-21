package com.test;

import java.util.NoSuchElementException;

public class Stack<Item> {
    // private int N; // size of the stack
    private Node first; // top of stack
    private int size = 0;

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        assert check();
    }

    /**
     * Is the stack empty?
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the number of items in the stack.
     */
    public int size() {
        return size;
    }

    /**
     * Add the item to the stack.
     */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
        assert check();
    }

    /**
     * Delete and return the item most recently added to the stack.
     *
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public Item pop() {
        // FIXME throw exception if stack is Empty.
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.item; // save item to return
        first = first.next; // delete first node
        size--;
        assert check();
        return item; // return the saved item
    }

    /**
     * Return the item most recently added to the stack without deletion.
     *
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node current = first; current != null; current = current.next) {
            Item item = current.item;
            s.append(item + " ");
        }
        return s.toString();
    }

    // check internal invariants
    private boolean check() {
        if (size == 0) {
            if (first != null) {
                return false;
            }
        } else if (size == 1) {
            if (first == null) {
                return false;
            }
            if (first.next != null) {
                return false;
            }
        } else {
            if (first.next == null) {
                return false;
            }
        }

        // check internal consistency of instance variable N
        int numberOfNodes = 0;
        for (Node x = first; x != null; x = x.next) {
            numberOfNodes++;
        }
        return numberOfNodes == size;
    }
}