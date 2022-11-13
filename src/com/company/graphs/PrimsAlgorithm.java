package com.company.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    static class Edge{

        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static  class  Pair implements Comparable<Pair>{


        int v;
        int av;
        int vw;

        public Pair(int v, int av, int vw) {
            this.v = v;
            this.av = av;
            this.vw = vw;
        }

        @Override
        public int compareTo(Pair o) {
            return this.vw - o.vw;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> p = new PriorityQueue<>();

        p.add(new Pair(0 , - 1,0));

        boolean[] visited = new boolean[vtces];
        while (!p.isEmpty()){
            Pair pair = p.remove();

            if (visited[pair.v] == true){
                continue;
            }

            visited[pair.v] = true;

           if(pair.v!=-1) System.out.println("[" + pair.v + "-" + pair.av + "@" + pair.vw + "]");

           for (Edge e:  graph[pair.v]){

               if (visited[e.dest]== false){

                   p.add(new Pair(e.dest , pair.v , e.wt));
               }

           }



        }

    }
}
