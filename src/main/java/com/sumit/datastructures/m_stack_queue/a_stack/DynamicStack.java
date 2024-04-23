package com.sumit.datastructures.m_stack_queue.a_stack;

public class DynamicStack extends CustomStack {

    public DynamicStack(){
        super();
    }

    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int num){
        if(isFull()) {
            int[] temp = new int[arr.length * 2];

            for(int i=0; i<arr.length; i++)
                temp[i] = arr[i];

            arr = temp;
        }
        return super.push(num);
    }


}
