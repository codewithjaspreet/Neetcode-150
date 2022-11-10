package com.company.graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AlternateGraph {

    static  class  Edge{

        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {

        int vt = 7;
        ArrayList<Edge>[] graph = new ArrayList[vt];
        for (int i = 0  ; i < vt ; i++){

            graph[i] = new ArrayList<>();

        }

        graph[0].add(new Edge(0,3,40));
        graph[0].add(new Edge(0,1,40));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,3,10));
        graph[2].add(new Edge(2,1   ,10));

        // ... so on
    }
}
