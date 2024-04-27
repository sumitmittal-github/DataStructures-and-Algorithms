package com.sumit.datastructures.a_arrays.b_2DArray;

import java.util.ArrayList;
import java.util.List;

public class Array2D_6_PascalTriangle {

    //LeetCode-118 : https://leetcode.com/problems/pascals-triangle/description/

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // making row and column symmetric. now both will start from 0
        numRows = numRows-1;

        // initially it is 1st row (0th index row)
        List<Integer> previousRow = new ArrayList<>();
        previousRow.add(1);
        triangle.add(previousRow);

        // start from 2nd row (1st index row)
        for(int r = 1; r <= numRows; r++) {

            List<Integer> row = new ArrayList<>();
            for (int c = 0; c <= r; c++) {
                if(c == 0 || c == r)
                    row.add(1);
                else
                    row.add(  previousRow.get(c-1)  +  previousRow.get(c)  );
            }
            triangle.add(row);
            previousRow = row;
        }
        return triangle;
    }


    public void display(List<List<Integer>> triangle) {
        for(List<Integer> row : triangle){
            for(Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Array2D_6_PascalTriangle obj = new Array2D_6_PascalTriangle();

        obj.display(obj.generate(1));
        System.out.println("-----------------------");

        obj.display(obj.generate(2));
        System.out.println("-----------------------");

        obj.display(obj.generate(5));
        System.out.println("-----------------------");
    }

}