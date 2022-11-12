package com.company.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CycleDetection {

    static class Edge {

        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
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
            int v3 = Integer.parseInt(parts[2]);

            graph[v1].add(new Edge(v1, v2, v3));
            graph[v2].add(new Edge(v2, v1, v3));
        }

        int src = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        System.out.println(isCyclic(graph, visited, src, vtces));
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] visited, int src, int v) {

        for (int i = 0; i < v; i++) {

            if (!visited[src]) {

                return bfs(graph, visited, src);
            }
        }

        return false;
    }

    public static boolean bfs(ArrayList<Edge>[] graph, boolean[] visited, int src) {

        Queue<Pair> q = new ArrayDeque<>();


        q.add(new Pair(src, src + ""));

        while (!q.isEmpty()) {

            Pair rem = q.poll();

            if (visited[rem.v]) {

                return true;
            }

            visited[rem.v] = true;

            for (Edge e : graph[rem.v]) {

                if (!visited[e.nbr]) {

                    q.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }


        }
        return false;
    }

    static class Pair {

        int v;
        String psf;

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }


}

//}
//7
//
//        6
//
//        0 1 10
//
//        1 2 10
//
//        2 3 10
//
//        3 4 10
//
//        4 5 10
//
//        5 6 10