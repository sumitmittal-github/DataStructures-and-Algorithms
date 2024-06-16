package com.sumit.datastructures.g_stack_queue.questions;

import java.util.Stack;

public class SQ_Q2_GameOfTwoStacks {

    // https://www.hackerrank.com/challenges/game-of-two-stacks/problem

    public int findMaxScore(Stack<Integer> stack1, Stack<Integer> stack2, int maxSum){
        return helper(stack1, stack2, 0, maxSum, 0);
    }


    // numberOfElementsPicked : Number of elements picked from both stacks
    private int helper(Stack<Integer> stack1, Stack<Integer> stack2, int currentSum, int maxSum, int numberOfElementsPicked){
        if(currentSum > maxSum)
            return numberOfElementsPicked-1;

        int numberOfElementsPickedLeftTree = 0;
        if(!stack1.isEmpty()) {
            currentSum += stack1.pop();
            numberOfElementsPicked++;
            numberOfElementsPickedLeftTree = helper(stack1, stack2, currentSum, maxSum, numberOfElementsPicked);
        }

        int numberOfElementsPickedRightTree = 0;
        if(!stack2.isEmpty()){
            currentSum += stack2.pop();
            numberOfElementsPicked++;
            numberOfElementsPickedRightTree = helper(stack1, stack2, currentSum, maxSum, numberOfElementsPicked);
        }

        return Math.max(numberOfElementsPickedLeftTree, numberOfElementsPickedRightTree);
    }





    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack();
        //stack1.push(1); stack1.push(2); stack1.push(3); stack1.push(4); stack1.push(5);
        stack1.push(1); stack1.push(6); stack1.push(4); stack1.push(2); stack1.push(4);

        Stack<Integer> stack2 = new Stack();
        //stack2.push(1); stack2.push(1); stack2.push(1); stack2.push(1); stack2.push(1); stack2.push(6);
        stack2.push(5); stack2.push(8); stack2.push(1); stack2.push(2);

        SQ_Q2_GameOfTwoStacks obj = new SQ_Q2_GameOfTwoStacks();
        int maxScore = obj.findMaxScore(stack1, stack2, 10);
        System.out.println("Max score : "+maxScore);
    }

}