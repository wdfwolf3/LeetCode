import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String args[]) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> lists = new ArrayList<String>();
        String string = "";
        gene(lists, string, n, n);
        return lists;
    }

    public static void gene(List<String> lists, String s, int l, int r) {
        String string = s;
        if (l > 0) {
            s += "(";
            gene(lists, s, l - 1, r);
        }
        if (r > 0 && r > l) {
            s = string;
            s += ")";
            gene(lists, s, l, r - 1);
        }
        if (r == 0 && l == 0)
            lists.add(s);
    }
}
