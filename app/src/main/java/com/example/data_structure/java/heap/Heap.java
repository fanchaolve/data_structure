package com.example.data_structure.java.heap;

public class Heap {

    private int[] a;//数组，从下标1开始存储数据

    private int n;//堆可以存储的最大数据个数

    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }


    //插入数据 从下往上的轮询
    public void insert(int data) {
        if (count >= n) return; //堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }


    private void removeMax() {
        if (count == 0) {
            return;
        }

        a[1] = a[count];
        --count;
        heapify(a, count, 1);


    }

    //自上往下堆化 自上而下
    private void heapify(int[] a, int count, int i) {


        while (true) {
            int maxIndex = i;
            //判断父节点和左子节点
            if (i * 2 <= count && a[i] < a[i * 2]) {
                maxIndex = i * 2;
            }

            //判断父节点和右子节点
            if (i * 2 + 1 <= count && a[maxIndex] < a[i * 2 + 1]) {
                maxIndex = i * 2 + 1;
            }

            //相等 跳出循环
            if (maxIndex == i)
                break;

            swap(a, i, maxIndex);
            //赋值给i;
            i = maxIndex;
        }

    }


    //堆排序
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }

    }

    private void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    private void swap(int[] a, int i, int i1) {
        int data = a[i];
        a[i] = a[i1];
        a[i1] = data;

    }

    public static void main(String[] args) {
        Heap h = new Heap(12);
//        h.insert(20);
//        h.insert(18);
//        h.insert(3);
//        h.insert(10);
//        h.insert(5);
//        h.insert(8);
//        h.insert(7);
//        h.insert(15);
//        h.insert(6);
//        h.insert(19);
        int[] bb = new int[]{0, 7, 5, 19, 8, 4, 1, 20, 13, 16};
        h.sort(bb, bb.length - 1);

        for (int i = 0; i < bb.length; i++) {
            System.out.print(bb[i] + "\t");
        }
    }
}
