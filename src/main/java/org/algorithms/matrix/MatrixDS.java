package org.algorithms.matrix;

public class MatrixDS {
    public int[][] data;
    public MatrixDS(int[][] data) {this.data = data;}
    public void print() {
        for(int i=0;i<data.length;i++) {
            for(int j=0;j<data[0].length;j++) {
                System.out.printf("%d ",data[i][j]);
            }
            System.out.println();
        }
    }
}
