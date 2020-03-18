package com.example.data_structure.java;

/**
 * 归并排序算法
 * <p>
 * <p>
 * 递归调用
 * 两种方式去合并递归的数组
 *
 * 普通方式 就是开辟临时数组 去合并
 *
 * 哨兵
 * 边界问题用哨兵处理方式
 *
 * 显然 利用哨兵方式简化了逻辑的处理
 */
public class MegeSort {


    public static void mergeSort(int[] a, int n) {
        mergeSortRecursion(a, 0, n - 1);
    }

    public static void mergeSortRecursion(int[] a, int p, int r) {

        if (p >= r)
            return;
        int q = p + (r - p) /2;
        mergeSortRecursion(a, p, q);
        mergeSortRecursion(a, q + 1, r);
        mergeWithNoSentinel(a,p,q,r);
    }


    private static void mergeWithNoSentinel(int[] a, int p, int q, int r) {
        //开辟零时数组
        int[]tmp = new int[r-p+1];
        int i=p;
        int j =q+1;

        int k =0;
        //比较两端数组从头比较 小的放到零时数组列表里面
        while (i<=q&&j<=r){
            if(a[i]<=a[j]){
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        }
        int start = i;
        int end=q;
        if(j<=r){
            start = j;
            end = r;
        }
        for (int m = start;m<=end;m++){
            tmp[k++] = a[m];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = tmp[i];
        }
    }

    //利用哨兵
    private static void mergeWith(int[] a, int p, int q, int r) {
        int[]leftArrays = new int[q-p+1+1];
        int[]rightArrays = new int[r-(q+1)+1+1];
        for (int i=0;i<=q-p;i++){
            leftArrays[i]=a[p+i];
        }
        //左边数组添加末尾哨兵
        leftArrays[q-p+1] = Integer.MAX_VALUE;
        for (int i=0;i<=(r-(q+1));i++){
            rightArrays[i] = a[q+1+i];
        }
        //右边数组添加末尾哨兵
        rightArrays[r-q] = Integer.MAX_VALUE;
        int i=0;
        int j =0;
        int k=p;
        while (k<=r){
            //哨兵这里处理边界问题 可以无限比较下去
            if(leftArrays[i] <=rightArrays[j]){
                a[k++] = leftArrays[i++];
            }else {
                a[k++] = rightArrays[j++];
            }
        }


    }


    public static void main(String[] args) {

        int [] a={ 232,34,5,2,39,450,45,56,100,34};
        mergeSort(a,a.length);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
