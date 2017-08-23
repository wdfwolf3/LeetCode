/**
 * Created by wdfwolf3 on 2017/7/9.
 */
public class SolvetheEquation {
    public String solveEquation(String equation) {
        String[] strings = equation.split("=");
        if (strings[0].charAt(0) != '-' && strings[0].charAt(0) != '+')
            strings[0] = "+" + strings[0];
        if (strings[1].charAt(0) != '-' && strings[1].charAt(0) != '+')
            strings[1] = "+" + strings[1];
        int x = 0, s = 0, left = 0;
        for (int i = 0; i < strings[0].length(); i++) {
            char c = strings[0].charAt(i);
            if (c == '+' || c == '-') {
                if (i != left) {
                    s -= Integer.parseInt(strings[0].substring(left, i));
                    left = i;
                }
            } else if (c == 'x') {
                if (left == i - 1)
                    x += (strings[0].charAt(left) == '+' ? 1 : -1);
                else
                    x += Integer.parseInt(strings[0].substring(left, i));
                left = i + 1;
            }
        }
        if ('x' != strings[0].charAt(strings[0].length() - 1))
            s -= Integer.parseInt(strings[0].substring(left));
        left = 0;
        for (int i = 0; i < strings[1].length(); i++) {
            char c = strings[1].charAt(i);
            if (c == '+' || c == '-') {
                if (i != left) {
                    s += Integer.parseInt(strings[1].substring(left, i));
                    left = i;
                }
            } else if (c == 'x') {
                if (left == i - 1)
                    x -= (strings[1].charAt(left) == '+' ? 1 : -1);
                else
                    x -= Integer.parseInt(strings[1].substring(left, i));
                left = i + 1;
            }
        }
        if ('x' != strings[1].charAt(strings[1].length() - 1))
            s += Integer.parseInt(strings[1].substring(left));
        if (x != 0)
            return "x=" + s / x;
        if (s == 0)
            return "Infinite solutions";
        return "No solution";
    }

    public static void main(String[] args) {
        String s = "-x+x+3x=2x-x+x";
        System.out.println(new SolvetheEquation().solveEquation(s));
    }
}
