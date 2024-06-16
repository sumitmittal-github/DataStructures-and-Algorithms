package com.sumit.datastructures.a_basics.a_patterns;

public class Pattern_5 {

/**
    *
   * *
  * * *
 * * * *
* * * * *
 * * * *
  * * *
   * *
    *
 */
    public static void main(String[] args) {
        pattern(4);
/**
Ex: n = 4                             part-1 count          part-2 count                 total column iteration count
  row=0  ____*____                   (n-row) spaces    +    (row+1)    *_           =>      n-row+row+1 = n+1
  row=1  ___*_*___                   (n-row) spaces    +    (row+1)    *_           =>      n-row+row+1 = n+1
  row=2  __*_*_*__                   (n-row) spaces    +    (row+1)    *_           =>      n-row+row+1 = n+1
  row=3  _*_*_*_*_                   (n-row) spaces    +    (row+1)    *_           =>      n-row+row+1 = n+1
  row=4  *_*_*_*_*                   (n-row) spaces    +    (row+1)    *_           =>      n-row+row+1 = n+1
  row=5  _*_*_*_*_                   (row-n) spaces    +    (2n-row+1) *_           =>      row-n+2n-row+1 = n+1
  row=6  __*_*_*__                   (row-n) spaces    +    (2n-row+1) *_           =>      row-n+2n-row+1 = n+1
  row=7  ___*_*___                   (row-n) spaces    +    (2n-row+1) *_           =>      row-n+2n-row+1 = n+1
  row=8  ____*____                   (row-n) spaces    +    (2n-row+1) *_           =>      row-n+2n-row+1 = n+1
*/
    }

    private static void pattern(int n){
        for (int row = 0; row < 2*n+1 ; row++) {

            String part1_str = "_";
            String part2_str = "*_";

            int part1_count = -1;
            int part2_count = -1;
            if(row <= n){
                part1_count = n-row;
                part2_count = row+1;
            } else {
                part1_count = row-n;
                part2_count = 2*n-row+1;
            }

            while(part1_count > 0){
                System.out.print(part1_str);
                part1_count--;
            }
            while(part2_count > 0){
                System.out.print(part2_str);
                part2_count--;
            }
            System.out.println("");
        }
    }

}