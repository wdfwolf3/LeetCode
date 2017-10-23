/**
 * Created by wdfwolf3 on 2017/10/18.
 */
/* Your Codec object will be instantiated and called as such:
 Codec codec = new Codec();
 codec.deserialize(codec.serialize(root));
 */

public class SerializeandDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        String s = "" + root.val;
        if (root.left != null)
            s += " " + serialize(root.left);
        if (root.right != null)
            s += " " + serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data))
            return null;
        String[] strings = data.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(strings[i]);
        return deserialize(nums, 0, nums.length - 1);
    }

    public TreeNode deserialize(int[] nums, int l, int r) {
        if (l > r)
            return null;
        TreeNode root = new TreeNode(nums[l]);
        if (l == r)
            return root;
        int mid = r + 1;
        for (int i = l + 1; i <= r; i++)
            if (nums[i] > nums[l]) {
                mid = i;
                break;
            }
        root.left = deserialize(nums, l + 1, mid - 1);
        root.right = deserialize(nums, mid, r);
        return root;
    }
}
