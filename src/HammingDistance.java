public class HammingDistance {
    public static void main(String args[]) {
        System.out.println(hammingDistance(0, 4));
    }

    public static int hammingDistance(int x, int y) {
        int i = x ^ y, ans = 0;
        while (i != 0) {
            i &= (i - 1);
            ans++;
        }
        return ans;
    }
}
