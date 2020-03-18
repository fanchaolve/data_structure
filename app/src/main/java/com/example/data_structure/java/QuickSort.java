package com.example.data_structure.java;

/**
 * 快排思想
 * 1 首先找出分区点
 * 然后替换分区点的位置 分成两端
 * 进行递归调用
 */
public class QuickSort {


    /**
     * @param a 为数组
     * @param n 为长度
     */
    public static void reverse_quickSort(int[] a, int n) {
        reverse_quickSortInternally(a, 0, n - 1);
    }

    private static void reverse_quickSortInternally(int[] a, int p, int q) {

        if (p >= q)
            return;
        int k = reverse_partition(a, p, q);
        reverse_quickSortInternally(a, p, k - 1);
        reverse_quickSortInternally(a, k + 1, q);

    }

    public static int reverse_partition(int[] a, int p, int r) {
        int point = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] > point) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;

            }
        }

        int tmp = a[r];
        a[r] = a[i];
        a[i] = tmp;
        return i;
    }


    /**
     * @param a 为数组
     * @param n 为长度
     */
    public static void quickSort(int[] a, int n) {

        quickSortInternally(a, 0, n - 1);
    }

    /**
     * 递归调用
     * 跳出的逻辑是 p>=r
     *
     * @param a
     * @param p
     * @param r
     */
    private static void quickSortInternally(int[] a, int p, int r) {

        if (p >= r)
            return;
        int k = partition(a, p, r);

        quickSortInternally(a, p, k - 1);
        quickSortInternally(a, k + 1, r);
    }

    public static int partition(int[] a, int p, int r) {

        int point = a[r];
        int i = p;
        for (int j = p; j < r; j++) {

            if (a[j] < point) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 6, 3,23,12,4,9,13,1, 8, 5, 10};
        reverse_quickSort(a,a.length);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
        System.out.println("hahah" + a[3-1]);

    }


}
