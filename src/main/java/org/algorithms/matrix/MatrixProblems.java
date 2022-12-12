package org.algorithms.matrix;

import java.util.Arrays;

public class MatrixProblems {
    public static void setMatrixZeros(Matrix m) {
        int[][] data = m.data;
        int[] dumCol = new int[data.length];
        int[] dumRow = new int[data[0].length];
        Arrays.fill(dumCol, -1); Arrays.fill(dumRow, -1);
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[i].length; j++) {
                if(data[i][j] == 0) {
                    dumCol[i] = 0; dumRow[j]=0;
                }
            }
        }
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[i].length; j++) {
                if(dumCol[i] == 0 || dumRow[j] == 0) {
                    data[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Matrix m = new Matrix(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
        m.print();
        setMatrixZeros(m);
        System.out.println();
        m.print();
    }
}
