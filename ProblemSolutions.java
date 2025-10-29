/******************************************************************
 *
 *   YOUR NAME / SECTION NUMBER
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE
        // Use a hashmap to count occurrences in list1 (handles duplicates).
        // Then ensure every element of list2 exists with sufficient count.
        if (list2 == null || list2.length == 0) { return true; }
        if (list1 == null || list1.length == 0) { return false; }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int v : list1) {
            counts.put(v, counts.getOrDefault(v, 0) + 1);
        }

        for (int v : list2) {
            int c = counts.getOrDefault(v, 0);
            if (c == 0) return false; 
            counts.put(v, c - 1);
        }

        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : array) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            list.add(array1[i]);
        }
        for (int j = 0; j < array2.length; j++) {
            list.add(array2[j]);
        }
        Collections.sort(list);
        int[] sortedArray = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            sortedArray[k] = list.get(k);
        }
        return sortedArray;
    }

}