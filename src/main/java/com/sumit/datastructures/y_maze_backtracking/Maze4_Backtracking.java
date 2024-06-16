package com.sumit.datastructures.y_maze_backtracking;

import java.util.LinkedList;
import java.util.List;

// Here can go in any direction ->  left, right, up, down
public class Maze4_Backtracking {

    public static void main(String[] args) {

        // false means we can not take that route
        boolean[][] allowedCells = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        // Note : we are considering the length of allowedCells matrix is the maze length.
        System.out.println(allPaths(0, 0, allowedCells, ""));
    }


    public static List<String> allPaths(int row, int column, boolean[][] allowedCells, String answer){
        List<String> paths = new LinkedList<>();

        // base condition
        if(row == allowedCells.length-1 && column == allowedCells[0].length-1) {
            paths.add(answer);
            return paths;
        }

        // return (cancel) this recursion call if we are at restricted cell
        if(!allowedCells[row][column]) {
            System.out.println("Invalid Path : "+answer);
            return null;
        }

        // marked the cell as FALSE before calling next recursion call
        // We are considering this block in our path
        allowedCells[row][column] = false;

        // count when moved right
        if(column < allowedCells[0].length-1){
            List<String> right = allPaths(row, column+1, allowedCells, answer+"R");
            if(right != null)
                paths.addAll(right);
        }

        // count when moved left
        if(column > 0){
            List<String> left = allPaths(row, column-1, allowedCells, answer+"L");
            if(left != null)
                paths.addAll(left);
        }

        // count when moved down
        if(row < allowedCells.length-1){
            List<String> down = allPaths(row+1, column, allowedCells, answer+"D");
            if(down != null)
                paths.addAll(down);
        }

        // count when moved up
        if(row > 0){
            List<String> up = allPaths(row-1, column, allowedCells, answer+"U");
            if(up != null)
                paths.addAll(up);
        }

        // before returning re-marked the cell as TRUE
        allowedCells[row][column] = true;

        return paths;
    }

}