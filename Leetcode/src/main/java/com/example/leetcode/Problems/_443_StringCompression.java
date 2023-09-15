package com.example.leetcode.Problems;

public class _443_StringCompression {

    public static void main(String[] args) {
//        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
//        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    public static int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        int lastIndex = -1;
        for (int i = 0; i < chars.length-1; i++){
            if (chars[i] != chars[i+1]) {
                int size = i - lastIndex;
                if (size == 1) {
                    lastIndex++;
                    s.append(chars[i]);
                    chars[s.length()-1] = chars[i];
                } else {
                    s.append(chars[i]).append(size);
                    chars[s.length()-2] = chars[i];
                    chars[s.length()-1] = String.valueOf(size).charAt(0);
                    lastIndex = i;
                }
            }
        }

        int size = chars.length-1 - lastIndex;
        if (size == 1) {
            int index = chars.length - 1;
            s.append(chars[index]);
            chars[s.length()-1] = chars[index];
        }
        else {
            int index = chars.length - 1;
            s.append(chars[index]).append(size);
            chars[s.length()-2] = chars[index];
            chars[s.length()-1] = String.valueOf(size).charAt(0);
        }


//        for (int i = 0; i < s.length(); i++){
//            System.out.println(chars[i]);
//        }
        System.out.println(s);
        return s.length();
    }

}
