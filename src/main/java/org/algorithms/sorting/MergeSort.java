package org.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] input) {
        this.mergeSort(input, 0, input.length-1);
    }
    private void mergeSort(int[] input, int l, int r) {
        if(r > l) {
            int m = (l+r) / 2;
            mergeSort(input, l, m);
            mergeSort(input, m+1, r);
            merge(input, l, m, r);
        }
    }
    private void merge(int[] input, int l, int m, int r) {
        int leftArraySize = m - l + 1;
        int rightArraySize = r - m;

        int[] leftArray = new int[leftArraySize], rightArray = new int[rightArraySize];

        for(int i=0; i<leftArraySize; i++) leftArray[i] = input[i + l];
        for(int i=0; i<rightArraySize; i++) rightArray[i] = input[i + m + 1];

        int i=0,j=0,k=l;
        while(i<leftArraySize && j<rightArraySize) {
            if(leftArray[i] < rightArray[j]) {
                input[k] = leftArray[i]; i++;
            }else {
                input[k] = rightArray[j]; j++;
            }
            k++;
        }

        while(i<leftArraySize) {
            input[k] = leftArray[i]; i++;k++;
        }

        while(j<rightArraySize) {
            input[k] = rightArray[j]; j++;k++;
        }
    }
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = new int[]{4,6,12,5,1,3,8,7};
        ms.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
 