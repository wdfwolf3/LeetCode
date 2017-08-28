
public class ArrayToTreeRoot {
    /**
     *
     * @param nums
     * @return
     */
    public static TreeNode arrayToTreeRoot(Integer[] nums){
        TreeNode[] treeNodes = new TreeNode[nums.length];
        for (int i = nums.length/2; i < nums.length; i++)
            treeNodes[i] = (nums[i]==null)?null:new TreeNode(nums[i]);
        for (int i = nums.length/2-1; i >= 0; i--) {
            if (nums[i]==null)
                treeNodes[i] = null;
            else {
                treeNodes[i] = new TreeNode(nums[i]);
                treeNodes[i].left = treeNodes[2*i+1];
                treeNodes[i].right = (2*i+2>=nums.length)?null:treeNodes[2*i+2];
            }
        }
        return treeNodes[0];
    }
}
