public class SuperPow {
    public static void main(String args[]) {
        int[] b = {};
        System.out.println(superPow(2, b));
    }

    public static int superPow(int a, int[] b) {
        int result = 1;
        a = a % 1337;
        for (int i = b.length - 1; i >= 0; i--) {
            int count = b[i];
            while (count > 0) {
                if (result >= 1337)
                    result = result % 1337;
            }
        }

        return result;
    }
}
