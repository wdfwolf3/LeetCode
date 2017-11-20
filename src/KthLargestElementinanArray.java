import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            queue.add(nums[i]);
        for (int i = k; i < nums.length; i++)
            if (nums[i] > queue.peek()) {
                queue.add(nums[i]);
                queue.poll();
            }
        return queue.poll();
    }
}
