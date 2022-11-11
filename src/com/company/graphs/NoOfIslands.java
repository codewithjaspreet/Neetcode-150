package com.company.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoOfIslands {

    public static void islands(int[][] arr , boolean[][] visited){

        int c = 0;
        for (int i = 0 ; i < arr.length ; i++){

            for (int j = 0; j  < arr[i].length; j++){

                if (arr[i][j] == 0 && !visited[i][j]){

                    dfs(arr , visited  ,i , j );
                    c++;
                }
            }
        }

        System.out.println(c);


    }
    static void dfs(int[][] arr , boolean[][] visited , int i , int j){

        if (i < 0 || j < 0 || i >= arr.length || j >= arr.length || arr[i][j] == 1 || visited[i][j]){

            return;
        }
        visited[i][j] = true;

        dfs(arr , visited , i-1, j);
        dfs(arr , visited , i+1, j);
        dfs(arr , visited , i, j- 1);
        dfs(arr , visited , i, j+ 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        boolean[][] visited  = new boolean[arr.length][ arr[0].length];

        islands(arr , visited);
    }
}

// on leetcode
//public class Solution {
//
//    private int n;
//    private int m;
//
//    public int numIslands(char[][] grid) {
//        int count = 0;
//        n = grid.length;
//        if (n == 0) return 0;
//        m = grid[0].length;
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < m; j++)
//                if (grid[i][j] == '1') {
//                    DFSMarking(grid, i, j);
//                    ++count;
//                }
//        }
//        return count;
//    }
//
//    private void DFSMarking(char[][] grid, int i, int j) {
//        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
//        grid[i][j] = '0';
//        DFSMarking(grid, i + 1, j);
//        DFSMarking(grid, i - 1, j);
//        DFSMarking(grid, i, j + 1);
//        DFSMarking(grid, i, j - 1);
//    }
//
//}