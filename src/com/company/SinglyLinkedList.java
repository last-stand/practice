package com.company;

public class SinglyLinkedList {
    private Node head;

    public Node getHead(){
        return this.head;
    }

    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = this.head;
        this.head = newNode;
    }

    public  void insert(int data) {
        Node node = new Node();
        node.data = data;
        if(this.head == null){
            this.head = node;
        }
        else{
            Node current = this.head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
    }

    public void insertAtPosition(int data, int position) {
        try {
            Node node = new Node();
            node.data = data;
            Node current = this.head;
            if(position == 0) {
                node.next = current;
                this.head = node;
            }
            else {
                if(position < 0)
                    throw new IndexOutOfBoundsException();

                for (int i = 0; i < position - 1; i++) {
                    current = current.next;
                }
                node.next = current.next;
                current.next = node;
            }
        }
        catch (Exception e){
            System.out.println("Element can't be inserted on given position: " + position);
        }
    }

    public void deleteFirst() {
        this.head = this.head.next;
    }

    public void deleteFromPosition(int position) {
        Node current = this.head;
        try {
            if (position == 0) {
                this.head = current.next;
            } else {
                if(position < 0)
                    throw new IndexOutOfBoundsException();
                for (int i = 0; i < position - 1; i++) {
                    current = current.next;
                }
                current.next = current.next.next;
            }
        }
        catch (Exception ex){
            System.out.println("Element can't be deleted from given position: " + position);
        }
    }

    public void reverse() {
        Node current = this.head;
        Node next = null;
        Node previous = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public boolean compareLists(Node head2){
        Node current = this.head;
        boolean isEqual = true;
        while(current != null && head2 != null){
            if(current.data != head2.data){
                isEqual = false;
            }
            current = current.next;
            head2 = head2.next;
        }
        return (current == null && head2 == null) && isEqual;
    }

    public void print() {
        Node current = this.head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printReverse(Node node){
        if(node == null)
            return;
        printReverse(node.next);
        System.out.print(node.data + " ");
    }

    public Node mergeLists(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return (head1 == null) ? head2 : head1;
        }
        Node current =  new Node();
        Node dummyNode = current;
        while (head1 != null && head2 != null){
            if(head1.data < head2.data){
                current.next = head1;
                head1 = head1.next;
            }
            else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        current.next = (head1 == null) ? head2 : head1;
        return dummyNode.next;
    }
    
    private static class Node {
        int data;
        Node next;
    }
}
