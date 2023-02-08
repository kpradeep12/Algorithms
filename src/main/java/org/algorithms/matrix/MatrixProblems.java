package org.algorithms.matrix;

import java.util.Arrays;

public class MatrixProblems {
    public static void setMatrixZeros(MatrixDS m) {
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
    public static void rotateMatrix(MatrixDS matrix) {
        int[][] array = matrix.data;
        int n = array.length;
        for(int layer=0; layer<n/2; layer++) {
            //System.out.printf("layer: %d\n\n", layer);
            int first = layer;
            int last = n - 1 - layer;
            for(int i=first; i<last; i++) {
                int offset = i - first;
                int top = array[first][i];
                array[first][i]=array[last-offset][first];
                array[last-offset][first]=array[last][last-offset];
                array[last][last-offset]=array[i][last];
                array[i][last]=top;
                /*System.out.printf("for with %d\n",i);
                System.out.printf("top -> array[%d][%d]\n",first, i);
                System.out.printf("left -> top array[%d][%d] = array[%d][%d]\n",first, i, last - offset,first);
                System.out.printf("bottom -> left array[%d][%d] = array[%d][%d]\n",last - offset,first,last, last-offset);
                System.out.printf("right -> bottom array[%d][%d] = array[%d][%d]\n",last, last-offset,i, last);
                System.out.printf("top -> right array[%d][%d] = top\n",i, last,top);*/
            }
        }

    }
    public static void main(String[] args) {
        /*MatrixDS m = new MatrixDS(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
        m.print();
        setMatrixZeros(m);
        System.out.println();
        m.print();*/
        MatrixDS m = new MatrixDS(new int[][]{
        {0,1,2,3},
        {3,4,5,2},
        {1,3,1,5},
        {0,3,4,1}});
        m.print();
        rotateMatrix(m);
        m.print();
    }
}
