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

//https://leetcode.com/problems/range-sum-of-bst/

public class RangeSumBST {
    static int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        return sumBST(root, low, high);
    }
    
    static int sumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        
        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }
           
        sumBST(root.left, low, high); 
        sumBST(root.right, low, high); 
        return sum;
    }
}