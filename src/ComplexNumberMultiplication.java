/**
 * Created by wdfwolf3 on 2017/6/7.
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        as[1] = as[1].substring(0, as[1].length() - 1);
        bs[1] = bs[1].substring(0, bs[1].length() - 1);
        int ansA = Integer.parseInt(as[0]) * Integer.parseInt(bs[0]) - Integer.parseInt(as[1]) * Integer.parseInt(bs[1]);
        int ansB = Integer.parseInt(as[1]) * Integer.parseInt(bs[0]) + Integer.parseInt(as[0]) * Integer.parseInt(bs[1]);
        return String.valueOf(ansA) + "+" + String.valueOf(ansB) + "i";
    }
}
