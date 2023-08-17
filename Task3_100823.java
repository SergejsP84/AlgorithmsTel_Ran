package Lesson2;

import java.util.Random;

public class Task3_100823 {
    /*
    1. Самый дешёвый путь
    В каждой клетке прямоугольной таблицы N*M записано некоторое число.
    Изначально игрок находится в левой верхней клетке.
    За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз (влево и вверх перемещаться запрещено).
    При проходе через клетку игрок платит определенную сумму, какое число записано в этой клетке.
    Требуется найти минимальную стоимость пути, отдав которую игрок может попасть в правый нижний угол. */
    public static void main(String[] args) {
        Random r = new Random();
        int N = r.nextInt(3, 11); // rows
        int M = r.nextInt(3, 11); // columns
        int[][] field = new int[N][M];
        System.out.println("N = " + N);
        System.out.println("M = " + M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                field[i][j] = r.nextInt(0, 101);
            }
        } // field generation
        String space;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] < 10) space = "   ";
                else if (field[i][j] < 100) space = "  ";
                else space = " ";
                if (j == M - 1) space = space + '\n';
                System.out.print(field[i][j] + space);
            }
        }
        // Temporary, remove upon completion
        System.out.println("There are " + (N-1) + " downward moves to be made");
        System.out.println("There are " + (M-1) + " rightward moves to be made");

        int minCost = Integer.MAX_VALUE;
        int[][] memo = new int[N][M];
        int x = 0;
        int y = 0;
        int accumulatedCost = 0;
        System.out.println("The cheapest full route costs " + (exploreRoutes(x, y, field, N-1, M-1, accumulatedCost, memo) + field[N-1][M-1]));
        System.out.println("The cheapest route omitting the starting cell costs " + (exploreRoutes(x, y, field, N-1, M-1, accumulatedCost, memo) + field[N-1][M-1] - field[0][0]));
    }


    public static int exploreRoutes(int x, int y, int[][] grid, int targetX, int targetY, int accumulatedCost, int[][] memo) {
        if (x >= targetX || y >= targetY || (x == targetX && y == targetY)) {
            return accumulatedCost + grid[x][y];
        }

        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        int moveRightCost = exploreRoutes(x + 1, y, grid, targetX, targetY, accumulatedCost + grid[x][y], memo);
        int moveDownCost = exploreRoutes(x, y + 1, grid, targetX, targetY, accumulatedCost + grid[x][y], memo);
        int minCost = Math.min(moveRightCost, moveDownCost);

        memo[x][y] = minCost;
        return minCost;
    }

}
