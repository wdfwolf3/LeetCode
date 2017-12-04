public class _1bitand2bitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1)
            return true;
        int i = 0;
        for (int l = bits.length - 1; i < l; i++) {
            if (bits[i] == 1)
                i++;
        }
        return i == bits.length - 1;
    }
}
