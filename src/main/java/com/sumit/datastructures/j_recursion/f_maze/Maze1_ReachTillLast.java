package com.sumit.datastructures.j_recursion.f_maze;

public class Maze1_ReachTillLast {

    //Que: write down and count all the ways we can reach till end from (4,4) to (1,1) matrix
    public static void main(String[] args) {
        System.out.println(stepsCount(3,3));
        System.out.println(stepsCount(4,4));
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

        return count;
    }

}