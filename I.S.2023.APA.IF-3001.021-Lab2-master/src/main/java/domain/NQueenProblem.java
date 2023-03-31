package domain;

public class NQueenProblem {

    public String solveNQueen(int n){
        String result="";
        int[][] board = new int[n][n];

        if(placeQueens(board, 0)){
            //imprimir la solucion
            result+=printBoard(board);
        }else{
            result+="Solution does not exist for a "+n+"x"+n+" board";
        }
        return result;
    }

    //metodo para colocar las n-reinas
    private boolean placeQueens(int[][] board, int col) {
        //Caso base: todas las reinas han sido colocadas
        if(col==board.length){
            return true;
        }
        //Colocar la reina en la columna actual
        for (int row = 0; row < board.length; row++) {
            if(isSafe(board, row, col)){
                board[row][col] = 1; //coloca la reina
                //luego colocamos las reinas restantes en forma recursiva
                if(placeQueens(board, col+1)){
                    return true;
                }
                //si no se encuentra una solución, debe quitar la reina y continuar
                //probando con la siguiente fila
                board[row][col] = 0;
            }
        }
        //si no se encuentra una solucion, debera retornar false
        return false;
    }

    private boolean isSafe(int[][] board, int row, int col) {
        //comprobar la fila hacia la izq
        for (int i = 0; i < col; i++) {
            if(board[row][i]==1){
                return false;
            }
        }

        //comprobar la diagonal superior hacia la izq
        for (int i = row, j = col; i >=0 && j >=0 ; i--, j--) {
            if(board[i][j]==1){
                return false;
            }
        }

        //comprobar la diagonal inferior hacia la izq
        for (int i = row, j = col; i < board.length && j>=0; i++, j--) {
            if(board[i][j]==1){
                return false;
            }
        }

        //si es seguro, retorne true
        return true;
    }

    private String printBoard(int[][] board) {
        String result="";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                result+=board[i][j]+" ";
            }
            result+="\n";
        }
        return result;
    }
}
