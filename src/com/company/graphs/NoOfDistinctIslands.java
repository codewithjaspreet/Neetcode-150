package com.company.graphs;

import java.util.HashSet;

class Solution {


    public static StringBuilder psf = new StringBuilder();

    int countDistinctIslands(int[][] arr) {
        // Your Code here
        HashSet<String> ans = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 1){
                    psf = new StringBuilder();
                    psf.append("x");
                    dfs(arr, i, j);

                    ans.add(psf.toString());
                }
            }
        }
        return ans.size();
    }
    public static void dfs(int[][] arr, int row, int col){
        arr[row][col] = 0;
        if(row - 1 >= 0 && arr[row - 1][col] == 1){
            psf.append("t");
            dfs(arr, row - 1, col);
        }
        if(col - 1 >= 0 && arr[row][col - 1] == 1){
            psf.append("l");
            dfs(arr, row, col - 1);
        }
        if(row + 1 < arr.length && arr[row + 1][col] == 1){
            psf.append("d");
            dfs(arr, row + 1, col);
        }
        if(col + 1 < arr[0].length && arr[row][col + 1] == 1){
            psf.append("r");
            dfs(arr, row, col + 1);
        }
        psf.append("b");

    }

}

