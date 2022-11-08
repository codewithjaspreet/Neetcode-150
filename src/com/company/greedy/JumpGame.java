package com.company.greedy;

import java.util.Scanner;

public class JumpGame {

    static  boolean jumpSolver(int[] arr){

        int reach = 0;

        for (int i = 0 ; i < arr.length  ;i++){

            if (reach < i) return false;

            reach = Math.max(reach , i + arr[i]);
        }

        return  true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] arr = new int[n];

        for (int i = 0 ; i < arr.length ; i++){

            arr[i] = s.nextInt();
        }

        System.out.println(jumpSolver(arr));
    }
}
