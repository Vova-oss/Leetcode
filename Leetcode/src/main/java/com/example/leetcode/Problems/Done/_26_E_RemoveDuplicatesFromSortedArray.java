package com.example.leetcode.Problems.Done;

public class _26_E_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2})); // 2
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})); // 5
    }

    public static int removeDuplicates(int[] nums) {
        int[] expectedNums = new int[nums.length];
        int currentPosition = 0;
        expectedNums[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(expectedNums[currentPosition] != nums[i]){
                currentPosition++;
                expectedNums[currentPosition] = nums[i];
                nums[currentPosition] = expectedNums[currentPosition];
            }
        }
        return currentPosition+1;
    }

}
