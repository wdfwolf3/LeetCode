import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/10/15.
 */
public class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        int[] height = new int[positions.length];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, max = 0; i < positions.length; i++) {
            int maxHeight = 0;
            for (int j = 0; j < i; j++)
                if (positions[j][1] + positions[j][0] > positions[i][0] &&
                        positions[j][0] < positions[i][1] + positions[i][0])
                    maxHeight = Math.max(maxHeight, height[j]);
            height[i] = maxHeight + positions[i][1];
            max = Math.max(max, height[i]);
            ans.add(max);
        }
        return ans;
    }
}
