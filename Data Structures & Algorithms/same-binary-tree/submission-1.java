/*
"I found you, passing by in cold December"
- When we feel young, When Chai Met Toast
*/

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

class Solution {

    public boolean recursion(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        
        if((node1 == null && node2 != null) ||
            (node1 != null && node2 == null) ||
            (node1.val != node2.val))
            return false;
        
        boolean leftSame = recursion(node1.left, node2.left);
        boolean rightSame = recursion(node1.right, node2.right);

        return leftSame && rightSame;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recursion(p, q);
    }
}
