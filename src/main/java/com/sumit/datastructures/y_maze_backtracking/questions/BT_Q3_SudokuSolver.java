package com.sumit.datastructures.y_maze_backtracking.questions;

import java.util.Arrays;

public class BT_Q3_SudokuSolver {

    // LeetCode-37 : https://leetcode.com/problems/sudoku-solver/description/

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);

    }


    static boolean isSudokuSolved = false;


    public static void solveSudoku(char[][] board) {

        solveSudokuHelper(board, 0, 0);

        // print the solved sudoku
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        // we need to mark this static variable true for Leet code
        // because in leet code for multiple test cases it does not reset the static variables
        isSudokuSolved = true;
    }


    public static void solveSudokuHelper(char[][] board, int row, int column) {

        // base condition : if we are in last row and crossed the last column the quit this recursion call
        if(row == board.length) {
            isSudokuSolved = true;
            return;
        }

        if(board[row][column] == '.') {
            for(char num = '1'; num <= '9'; num++) {
                if(isSafe(board, row, column, num)) {
                    board[row][column] = num;

                    if(column == board.length-1)
                        solveSudokuHelper(board, row+1, 0);
                    else
                        solveSudokuHelper(board, row, column+1);

                    if(!isSudokuSolved)             // we added this if condition so when our sudoku will be solved then we do not want to empty the filled values
                        board[row][column] = '.';   // backtracking
                }
            }
        }
        else {
            if(column == board.length-1)
                solveSudokuHelper(board, row+1, 0);
            else
                solveSudokuHelper(board, row, column+1);
        }

    }

    private static boolean isSafe(char[][] board, int row, int column, int value)
    {
        // check in the same row and same column
        for (int i = 0; i < board.length; i++) {

            // check all cells in the same row
            if(board[row][i] == value)
                return false;

            // check all cells in the same column
            if(board[i][column] == value)
                return false;
        }

        // check in its 3x3 grid
        int startRowIndex = (row/3)*3;
        int startColumnIndex = (column/3)*3;
        for (int r = startRowIndex; r < (startRowIndex+3); r++) {
            for (int c = startColumnIndex; c < (startColumnIndex+3); c++) {
                if(board[r][c] == value)
                    return false;
            }
        }

        return true;
    }


}