public class LongestRepeatingCharacterReplacement {
    public static void main(String args[]) {
        String s = "AAAA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int result = 1;
        int tmp = k;
        for (int i = 0; i < s.length(); i++) {
            int flag = i;
            while ((i < s.length() - 1) && (s.charAt(i) == s.charAt(i + 1))) {
                i++;
            }
            int j = i + 1;
            for (; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    continue;
                } else if ((s.charAt(j) != s.charAt(i)) && (tmp == 0)) {
                    result = ((j - flag) > result) ? (j - flag) : result;
                    break;
                } else {
                    tmp--;
                }
            }
            result = ((tmp + j - flag) > result) ? (tmp + j - flag) : result;
            tmp = k;
        }
        return Math.min(result, s.length());
    }
}
