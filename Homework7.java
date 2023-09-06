package Homeworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Homework7 {

    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        int arraySize = r.nextInt(7, 16);
        for (int i = 0; i < arraySize; i++) array.add(r.nextInt(0, 101));
        System.out.println("Unsorted array");
        System.out.println(array);
        System.out.println("Sorted array");
        System.out.println(quickSort(array));
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> array) {
        if (array.size() <= 1) return array;
        Random r2 = new Random();
        int pivotIndex = r2.nextInt(array.size());
        int pivot = array.get(pivotIndex);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (Integer integer : array) {
            if (integer < pivot) left.add(integer);
            else if (integer > pivot) right.add(integer);
        }
        ArrayList<Integer> sortedLeft = quickSort(left);
        ArrayList<Integer> sortedRight = quickSort(right);
        ArrayList<Integer> output = new ArrayList<>(sortedLeft);
        output.add(pivot);
        output.addAll(sortedRight);
        return output;
    }

}
