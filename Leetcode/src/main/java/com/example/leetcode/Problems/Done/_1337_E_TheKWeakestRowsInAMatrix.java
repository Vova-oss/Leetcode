package com.example.leetcode.Problems.Done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1337_E_TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 1, 1, 0}, new int[]{1, 0, 0, 0, 0}, new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}}, 3)));
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{new int[]{1,0,0,0}, new int[]{1,1,1,1}, new int[]{1,0,0,0}, new int[]{1,0,0,0}}, 2)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> rowValues = checkAmountOfOnes(mat);
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = getMinRow(rowValues);
        }
        return result;
    }

    public static List<Integer> checkAmountOfOnes(int[][] mat){
        List<Integer> result = new ArrayList<>();

        for (int[] ints : mat)
            result.add(checkAmountOfOnes(ints));

        return result;
    }

    public static int checkAmountOfOnes(int[] row){
        for(int i = 0; i < row.length; i++){
            if (row[i] == 0)
                return i;
        }
        return row.length;
    }

    private static int getMinRow(List<Integer> rowValues) {
        int min = Integer.MAX_VALUE;
        int indexOfEl = 0;
        for (int i = 0; i < rowValues.size(); i++){
            if (rowValues.get(i) != null && rowValues.get(i) < min) {
                min = rowValues.get(i);
                indexOfEl = i;
            }
        }

        rowValues.set(indexOfEl, null);
        return indexOfEl;
    }
}
