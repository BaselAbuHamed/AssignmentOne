package com.example.assignmentone.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DAOperation {
    private static final String OPERATIONS_KEY = "operations";

    private ArrayList<Operation> operations = new ArrayList<>();
    ArrayList <Operation> temp=new ArrayList<>();
    public ArrayList<Operation> getEquation(char c){

        for (int i = 0; i <operations.size() ; i++) {
            if(operations.get(i).getOperation()==c){
                temp.add(operations.get(i));
            }
        }
        return temp;
    }
    public DAOperation(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String operationsJson = sharedPreferences.getString(OPERATIONS_KEY, null);

        if (operationsJson != null) {
            // If data exists in SharedPreferences, deserialize it and set the operations
            Type listType = new TypeToken<List<Operation>>() {}.getType();
            operations = new Gson().fromJson(operationsJson, listType);
        } else {
            // If no data exists in SharedPreferences, create the operations data
            createOperations();

            // Save the operations in SharedPreferences
            saveOperations(context);
        }
    }


    private void createOperations() {
        operations.add(new Operation('+', "5 + 7 =", new int[] {14, 12, 13, 10},12));
        operations.add(new Operation('+', "3 + 4 =", new int[] {7, 9, 8, 6},7));
        operations.add(new Operation('+', "6 + 2 =", new int[] {8, 10, 12, 7},8));
        operations.add(new Operation('+', "9 + 1 =", new int[] {10, 11, 9, 12},10));
        operations.add(new Operation('+', "8 + 7 =", new int[] {14, 15, 16, 12},15));
        operations.add(new Operation('+', "2 + 5 =", new int[] {6, 7, 8, 5},7));
        operations.add(new Operation('+', "7 + 3 =", new int[] {10, 12, 9, 11},10));
        operations.add(new Operation('+', "5 + 6 =", new int[] {10, 12, 11, 9},11));
        operations.add(new Operation('+', "4 + 8 =", new int[] {12, 10, 13, 9},12));
        operations.add(new Operation('+', "0 + 9 =", new int[] {9, 11, 8, 12},9));

        operations.add(new Operation('-', "8 - 3 =", new int[] {5, 4, 6, 3}, 5));
        operations.add(new Operation('-', "9 - 6 =", new int[] {3, 2, 5, 4}, 3));
        operations.add(new Operation('-', "12 - 4 =", new int[] {7, 6, 8, 5}, 8));
        operations.add(new Operation('-', "7 - 2 =", new int[] {5, 3, 6, 4}, 5));
        operations.add(new Operation('-', "10 - 9 =", new int[] {0, 2, 3, 1}, 1));
        operations.add(new Operation('-', "15 - 5 =", new int[] {9, 8, 10, 7}, 10));
        operations.add(new Operation('-', "20 - 8 =", new int[] {12, 11, 14, 9}, 12));
        operations.add(new Operation('-', "14 - 3 =", new int[] {10, 11, 13, 8}, 11));
        operations.add(new Operation('-', "11 - 6 =", new int[] {3, 4, 7, 5}, 5));
        operations.add(new Operation('-', "18 - 7 =", new int[] {12, 9, 11, 8}, 11));

        operations.add(new Operation('*', "4 * 3 =", new int[] {12, 10, 9, 7}, 12));
        operations.add(new Operation('*', "5 * 2 =", new int[] {8, 10, 6, 4}, 10));
        operations.add(new Operation('*', "6 * 4 =", new int[] {24, 20, 18, 16}, 24));
        operations.add(new Operation('*', "3 * 3 =", new int[] {5, 6, 8, 9}, 9));
        operations.add(new Operation('*', "7 * 2 =", new int[] {14, 12, 10, 8}, 14));
        operations.add(new Operation('*', "8 * 5 =", new int[] {37, 35, 30, 40}, 40));
        operations.add(new Operation('*', "9 * 3 =", new int[] {25, 24, 27, 18}, 27));
        operations.add(new Operation('*', "2 * 6 =", new int[] {4, 10, 8, 12}, 12));
        operations.add(new Operation('*', "10 * 4 =", new int[] {36, 32, 40, 30}, 40));
        operations.add(new Operation('*', "4 * 5 =", new int[] {16, 20, 18, 15}, 20));

        operations.add(new Operation('/', "12 / 4 =", new int[] {3, 2, 4, 6}, 3));
        operations.add(new Operation('/', "15 / 3 =", new int[] {2, 3, 5, 6}, 5));
        operations.add(new Operation('/', "24 / 6 =", new int[] {3, 4, 5, 2}, 4));
        operations.add(new Operation('/', "9 / 3 =", new int[] {3, 2, 4, 6}, 3));
        operations.add(new Operation('/', "10 / 2 =", new int[] {5, 3, 4, 6}, 5));
        operations.add(new Operation('/', "36 / 6 =", new int[] {7, 5, 6, 4}, 6));
        operations.add(new Operation('/', "20 / 5 =", new int[] {3, 4, 5, 2}, 4));
        operations.add(new Operation('/', "45 / 9 =", new int[] {7, 6, 4, 5}, 5));
        operations.add(new Operation('/', "18 / 3 =", new int[] {6, 4, 5, 3}, 6));
        operations.add(new Operation('/', "8 / 2 =", new int[] {2, 4, 3, 5}, 4));
    }

    private void saveOperations(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String operationsJson = new Gson().toJson(operations);
        editor.putString(OPERATIONS_KEY, operationsJson);
        editor.apply();
    }

    // Getter method for operations list
    public ArrayList<Operation> getOperations() {
        return operations;
    }
}