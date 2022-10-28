package com.company.arraysandhashing;

import java.util.HashMap;
import java.util.Scanner;

public class ContainsDuplicate {

    static boolean containsDuplicate(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int a : arr){

            map.put(a , map.getOrDefault(a , 0) + 1);
        }

        for(int a : map.keySet()){

            if(map.get(a) > 1) return true;
        }

        return false;

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            arr[i] = s.nextInt();
        }

        System.out.println(containsDuplicate(arr));
    }
}
