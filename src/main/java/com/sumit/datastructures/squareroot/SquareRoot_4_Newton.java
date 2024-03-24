package com.sumit.datastructures.squareroot;

public class SquareRoot_4_Newton {

    public static void main(String[] args) {
        int num = 40;
        double root = newtonSquareRoot(num);
        System.out.printf("%.6f", root);
    }

    private static double newtonSquareRoot(double num) {
        double root;
        double assumedRoot = num;

        while (true) {
            root = (assumedRoot + num/assumedRoot)/2;
            double error = Math.abs(assumedRoot - root);

            if(error < .01)
                break;

            assumedRoot = root;
        }
        return root;
    }

}