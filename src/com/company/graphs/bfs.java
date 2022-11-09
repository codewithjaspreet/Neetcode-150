package com.company.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {

    public static ArrayList<Integer> bfsTraversal(ArrayList<ArrayList<Integer>> Adj , int V ){

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        q.add(0);
        boolean[] visited = new boolean[V];

        visited[0] = true;

        while (!q.isEmpty()){

            Integer node  = q.poll();

            ans.add(node);

            for (Integer i : Adj.get(node)){

                if (!visited[i]){

                    visited[i] = true;
                    q.add(i);
                }
            }

        }
        return  ans;

    }


}
