package com.company.graphs;

import java.io.*;
import java.util.*;

public class IsConnected {

    public  static void getConnectedComponents(int vtces ,boolean visited[] ,ArrayList<Edge>[] graph,ArrayList<ArrayList<Integer>> comps){

        for(int v = 0; v < vtces; v++) {
            if(!visited[v]){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(graph, v, visited, comp);
                comps.add(comp);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
        comp.add(src);
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                dfs(graph, e.nbr, visited, comp);
            }
        }

    }
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
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

        boolean[] visited = new boolean[vtces];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        getConnectedComponents(vtces,visited,graph,comps);
        System.out.println(comps.size()  == 1);
    }



}


