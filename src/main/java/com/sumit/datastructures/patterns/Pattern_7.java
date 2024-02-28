package com.sumit.datastructures.patterns;

public class Pattern_7 {

/**
        1
      2 1 2
    3 2 1 2 3
  4 3 2 1 2 3 4
    3 2 1 2 3
      2 1 2
        1
 */
    public static void main(String[] args) {
        pattern(3);
        /**
        Ex: n = 3                                   part-1 count          part-2 count       part-2 string
          row=1  ______1                         (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
          row=2  ____2_1_2                       (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
          row=3  __3_2_1_2_3                     (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
          row=4  4_3_2_1_2_3_4                   (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
          row=5  __3_2_1_2_3                     (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
          row=6  ____2_1_2                       (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
          row=7  ______1                         (n-row)*2 spaces    +    2*row-1           row -> 1 -> row
        */
    }

    private static void pattern(int n) {
        for (int row = 1; row <= 2*n+1 ; row++) {

            int spacesCount = -1;
            int countStart = -1;
            if(row <= n+1){
                spacesCount =  (n-row+1)*2;
                countStart = row;
            } else {
                spacesCount =  (row-n-1)*2;
                countStart = 2*n-row+2;
            }

            // printing spaces
            for (int spaces = 1; spaces <= spacesCount; spaces++) {
                System.out.print("_");
            }

            // printing countStart -> 1
            for (int i = countStart; i >= 1; i--) {
                System.out.print(i+"_");
            }
            // printing 2 -> countStart
            for (int i = 2; i <= countStart; i++) {
                System.out.print(i+"_");
            }

            System.out.println();
        }
    }

}