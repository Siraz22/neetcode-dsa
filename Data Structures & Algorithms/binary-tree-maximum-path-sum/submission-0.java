/*
"The best solution to a problem is usually the easiest one."
- GLaDOS, Portal 2
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

    int maxSum = Integer.MIN_VALUE;

    public int recursion(TreeNode node){
        if(node == null)
            return 0;

        int leftSum = recursion(node.left);
        int rightSum = recursion(node.right);

        //the actual calculation
        int currSumThroughThisNode = node.val + leftSum + rightSum;
        int currSumThroughLeft = node.val + leftSum;
        int currSumThroughRight = node.val + rightSum;
        
        int currNodePathLocalMax = Math.max(
            node.val,
            Math.max(currSumThroughThisNode, 
            Math.max(currSumThroughLeft, currSumThroughRight)));

        maxSum = Math.max(maxSum, currNodePathLocalMax);

        //at this node, the curr Sum is left + curr + right, but for other nodes
        //we have the option to go either left or right; ie, only one branch can be chosen
        return Math.max(node.val,
                Math.max(currSumThroughLeft, currSumThroughRight));
    }

    public int maxPathSum(TreeNode root) {
        recursion(root);
        return maxSum;
    }
}