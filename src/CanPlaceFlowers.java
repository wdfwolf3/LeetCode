/**
 * Created by wdfwolf3 on 2017/6/4.
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeros = 0;
        int count = 0;
        boolean flag = false;
        for (int i : flowerbed) {
            if (i == 1) {
                if (flag)
                    count += (zeros - 1) / 2;
                else
                    count += zeros / 2;
                zeros = 0;
                flag = true;
            } else
                zeros++;
        }
        if (zeros != 0) {
            if (flag)
                count += zeros / 2;
            else
                count += (zeros + 1) / 2;
        }
        return count >= n;
    }
}
