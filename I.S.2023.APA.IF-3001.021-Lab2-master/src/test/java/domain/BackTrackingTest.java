package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BackTrackingTest {

    @Test
    public void test1() {
        NQueenProblem nQueen = new NQueenProblem();
        System.out.println("N Queens Problem solution for a 8x8 board");
        System.out.println(nQueen.solveNQueen(8));

        System.out.println("N Queens Problem solution for a 4x4 board");
        System.out.println(nQueen.solveNQueen(4));
    }

    @Test
    public void test2() {
        System.out.println("Rat in Maze Problem solution for 4x4 board");
        RatInMaze rat = new RatInMaze();
        int[][] maze1 = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        System.out.println(rat.solveMaze(maze1));

        System.out.println("Rat in Maze Problem solution for 8x8 board");
        int maze2[][] = {
                {1, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 1},
        };
        System.out.println(rat.solveMaze(maze2));

        System.out.println("Rat in Maze Problem solution for 8x8 board\"");

        int maze3[][] = {
                {1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 1},
        };
        System.out.println(rat.solveMaze(maze3));


    }

    @Test
    public void test3(){
        Sudoku sudoku= new Sudoku();
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        System.out.println("Sudoku\n"+sudoku.printBoard(board));
        System.out.println("Sudoku solution \n"+sudoku.solverSudoku(board));



    }
    @Test
    public void test4(){
        KnightTour knightTour = new KnightTour();
        System.out.println(" KnightTour\n"+knightTour.solveKT(8));

    }
}