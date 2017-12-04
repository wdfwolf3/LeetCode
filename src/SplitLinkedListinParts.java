public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        int n = 0;
        ListNode node = root;
        while (node != null) {
            n++;
            node = node.next;
        }
        int more = n % k;
        n = n / k;
        for (int i = 0; i < more; i++) {
            ans[i] = root;
            node = root;
            for (int j = 0; j < n; j++)
                node = node.next;
            root = node.next;
            node.next = null;
        }
        if (n != 0)
            for (int i = more; i < k; i++) {
                ans[i] = root;
                node = root;
                for (int j = 0; j < n - 1; j++)
                    node = node.next;
                root = node.next;
                node.next = null;
            }
        return ans;
    }
}
