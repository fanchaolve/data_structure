package com.example.data_structure.java;

import java.util.Scanner;


/**
 * 基于单链表LRU算法
 */
public class LRUBaseLinkedList<T> {


    /**
     * 链表头部
     */
    private SNode<T> headNode;


    /**
     * 链表的长度
     */
    private Integer length;


    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;


    /**
     * 链表容量
     */
    private Integer capacity;


    private LRUBaseLinkedList() {
        headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;

    }

    public void add(T data) {
        SNode preNode = findPreNode(data);
        // 链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            intsertElemAtBegin(data);

        } else {
            if (length >= this.capacity) {
                deleteElemAtEnd();
            }
            intsertElemAtBegin(data);
        }

    }


    /**
     * 获取查找到元素的前一个结点
     *
     * @param data
     * @return
     */
    public SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode) {

        SNode temp = preNode.getNext();

        preNode.setNext(temp.getNext());
        temp = null;
        length--;

    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void intsertElemAtBegin(T data) {
        SNode temp = headNode.getNext();
        headNode.setNext(new SNode(data, temp));
        length++;

    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {

        SNode temp = headNode;
        // 空链表直接返回
        if (temp.getNext() == null) {
            return;
        }
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        SNode tmp = temp.getNext();
        temp.setNext(null);
        tmp = null;
        length--;

    }

    public void printAll() {
        SNode sNode = headNode.getNext();
        while (sNode != null) {
            System.out.println(sNode.getElement());
            sNode = sNode.getNext();
        }
        System.out.println();
    }


    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        LRUBaseLinkedList lruBaseLinkedList = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true){
            lruBaseLinkedList.add(sc.nextInt());
            lruBaseLinkedList.printAll();
        }
    }
}
