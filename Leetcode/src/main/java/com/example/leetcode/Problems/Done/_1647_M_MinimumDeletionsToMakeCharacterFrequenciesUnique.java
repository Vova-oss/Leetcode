package com.example.leetcode.Problems.Done;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class _1647_M_MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {
//        System.out.println(minDeletions("aab"));
//        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("ceabaacb"));

    }



    ////////////////////// FIRST WAY //////////////////////////////////////////////////////////////////////////////////
//    static int result = 0;
//
//    public static int minDeletions(String s) {
//        Map<String, Integer> map = Arrays.stream(s.split(""))
//                .collect(Collectors.toMap(s1 -> s1, o -> 1, Integer::sum));
//
//        Set<Integer> set = new HashSet<>();
//        for (Map.Entry<String, Integer> entry:  map.entrySet()){
//            tryToPutValueInSet(set, entry.getValue());
//        }
//
//        return result;
//    }
//
//    public static void tryToPutValueInSet(Set<Integer> set, Integer value){
//        if (value == 0)
//            return;
//
//        if (set.contains(value)){
//            value--;
//            result++;
//            tryToPutValueInSet(set, value);
//        } else set.add(value);
//    }


    ////////////////////// SECOND WAY //////////////////////////////////////////////////////////////////////////////////
//    public int minDeletions(String s) {
//        Map<String, Integer> map = Arrays.stream(s.split(""))
//                .collect(Collectors.toMap(s1 -> s1, o -> 1, Integer::sum));
//        List<Integer> values = new ArrayList<>(map.values());
//        // if (new HashSet<>(values).size() == values.size())
//        //     return 0;
//
//        values.sort(Integer::compareTo);
//        int result = 0;
//        for (int i = values.size() - 2; i >= 0; i--){
//            int currentValue = values.get(i);
//            if (currentValue >= values.get(i+1)){
//                do{
//                    currentValue--;
//                    result++;
//                } while (currentValue >= values.get(i+1) && currentValue != 0);
//                values.set(i, currentValue);
//            }
//
//        }
//
//        return result;
//    }




    ////////////////////// THIRD WAY //////////////////////////////////////////////////////////////////////////////////
//    static int result = 0;
//    public static int minDeletions(String s) {
//        char tempArray[] = s.toCharArray();
//        Arrays.sort(tempArray);
//        Set<Integer> set = new HashSet<>();
//        int count = 1;
//        for (int i = 0; i < tempArray.length-1; i++){
//            if (tempArray[i] == tempArray[i+1]){
//                count++;
//            } else {
//                tryToPutValueInSet(set, count);
//                count = 1;
//            }
//        }
//        tryToPutValueInSet(set, count);
//
//        return result;
//    }
//
//    public static void tryToPutValueInSet(Set<Integer> set, Integer value){
//        if (value == 0)
//            return;
//
//        if (set.contains(value)){
//            value--;
//            result++;
//            tryToPutValueInSet(set, value);
//        } else set.add(value);
//    }

    ////////////////////// FOURTH WAY //////////////////////////////////////////////////////////////////////////////////
    static int result = 0;
    public static int minDeletions(String s) {
        int[] amountOfLetters = new int[26];

        for (byte letter: s.getBytes(StandardCharsets.US_ASCII))
            amountOfLetters[letter - 97]++;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++){
            if (amountOfLetters[i] == 0)
                continue;

            tryToPutValueInSet(set, amountOfLetters[i]);
        }

        return result;
    }

    public static void tryToPutValueInSet(Set<Integer> set, Integer value){
        if (value == 0)
            return;

        if (set.contains(value)){
            value--;
            result++;
            tryToPutValueInSet(set, value);
        } else set.add(value);
    }

}
