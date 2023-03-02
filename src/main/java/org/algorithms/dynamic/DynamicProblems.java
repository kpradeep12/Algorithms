package org.algorithms.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class DynamicProblems {
    
    public static int fibonacciOf(int n) {
        if(n == 0) return 0;
        int n1 = 1, n2 = 0, next = 0;
        for(int i=2; i<n; i++) {
            next = n1 + n2;
            n2 = n1;
            n1 = next;
        }
        return n1 + n2;
    }
    public static class Point { 
        int row, col; 
        Point (int row, int col) {this.row = row; this.col = col;}
        @Override
        public String toString() {
            return "Point [col=" + col + ", row=" + row + "]";
        }
        
    }
    public static int waysToClimbStairs(int n, int[] mem) {
        if(n == 0) return 1;
        else if (n < 0) return 0;
        else if(mem[n] > -1) return mem[n];
        else {
            mem[n] = waysToClimbStairs(n-3, mem) + waysToClimbStairs(n-2, mem)
            + waysToClimbStairs(n-1, mem);
            return mem[n];
        }
    }
    public static void printMatrix(boolean[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static ArrayList<Point> getPath(boolean[][] maze) {
        printMatrix(maze);
        ArrayList<Point> path = new ArrayList<>();
        if(getPath(maze, maze.length-1, maze[0].length-1, path, 0, "base")) {
            return path;
        }
        return null;
    }
    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, int level, String mark) {
        System.out.println("->"+" For "+ row+ " "+col);
        if(row < 0 || col < 0 || !maze[row][col]) {return false;}
        boolean isAtOrigin = row == 0 && col == 0;
        if(isAtOrigin || getPath(maze, row, col-1, path, level+1,"col-1") || getPath(maze, row-1, col, path,level+1,"row-1")) {
            path.add(new Point(row, col));
            String preText="";
            for(int i=0;i<level;i++) preText = preText+"-";
            System.out.println(preText+ mark+"-"+" Adding "+ row+ "-"+col);
            return true;
        }
        return false;
    }

    public static int magicIndex(int[] array) {
        return magicIndex(array, 0, array.length-1);
    }
    private static int magicIndex(int[] array, int start, int end) {
        if(end < start) return -1;
        int mid = (start + end)/2;
        if(array[mid] == mid) return mid;
        else if(array[mid] > mid) return magicIndex(array, start, mid-1);
        else return magicIndex(array, mid+1, end);
    }
    
    //Problem 8.4 Return all subsets of a set
    public static ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if(set.size() == index) {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        }else {
            allsubsets = getSubSets(set, index+1);
            int item = set.get(index);

            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();

        for (ArrayList<Integer> subset : allsubsets) {
            ArrayList<Integer> newsubset = new ArrayList<Integer>();
            newsubset.addAll(subset);
            newsubset.add(item);
            moresubsets.add(newsubset);
        }
        allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    //Problem 8.4 Return all subsets of a set -> Iterative approach
    public static ArrayList<ArrayList<Integer>> getAllSubSetsIterative(int size) {
        ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<>();
        allSubSets.add(new ArrayList<>());
        for(int i=1;i<=size;i++) {
            ArrayList<ArrayList<Integer>> set = new ArrayList<>();
            for(ArrayList<Integer> subset:allSubSets) {
                ArrayList<Integer> newSubSet = new ArrayList<>();
                newSubSet.addAll(subset);
                newSubSet.add(i);
                set.add(newSubSet)                ;
            }
            allSubSets.addAll(set);
        }
        return allSubSets;
    }

    public static int multiply(int a, int b) {
        if(a==0 || b==0) return 0;
        if(a==1) return b;
        return multiply(a-1, b) + b;
    }
    public static int countWaysToStair(int num) {
        int[] nums = new int[num+1];
        Arrays.fill(nums, -1);
        return countWaysToStair(num, nums);
    }
    public static int countWaysToStair(int num, int[] nums) {
        if(num == 0) return 1;
        else if(num < 0) return 0;
        else if(nums[num] != -1) return nums[num];
        else { nums[num] =countWaysToStair(num-1, nums) + countWaysToStair(num-2, nums) + countWaysToStair(num-3, nums);
            return nums[num];
        }
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0]=0;
        for(int currAmt =1; currAmt<=amount; currAmt++) {
            int temp = Integer.MAX_VALUE;
            for(int j=0; j<coins.length; j++){
                int coin = coins[j];
                if(currAmt-coin >= 0) {
                    temp = Math.min(temp, dp[currAmt-coin]+1);
                }
            }
            dp[currAmt] = temp;
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }
    public static int longestSequence(int[] data, int startIndex, int level, int[] store) {
        System.out.printf("%s->%s with index %d\n","    ".repeat(level),Arrays.toString(data), startIndex);
        if(startIndex == data.length-1) return 1;
        if(store[startIndex] != -1) return store[startIndex];
        int max = 1;
        for (int i = startIndex+1; i < data.length; i++) {
            if(data[startIndex] < data[i])   {
                System.out.printf("%s-> %d < %d\n","    ".repeat(level+1),data[startIndex], data[i]);
                int result = 1 + longestSequence(data, i, level+1, store);
                store[startIndex] = result;
                if(result > max) max = result;
            }
        }
        return max;
    }
    public static int longestSequence(int[] data) {
        int max = 0;
        int[] store = new int[data.length];
        Arrays.fill(store, -1);
        for (int i = 0; i < data.length; i++) {
            System.out.printf("index %d\n",i);
            int length = longestSequence(data, i, 0, store);
            if(length > max) max = length;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(longestSequence(new int[]{10,9,2,5,3,7,101,18}));
        /*int n = 4;
        int[] mem = new int[n+1];
        Arrays.fill(mem, -1);
        System.out.println(waysToClimbStairs(n, mem));*/

        //ArrayList<Point> path = getPath(new boolean[][] {{true, true, true}, {false, true, true}, {true, true, true}});
        //path.forEach(point -> System.out.println(point));

        //System.out.println(magicIndex(new int[]{-40,-20,-1,1,2,3,5,7,9,12,13}));
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        ArrayList<ArrayList<Integer>> subsets = getAllSubSetsIterative(3);
        for(ArrayList<Integer> set:subsets) {
            System.out.println("set size "+set.size());
            for(Integer i: set) {
                System.out.print(i+" ");
            }
            System.out.println();
        }*/
       //System.out.println(multiply(3, 2));
       //System.out.println(countWaysToStair(3));
       //System.out.println(coinChange(new int[]{1,2,3}, 1));
        
    }
}
