/*
"When I find myself in times of trouble, Mother Mary comes to me
Speaking words of wisdom, let it be"
- Let it be, The Beatles
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

    private TreeNode dfs(TreeNode node, int val){
        if(node == null)
            return new TreeNode(val);

        if(val < node.val)
            node.left = dfs(node.left, val);
        else if(val > node.val)
            node.right = dfs(node.right, val);

        return node;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode answer = dfs(root, val);
        return answer;
    }
}