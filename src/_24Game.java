public class _24Game {
    private static double c = 0.000001;

    public boolean judgePoint24(int[] nums) {
        for (int i = 0; i < 4; i++) {
            swap(nums, 0, i);
            for (int j = 1; j < 4; j++) {
                swap(nums, 1, j);
                double[] two = help(nums[2], nums[3]);
                for (int k = 0; k < 6; k++) {
                    double[] three = help(nums[1], two[k]);
                    for (int l = 0; l < 6; l++) {
                        double[] four = help(nums[0], three[l]);
                        for (int m = 0; m < 6; m++) {
                            if (Math.abs(four[m] - 24) < c)
                                return true;
                        }
                    }
                }
            }
            swap(nums, 1, 2);
            swap(nums, 2, 3);
        }
        for (int i = 1; i < 4; i++) {
            swap(nums, 1, i);
            double[] before = help(nums[0], nums[1]);
            double[] after = help(nums[2], nums[3]);
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    double[] ans = help(before[j], after[k]);
                    for (int l = 0; l < 6; l++) {
                        if (Math.abs(24 - ans[l]) < c)
                            return true;
                    }
                }

            }
        }
        return false;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public double[] help(double a, double b) {
        double[] ans = new double[6];
        ans[0] = a + b;
        ans[1] = a - b;
        ans[2] = b - a;
        ans[3] = a * b;
        ans[4] = a / b;
        ans[5] = b / a;
        return ans;
    }

    public static void main(String[] args) {
        double d = 3 - 8 / (double) 3;
        d = 8 / d;
        System.out.println(24 - d <= c || d - 24 <= c);
    }
}
