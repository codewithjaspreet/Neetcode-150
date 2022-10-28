package com.company.arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    static  int[] twoSum(int[] arr , int target){

        HashMap<Integer , Integer> map = new HashMap<>();

        int[] ans = new int[2];
        for(int i = 0 ; i  < arr.length ; i++){

            if(map.containsKey(target - arr[i])){

                ans[0] = i;
                ans[1] = map.get(target - arr[i]);
                return  ans;
            }
            map.put(arr[i] , i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i <arr.length ; i++) {

            arr[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();
        int[] ans = twoSum(arr , target);
        System.out.println(Arrays.toString(ans));
    }
}
