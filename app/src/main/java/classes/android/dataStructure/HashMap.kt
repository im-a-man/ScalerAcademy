package classes.android.dataStructure

import com.google.common.hash.Hashing

//Hashmap uses LOAD_FACTOR concept of 16 buckets by default.
//So if we want to store more than 16 buckets in a hashmap,
//Then If Hashmap reaches 75% of its capacity, then it doubles the existing capacity
//75% means if I try to put item on 13th bucket then it will double the existing capacity.
//And A bucket is basically a linked list

/**
 * So Basically A Hashmap contains 16 buckets by default,
 * and Each bucket contains a linked list.
 * */

/**
 * Hashmap is use hashcode() of key to store the value,
 * Then calculate the bucket index using hashcode.
 * When hashcode-collision occurs, then new item will be added to the hashmap at the same bucket.
 * that's why Hashmap do not contain duplicate item or key.
 * */

class HashMap<K, V> {
    private data class Node<K, V>(val key: K, var value: V, val hash: Int) {
        // Additional properties or methods can be added if needed
    }

    private val initialCapacity = 16
    private val loadFactor = 0.75
    private var size = 0
    private var capacity = initialCapacity
    private var table: Array<MutableList<Node<K, V>>?> = arrayOfNulls(capacity)

    fun put(key: K, value: V) {
        resizeIfNeeded()

        val hash = key.hashCode()
        val index = hash % capacity
        val newNode = Node(key, value, hash)

        if (table[index] == null) {
            table[index] = mutableListOf(newNode)
        } else {
            val bucketList = table[index]!!
            val existingNode = bucketList.find { it.key == key }

            if (existingNode != null) {
                existingNode.value = value
            } else {
                bucketList.add(newNode)
            }
        }

        size++
    }

    fun get(key: K): V? {
        val hash = key.hashCode()//Create hashcode
        val index = hash % capacity//Create bucket index using hash
        val bucketList = table[index]

        if (bucketList != null) {
            val node = bucketList.find { it.key == key }
            return node?.value
        }

        return null
    }

    private fun resizeIfNeeded() {
        if (size.toDouble() / capacity > loadFactor) {
            // Resize the array
            capacity *= 2
            val newTable: Array<MutableList<Node<K, V>>?> = arrayOfNulls(capacity)

            // Rehash and redistribute the existing elements
            for (bucketList in table) {
                bucketList?.forEach { node ->
                    val newIndex = node.hash % capacity
                    if (newTable[newIndex] == null) {
                        newTable[newIndex] = mutableListOf(node)
                    } else {
                        newTable[newIndex]!!.add(node)
                    }
                }
            }

            // Update the table reference
            table = newTable
        }
    }
}

fun main() {
    val myHashMap = HashMap<String, Int>()

    myHashMap.put("one", 1)
    myHashMap.put("two", 2)
    myHashMap.put("three", 3)

    println("Value for key 'two': ${myHashMap.get("two")}")
    println("Value for key 'four': ${myHashMap.get("four")}")
}