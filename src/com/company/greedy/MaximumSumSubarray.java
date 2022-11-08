package com.company.greedy;

import java.util.Scanner;

public class MaximumSumSubarray {

    public static int solve(int[] nums){

        int sum = 0;
        int max = nums[0];

        for(int a : nums){

            sum+=a;
            max = Math.max(sum , max);
            if (sum < 0) sum = 0;

        }
        return  max;

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] arr = new int[n];

        for(int i = 0    ; i < arr.length ;i++){

            arr[i] = s.nextInt();
        }

        System.out.println(solve(arr));
    }

//    [-2,1,-3,4,-1,2,1,-5,4]
    // output - 6
}
