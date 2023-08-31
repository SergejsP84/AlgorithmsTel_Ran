package Lesson5;

public class ArrayShift {
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 4, 5, 6};
//        int[] arr = {18, 19, 20, 21, 22, 15, 16, 17};
//        int[] arr = {89, 90, 91, 92, 93, 94, 95, 96};
//        int[] arr = {97, 98, 99, 100, 101, 102, 103, 96};
//        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};

        // Работает со всеми приведёнными примерами, разного содержания и длины

        int start = 0;
        int end = arr.length - 1;
        if (arr.length == 1) start = end = 0;
        while (start < end) {
            int midpoint = (start + end) / 2;
            if (arr[midpoint] > arr[end]) start = midpoint + 1;
            if (arr[midpoint] < arr[end]) end = midpoint;
        }
        System.out.println("Rejoice, as thou hast foundeth that ye initial element of ye original sequence be cosily situated at index " + start);
        System.out.println("To check whether the search has been indeed narrowed down to the maximum, let us state that the value of this element is " + arr[end]);
    }
}
