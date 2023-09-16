package com.example.leetcode.Problems.VeryHardForMe;

import java.util.*;

public class _2790_H_MaximumNumberOfGroupsWithIncreasingLength {


    public static void main(String[] args) {
        System.out.println(maxIncreasingGroups(new ArrayList<>(List.of(1,2,5)))); //3
        System.out.println(maxIncreasingGroups(new ArrayList<>(List.of(2,1,2)))); //2
        System.out.println(maxIncreasingGroups(new ArrayList<>(List.of(1,1,5)))); //2
        System.out.println(maxIncreasingGroups(new ArrayList<>(List.of(1,1,5)))); //2
    }

    public static int maxIncreasingGroups(List<Integer> usageLimits) {
        int result = 0;

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(usageLimits);

        for (int i = 1; i <= usageLimits.size(); i++){
            if (updatedNewGroup(queue, i)){
                result ++;
            } else break;
        }


//        while (!queue.isEmpty())
//            System.out.println(queue.poll());

        return result;
    }



    public static boolean updatedNewGroup(Queue<Integer> queue, int groupSize){
        if (queue.size() < groupSize)
            return false;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < groupSize; i++) {
            int temp = queue.poll();
            if (!(temp == 1))
                list.add(temp - 1);
        }

        queue.addAll(list);
        return true;
    }

}
