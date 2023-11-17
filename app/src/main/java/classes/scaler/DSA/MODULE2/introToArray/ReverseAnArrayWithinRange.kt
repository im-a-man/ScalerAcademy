package classes.scaler.DSA.MODULE2.introToArray

fun main() {
    println(reverseAnArrayWithARange(intArrayOf(1,2,3,4,5),0,4).joinToString())
}

fun reverseAnArrayWithARange(A: IntArray, B: Int, C: Int): IntArray {
    var l = B
    var r = C //for complete array r = A.size-1
    if(l>=0 && r<=A.size-1){
        while(l<r){
            val temp = A[l]
            A[l] = A[r]
            A[r] = temp
            l++
            r--
        }
    }
    return A
}