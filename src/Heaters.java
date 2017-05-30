import java.util.Arrays;

/**
 * Created by wdfwolf3 on 2017/5/23.
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.binarySearch(heaters, houses[0]);
        for (int i : houses){
            ans = Math.max(ans, minDistance(i, heaters));
        }
        return ans;
    }

    public int minDistance(int house, int[] heaters){
        int left = 0, right = heaters.length-1;
        while (right-left > 1){
            int middle = (left + right)/2;
            if(house == heaters[middle])
                return 0;
            else if (house < heaters[middle])
                right = middle;
            else
                left = middle;
        }
        return Math.min(Math.abs(house-heaters[left]), Math.abs(heaters[right]-house));
    }
}
