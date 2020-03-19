package com.example.data_structure.java.search;


import java.text.DecimalFormat;

/**
 * 二分查找
 */
public class BinarySearch {


    /**
     * 求一个数的平方跟
     *
     * @param k
     * @return
     *  0.000001是计算的精确阈值
     */
    public static double binarySearchSqart(double k) {

        double low = 0;
        double high = k;
        if (k == 1)
            return 1;
        double mid = 0;
        while (low < high) {
            mid = low + ((high - low) / 2);
            if (mid * mid - k > 0.000001) {
                high = mid;
            } else if (k - mid * mid > 0.000001) {
                low = mid;
            } else {
                return mid;
            }
        }
        return mid;
    }


    public static void main(String[] args) {

        DecimalFormat format = new DecimalFormat("0.000000");
        double d = binarySearchSqart(10);
        System.out.println(format.format(d));

    }
}
