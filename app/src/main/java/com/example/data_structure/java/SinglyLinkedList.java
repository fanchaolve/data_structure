package com.example.data_structure.java;

import java.util.NoSuchElementException;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 */
public class SinglyLinkedList {


    private Node head;


    public Node findByValue(int index) {
        Node p = head;

        while (p != null && p.data != index) {
            p = p.next;
        }

        return p;

    }

    public Node findByIndex(int index) {


        Node p = head;
        int pos = 0;

        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }


    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }


    //顺序插入
    //链表尾部插入
    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null)
            head = newNode;
        else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null)
            return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }
        Node q = head;

        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null)
            return;
        newNode.next = p;
        q.next = newNode;

    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);

    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null)
            return;
        newNode.next = p.next;
        p.next = newNode;
    }


    public void deletByNode(Node p) {
        if (p == null || head == null)
            return;
        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;

        while (q != null && q.next != p) {
            q.next = q;

        }
        if (q == null)
            return;
        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null)
            return;
        Node p = head;
        Node q = null;

        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        if (p == null)
            return;
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }


    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }


    public boolean TFResult(Node left,Node right){
        Node l = left;
        Node r = right;
        boolean flag = true;
        System.out.println("left_:"+l.data);
        System.out.println("right_"+r.data);
        while (l != null && r != null){
            if(l.data ==r.data){
                l = l.next;
                r = r.next;
                continue;
            }else {
                flag = false;
                break;
            }
        }
        System.out.println("什么结果");
        return  flag;
    }

    //判断是否回文
    public boolean palindrmoe(){
        if(head == null){
            return false;
        }else {
            System.out.println("开始执行找到中间节点");
            Node p = head;
            Node q = head;

            if(p.next == null){
                System.out.println("只有一个元素");
                return  true;
            }
            while (q.next != null && q.next.next != null){
                p = p.next;
                q = q.next.next;
            }
            System.out.println("中间节点"+p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;
            if(q.next == null){
                rightLink = p.next;
                leftLink =inverseLinkList(p).next;
                System.out.println("左边第一个节点"+leftLink.data);
                System.out.println("右边第一个节点"+rightLink.data);
            }else {
                //p q　均为中点
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return  TFResult(leftLink, rightLink);

        }

    }

    //带结点的链表翻转
    public Node inverseLinkList_head(Node p){
        Node Head = new Node(9999,null);
        // p　为原来整个链表的头结点,现在Head指向　整个链表
        Head.next = p;
        Node Cur = p.next;
        p.next = null;
        Node next = null;
        while (Cur != null){
            next = Cur.next;
            Cur.next =Head.next;

        }

        return null;

    }

    //无头结点的链表翻转
    public Node inverseLinkList(Node p){
        Node pre = null;
        Node r = head;
        System.out.println("z---"+r.data);
        Node next;
        while (r != p){
           next = r.next;
           r.next = pre;
           pre =r;
           r=next;
        }
        r.next =pre;
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;
    }

    public static class Node {
        private int data;
        private Node next;


        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();
        int data[] = {1,2,5,2,1};
        for (int i = 0;i<5;i++){
            link.insertTail(data[i]);
        }

        System.out.println("打印原始:");
        link.printAll();
        if (link.palindrmoe()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }
    }


}
