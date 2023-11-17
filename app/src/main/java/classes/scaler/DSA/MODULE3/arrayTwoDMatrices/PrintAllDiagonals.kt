package classes.scaler.DSA.MODULE3.arrayTwoDMatrices

import com.google.gson.Gson

fun main(args: Array<String>) {
    /*
        [1,0,0]
        [2,5,0]
        [3,6,9]
        [4,7,10]
        [8,11,0]
        [12,0,0]

        [1,0,0]
        [2,4,0]
        [3,5,7]
        [6,8,0]
        [9,0,0]
    * */
    val arr = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))
    val arr1 = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4,5,6), intArrayOf(7,8,9))
    val res = printDiagonals(arr1)
    for (item in res) {
        println(Gson().toJson(item))
    }
}

fun printDiagonals(arr: Array<IntArray>): Array<IntArray> {
    val N = arr.size
    val M = arr[0].size
    val res = Array(N + M - 1) { IntArray(Math.min(N, M)) }

    var ri = 0
    for (col in 0 until M) {;
        var i = 0
        var j = col

        var ci = 0
        //traversing on the Diagonals of 0th row
        while (i < N && j >= 0) {
            res[ri][ci] = arr[i][j]
            ci++

            i++
            j--
        }
        ri++
    }

    for (row in 1 until N) {
        var i = row
        var j = M - 1

        var ci = 0
        //traversing on the Diagonals of last column from 1st row
        while (i < N && j >= 0) {
            res[ri][ci] = arr[i][j]
            ci++

            i++
            j--
        }
        ri++
    }
    return res
}