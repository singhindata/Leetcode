import java.util.PriorityQueue;

public class L215_findKthLargest {
    public static int solution(int nums[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5,6,6,6, 6, 4 };
        int k = 2;
        System.out.println("The " + k + "nd largest element is: " + solution(nums, k));
    }
}
