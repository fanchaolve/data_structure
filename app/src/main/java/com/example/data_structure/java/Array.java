package com.example.data_structure.java;


public class Array {
    //定义整型数据data保存数据
    public int data[];
    //定义数组长度
    private int n;
    //定义中实际个数
    private int count;


    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int find(int index) {
        if (index < 0 || index >= count)
            return -1;
        return data[index];

    }

    public boolean insert(int index, int value) {
        //数组已经满了
        if (count == n) {
            System.out.println("没有可插入的位置");
        }
        // 如果count 还没满 那么可以插入数据到数组中
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    //根据索引删除数据
    public boolean delete(int index) {
        if (index < 0 || index >= count)
            return false;
        //从删除位置开始，将后面的元素向前移动一位
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }



    public void printAll(){
        for (int i =0;i<count;++i){
            System.out.println(data[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[]args){
        Array array = new Array(10);
        array.printAll();
        array.insert(0,6);
        array.insert(1,7);
        array.insert(1,4);
        array.printAll();

    }

}
