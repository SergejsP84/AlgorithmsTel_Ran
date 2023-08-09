package Homeworks;

import java.util.Arrays;
import java.util.Random;

public class Homework2 {
    public static void main(String[] args) {
        Random r1 = new Random();
        Random r2 = new Random();
        int n = r1.nextInt(10, 101);
        int m = r1.nextInt(2, n / 2);
        System.out.println("Numbers generated for Task 1: n = " + n + ", m = " + m + ".");
        System.out.println("Task 1 solved using a cycle - output: " + task1a(n, m));
        System.out.println("Task 1 solved using recursion - output: " + task1b(n, m));
        n = r1.nextInt(0, 101);
        System.out.println("The n value generated for task 2 is: " + n);
//        System.out.println("The temporary permanent value for task 2 is 16");
        System.out.println("N-value produced using vanilla recursion: " + task2Recursion(n));
        System.out.println("N-value produced using memoizing recursion: " + task2Memoization(n));
    }

// Задача 1. Написать функцию, вычисляющую сумму тех чисел в диапазоне от 1 до n, которые делятся на m.
// Решить задачу:
//    а) через цикл
//    б) через рекурсию

    // Через цикл
    public static int task1a(int n, int m) {
        int totalSum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) totalSum = totalSum + i;
        }
        return totalSum;
    }

    // Через рекурсию
    public static int task1b(int n, int m) {
        if (n <= 0) {
            return 0;
        }
        int totalSum = task1b(n - 1, m);
        if (n % m == 0) {
            totalSum = totalSum + n;
        }
        return totalSum;
    }

//    Задача 2: Вычислить n-й член последовательности, заданной формулами:
//    a(2n) = a(n) + a(n-1),
//    a(2n+1) = a(n) — a(n-1),
//    a(0) = a(1) = 1.
//  Т.е.:
//  a(2) = a(1) + a(0) = 2
//  a(3) = a(1) - a(0) = 0
//  a(4) = a(2) + a(1) = 3
//  a(5) = a(2) - a(1) = 1
//  Решить задачу через рекурсию, и далее оптимизировать алгоритм методом мемоизации.

    // Решение 2-ой задачи через рекурсию без мемоизации
    public static int task2Recursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return task2Recursion(n / 2) + task2Recursion(n / 2 - 1); // a(2n) = a(n) + a(n-1),
        } else {
            return task2Recursion(n / 2) - task2Recursion(n / 2 - 1); // a(2n+1) = a(n) — a(n-1),
        }
    }

    // Вспомогательный "вводный" метод для второго решения задачи 2 (с мемоизацией)
    // Я не мог додуматься, как корректно передать или инициализировать в самом основном методе
    // массив интов в качестве cache, поэтому вот отдельный метод который принимает только n, а
    // ан, в свою очередь, дальше уже инициирует основной рекурсирующий метод и передаёт в него
    // склёпанный массив. Потом коллеги подсказали, что вместо массива интов можно какую-нибудь
    // более гибкую коллекцию использовать, но уже не успеваю переделать, полночь. -666 - "заглушка"
    // для пустых элементов кэша (0, -1 и всё прочее не годится, так как эти числа могут быть
    // легитимным решением для некоторых вариантов исходного n)

    public static int task2Memoization(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -666);
        return task2Memoization(n, cache);
    }

    // Решение 2-ой задачи с мемоизацией - основной метод
    public static int task2Memoization(int n, int[] cache) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cache[n] != -666) {
            return cache[n];
        }
        if (n % 2 == 0) {
            cache[n] = task2Memoization(n / 2, cache) + task2Memoization(n / 2 - 1, cache);
        } else {
            cache[n] = task2Memoization(n / 2, cache) - task2Memoization(n / 2 - 1, cache);
        }
        return cache[n];
    }

}
