package org.algorithms.interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class IntervalProblems {
    public static ArrayList<Interval> insertInterval(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval == null) return intervals;
        ArrayList<Interval> result = new ArrayList<>();
        if(intervals.size() == 0) {
            result.add(newInterval); return result;
        }
        for(Interval temp: intervals) {
            if(temp.end < newInterval.start)
                result.add(temp);
            else if(temp.start > newInterval.end) {
                result.add(newInterval);
                newInterval = temp;
            }else {
                newInterval.start = Math.min(temp.start, newInterval.start);
                newInterval.end = Math.max(temp.end, newInterval.end);
            }
        }
        result.add(newInterval);
        return result;
    }
    public static LinkedList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {return i1.start - i2.start;}
        });
        LinkedList<Interval> result = new LinkedList<>();
        for(int i=0; i<intervals.size();i++) {
            if(result.size() > 0 && intervals.get(i).start <= result.getLast().end) {
                result.getLast().start = Math.min(intervals.get(i).start, result.getLast().start);
                result.getLast().end = Math.max(intervals.get(i).end, result.getLast().end);
            }else result.add(intervals.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        /*ArrayList<Interval> result = insertInterval(new ArrayList<Interval>() {
           {add(new Interval(1,2)); add(new Interval(3,5));
            add(new Interval(6,7)); add(new Interval(8,10));
            add(new Interval(12,16));}
        }, new Interval(4,9));
        for(Interval temp: result) {
            System.out.printf("[%d, %d]\n",temp.start, temp.end);
        }*/
        LinkedList<Interval> result = mergeIntervals(new ArrayList<Interval>() {
            {add(new Interval(1,3)); add(new Interval(15,18));
                add(new Interval(2,6));
             add(new Interval(8,10)); 
            }
         });
         for(Interval temp: result) {
             System.out.printf("[%d, %d]\n",temp.start, temp.end);
         }
    }
}
