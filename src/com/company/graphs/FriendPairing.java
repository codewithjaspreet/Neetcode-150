package com.company.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FriendPairing {


    public  static ArrayList<ArrayList<Integer>> getConnectedComponents(int vtces , boolean visited[] , ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps){

        for(int v = 0; v < vtces; v++) {
            if(!visited[v]){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(graph, v, visited, comp);
                comps.add(comp);
            }
        }
        return comps;
    }

    public static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
        comp.add(src);
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.n]) {
                dfs(graph, e.n, visited, comp);
            }
        }

    }
    static class Edge{

        int v;
        int n;

        public Edge(int v, int n) {
            this.v = v;
            this.n = n;
        }
    }

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int v = 0 ; v < n ; v++ ){

            graph[v] = new ArrayList<>();
        }
        for(int e  = 0 ; e < k ; e++){

            String line = br.readLine();
            int v1 = Integer.parseInt(line.split(" ")[0]);
            int v2   = Integer.parseInt(line.split(" ")[1]);

            graph[v1].add(new Edge(v1 , v2));
            graph[v2].add(new Edge(v2, v1));

        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> temp = getConnectedComponents(n,visited,graph,comps);

        int pairs = 0;

        for (int  i = 0 ; i < comps.size(); i++){

            for (int j = i  + 1 ; j < comps.size() ; j++){

                int count = comps.get(i).size()* comps.get(j).size();
                pairs+=count;
            }
        }

        System.out.println(pairs);
    }
}