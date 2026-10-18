/*
"What I cannot create, I do not understand."
- Richard Feynman
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

    public int recursion(TreeNode node, int localMaxima){
        //base case
        if(node == null) return 0;

        int goodNode = node.val >= localMaxima ? 1 : 0;
        localMaxima = Math.max(node.val, localMaxima);
        
        int left = recursion(node.left, localMaxima);
        int right = recursion(node.right, localMaxima);

        return goodNode + left + right;
    }

    public int goodNodes(TreeNode root) {
        return recursion(root, Integer.MIN_VALUE);
    }
}
