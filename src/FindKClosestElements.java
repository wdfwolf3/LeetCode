import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/8/13.
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        if (arr.size() == 0)
            return ans;
        int right = 0;
        for (int i = 0, min = Integer.MAX_VALUE; i < arr.size(); i++)
            if (Math.abs(arr.get(i) - x) < min) {
                right = i;
                min = Math.abs(arr.get(i) - x);
            }
        right = Math.max(k, right + 1);
        int left = right - k;
        for (; right < arr.size(); right++)
            if (Math.abs(arr.get(right) - x) >= Math.abs(arr.get(left) - x))
                break;
            else
                left++;
        for (int i = left; i < left + k; i++)
            ans.add(arr.get(i));
        return ans;
    }
}
