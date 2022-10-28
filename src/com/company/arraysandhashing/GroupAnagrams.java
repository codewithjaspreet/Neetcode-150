package com.company.arraysandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GroupAnagrams {

    static List<List<String>> groupAnagrams(String[] strs){

        List<List<String>> ans = new ArrayList<>();



        HashMap<HashMap<Character,Integer> ,ArrayList<String>> bmap = new HashMap<>();

        for(String str : strs){

            HashMap<Character, Integer> fmap = new HashMap<>();

            for(char c : str.toCharArray()){
                fmap.put(c , fmap.getOrDefault(c,0 ) +1);

            }

            if(bmap.containsKey(fmap)){
                ArrayList<String> get = bmap.get(fmap);
                get.add(str);
            }
            else{

                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                bmap.put(fmap,arrayList);
            }

         }

        for (ArrayList<String> str : bmap.values()){
            ans.add(str);
        }

        return  ans;
    }

    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(arr));
    }
}
