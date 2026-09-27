import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        // In-order traversal visits nodes in sorted ascending order
        while (curr != null || !stack.isEmpty()) {
            // Traverse as far left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop and visit node
            curr = stack.pop();
            k--;

            // If k reaches 0, we have found the kth smallest element
            if (k == 0) {
                return curr.val;
            }

            // Move to the right subtree
            curr = curr.right;
        }

        return -1;
    }
}