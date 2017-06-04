/**
 * Created by wdfwolf3 on 2017/6/4.
 */
public class NonNegativeIntegerswithoutConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(new NonNegativeIntegerswithoutConsecutiveOnes().findIntegers(8));
    }

    public int findIntegers(int num) {
        System.out.println(Math.log(num));
        int[] n = new int[(int) Math.floor(Math.log(num)/Math.log(2))];
        for (int i = n.length-1; i >=0 ; i--) {
            n[i] = num % 2;
            num /= 2;
        }
        int ans = 1;
        boolean flag = false;
        for (int i = 1; i < n.length; i++) {
            if((n[i] ^ n[i-1]) == 0){
                if(n[i] == 1){
                    n[i] = 0;
                    flag = true;
                }else if(flag){
                    n[i] = 1;
                }
            }
            ans = ans *2 +n[i];
        }
        return ans;
    }
}
