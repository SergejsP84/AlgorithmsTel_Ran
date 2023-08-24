package Homeworks;

import java.util.Arrays;

public class Homework5 {
    public static void main(String[] args) {
        int[] array1 = {100, 112, 256, 349, 770};
        int[] array2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;

        System.out.println(Arrays.toString(arrayMerger(array1, array2)));
        int[] mergedArray = arrayMerger(array1, array2);
        System.out.println("The element at position K (" + k + ") in the merged array is " + elementAtPositionK(mergedArray, k));
    }

    // Я старался не применять никаких инструментов из коллекций, так как, насколько я понимаю, нужно
    // показать именно сам механизм работы. Так вообще конечно всё это проще можно сделать - просто слить, а потом отсортировать уже
    public static int[] arrayMerger(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length+array2.length];
        int indexAuxilia1 = 0;
        int indexAuxilia2 = 0;
        boolean array1Expired = false;
        boolean array2Expired = false;
        for (int i = 0; i < mergedArray.length; i++) {
            // оба массива ещё имеют значения
            if (!array1Expired && !array2Expired) {
                if (array1[indexAuxilia1] < array2[indexAuxilia2]) {
                    mergedArray[i] = array1[indexAuxilia1];
                    if (indexAuxilia1 < array1.length - 1) {
                        indexAuxilia1++;
                    } else {
                        array1Expired = true;
                    }
                } else if (array1[indexAuxilia1] > array2[indexAuxilia2]) {
                    mergedArray[i] = array2[indexAuxilia2];
                    if (indexAuxilia2 < array2.length - 1) {
                        indexAuxilia2++;
                    } else {
                        array2Expired = true;
                    }
                } else if (array1[indexAuxilia1] == array2[indexAuxilia2]) {
                    mergedArray[i] = array1[indexAuxilia1];
                    i++;
                    mergedArray[i] = array2[indexAuxilia2];
                    if (indexAuxilia1 < array1.length - 1) {
                        indexAuxilia1++;
                    } else {
                        indexAuxilia1++;
                        array1Expired = true;
                    }
                    if (indexAuxilia2 < array2.length - 1) {
                        indexAuxilia2++;
                    } else {
                        indexAuxilia2++;
                        array2Expired = true;
                    }
                }
            }
            // массив 1 разобран
            else if (array1Expired && !array2Expired) {
                mergedArray[i] = array2[indexAuxilia2];
                if (indexAuxilia2 < array2.length - 1) {
                    indexAuxilia2++;
                } else {
                    array2Expired = true;
                }
            }
            // массив 2 разобран
            else if (!array1Expired && array2Expired) {
                mergedArray[i] = array1[indexAuxilia1];
                if (indexAuxilia1 < array1.length - 1) {
                    indexAuxilia1++;
                } else {
                    array1Expired = true;
                }
            }

        }
        return mergedArray;
    }

    public static int elementAtPositionK(int[] inputArray, int k) {
        int result;
        if (k > inputArray.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
        } else {
          result = inputArray[k-1];
        }
        return result;
    }

}

