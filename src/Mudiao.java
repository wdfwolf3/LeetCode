import java.util.Scanner;

public class Mudiao {
    private static int[][] nums;
    private static boolean[] sign;

    public static void dfs(int n) {
        for (int i = 1; i < nums.length; i++)
            if ((!sign[i]) && nums[n][i] == 1) {
                sign[i] = true;
                dfs(i);
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n + 1][n + 1];
        sign = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = sc.nextInt();
            nums[i][j] = 1;
            nums[j][i] = 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++)
            if (!sign[i]) {
                sign[i] = true;
                dfs(i);
                count++;
            }
        System.out.println(count);


//        UnionFind unionFind = new UnionFind(n);
//        for (int i = 1; i <= n; i++) {
//            int tmp = sc.nextInt();
//        unionFind.union(i,tmp);
//        }
//        System.out.println(unionFind.count());
    }
}

class UnionFind {
    int[] nums;
    int count;

    public UnionFind(int n) {
        nums = new int[n];
        for (int i = 1; i <= n; i++)
            nums[i] = i;
        count = n;
    }

    void union(int p, int q) {
        int pp = find(p), qp = find(q);
        if (pp == qp)
            return;
        else {
            count--;

        }
    }

    int find(int i) {
        while (nums[i] != i)
            i = nums[i];
        return i;
    }

    int count() {
        return count;
    }


}
