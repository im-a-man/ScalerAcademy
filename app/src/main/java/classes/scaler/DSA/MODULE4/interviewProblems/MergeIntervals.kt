package classes.scaler.DSA.MODULE4.interviewProblems

import classes.GsonFactory.toJson

/**
Problem Description
You have a set of non-overlapping intervals.
You are given a new interval [start, end],
insert this new interval into the set of intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Problem Constraints
0 <= |intervals| <= 105

Input Format
First argument is the vector of intervals
second argument is the new interval to be merged

Output Format
Return the vector of intervals after merging

Example Input
Input 1:
Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:
Given intervals [1, 3], [6, 9] insert and merge [2, 6] .

Example Output
Output 1:
[ [1, 5], [6, 9] ]
Output 2:
[ [1, 9] ]

Example Explanation
Explanation 1:
(2,5) does not completely merge the given intervals
Explanation 2:
(2,6) completely merges the given intervals
 * */

fun main() {
    println(insert(arrayListOf(Interval(1, 3), Interval(6, 9)), Interval(2, 5)).toJson())
}

fun insert(intervals: ArrayList<Interval>, newInterval: Interval): ArrayList<Interval> {
    //intervals.sortWith(Comparator { a: Interval, b: Interval -> a.start - b.start })
    // Write your code here.
    val answer: ArrayList<Interval> = arrayListOf()
    var left = newInterval.start
    var right = newInterval.end
    for (i in 0 until intervals.size) {
        if (intervals[i].end < left) {
            //Not overlapped
            answer.add(intervals[i])
        } else if (intervals[i].start > right) {
            //Not overlapped
            answer.add(Interval(left, right))
            for (j in i until intervals.size) {
                answer.add(intervals[j])
            }
            return answer
        } else {
            //Overlapped
            left = minOf(left, intervals[i].start)
            right = maxOf(right, intervals[i].end)
        }
    }
    answer.add(Interval(left, right))
    return answer
}