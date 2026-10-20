/*
"You don't win the battle by doing what's right. You win, by doing what's necessary."
- Ghost Recon : Future Soldier
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

    int val;
    int count;

    public void recursion(TreeNode node, int k){
        if(node == null) return;

        recursion(node.left,k);

        //inorder
        count++;
        if(count == k){
            this.val = node.val;
            return;
        }    

        recursion(node.right,k);
    }

    public int kthSmallest(TreeNode root, int k) {
        recursion(root, k);
        return this.val;
    }
}