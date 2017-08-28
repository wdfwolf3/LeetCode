public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return help(nums, 0, nums.length - 1);
    }

    public TreeNode help(int[] nums, int l, int r) {
        if (l > r)
            return null;
        else if (l == r)
            return new TreeNode(nums[l]);
        int mid = (l + r) / 2;
        TreeNode ans = new TreeNode(nums[mid]);
        ans.left = help(nums, l, mid - 1);
        ans.right = help(nums, mid + 1, r);
        return ans;
    }
}
