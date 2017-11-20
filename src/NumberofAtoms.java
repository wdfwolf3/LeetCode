import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class NumberofAtoms {
    public static void main(String[] args) {
        System.out.println(new NumberofAtoms().countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
    }

    public String countOfAtoms(String formula) {
        Map<String, Integer> map = help(formula);
        StringBuilder ans = new StringBuilder("");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.append(entry.getKey());
            if (entry.getValue() != 1)
                ans.append(entry.getValue());
        }
        return ans.toString();
    }

    public Map<String, Integer> help(String formula) {
        formula += "A";
        Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Map<String, Integer> sub = null;
        String tmp = "";
        for (int i = 0, sum = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (Character.isLowerCase(c))
                tmp += c;
            else if (Character.isUpperCase(c)) {
                if (!tmp.equals(""))
                    map.put(tmp, sum == 0 ? 1 : sum);
                else if (sub != null) {
                    for (Map.Entry<String, Integer> entry : sub.entrySet()) {
                        int k = map.getOrDefault(entry.getKey(), 0);
                        sum = sum == 0 ? 1 : sum;
                        map.put(entry.getKey(), k + entry.getValue() * sum);
                    }
                    sub = null;
                }
                tmp = "" + c;
                sum = 0;
            } else if (c == '(') {
                map.put(tmp, sum == 0 ? 1 : sum);
                System.out.println(tmp);
                tmp = "";
                sum = formula.lastIndexOf(')');
                sub = help(formula.substring(i + 1, sum));
                i = sum;
                sum = 0;
            } else
                sum = sum * 10 + (c - '0');
        }
        return map;
    }
}
