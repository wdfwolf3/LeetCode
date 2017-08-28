/**
 * Created by wdfwolf3 on 2017/5/30.
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        String flag = "";
        if (num < 0) {
            flag = "-";
            num = -1 * num;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        while (num != 0) {
            stringBuilder.insert(0, num % 7);
            num /= 7;
        }
        return flag + stringBuilder.toString();
    }
}
