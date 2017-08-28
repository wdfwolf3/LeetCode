/**
 * Created by wdfwolf3 on 2017/8/13.
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int[] sign = new int[4];
        for (char c : moves.toCharArray()) {
            System.out.println(c);
            switch (c) {
                case 'L':
                    sign[0] = sign[0] + 1;
                    break;
                case 'R':
                    sign[1] = sign[1] + 1;
                    break;
                case 'U':
                    sign[2] = sign[2] + 1;
                    break;
                case 'D':
                    sign[3] = sign[3] + 1;
                    break;
                default:
                    break;
            }
        }
        return sign[0] == sign[1] && sign[2] == sign[3];
    }

    public static void main(String[] args) {
        String s = "UD";
        System.out.println(new JudgeRouteCircle().judgeCircle(s));
    }
}
