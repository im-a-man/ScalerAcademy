package classes.scaler.DSA.MODULE2.introToArray

import java.util.*

/*
The time complexity of finding the Kth largest element in an integer array using a min-heap (PriorityQueue)
as described in the code I provided is O(N * log K), where N is the number of elements
in the input array and K is the desired Kth largest element.

Here's a breakdown of the time complexity:

Initializing the min-heap with K elements: O(K * log K) -
This step involves adding the first K elements to the heap.

Iterating through the remaining (N - K) elements in the array: O((N - K) * log K) -
For each element, we may perform insertion and removal from the heap, both of which take O(log K) time.

Overall, the dominant factor in the time complexity is the iteration through the array.
So, the time complexity is O((N - K) * log K). When K is much smaller than N (K << N),
the time complexity can be approximated as O(N * log K).

In practice, this approach is efficient for finding the Kth largest element,
especially when K is small compared to N.
* */
fun findKthLargestUsingMinHeap(nums: IntArray, k: Int): Int {
    /*
    In this code, we use a min-heap (PriorityQueue) to maintain the K largest elements.
    We iterate through the input array, adding elements to the heap and removing the
    smallest element when the heap size exceeds K. Finally,
    we return the top element of the heap, which will be the Kth largest element.
    * */
    val minHeap = PriorityQueue<Int>()
    for (num in nums) {
        minHeap.offer(num)
        if (minHeap.size > k) {
            minHeap.poll()
        }
    }
    return minHeap.peek() ?: 0
}

fun findKthLargestUsingMaxHeap(nums: IntArray, k: Int): Int {
    val maxHeap = PriorityQueue<Int>(k, Collections.reverseOrder())
    for (num in nums) {
        maxHeap.offer(num)
    }
    var result = 0
    for (i in 0 until k) {
        result = maxHeap.poll() ?: 0
    }
    return result
}

fun main() {
    val nums = intArrayOf(3, 2, 1, 5, 6, 4)
    val k = 2

    val kthLargestUsingMinHeap = findKthLargestUsingMinHeap(nums, k)
    val kthLargestUsingMaxHeap = findKthLargestUsingMaxHeap(nums, k)
    println("The $k-th largest element is: $kthLargestUsingMinHeap")
}
