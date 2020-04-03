package com.example.demo;

import java.util.Arrays;

public class Algorithm {

     public  static void  select1()
     {
         int array[]={18,5,8,2,15,58,78};
         for(int i=0;i<array.length;i++){
             if(array[i]==58){
                 System.out.println(58+"的位置为："+i);
                 break;
             }
         }
     }

    public static int select2(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //select1();
        int[] array={18,5,8,2,15,58,78};
        int i;
        for (int k=0;k<array.length;k++) {
            for (i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }

        for(i=0;i<array.length;i++)
            System.out.print(array[i]+" ");


       /* Arrays.sort(array);
        int  number= select2(array,58);
        System.out.print(number);*/
    }

}
