/**
 * @author wendefeng
 * @Description:
 * @date 2017-6-6 下午3:52:00
 */
public class BestTimetoBuyandSellStock {
    /**
     * @param prices
     * @return
     * @throws
     * @Description: current保存当前元素之前的最小元素，ans保存最大结果
     */
    public int maxProfit(int[] prices) {
        int ans = 0, current = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - current);
            if (prices[i] < current)
                current = prices[i];
        }
        return ans;
    }
}
