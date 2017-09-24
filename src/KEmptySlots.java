import java.util.TreeSet;

/**
 * Created by wdfwolf3 on 2017/9/24.
 */
public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int n = flowers[i];
            Integer h = set.higher(n), l = set.lower(n);
            if ((h!= null && h - n - 1 == k) || (l!=null && l + k + 1 == n))
                return i + 1;
            set.add(n);
        }
        return -1;
//
//        boolean[] sign = new boolean[flowers.length + 1];
//        sign[flowers[0]] = true;
//        for (int i = 1; i < flowers.length; i++) {
//            int n = flowers[i];
//            sign[n] = true;
//            if (n + k + 1 < sign.length && sign[n + k + 1]) {
//                int j = 1;
//                for (; j <= k; j++) {
//                    if (sign[n + j])
//                        break;
//                }
//                if (j > k)
//                    return i + 1;
//            }
//            if (n - k - 1 >= 1 && sign[n - k - 1]) {
//                int j = 1;
//                for (; j <= k; j++) {
//                    if (sign[n - j])
//                        break;
//                }
//                if (j > k)
//                    return i + 1;
//            }
//        }
//        return -1;
    }
}
