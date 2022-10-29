package com.company.arraysandhashing;


import java.util.Arrays;
import java.util.Scanner;
//https://leetcode.com/problems/product-of-array-except-self/discuss/1342916/3-Minute-Read-Mimicking-an-Interview
public class ProductOfArrayExceptItself {

    public static int[] helper(int[] nums) {


        // right product array

        int[] rarr= new int[nums.length];

        int p =  1;

        for(int i = nums.length - 1; i >=0 ; i--){

            p*=nums[i];
            rarr[i] = p;
        }


        // make result maintaining left array

        int prod = 1;

        int[] res = new int[nums.length];

        for(int i =  0 ; i < nums.length  - 1 ; i++){

            int lp  = prod;

            int rp = rarr[i+1];

            res[i] = lp * rp;

            prod = nums[i] * prod;


        }

        res[res.length - 1] = prod;
        return res;
    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = s.nextInt();
        }

        int[] ans = helper(arr);
        System.out.println(Arrays.toString(ans));

    }
}

