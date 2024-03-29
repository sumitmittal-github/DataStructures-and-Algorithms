package com.sumit.datastructures.j_recursion.f_maze;

import java.util.LinkedList;
import java.util.List;

public class Maze2_Diagonal {

    //Que: write down and count all the ways we can reach till end from (4,4) to (1,1) matrix
    public static void main(String[] args) {
        System.out.println(stepsCount(3,3));
        System.out.println(stepsList(3,3, ""));
        System.out.println(stepsList2(3,3, ""));

        System.out.println(stepsCount(4,4));
        System.out.println(stepsList(4,4, ""));
        System.out.println(stepsList2(4,4, ""));


    }

    public static int stepsCount(int row, int column) {
        int count = 0;

        // base condition
        if(row == 1 || column == 1)
            return 1;

        // count when moved right
        count += stepsCount(row, column-1);

        // count when moved down
        count += stepsCount(row-1, column);

        // count when moved diagonal
        count += stepsCount(row-1, column-1);

        return count;
    }

    public static List<String> stepsList(int row, int column, String answer) {
        List<String> steps = new LinkedList<>();

        // base condition
        if(row == 1 && column == 1){
            steps.add(answer);
            return steps;
        }


        // count when moved right
        // added if condition because, if we are at last column then we can not move further right in the matrix
        if(column > 1){
            int nextCol = column-1;
            steps.addAll(stepsList(row, nextCol, answer+row+nextCol+"->"));
        }

        // count when moved down
        // added if condition because, if we are at last row then we can not move further down in the matrix
        if(row > 1) {
            int nextRow = row - 1;
            steps.addAll(stepsList(nextRow, column, answer + nextRow + column + "->"));
        }

        // count when moved diagonal
        // added if condition because, if we are at last row or last column then we can not move further diagonal in the matrix
        if(row > 1 && column > 1) {
            int nextRow = row - 1;
            int nextCol = column - 1;
            steps.addAll(stepsList(nextRow, nextCol, answer + nextRow + nextCol + "->"));
        }

        return steps;
    }

    public static List<String> stepsList2(int row, int column, String answer) {
        List<String> steps = new LinkedList<>();

        // base condition
        if(row == 1 && column == 1){
            steps.add(answer);
            return steps;
        }


        // count when moved right
        // added if condition because, if we are at last column then we can not move further right in the matrix
        if(column > 1){
            steps.addAll(stepsList2(row, column-1, answer+"R"));
        }

        // count when moved down
        // added if condition because, if we are at last row then we can not move further down in the matrix
        if(row > 1) {
            steps.addAll(stepsList2(row-1, column, answer+"D"));
        }

        // count when moved diagonal
        // added if condition because, if we are at last row or last column then we can not move further diagonal in the matrix
        if(row > 1 && column > 1) {
            steps.addAll(stepsList2(row-1, column-1, answer+"#"));
        }

        return steps;
    }

}