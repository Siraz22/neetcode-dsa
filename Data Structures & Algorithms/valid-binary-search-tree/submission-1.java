/*
"Remember, no Russian."
- Vladimir Makarov, CoD : Modern Warfare 2
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

    public boolean recursion(TreeNode node, long leftMax, long rightMin){
        if(node == null) return true;

        boolean self = true;
        if(!(leftMax < node.val))
            return false;
        if(!(node.val < rightMin))
            return false;

        boolean left = recursion(node.left, leftMax ,node.val);
        boolean right = recursion(node.right, node.val, rightMin);

        return left && right && self;
    }

    public boolean isValidBST(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}