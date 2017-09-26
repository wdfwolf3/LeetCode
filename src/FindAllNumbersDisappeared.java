import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappeared {
    public static void main(String args[]) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0, j = 1; i < len; i++, j++) {
            if (nums[i] != j)
                list.add(j);
        }
        return list;
    }
}
