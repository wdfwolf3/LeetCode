/**
 * Created by wdfwolf3 on 2017/6/4.
 */
public class NonNegativeIntegerswithoutConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(new NonNegativeIntegerswithoutConsecutiveOnes().findIntegers(8));
    }

    public int findIntegers(int num) {
        System.out.println(Math.log(num));
        int[] n = new int[(int) Math.floor(Math.log(num) / Math.log(2))];
        for (int i = n.length - 1; i >= 0; i--) {
            n[i] = num % 2;
            num /= 2;
        }
        int oneLess = 0, oneEqual = 0, zeroLess = 0, zeroEqual = 1;
        for (int i : n) {
            if (i == 0) {
                int tmp = oneLess;
                oneLess = zeroLess;
                zeroLess = tmp + zeroLess;
                zeroEqual = zeroEqual + oneEqual;
                oneEqual = 0;
            } else {
                int tmp = zeroLess;
                zeroLess = oneEqual + oneLess + zeroEqual + zeroLess;
                oneLess = tmp;
                oneEqual = zeroEqual;
                zeroEqual = 0;
            }
        }
        return oneEqual + oneLess + zeroEqual + zeroLess;
    }
}
