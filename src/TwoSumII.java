public class TwoSumII {
    public static void main() {
        int[] n = new int[]{2, 7, 9, 15};
        System.out.println(twoSum(n, 9));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length;
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target)
                i++;
            else
                j--;
        }
        result[0] = i + 1;
        result[1] = j + 1;
        return result;


    }
}
