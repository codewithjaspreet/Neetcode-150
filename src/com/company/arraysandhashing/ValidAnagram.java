package com.company.arraysandhashing;

import java.util.Scanner;

public class ValidAnagram {

    static boolean isAnagram(String s1 , String s2){

        int[] arr = new int[26];

        for(char c : s1.toCharArray()){

            arr[c - 'a']++;
        }

        for(char c : s2.toCharArray()){

            arr[c - 'a']--;
        }

        for (int a  :arr){

            if(a != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);

        String s1 = s.next();
        String s2 = s.next();

        System.out.println(isAnagram(s1 , s2));
    }
}
