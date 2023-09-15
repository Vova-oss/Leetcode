package com.example.leetcode.Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1282_GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{3,3,3,3,3,1,3}));
        System.out.println(groupThePeople(new int[]{2,1,3,3,3,2}));
        System.out.println(groupThePeople(new int[]{2,1,3,3,3,2}));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> personsInGroup = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++){
            List<Integer> currentList = personsInGroup.computeIfAbsent(groupSizes[i], integer -> new ArrayList<>());
            currentList.add(i);

            if (currentList.size() == groupSizes[i])
                result.add(personsInGroup.remove(groupSizes[i]));
        }

        return result;
    }

}
