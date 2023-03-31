package domain;

public class Sudoku {

    public String solverSudoku(int[][] board){
        String result="";
        int [][]a= board.clone();
        if (solveBoard(a)){
            result+= printBoard(a);

        } else {
            result += "Sudoku can't solve";


        }
        return result;
    }
    private static final int Grid_Size = 9;
/*    public int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}};*/
public  boolean isNumberRow(int[][] board,int number,int row){

    for (int i = 0; i < Grid_Size; i++) {
        if (board[row][i]==number){
            return true;

        }
    }
    return false;
}

    public  boolean isNumberColumn(int[][] board,int number,int column) {

        for (int i = 0; i < Grid_Size; i++) {
            if (board[i][column] == number) {
                return true;

            }
        }
        return false;

    }
    public  boolean isNumberinBox(int[][] board,int number,int row,int column) {

    int localBoxRow= row-row%3;
    int localBoxColumn= column-column%3;
        for (int i = localBoxRow; i < localBoxRow+3; i++) {
            for (int j = localBoxColumn; j <localBoxColumn+3 ; j++) {
                if (board[i][j]==number){
                    return true;
                }

            }

        }

        return false;
    }

    public  boolean isValidPlacement(int [][]board,int number, int row,int column){

    return !isNumberRow(board, number, row)&&
            !isNumberColumn(board, number, column)&&
            !isNumberinBox(board, number, row, column);
    }
    public  boolean solveBoard(int[][]board){
        for (int row = 0; row <Grid_Size ; row++) {
            for (int column = 0; column < Grid_Size; column++) {
                if (board[row][column]==0){
                    for (int numberToTry = 1; numberToTry <=Grid_Size ; numberToTry++) {
                        if (isValidPlacement(board,numberToTry,row,column)){
                            board[row][column]=numberToTry;

                           if(solveBoard(board)) {
                               return true;
                           }
                           else{
                               board[row][column]=0;
                           }
                        }
                    }
                    return false;
                }
            }
            
        }
        return true;
    }
   public String printBoard(int[][]board){
    String result="";
       for (int row= 0; row <Grid_Size ; row++) {

           for (int column = 0; column < Grid_Size; column++) {
               result+=board[row][column]+" ";

           }

           result+="\n";

       }

       return result;
   }

}
