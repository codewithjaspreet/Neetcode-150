package com.company.maths;

import java.util.Scanner;

class RotateImage {

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        int n = s.nextInt();
        int m  = s.nextInt();

        int[][] matrix = new int[n][m];

        for(int i  =  0 ; i < n  ;i++) {

            for(int  j = 0 ;j < m ; j++){

                matrix[i][j]  = s.nextInt();
            }
        }

        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {

        Transpose(matrix);

        for(int i = 0 ; i<matrix.length  ; i++){

            int l = 0 ;
            int r = matrix[0].length -1;
            while(r>l){

                int val = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r]  = val;
                l++;
                r--;
            }
        }

    }

   static void Transpose(int[][] matrix){

        for(int i = 0 ; i<matrix.length ;i++){

            for(int j = i+1 ; j<matrix.length ; j++){

                swap(matrix , i , j);
            }
        }
    }

   static void swap(int[][] matrix , int i  , int j){

        int s  = matrix[i][j];
        matrix[i][j] =    matrix[j][i];
        matrix[j][i] = s;
    }


}
