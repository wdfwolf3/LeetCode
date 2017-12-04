public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length == 1)
            return 1;
        int j = 0;
        for (int i = 0; i < chars.length; ) {
            int count = 1, tmp = i++;
            while (i < chars.length && chars[i] == chars[i - 1]) {
                i++;
                count++;
            }
            chars[j++] = chars[tmp];
            if (count > 1) {
                String s = String.valueOf(count);
                for (int k = 0; k < s.length(); k++) {
                    chars[j++] = s.charAt(k);
                }
            }
        }
        return j;
    }
}
