package com.example.leetcode.Problems.Done;

public class _125_E_ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {
        int length = s.length();
        int leftPosition = 0;
        int rightPosition = length - 1;

        while (leftPosition < rightPosition){
            if (!Character.isLetterOrDigit(s.charAt(leftPosition)))
                leftPosition++;
            else if (!Character.isLetterOrDigit(s.charAt(rightPosition)))
                rightPosition--;
            else {
                if (Character.toLowerCase(s.charAt(leftPosition)) != Character.toLowerCase(s.charAt(rightPosition)))
                    return false;
                else {
                    leftPosition++;
                    rightPosition--;
                }
            }
        }
        return true;
    }

}
