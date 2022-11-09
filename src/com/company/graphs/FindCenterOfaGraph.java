package com.company.graphs;

import java.util.HashMap;
import java.util.Map;

public class FindCenterOfaGraph {

    class Solution {
        public int findCenter(int[][] edges) {

            Map<Integer , Integer> map = new HashMap<>();


            for(int[] a : edges) {


                map.put(a[0] , map.getOrDefault(a[0] ,0) + 1);
                map.put(a[1] , map.getOrDefault(a[1] ,0) + 1);
            }

            int max  = 0 ; int key = 0;

            for(int a  : map.keySet()){

                if(map.get(a) > max) {

                    max = map.get(a);
                    key = a;

                }
            }
            return key;
        }
    }


}
