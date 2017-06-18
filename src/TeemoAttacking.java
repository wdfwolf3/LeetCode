/**
 * Created by wdfwolf3 on 2017/6/8.
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0)
            return 0;
        int ans = 0;
        for (int i = 0; i < timeSeries.length - 1; i++)
            ans += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        return ans + duration;
    }
}
