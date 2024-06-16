package com.sumit.datastructures.y_maze_backtracking.questions;

public class BT_Q2_NKnights {

    public static void main(String[] args) {
        int n=3;
        boolean[][] emptyBoard = new boolean[n][n];
        int count = placeKnightInPassedRow(n, emptyBoard, 0, 0);
        System.out.println("Number of ways we can place knight is : "+count);
    }

    public static int placeKnightInPassedRow(int targetKnights, boolean[][] board, int row, int column){
        // number of ways we can place n knights in the n*n board
        int count=0;

        // base condition-1 : if we placed all the knights
        if(targetKnights == 0) {
            displayBoard(board);
            return 1;
        }
        // base condition-2 : if we are in last row and crossed the last column the quit this recursion call
        if(row == board.length-1 && column == board.length) {
            return 0;
        }

        // if we crossed the last column then start recursion with : increase the row and mark column as 0
        if(column == board.length) {
            count += placeKnightInPassedRow(targetKnights, board, row+1, 0);
            return count;
        }


        // if it is safe to place knight, then place it and start looking for new column
        if(isSafe(board, row, column)){
            board[row][column] = true;
            count += placeKnightInPassedRow(targetKnights-1, board, row, column+1);
            board[row][column] = false;
        }

        count += placeKnightInPassedRow(targetKnights, board, row, column+1);

        return count;
    }


    private static void displayBoard(boolean[][] board){
        for(boolean[] row : board){
            for(boolean isKnightPresent : row){
                if(isKnightPresent)
                    System.out.print("K ");
                else
                    System.out.print("x ");
            }
            System.out.println();
        }
        System.out.println();
    }



    // knight placement is safe if no knight is at below 4 positions -
    // (r-2, c-1)
    // (r-2, c+1)
    // (r-1, c+2)
    // (r-1, c-2)
    private static boolean isSafe(boolean[][] board, int row, int column) {
        int min = 0;                    // board start index for row or column
        int max = board.length-1;       // board last index for row or column

        //1. safe if - no knight in (r-2,c-1)
        if( isRowColInMatrixRange(board, row-2, column-1) && board[row-2][column-1] )
            return false;

        //2. safe if - no knight in (r-2,c+1)
        if( isRowColInMatrixRange(board, row-2, column+1) && board[row-2][column+1] )
            return false;

        //3. safe if - no knight in (r-1,c+2)
        if( isRowColInMatrixRange(board, row-1, column+2) && board[row-1][column+2] )
            return false;

        //4. safe if - no knight in (r-1,c-2)
        if( isRowColInMatrixRange(board, row-1, column-2) && board[row-1][column-2] )
            return false;

        return true;
    }

    private static boolean isRowColInMatrixRange(boolean[][] board, int row, int column){
        if(row >= 0 && row <= board.length-1 && column >= 0 && column <= board.length-1)
            return true;
        else
            return false;
    }

}
