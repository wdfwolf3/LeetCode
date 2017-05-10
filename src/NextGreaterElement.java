import java.util.*;

/**
 * Created by wdfwolf3 on 2017/5/9.
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        String string = "23432";
        System.out.println(string.toCharArray().toString());
        System.out.println(new String(string.toCharArray()));
    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        //ans数组存放结果
        int[] ans = new int[findNums.length];
        //便利数组findNums中的元素
        for (int i = 0; i < findNums.length; i++) {
            int start = 0;
            //start索引从头开始遍历nums查找当前元素在nums中的位置
            while (findNums[i] != nums[start]){
                start++;
            }
            //从start位置开始向后查找第一个比当前元素大的值，并赋值到ans数组中
            for (; start < nums.length; start++) {
                if(nums[start] > findNums[i]){
                    ans[i] = nums[start];
                    break;
                }
            }
            //如果start到达nums末尾，说明没有找到大于当前元素的值，赋值-1到ans数组中
            if(start == nums.length){
                ans[i] = -1;
            }
        }
        return ans;
    }

    public int[] nextGreaterElement1(int[] findNums, int[] nums) {
        //辅助栈，存放待查找结果的元素，查找到的立即出栈
        Stack<Integer> stack = new Stack<>();
        //key存放元素，value存放找到的第一个大于它的值
        Map<Integer, Integer> map = new HashMap<>();
        //当栈顶元素大于当前元素时，入栈；当栈顶元素小于当前元素时，说明栈顶元素找到了第一个大于的值，
        // 出栈，然后继续出栈直到栈顶元素大于当前元素，将当前元素入栈。
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums[i]){
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        //ans数组存放结果
        int[] ans = new int[findNums.length];
        //遍历findNums，在map中查找结果，不存在说明没有大于它的第一个元素，赋值为-1
        for (int i = 0; i < findNums.length; i++) {
            ans[i] = map.getOrDefault(findNums[i], -1);
        }
        return ans;
    }

    public int[] nextGreaterElement2(int[] nums){
        //ans数组存放结果
        int[] ans = new int[nums.length];
//      Arrays.fill(ans, -1);
        //辅助栈，存放待查找结果元素的索引，查找到的立即出栈
        Stack<Integer> stack = new Stack<>();
        //第一次遍历nums，同第一个问题，查找元素的nextGreaterElement。
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ans[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        //第二次遍历nums，相当于在元素的左边查找nextGreaterElement，但是不再入栈，因为元素在第一次遍历时已经被遍历过，不能再次入栈
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                ans[stack.peek()] = nums[i];
                stack.pop();
            }
        }
        //此时栈中存放的是没有找到nextGreaterElement的元素，在结果中赋值-1
        for (Integer i : stack){
            ans[i] = -1;
        }
        return ans;
    }

    public int nextGreaterElement3(int n){
        //如果是1位整数，直接返回-1，同时加上了10和11
        if(n <= 11){
            return -1;
        }
        //转化为char数组，方便处理数字
        char[] nums = (n+"").toCharArray();
        int i = nums.length - 2;
        //从后往前找到第一个升序的位数
        for (; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        //如果没有即不存在，返回-1
        if(i < 0){
            return -1;
        }
        int j = nums.length -1;
        //从后往前查找第一个比i大的数字，这样找出来的是所有大于i数字中的最小值
        for (; j > i; j--) {
            if(nums[i] < nums[j]){
                break;
            }
        }
        //交换i，j位置的数字
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        //i之后的数字排序，让结果最小
        Arrays.sort(nums, i, nums.length);
        //有可能交换后越界，使用long类型判断一下
        long ans = Long.parseLong(new String(nums));
        return (ans>Integer.MAX_VALUE)?-1:((int)ans);
    }
}
