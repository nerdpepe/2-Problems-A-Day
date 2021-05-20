/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return ans;
        q.add(root);
        while (q.size() > 0) {
            int qLen = q.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < qLen; i++) {
                // Dequeue node and add to row
                TreeNode cur = q.remove();
                row.add(cur.val);
                // enqueue child nodes 
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
            ans.add(row);
        }
        return ans;
    }
}