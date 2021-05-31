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
class RangeSumBSTOther {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root ==null){
            return 0;
        }

        //exclude traversing right subtree from root since BST property will have all values out of R range
        if(root.val > high){ 
            return rangeSumBST(root.left, low, high);
        }

        //exclude traversing right subtree from root since BST property will have all values out of R range 
        if(root.val < low){ 
            return rangeSumBST(root.right, low, high);
        }

        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high); //return the sum of each subtree traversal
    }
}