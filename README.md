# LeetCode 215 — Kth Largest Element in an Array

**Problem:** [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

## Approach 1: Sorting

Initially, I considered sorting the array using `Arrays.sort()` and retrieving the kth largest element.

- **Time Complexity:** O(n log n)
- **Space Complexity:** Depends on the sorting implementation.

However, sorting the entire array is unnecessary when we only need the kth largest element.

## Approach 2: Min-Heap (Optimized)

To improve the time complexity, I used Java's `PriorityQueue` to maintain a min-heap of size `k`.

### Algorithm

1. Insert each element into the min-heap.
2. If the heap size exceeds `k`, remove the smallest element using `poll()`.
3. After processing all elements, the root of the min-heap (`peek()`) contains the kth largest element.

### Java Solution

```java
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
```

### Complexity Analysis

- **Time Complexity:** O(n log k)
- **Space Complexity:** O(k)

## Follow-up: What if we want the Kth largest *unique* element?

Duplicates should be counted only once. For example, in `[5, 5, 4, 3]` with `k = 2`, the 2nd largest unique element is `4`, not `5`.

### Approach

Use a `HashSet` to track values already seen. Add a number to the min-heap only if it is new (`set.add(num)` returns `false` for duplicates).

### Java Solution

```java
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int findKthLargestUnique(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.add(num)) {
                minHeap.add(num);

                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        // Fewer than k unique elements -> kth unique largest doesn't exist
        if (minHeap.size() < k) {
            return -1; // or throw an exception, depending on requirements
        }

        return minHeap.peek();
    }
}
```

### Complexity Analysis

- **Time Complexity:** O(n log k)
- **Space Complexity:** O(n) for the set (worst case, all elements unique) + O(k) for the heap

### Edge Cases

- If the array has fewer than `k` unique elements, the answer doesn't exist, so clarify the expected behavior with the interviewer (return -1, throw an exception, etc.).
- Once a value is polled from the heap it stays in the set, which is fine: it was smaller than the `k` larger values already in the heap, so a repeat of it would be polled anyway.

**Alternative:** Use a `TreeSet`, which keeps unique elements sorted, and remove the smallest when its size exceeds `k`. This is simpler, but each operation is O(log n) instead of O(log k).

## Key Learning

Instead of sorting the entire array, maintaining a min-heap of size `k` allows us to find the kth largest element more efficiently. For the unique variant, pairing the heap with a `HashSet` filters duplicates while keeping the same O(n log k) time.

**Concepts practiced:** Arrays, Sorting, PriorityQueue, Min-Heap, HashSet, Time Complexity, Space Complexity.