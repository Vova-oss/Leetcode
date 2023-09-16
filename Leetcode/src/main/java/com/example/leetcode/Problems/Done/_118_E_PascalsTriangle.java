package com.example.leetcode.Problems.Done;

import java.util.ArrayList;
import java.util.List;

public class _118_E_PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
//        System.out.println(generate(1));
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = List.of(1);
        result.add(first);
        if (numRows == 1)
            return result;

        List<Integer> currentLevel = List.of(1, 1);
        result.add(currentLevel);
        for (int i = 2; i < numRows; i++) {
           currentLevel = generateNextLevel(currentLevel);
           result.add(currentLevel);
        }
        return result;
    }

    public static List<Integer> generateNextLevel(List<Integer> currentLevel){
        List<Integer> nextLevel = new ArrayList<>();
        nextLevel.add(1);
        for (int i = 1; i < currentLevel.size(); i++){
            nextLevel.add(i, currentLevel.get(i - 1) + currentLevel.get(i));
        }
        nextLevel.add(1);
        return nextLevel;
    }

}
