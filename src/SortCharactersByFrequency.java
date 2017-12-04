import java.util.Arrays;
import java.util.Comparator;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[][] nums = new int[256][2];
        for (char c : s.toCharArray()) {
            nums[c][0]++;
            nums[c][1] = c;
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? -1 : o1[0] == o2[0] ? 0 : 1;
            }
        });
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < nums.length; i++)
            if (nums[i][0] == 0)
                break;
            else {
                char c = (char) (nums[i][1]);
                for (int j = 0, l = nums[i][0]; j < l; j++)
                    ans.append(c);
            }
        return ans.toString();
    }
}
