package org.example.core.java.test;

public class ReverseArray {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.print("Before reverse:");
        printArray(array);
        int[] arr = reverseArray(array, array.length);
        System.out.println();
        System.out.print("After reverse:");
        printArray(arr);
    }

    public static void swap(int element_a, int element_b) {
        element_b = element_a ^ element_b;
        element_a = element_a ^ element_b;
        element_b = element_a ^ element_b;
    }

    public static int[] reverseArray(int[] array, int length) {
        int first = 0;
        int last = length - 1;
        for (; first < last; first++, last--) {
            swap(array[first], array[last]);
        }
        return array;
    }
    
    public static void printArray(int[] array){
        System.out.print("[");
        for(int i = 0; i < array.length -1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1] +  "]");
    }
}
