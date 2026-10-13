/*
"Choose whatever you’ll regret the least."
- Levi Ackerman, Attack on Titan
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

    public boolean isSameTree(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null && node2 != null) return false;
        if(node1 != null && node2 == null) return false;

        return node1.val == node2.val 
            && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root != null && subRoot == null) return false;
        if(root == null && subRoot != null) return false;

        boolean leftContainsSubTree = isSubtree(root.left, subRoot);
        boolean rightContainsSubTree = isSubtree(root.right, subRoot);

        return isSameTree(root, subRoot) || leftContainsSubTree || rightContainsSubTree;
    }
}