package com.example.leetcode.Problems.NeedToOptimize;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _13_E_RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // 3
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = Map.of("I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000);

        int result = 0;

        List<Integer> collect = Arrays.stream(s.split(""))
                .map(map::get).toList();

        for (int i = 0; i <collect.size(); i++){
            if(i != collect.size()- 1 && collect.get(i) < collect.get(i + 1)){
                result = result - collect.get(i);
            } else result = result + collect.get(i);
        }

        return result;
    }


}
