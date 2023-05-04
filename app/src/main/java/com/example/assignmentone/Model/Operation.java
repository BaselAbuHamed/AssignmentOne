package com.example.assignmentone.Model;

public class Operation {

    private char operation;
    private String equation;
    public int []choice ;

    public Operation(char operation, String equation, int[] choice) {
        this.operation = operation;
        this.equation = equation;
        this.choice = choice;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public int[] getChoice() {
        return choice;
    }

    public void setChoice(int[] choice) {
        this.choice = choice;
    }
}
