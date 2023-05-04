package com.example.assignmentone.Model;

import java.util.ArrayList;

public class DAOperation {

    public ArrayList<Operation> operations =new ArrayList<>();

    public  DAOperation () {

        operations.add(new Operation('+', "5+7", new int[] {14, 12, 13, 10}));
        operations.add(new Operation('+', "3+4", new int[] {7, 9, 8, 6}));
        operations.add(new Operation('+', "6+2", new int[] {8, 10, 12, 7}));
        operations.add(new Operation('+', "9+1", new int[] {10, 11, 9, 12}));
        operations.add(new Operation('+', "8+7", new int[] {14, 15, 16, 12}));
        operations.add(new Operation('+', "2+5", new int[] {6, 7, 8, 5}));
        operations.add(new Operation('+', "7+3", new int[] {10, 12, 9, 11}));
        operations.add(new Operation('+', "5+6", new int[] {10, 12, 11, 9}));
        operations.add(new Operation('+', "4+8", new int[] {12, 10, 13, 9}));
        operations.add(new Operation('+', "0+9", new int[] {9, 11, 8, 12}));

        operations.add(new Operation('-', "8-3", new int[] {5, 4, 6, 3}));
        operations.add(new Operation('-', "9-6", new int[] {3, 2, 5, 4}));
        operations.add(new Operation('-', "12-4", new int[] {8, 6, 7, 5}));
        operations.add(new Operation('-', "7-2", new int[] {5, 3, 6, 4}));
        operations.add(new Operation('-', "10-9", new int[] {1, 2, 3, 0}));
        operations.add(new Operation('-', "15-5", new int[] {10, 8, 9, 7}));
        operations.add(new Operation('-', "20-8", new int[] {12, 11, 14, 9}));
        operations.add(new Operation('-', "14-3", new int[] {11, 10, 13, 8}));
        operations.add(new Operation('-', "11-6", new int[] {5, 4, 7, 3}));
        operations.add(new Operation('-', "18-7", new int[] {11, 9, 12, 8}));

        operations.add(new Operation('/', "12/4", new int[] {3, 2, 4, 6}));
        operations.add(new Operation('/', "15/3", new int[] {5, 3, 4, 6}));
        operations.add(new Operation('/', "24/6", new int[] {4, 3, 5, 2}));
        operations.add(new Operation('/', "9/3", new int[] {3, 2, 4, 6}));
        operations.add(new Operation('/', "10/2", new int[] {5, 3, 4, 6}));
        operations.add(new Operation('/', "36/6", new int[] {6, 5, 7, 4}));
        operations.add(new Operation('/', "20/5", new int[] {4, 3, 5, 2}));
        operations.add(new Operation('/', "45/9", new int[] {5, 6, 4, 7}));
        operations.add(new Operation('/', "18/3", new int[] {6, 4, 5, 3}));
        operations.add(new Operation('/', "8/2", new int[] {4, 2, 3, 5}));

        operations.add(new Operation('*', "4*3", new int[] {12, 10, 9, 7}));
        operations.add(new Operation('*', "5*2", new int[] {8, 10, 6, 4}));
        operations.add(new Operation('*', "6*4", new int[] {24, 20, 18, 16}));
        operations.add(new Operation('*', "3*3", new int[] {5, 6, 8, 9}));
        operations.add(new Operation('*', "7*2", new int[] {14, 12, 10, 8}));
        operations.add(new Operation('*', "8*5", new int[] {37, 35, 30, 40}));
        operations.add(new Operation('*', "9*3", new int[] {25, 24, 27, 18}));
        operations.add(new Operation('*', "2*6", new int[] {4, 10, 8, 12}));
        operations.add(new Operation('*', "10*4", new int[] {36, 32, 40, 30}));
        operations.add(new Operation('*', "4*5", new int[] {16, 20, 18,15}));
    }

}

