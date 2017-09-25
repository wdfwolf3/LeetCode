public class UTF8Validation {
    public static void main(String args[]) {
        int[] data = new int[]{235, 140, 4};
        System.out.println(validUtf8(data));
    }

    public static boolean validUtf8(int[] data) {
        int flag = 0;
        for (int i = 0; i < data.length; i++) {
            data[i] &= 255;
            if (flag == 0) {
                if ((data[i] & 128) == 0)
                    continue;
                else {
                    while ((data[i] & 128) != 0) {
                        flag++;
                        data[i] <<= 1;
                    }
                    if (--flag > 3)
                        return false;
                }
            } else if ((data[i] & 128) == 128) {
                flag--;
            } else {
                return false;
            }
        }
        return true;
    }
}
