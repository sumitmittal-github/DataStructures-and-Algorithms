package com.sumit.datastructures.patterns;

public class Pattern_6 {

/**
        1
      2 1 2
    3 2 1 2 3
  4 3 2 1 2 3 4
5 4 3 2 1 2 3 4 5
 */
    public static void main(String[] args) {
        pattern(10);
        /**
        Ex: n = 5                                   part-1 count          part-2 count       part-2 string
          row=1  ________1____                   (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
          row=2  ______2_1_2___                  (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
          row=3  ____3_2_1_2_3__                 (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
          row=4  __4_3_2_1_2_3_4_                (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
          row=5  5_4_3_2_1_2_3_4_5               (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
        */
    }

    private static void pattern(int n) {
        for (int row = 1; row <= n ; row++) {

            String part1_str = "_";
            int part1_count = (n-row)*2;
            while(part1_count > 0){
                System.out.print(part1_str);
                part1_count--;
            }

            // printing row -> 1
            int part2_beginning = row;
            while (part2_beginning >= 1) {
                System.out.print(part2_beginning+"_");
                part2_beginning--;
            }

            // printing 2 -> row
            part2_beginning = 2;
            while (part2_beginning <= row) {
                System.out.print(part2_beginning+"_");
                part2_beginning++;
            }
            System.out.println("");
        }
    }

}