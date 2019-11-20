package com.example.data_structure.java;

import java.util.LinkedList;

public class SampleBrowser {


    private String currentPage;

    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;




    public void goBack() {

    }

    public void goForward() {

    }

    public void open() {

    }

    public static class LinkedListBasedStack {


        private int size;

        private Node top;


        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        public void clear() {
            this.top = null;
            this.size = 0;
        }

        public void push(String data) {
            Node node = createNode(data, this.top);
            this.top = node;
            this.size++;
        }

        public String pop(){
            Node popNode = this.top;
            if(popNode == null){
                System.out.println("Stack is empty.");
                return null;

            }
            this.top = popNode.next;
            if(this.size>0){
                this.size--;
            }
            return popNode.data;
        }


        public static class Node {
            private String data;
            private Node next;

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }

    }


}
