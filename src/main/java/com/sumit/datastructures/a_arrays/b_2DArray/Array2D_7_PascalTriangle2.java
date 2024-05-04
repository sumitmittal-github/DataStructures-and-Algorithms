package com.sumit.datastructures.a_arrays.b_2DArray;

import com.sumit.utils.DSAUtils;

import java.util.ArrayList;
import java.util.List;

public class Array2D_7_PascalTriangle2 {

    // LeetCode-119 : https://leetcode.com/problems/pascals-triangle-ii/description/

    public List<Integer> generate(int rowIndex) {
        // making row and column symmetric. now both will start from 0
        //rowIndex = rowIndex-1;
        // above line is not required. because we are receiving rowIndex from 0.

        // initially it is 1st row (0th index row)
        List<Integer> previousRow = new ArrayList<>();
        previousRow.add(1);

        // start from 2nd row (1st index row)
        for(int r = 1; r <= rowIndex; r++) {

            List<Integer> row = new ArrayList<>();
            for (int c = 0; c <= r; c++) {
                if(c == 0 || c == r)
                    row.add(1);
                else
                    row.add(  previousRow.get(c-1)  +  previousRow.get(c)  );
            }
            previousRow = row;
        }
        return previousRow;
    }


    public static void main(String[] args) {
        Array2D_7_PascalTriangle2 obj = new Array2D_7_PascalTriangle2();

        DSAUtils.printIntList(obj.generate(0));
        System.out.println("-----------------------");

        DSAUtils.printIntList(obj.generate(1));
        System.out.println("-----------------------");

        DSAUtils.printIntList(obj.generate(2));
        System.out.println("-----------------------");

        DSAUtils.printIntList(obj.generate(5));
        System.out.println("-----------------------");
    }

}