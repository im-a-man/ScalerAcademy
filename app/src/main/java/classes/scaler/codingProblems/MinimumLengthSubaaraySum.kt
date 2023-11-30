package classes.scaler.interviewPreparation.codingProblems


fun main() {
    val target = 7
    val nums = intArrayOf(2, 3, 1, 2, 4, 3)
    /**
     * This example would output 2 because the subarray [4, 3] has a sum of 7,
     * and it is the minimum-length subarray with a sum greater than or equal to the target.
     * In Big O(N). Using Sliding window technique
     * */

    val result = minSubarrayLen(target, nums)
    println("Minimum length of sub-array with sum at least $target: $result")
}


fun minSubarrayLen(target: Int, nums: IntArray): Int {
    var minLength = Int.MAX_VALUE
    var left = 0
    var sum = 0

    for (right in nums.indices) {
        sum += nums[right]

        while (sum >= target) {
            // Update the minimum length
            minLength = minOf(minLength, right - left + 1)

            // Move the left pointer to shrink the subarray
            sum -= nums[left]
            left++
        }
    }

    // If minLength is still Int.MAX_VALUE, no such subarray is found
    return if (minLength == Int.MAX_VALUE) 0 else minLength
}

/**
 * 1=> Initialization:
 * minLength is initialized to Int.MAX_VALUE to represent an initially undefined minimum length.
 * left and right are initialized to 0, indicating the start of the array.
 * sum is initialized to 0 to represent the sum of the current subarray.
 *
 * 2=> Iterating through the Array:
 * The outer for loop iterates through the array using the right pointer.
 *
 * 3=> Expanding the Window:
 * As the right pointer moves, the corresponding element is added to the sum.
 * The code checks if the current sum is greater than or equal to the target.
 *
 * 4=> Inner while Loop:
 * If sum is greater than or equal to the target, it means we have a subarray with a sum at least the target.
 * The inner while loop is entered to try to minimize the length of the subarray.
 *
 * 5=> Contracting the Window:
 * Inside the while loop, the minLength is updated to be the minimum of its current value and the length of the current subarray (right - left + 1).
 * The left pointer is then moved to the right, effectively shrinking the subarray by subtracting the leftmost element from the sum.
 * This process continues until the sum is less than the target.
 *
 * 6=> Tracking the Minimum Length:
 * The minLength variable keeps track of the minimum length of subarrays with a sum at least the target.
 *
 * 7=> Completing the Iteration:
 * The outer loop continues until the right pointer reaches the end of the array.
 *
 * 8=> Returning the Result:
 * The function returns either the calculated minLength or 0 if no subarray is found.
 *
 * Note=> In summary, the code uses two pointers (left and right)
 * to create a sliding window that moves through the array.
 * The sum is updated as the window expands,
 * and when the sum becomes greater than or equal to the target,
 * the window contracts to find the minimum length subarray.
 * The minimum length is continuously updated as the algorithm iterates through the array.
* */