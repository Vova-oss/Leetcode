package com.example.leetcode.Problems._InProgress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _1631_M_PathWithMinimumEffort {

    public static void main(String[] args) {
        //[],[],[5,3,5]
        System.out.println(minimumEffortPath(new int[][]{new int[]{1,2,2}, new int[]{3,8,2}, new int[]{5,3,5}})); // 2
    }

    static int rowsAmount;
    static int colsAmount;

    public static int minimumEffortPath(int[][] heights) {
        rowsAmount = heights.length;
        colsAmount = heights[0].length;
        List<Integer> collect = Arrays.stream(heights)
                .flatMapToInt(Arrays::stream)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        choseMove(collect, 0, 0, 1);
        choseMove(collect, 0, 0, 3);

        System.out.println(collect);
        return 0;
    }

    public static int choseMove(List<Integer> collect, int startPosition, int currentEffort, int move){
        return 0;
    }

}
