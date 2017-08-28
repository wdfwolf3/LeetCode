/**
 * @author wendefeng
 * @Description:
 * @date 2017-6-6 下午4:06:12
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                ans += (prices[i + 1] - prices[i]);
        }
        return ans;
    }
}
