public class ValidPerfectSquare {
    public static void main(String args[]) {
        int[] nums = {123, 23, 43, 1, 34, 1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(isPerfectSquare(nums[i]));
        }
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        int left = 1, right = num / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num / mid < mid)
                right = mid;
            else if (num / (mid + 1) > mid + 1)
                left = mid + 1;
            else if ((num / mid == mid && num % mid == 0) || (num / (mid + 1) == mid + 1 && num % (mid + 1) == 0))
                return true;
            else
                return false;

        }
        return false;


    }
}
