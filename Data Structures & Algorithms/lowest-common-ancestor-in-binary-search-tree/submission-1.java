/*
"Yes, we too are stardust."
- Sophie's World, Jostein Gaarder
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode recursion(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;

        if (p.val < node.val && q.val < node.val)
            return recursion(node.left, p, q);

        if (p.val > node.val && q.val > node.val)
            return recursion(node.right, p, q);

        return node;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursion(root, p, q);
    }
}