package domain;

public class KnightTour {

    public String solveKT(int N) {
        int sol[][] = new int[N][N];
        String result ="";

        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };


        sol[0][0] = 0;

        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            result+="Solution does not exist";
            return result;
        } else
            result+=printSolution(sol);
        return result;
    }



    static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
        int N = sol.length;
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y] = -1; // backtracking
            }
        }
        return false;
    }

    static boolean isSafe(int x, int y, int sol[][]) {
        int N= sol.length;
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }
    static String printSolution(int sol[][]) {
        String result = "";
        int N = sol.length;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++){
                if (sol[x][y]<10){
                    result+= "0"+sol[x][y]+" ";
                }else{
                    result+= ""+sol[x][y]+" ";

                }
            }
            result += "\n";
        }
        return result;
    }

} //fin
