package com.example.leetcode.Problems.Done;

import java.util.ArrayList;
import java.util.List;

public class _14_E_LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"})); // fl
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"})); //
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder common = new StringBuilder(strs[0]);

        int k = 0;
        for (int i = 1; i < strs.length; i++){
            if(common.toString().length() >= strs[i].length()){
                common = new StringBuilder(strs[i]);
                k = i;
            }
        }

        String temp = strs[k];
        strs[k] = strs[0];
        strs[0] = temp;

        for (int j = 1; j < strs.length; j++){
            for(int i = common.length() - 1; i > -1; i--){
                if (strs[j].charAt(i) != common.charAt(i)){
                    common.delete(i, common.length());
                }
            }
            if(common.length() == 0)
                return "";
        }
        return common.toString();
    }

}
