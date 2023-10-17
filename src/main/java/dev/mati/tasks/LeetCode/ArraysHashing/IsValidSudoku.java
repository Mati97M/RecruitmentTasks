package dev.mati.tasks.LeetCode.ArraysHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class IsValidSudoku {
    public static void main(String[] args) {
        char[][] board =
                {{'.','.','.','.','5','.','.','1','.'},
                        {'.','4','.','3','.','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','1'},
                        {'8','.','.','.','.','.','.','2','.'},
                        {'.','.','2','.','7','.','.','.','.'},
                        {'.','1','5','.','.','.','.','.','.'},
                        {'.','.','.','.','.','2','.','.','.'},
                        {'.','2','.','9','.','.','.','.','.'},
                        {'.','.','4','.','.','.','.','.','.'}};

    System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        var cols = new HashMap<Integer,HashSet>();
        var subBoxes = new ArrayList<ArrayList<HashSet<Integer>>>(3);   //3x3
        for(int i = 0; i < board.length; i++) {
            var row = new HashSet<Integer>();
            if(i%3 == 0) {
                subBoxes.add(new ArrayList<>());
            }
            HashSet<Integer> col = new HashSet<>();
            for(int j = 0; j < board[0].length; j++) {
                if(j%3 == 0) {
                    subBoxes.get(i/3).add(new HashSet<>());
                }
                if(Character.isDigit(board[i][j])) {
                    int numericValue = Character.getNumericValue(board[i][j]);
                    //rows validation
                    if(!row.add(numericValue))
                        return false;
                    if(!cols.containsKey(j)) {
                        cols.put(j,new HashSet<>());
                    }
                    //cols validation
                    if(!cols.get(j).add(numericValue)) {
                        return false;
                    }
                    //subBoxes validation
                    if(!subBoxes.get(i/3).get(j/3).add(numericValue)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean isValidSudoku2(char[][] board) {
        var locations = new HashMap<Integer, LinkedList<Integer>>(9);
        //arraylist cords: xy xy xy
        var subBoxes = new ArrayList<ArrayList<HashSet<Integer>>>(3);   //3x3

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(Character.isDigit(board[i][j])) {
                    int numericValue = Character.getNumericValue(board[i][j]);
                    if(!locations.containsKey(numericValue)) {
                        locations.put(
                                numericValue,
                                new LinkedList<Integer>());
                    }

                    locations.get(numericValue)
                            .add(i);
                    locations.get(numericValue)
                            .add(j);
                }
            }
        }
        int index = 0; // even -> rows, odd -> cols
        for (var coordList: locations.values()) {
            var rows = new HashSet<Integer>();
            var cols = new HashSet<Integer>();
            for(var coord: coordList) {
                if(index%2 == 0) {
                    if(!rows.add(coord))
                        return false;
                } else {
                    if(!cols.add(coord))
                        return false;
                }
                index++;
            }
        }
        return true;
    }
}
