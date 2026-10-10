/*
"We've heard your claims, and believe what you say! We will follow you to Chinon!"
- Knights to Joan of Arc, Age of Empires II
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

    public int depth(TreeNode node){
        if(node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);
    
        return 1 + Math.max(left, right);
    }

    public boolean recursion(TreeNode node){
        if(node == null) return true;

        boolean leftBalanced = recursion(node.left);
        boolean rightBalanced = recursion(node.right);

        int leftHeight = depth(node.left);
        int rightHeight = depth(node.right);

        return leftBalanced && rightBalanced 
            && (Math.abs(leftHeight - rightHeight) <= 1);
    }

    public boolean isBalanced(TreeNode root) {
        return recursion(root);
    }
}