import java.util.Arrays;

/**
 * Created by wdfwolf3 on 2017/9/24.
 */
public class NextClosestTime {
    public String nextClosestTime(String time) {
        int[] nums = new int[4];
        nums[0] = time.charAt(0) - '0';
        nums[1] = time.charAt(1) - '0';
        nums[2] = time.charAt(3) - '0';
        nums[3] = time.charAt(4) - '0';
        int n1 = nums[0], n2 = nums[1], n3 = nums[2], n4 = nums[3];
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] > n4) {
                n4 = nums[i];
                return "" + n1 + n2 + ":" + n3 + n4;
            }
        }
        n4 = nums[0];
        for (int i = 0; i < 4; i++) {
            if (nums[i] > n3 && nums[i] < 6) {
                n3 = nums[i];
                return "" + n1 + n2 + ":" + n3 + n4;
            }
        }
        n3 = nums[0];
        for (int i = 0; i < 4; i++) {
            if (nums[i] > n2) {
                if (n1 == 2 && nums[i] > 3)
                    continue;
                n2 = nums[i];
                return "" + n1 + n2 + ":" + n3 + n4;
            }
        }
        n2 = nums[0];
        if (n1 == 0) {
            for (int i = 3; i >= 0; i--)
                if (nums[i] == 1) {
                    n1 = 1;
                    return "" + n1 + n2 + ":" + n3 + n4;
                }
            for (int i = 3; i >= 0; i--)
                if (nums[i] == 2) {
                    n1 = 2;
                    return "" + n1 + n2 + ":" + n3 + n4;
                }
        } else if (n1 == 1) {
            for (int i = 3; i >= 0; i--)
                if (nums[i] == 2) {
                    n1 = 2;
                    return "" + n1 + n2 + ":" + n3 + n4;
                }

        }
        n1 = nums[0];
        return "" + n1 + n2 + ":" + n3 + n4;
    }
}
