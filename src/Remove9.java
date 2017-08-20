import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/8/13.
 */
public class Remove9 {
    public int newInteger(int n) {
        if (n< 9)
            return n;
        List<Integer> list = new ArrayList<>();
        int tmp = 1, cheng = 1;
        while (tmp <= n){
            if (tmp == n)
                return (int) Math.pow(10,list.size());
            list.add(tmp);
            tmp*=9;
        }
        int newn = n - list.get(list.size()-1);
        int ans = (int) Math.pow(10, list.size()-1), i = 1;
        while (newn!=0){
            int t = newn/list.get(list.size()-i);
            ans+=(int) Math.pow(10, list.size()-i)*t;
            newn %= list.get(list.size()-i++);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 1313;
        System.out.println(new Remove9().newInteger(n));
    }
}
