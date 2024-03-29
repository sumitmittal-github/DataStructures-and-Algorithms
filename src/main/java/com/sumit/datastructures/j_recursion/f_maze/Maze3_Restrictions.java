package com.sumit.datastructures.j_recursion.f_maze;

import java.util.LinkedList;
import java.util.List;

// Here we have few restricted cells, which shall not be considered in our paths.
public class Maze3_Restrictions {

    //Que: write down and count all the ways we can reach till end from (4,4) to (1,1) matrix
    public static void main(String[] args) {

        // false means we can not take that route
        boolean[][] allowedCells = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        // Note : we are considering the length of allowedCells matrix is the maze length.
        System.out.println(stepsCount(0, 0, allowedCells, ""));
        System.out.println(stepsList(0, 0, allowedCells, ""));


    }

    public static int stepsCount(int row, int column, boolean[][] allowedCells, String answer){
        int count = 0;

        // base condition
        if(row == allowedCells.length-1 && column == allowedCells[0].length-1) {
            System.out.println("Valid Path : "+answer);
            return 1;
        }

        // return (cancel) this recursion call if we are at restricted cell
        if(!allowedCells[row][column]) {
            System.out.println("Invalid Path : "+answer);
            return 0;
        }

        // count when moved right
        if(column < allowedCells[0].length-1)
            count += stepsCount(row, column+1, allowedCells, answer+"R");

        // count when moved down
        if(row < allowedCells.length-1)
            count += stepsCount(row+1, column, allowedCells, answer+"D");

        return count;
    }

    public static List<String> stepsList(int row, int column, boolean[][] allowedCells, String answer){
        List<String> steps = new LinkedList<>();

        // base condition
        if(row == allowedCells.length-1 && column == allowedCells[0].length-1) {
            steps.add(answer);
            return steps;
        }

        // return (cancel) this recursion call if we are at restricted cell
        if(!allowedCells[row][column]) {
            System.out.println("Invalid Path : "+answer);
            return null;
        }

        // count when moved right
        if(column < allowedCells[0].length-1){
            List<String> right = stepsList(row, column+1, allowedCells, answer+"R");
            if(right != null)
            steps.addAll(right);
        }

        // count when moved down
        if(row < allowedCells.length-1){
            List<String> down = stepsList(row+1, column, allowedCells, answer+"D");
            if(down != null)
                steps.addAll(down);
        }

        return steps;
    }

}