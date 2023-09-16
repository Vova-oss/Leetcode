package com.example.leetcode.Problems.Done;

public class _1359_H_CountAllValidPickupAndDeliveryOptions {

    public static void main(String[] args) {
        System.out.println(countOrders(1));
        System.out.println(countOrders(3));
        System.out.println(countOrders(8));
        System.out.println(countOrders(18));
    }

    public static int countOrders(int n) {
        long result = 1;
        for (int i = n*2 - 1; i > 0; i=i-2){
            // Сумма чисел расчитывается по формуле: N * (N + 1) / 2
            int sum = i * (i + 1) / 2;
            result = result * sum % 1000000007;
        }

        return (int) (result % 1000000007);
    }

}
