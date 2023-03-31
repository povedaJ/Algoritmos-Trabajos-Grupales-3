package domain;

import java.util.Arrays;

public class RatInMaze {

    public String solveMaze(int maze[][]) {
        String result = "";
        int [][]sol =maze.clone();
        //int sol [][] = new int [0][0];

        if (ratRoad(sol, 0, 0)) {
            result += printMaze(sol);
            System.out.println("solve maze if " + result);
            return result;


        } else {
            result += "Solution doesn't exist";
            System.out.println("else solve maze t " + result);
            return result;
        }


    }

    //format ctrl alt L
// metodo recursivo para resolver
    boolean ratRoad(int sol[][], int x, int y) {
        // int N = maze.length;
        int N = sol.length;

        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 2;
            return true;
        }

        if (isSafe(sol, x, y) == true) {
            sol[x][y] = 2;

            if (ratRoad(sol, x + 1, y))
                return true;

            if (ratRoad(sol, x, y + 1))
                return true;

            sol[x][y] = 0;
            return false;
        }

        return false;
    }//edn ratRoad

    private boolean isSafe(int[][] maze, int x, int y) {
        int N = maze.length;
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }//end is safe

    public String printMaze(int sol[][]) {
        String result = "";

        int N = sol.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += sol[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }

}//end


