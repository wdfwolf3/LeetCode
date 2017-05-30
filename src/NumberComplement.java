/**
 * Created by wdfwolf3 on 2017/5/30.
 */
public class NumberComplement {
    public int findComplement(int num) {
        int ans = 0, tmp = 1;
        while (num != 0){
            if(num % 2 == 0){
                ans += tmp;
            }
            num /= 2;
            tmp *= 2;
        }
        return ans;
    }
}
