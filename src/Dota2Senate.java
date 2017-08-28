public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        boolean[] sign = new boolean[senate.length()];
        int i = 0, j = 1, length = senate.length();
        while (true) {
            char c = senate.charAt(i);
            j = (i + 1) % length;
            while (j != i && (sign[j] || senate.charAt(j) == c))
                j = (j + 1) % length;
            if (j == i)
                return c == 'R' ? "Radiant" : "Dire";
            sign[j] = true;
            i = (i + 1) % length;
            while (sign[i])
                i = (i + 1) % length;
        }
    }
}
