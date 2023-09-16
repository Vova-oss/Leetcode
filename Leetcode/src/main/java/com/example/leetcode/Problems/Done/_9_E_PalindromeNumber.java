package com.example.leetcode.Problems.Done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _9_E_PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121)); // true
        System.out.println(isPalindrome(-121)); // false
        System.out.println(isPalindrome(10)); // false
    }

    /////////////////////////// FIRST WAY (long time)/////////////////////////////////////////
//    public static boolean isPalindrome(int x) {
//        if(x<0)
//            return false;
//        String str = String.valueOf(x);
//        StringBuilder after = new StringBuilder();
//        for(int i = str.length() - 1; i > -1; i--){
//            after.append(str.charAt(i));
//        }
//        return str.equals(after.toString());
//    }

    /////////////////////////// SECOND WAY (very fast)////////////////////////////////////////
    public static boolean isPalindrome(int x){
        if(x<0)
            return false;

        int inputX = x;
        int newX = 0;
        while (x!=0){
            newX = newX * 10 + x % 10;
            x = x / 10;
        }
        return inputX == newX;
    }

}
