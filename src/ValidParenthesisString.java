public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*')
                builder.append(c);
            else if (c == '(')
                builder.append(c);
            else {
                int index = builder.lastIndexOf("(");
                if (index >= 0)
                    builder.deleteCharAt(index);
                else if (builder.length() == 0)
                    return false;
                else
                    builder.deleteCharAt(builder.length() - 1);
            }
        }
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '(')
                count++;
            else if (count > 0)
                count--;
        }
        return count == 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '*')
//                count++;
//            else if (c == '(')
//                stack++;
//            else if (stack > 0)
//                stack--;
//            else if (count > 0)
//                count--;
//            else
//                return false;
//        }
//        return stack <= count;
    }
}
