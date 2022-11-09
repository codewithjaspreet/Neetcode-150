package com.company.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

    public  static HashMap<Integer  , ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {


        Graph g= new Graph();
        g.addEdge(0,1);
        g.addEdge(0,4);
        g.addEdge(0,5);
        g.addEdge(1,4);
        g.addEdge(1,3);
        g.addEdge(3,2);
        g.addEdge(2,1);
        g.addEdge(3,4);
        g.displayGraph();

    }


    static  void addEdge(int src , int dest ){

        if (!map.containsKey(src)){

            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(dest);
            map.put(src , arrayList);
        }
        else {

            ArrayList<Integer> arr = map.get(src);
            arr.add(dest);
            map.put(src , arr);
        }
    }

    void displayGraph(){
        for(Map.Entry m: map.entrySet()){
            System.out.println(m.getKey()+"-->"+m.getValue());
        }
    }
}
