package com.sumit.datastructures.y_maze_backtracking.questions;

public class BT_Q1_NQueens {

    public static void main(String[] args) {
        int n=5;
        boolean[][] emptyBoard = new boolean[n][n];
        int count = placeQueenInPassedRow(emptyBoard, 0);
        System.out.println("Number of ways we can place queen is : "+count);
    }

    public static int placeQueenInPassedRow(boolean[][] board, int row){
        // number of ways we can place n queens in the n*n board
        int count=0;

        // base condition : if we have crossed the last row, it means we have completed the queen's placement
        if(row == board.length){
            displayBoard(board);
            return 1;
        }

        // try to place queens in every column if it is safe to place that (row, column)
        for(int column = 0; column < board.length; column++){
            if(isSafe(board, row, column)){
                board[row][column] = true;                      // place queen at this row and column because it is safe
                count += placeQueenInPassedRow(board, row+1);       // try to place queen in next row
                board[row][column] = false;                     // backtrack once coming out of above line recursion call
            }
        }

        return count;
    }


    private static void displayBoard(boolean[][] board){
        for(boolean[] row : board){
            for(boolean isQueen : row){
                if(isQueen)
                    System.out.print("Q ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }



    // queen placement is safe if -
    // 1. no queen in the same row
    // 2. no queen in the same column
    // 3. no queen in the diagonals
    private static boolean isSafe(boolean[][] board, int row, int column) {
        //1. safe if - no queen in the same row
        for(int c=0; c<board.length; c++){
            if(board[row][c])
                return false;
        }

        //2. safe if - no queen in the same column
        for(int r=0; r<board.length; r++){
            if(board[r][column])
                return false;
        }

        //3. safe if - no queen in the upper left diagonal
        for(int r=row, c=column; r>=0 && c>=0; r--,c--){
            if(board[r][c])
                return false;
        }

        //4. safe if - no queen in the upper right diagonal
        for(int r=row, c=column; r>=0 && c<=board.length-1; r--,c++){
            if(board[r][c])
                return false;
        }

        //5. safe if - no queen in the below left diagonal
        for(int r=row, c=column; r<=board.length-1 && c>=0; r++,c--){
            if(board[r][c])
                return false;
        }

        //6. safe if - no queen in the below right diagonal
        for(int r=row, c=column; r<=board.length-1 && c<=board.length-1; r++,c++){
            if(board[r][c])
                return false;
        }

        return true;
    }

}
