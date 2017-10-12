public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] chars = ("" + num).toCharArray();
        int index = -1;
        for (int i = 0; i < chars.length; i++) {
            char tmp = chars[i];
            for (int j = i; j < chars.length; j++) {
                if (chars[j] >= tmp) {
                    tmp = chars[j];
                    index = j;
                }
            }
            if (tmp != chars[i]) {
                char t = chars[i];
                chars[i] = chars[index];
                chars[index] = t;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
