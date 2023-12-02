package classes.scaler.DSA.MODULE4.interviewProblems

import classes.scaler.GsonFactory.toJson
import java.util.Collections


/**
Problem Description
Given a collection of intervals, merge all overlapping intervals.

Problem Constraints
1 <= Total number of intervals <= 100000.

Input Format
First argument is a list of intervals.

Output Format
Return the sorted list of intervals after merging all the overlapping intervals.

Example Input
Input 1:
[1,3],[2,6],[8,10],[15,18]

Example Output
Output 1:
[1,6],[8,10],[15,18]

Example Explanation
Explanation 1:
Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.
 * */

fun main() {
    println(
        merge(
            arrayListOf(
                Interval(1, 3),
                Interval(2, 6),
                Interval(8, 10),
                Interval(15, 18)
            )
        ).toJson()
    )
}

fun merge(intervals: ArrayList<Interval>): ArrayList<Interval> {
    intervals.sortWith(Comparator { a: Interval, b: Interval -> a.start - b.start })
    // Write your code here.
    val answer: ArrayList<Interval> = arrayListOf()
    var left = intervals[0].start
    var right = intervals[0].end
    for (i in 1 until intervals.size) {
        if (intervals[i].start <= right) {
            right = maxOf(right, intervals[i].end)
        } else {
            answer.add(Interval(left, right))
            left = intervals[i].start
            right = intervals[i].end
        }
    }
    answer.add(Interval(left, right))
    return answer
}

data class Interval(val start: Int, val end: Int)
