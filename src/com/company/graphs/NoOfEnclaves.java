package com.company.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// idea is to find all the ones that are connected directly or indirectly with the one that is on the boundary

// and make them all zero

// after that count all the no of ones that will give the ans

public class NoOfEnclaves {

    static void noOfEnclaves(int[][] grid){

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0  ; i < n ; i++){

            for (int j = 0 ; j < m ; j++){

                if (i == 0 || j == 0 || i == n-1 || j == m - 1){

                    if (grid[i][j] == 1){

                        dfs(grid , i , j);
                    }
                }
            }
        }

        int c = 0;
        for (int i = 0 ; i < grid.length ; i++){

            for (int j = 0  ; j < grid[0].length ; j++){

                if (grid[i][j] == 1) c++;
            }
        }

        System.out.println(c);

    }

    static void  dfs(int[][] grid , int i , int j){


        if (i < 0 || j < 0 || i >= grid.length  || j >= grid[0].length ) return;

        grid[i][j] = 0;

        dfs(grid , i+1 , j);
        dfs(grid , i-1 , j);
        dfs(grid , i , j-1);
        dfs(grid , i , j+1);



    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



    }
}
