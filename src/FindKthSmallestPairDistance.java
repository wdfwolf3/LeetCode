public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums.length == 2)
            return Math.abs(nums[1] - nums[0]);
        int[] count = new int[1000001];
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                count[Math.abs(nums[j] - nums[i])]++;
        int ans = 0;
        for (int i = 0, sum = 0; i < count.length; i++) {
            sum += count[i];
            if (sum >= k)
                return count[i];
        }
        return ans;
    }
}
