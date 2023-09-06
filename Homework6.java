package Homeworks;

import java.util.Arrays;
import java.util.Random;

public class Homework6 {

    public static void main(String[] args) {
        Random r = new Random();
        int[] array = new int[r.nextInt(5, 17)];
        for (int i = 0; i < array.length; i++) array[i] = r.nextInt(0, 101);
        System.out.println("Unsorted array");
        System.out.println(Arrays.toString(array));
        System.out.println("Sorted array");
        System.out.println(Arrays.toString((mergeSort(array))));
    }

    public static int[] mergeSort(int[] array){
        if (array.length <= 1) return array;
        int[] left = Arrays.copyOfRange(array,0,array.length/2);
        int[] right = Arrays.copyOfRange(array,array.length/2,array.length);
        return mergeBack(mergeSort(left),mergeSort(right));
        }

    public static int[] mergeBack(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                merged[mergedIndex++] = left[leftIndex++];
            } else {
                merged[mergedIndex++] = right[rightIndex++];
            }
        }
        System.arraycopy(left, leftIndex, merged, mergedIndex, left.length - leftIndex);
        System.arraycopy(right, rightIndex, merged, mergedIndex, right.length - rightIndex);
        return merged;
    }

}
