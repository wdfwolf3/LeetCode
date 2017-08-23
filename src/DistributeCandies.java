import java.util.HashSet;
import java.util.Set;

/**
 * Created by wdfwolf3 on 2017/5/31.
 */
public class DistributeCandies {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3};
        System.out.println(new DistributeCandies().distributeCandies(nums));
    }

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i : candies) {
            set.add(i);
        }
        return Math.min(candies.length / 2, set.size());
    }
}
