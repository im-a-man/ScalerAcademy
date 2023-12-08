package classes.android.dataStructure

class LinkedList {
    class Node(var data: Int) {
        //Create a node
        var next: Node? = null
    }

    //Create a head node
    var head: Node? = null

    //Implementation of add method
    fun add(data: Int) {
        if (head == null) {//If head is null then list is empty and will add data to head
            head = Node(data)//Set data into head as a node
        } else {//Else will add data to next of head
            var last: Node? = head
            while (last?.next != null) {
                last = last.next
            }
            last?.next = Node(data)//Set data into next of head as a node
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //Now create a linked list and add nodes
            val list = LinkedList()
            list.add(8)
            list.add(3)
            list.add(9)
            list.add(24)

            //Printing the linked list
            var current: Node? = list.head
            while (current != null) {
                println(current.data)
                current = current.next
            }
        }
    }
}