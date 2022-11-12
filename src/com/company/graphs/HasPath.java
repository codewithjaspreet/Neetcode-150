package com.company.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// graph is an array of arraylist of edges
public class HasPath {

    public  static boolean hasPath(ArrayList<Edges>[] graph , int src , int dest,boolean[] visited) {

        if (src == dest) return true;

        visited[src]  = true;
        for (Edges edges : graph[src]){

            if (!visited[edges.nbr]){

                boolean hasNbrPath = hasPath(graph , edges.nbr , dest,visited);

                if (hasNbrPath) return true;
            }


        }

        return false;
    }
    static  class  Edges{

        // class of edges
        int src;
        int nbr;
        int wt;

        public Edges(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edges>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for(int i = 0; i < edges; i++){
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edges(v1, v2, wt));
            graph[v2].add(new Edges(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];

        System.out.println(hasPath(graph , src , dest , visited));

    }
}
