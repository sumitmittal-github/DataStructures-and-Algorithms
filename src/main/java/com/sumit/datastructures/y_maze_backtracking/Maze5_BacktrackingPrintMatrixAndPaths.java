package com.sumit.datastructures.y_maze_backtracking;

import java.util.Arrays;

// Here can go in any direction ->  left, right, up, down
// Also print the valid paths and its matrix on the console
public class Maze5_BacktrackingPrintMatrixAndPaths {

    //Que: write down and count all the ways we can reach till end from (4,4) to (1,1) matrix
    public static void main(String[] args) {

        // false means we can not take that route
        boolean[][] allowedCells = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        // Note : we are considering the length of allowedCells matrix is the maze length.
        int[][] pathArrWithStepNumbers = new int[allowedCells.length][allowedCells[0].length];
        allPaths(0, 0, allowedCells, "", pathArrWithStepNumbers, 1);


    }


    public static void allPaths(int row, int column, boolean[][] allowedCells, String answer, int[][] pathArrWithStepNumbers, int stepNumber){

        // base condition
        if(row == allowedCells.length-1 && column == allowedCells[0].length-1) {
            // this last node is also a step hence add step number here also
            pathArrWithStepNumbers[row][column] = stepNumber;

            // we have our path : print the path and path in the array with step numbers
            System.out.println("Path : "+answer);
            printArr(pathArrWithStepNumbers);
            return;
        }

        // return (cancel) this recursion call if we are at restricted cell
        if(!allowedCells[row][column]) {
            //System.out.println("Invalid Path : "+answer);
            return;
        }

        // marked the cell as FALSE before calling next recursion call
        // We are considering this block in our path
        allowedCells[row][column] = false;
        pathArrWithStepNumbers[row][column] = stepNumber;

        // count when moved right
        if(column < allowedCells[0].length-1)
            allPaths(row, column+1, allowedCells, answer+"R", pathArrWithStepNumbers, stepNumber+1);

        // count when moved left
        if(column > 0)
            allPaths(row, column-1, allowedCells, answer+"L", pathArrWithStepNumbers, stepNumber+1);

        // count when moved down
        if(row < allowedCells.length-1)
            allPaths(row+1, column, allowedCells, answer+"D", pathArrWithStepNumbers, stepNumber+1);

        // count when moved up
        if(row > 0)
            allPaths(row-1, column, allowedCells, answer+"U", pathArrWithStepNumbers, stepNumber+1);

        // before returning re-marked the cell as TRUE
        allowedCells[row][column] = true;
        pathArrWithStepNumbers[row][column] = 0;

    }

    private static void printArr(int[][] pathArrWithStepNumbers) {
        for(int[] a : pathArrWithStepNumbers)
            System.out.println(Arrays.toString(a));
        System.out.println();
    }

}