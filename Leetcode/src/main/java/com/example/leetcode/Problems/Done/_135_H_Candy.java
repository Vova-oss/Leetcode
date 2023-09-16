package com.example.leetcode.Problems.Done;

import java.util.Arrays;

public class _135_H_Candy {

    public static void main(String[] args) {
//        System.out.println(candy(new int[]{1,0,2})); // [2, 1, 2] 5
        System.out.println(candy(new int[]{1,2,2})); // [1, 2, 1] 4
//        System.out.println(candy(new int[]{1,3,2,2,1})); // [1, 2, 1, 2, 1] 7
//        System.out.println(candy(new int[]{1,6,10,8,7,3,2})); // [1, 2, 5, 4, 3, 2, 1] 18
//        System.out.println(candy(new int[]{1,3,4,5,2})); // [1, 2, 3, 4, 1] 11
    }

    static int result = 0;

    public static int candy(int[] ratings) {
        if (ratings.length == 1)
            return 1;

        int[] candies = new int[ratings.length];

        int min = Arrays.stream(ratings)
                .min().orElse(-1);

        distributeOneCandy(ratings, candies, min);
        distributeRemainingSweetsLookingOnNeighbors(candies);
        System.out.println(Arrays.toString(candies));
//        return Arrays.stream(candies)
//                .reduce(0,Integer::sum);
        return result;
    }

    public static void distributeOneCandy(int[] ratings, int[]candies, int min){
        if (ratings[0] == min || ratings[0]<=ratings[1]) {
            result++;
            candies[0] = 1;
            distributionOfOneMoreCandyOnTheRight(ratings, candies, 0);
        }

        for (int i = 1; i < ratings.length-1; i++){
            if (ratings[i] == min
                    || (ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1])) {
                result++;
                candies[i] = 1;
                distributionOfOneMoreCandyOnTheLeft(ratings, candies, i);
                distributionOfOneMoreCandyOnTheRight(ratings, candies, i);
            }
        }

        if (ratings[ratings.length-1] == min || ratings[ratings.length-1]<=ratings[ratings.length-2]) {
            result++;
            candies[ratings.length - 1] = 1;
            distributionOfOneMoreCandyOnTheLeft(ratings, candies, ratings.length-1);
        }
    }

    public static void distributionOfOneMoreCandyOnTheRight(int[] ratings, int[] candies, int position){
        if (position != ratings.length-1
                && ratings[position] < ratings[position + 1]
                && candies[position + 1] == 0
                && (position == ratings.length-2 || ratings[position + 2] >= ratings[position + 1])
        ) {
            result = result + candies[position] + 1;
            candies[position + 1] = candies[position] + 1;
            distributionOfOneMoreCandyOnTheRight(ratings, candies, position + 1);
        }
    }

    public static void distributionOfOneMoreCandyOnTheLeft(int[] ratings, int[] candies, int position){
        if (position != 0
                && ratings[position] < ratings[position - 1]
                && candies[position - 1] == 0
                && (position == 1 || ratings[position - 2] >= ratings[position - 1])
        ) {
                result = result + candies[position] + 1;
                candies[position - 1] = candies[position] + 1;
                distributionOfOneMoreCandyOnTheLeft(ratings, candies, position - 1);
        }
    }

    private static void distributeRemainingSweetsLookingOnNeighbors(int[] candies) {
        for (int i = 1; i < candies.length-1; i++){
            if (candies[i] == 0){
                int currentCandy = Math.max(candies[i-1], candies[i+1])+1;
                candies[i] = currentCandy;
                result = result + currentCandy;
            }
        }
    }


    /////////////////////////////////////////////////////////////////
//    public static int candy(int[] ratings) {
//        if (ratings.length == 1)
//            return 1;
//
//        int[] candies = new int[ratings.length];
//
//        int min = Arrays.stream(ratings)
//                .min().getAsInt();
//
//        distributeOneCandy(ratings, candies, min);
//        distributeRemainingSweetsLookingOnNeighbors(candies);
//
//        return Arrays.stream(candies)
//                .reduce(0,Integer::sum);
//    }
//
//    public static void distributeOneCandy(int[] ratings, int[]candies, int min){
//        if (ratings[0] == min || ratings[0]<=ratings[1]) {
//            candies[0] = 1;
//            distributionOfOneMoreCandyOnTheRight(ratings, candies, 0);
//        }
//
//        for (int i = 1; i < ratings.length-1; i++){
//            if (ratings[i] == min
//                    || (ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1])) {
//                candies[i] = 1;
//                distributionOfOneMoreCandyOnTheLeft(ratings, candies, i);
//                distributionOfOneMoreCandyOnTheRight(ratings, candies, i);
//            }
//        }
//
//        if (ratings[ratings.length-1] == min || ratings[ratings.length-1]<=ratings[ratings.length-2]) {
//            candies[ratings.length - 1] = 1;
//            distributionOfOneMoreCandyOnTheLeft(ratings, candies, ratings.length-1);
//        }
//    }
//
//    public static void distributionOfOneMoreCandyOnTheLeft(int[] ratings, int[] candies, int position){
//        if (position != 0
//                && ratings[position] < ratings[position - 1]
//                && candies[position - 1] == 0
//                && (position == 1 || ratings[position - 2] >= ratings[position - 1])
//        ) {
//            candies[position - 1] = candies[position] + 1;
//            distributionOfOneMoreCandyOnTheLeft(ratings, candies, position - 1);
//        }
//    }
//
//    public static void distributionOfOneMoreCandyOnTheRight(int[] ratings, int[] candies, int position){
//        if (position != ratings.length-1
//                && ratings[position] < ratings[position + 1]
//                && candies[position + 1] == 0
//                && (position == ratings.length-2 || ratings[position + 2] >= ratings[position + 1])
//        ) {
//            candies[position + 1] = candies[position] + 1;
//            distributionOfOneMoreCandyOnTheRight(ratings, candies, position + 1);
//        }
//    }
//
//    private static void distributeRemainingSweetsLookingOnNeighbors(int[] candies) {
//        for (int i = 1; i < candies.length-1; i++){
//            if (candies[i] == 0){
//                candies[i] = Math.max(candies[i-1], candies[i+1])+1;
//            }
//        }
//    }

}
