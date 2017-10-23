import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wdfwolf3 on 2017/5/11.
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (s == null || s.equals("")) {
            return new NestedInteger();
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger ans = null;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (c == '[') {
                if (ans != null) {
                    stack.push(ans);
                }
                ans = new NestedInteger();
                left = right + 1;
            } else if (c == ',') {
                if (s.charAt(right - 1) != ']') {
                    ans.add(new NestedInteger(Integer.parseInt(s.substring(left, right))));
                }
                left = right + 1;
            } else if (c == ']') {
                String number = s.substring(left, right);
                if (!number.isEmpty()) {
                    ans.add(new NestedInteger(Integer.parseInt(s.substring(left, right))));
                }
                if (!stack.isEmpty()) {
                    stack.peek().add(ans);
                    ans = stack.pop();
                }
                left = right + 1;
            }
        }
        return ans;
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
//public interface NestedInteger {
//
//     // @return true if this NestedInteger holds a single integer, rather than a nested list.
//     public boolean isInteger();
//
//      // @return the single integer that this NestedInteger holds, if it holds a single integer
//      // Return null if this NestedInteger holds a nested list
//      public Integer getInteger();
//
//     // @return the nested list that this NestedInteger holds, if it holds a nested list
//      // Return null if this NestedInteger holds a single integer
//      public List<NestedInteger> getList();
//}
class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    public void add(NestedInteger nestedInteger) {
        if (this.list != null) {
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public NestedInteger(Integer integer) {
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList();
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public String printNi(NestedInteger thisNi, StringBuilder sb) {
        if (thisNi.isInteger()) {
            sb.append(thisNi.integer);
            sb.append(",");
        }
        sb.append("[");
        for (NestedInteger ni : thisNi.list) {
            if (ni.isInteger()) {
                sb.append(ni.integer);
                sb.append(",");
            } else {
                printNi(ni, sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
