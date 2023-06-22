package com.example.assignmentone.Model;

import java.util.ArrayList;

public class Operation {

    private char operation;
    private String equation;
    public int []choice ;

    public int correctChoice;

    public Operation(char operation, String equation, int[] choice,int correctChoice) {
        this.operation = operation;
        this.equation = equation;
        this.choice = choice;
        this.correctChoice=correctChoice;
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

    public int getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(int correctChoice) {
        this.correctChoice = correctChoice;
    }
}
