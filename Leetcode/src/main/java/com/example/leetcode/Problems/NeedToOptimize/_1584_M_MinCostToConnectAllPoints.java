package com.example.leetcode.Problems.NeedToOptimize;

import java.util.ArrayList;
import java.util.List;

public class _1584_M_MinCostToConnectAllPoints {

    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{new int[]{0,0}, new int[]{2,2}, new int[]{3,10}, new int[]{5,2}, new int[]{7,0} })); // 20
        System.out.println(minCostConnectPoints(new int[][]{new int[]{3,12}, new int[]{-2,5}, new int[]{-4,1}})); // 18
        System.out.println(minCostConnectPoints(new int[][]{new int[]{11,-6}, new int[]{9,-19}, new int[]{16,-13}, new int[]{4,-9}, new int[]{20,4}, new int[]{20,7}
                , new int[]{-9,18}, new int[]{10,-15}, new int[]{-15,3}, new int[]{6,6}})); // 113
        System.out.println(minCostConnectPoints(new int[][]{new int[]{9,-19}, new int[]{20,4}, new int[]{20,7}, new int[]{6,6}})); // 46

        System.out.println(minCostConnectPoints(new int[][]{new int[]{6256,82052}, new int[]{-72567,67051}, new int[]{56891, -84722}})); // 311233
    }

    public static int minCostConnectPoints(int[][] points) {
        if (points.length == 1)
            return 0;
        if (points.length == 2)
            return findDistance(points[0], points[1]);

        List<int[]> myPoints = new ArrayList<>(List.of(points));
        int result = 0;
        int[] firstPoint = myPoints.get(0);
        List<int[]> dump = new ArrayList<>(myPoints.size());
        dump.add(firstPoint);
        myPoints.remove(firstPoint);
        int index;
        do {
            int min = 9999999;
            index = -1;
            for (int[] ints : dump) {
                for (int j = 0; j < myPoints.size(); j++) {
                    int currentLength = findDistance(ints, myPoints.get(j));
                    if (min > currentLength) {
                        min = currentLength;
                        index = j;
                    }
                }
            }
            if(index != -1) {
                result = result + min;
                dump.add(myPoints.get(index));
                myPoints.remove(index);
            }
        } while (index != -1);


        return result;

    }

    public static int findDistance(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }


}
