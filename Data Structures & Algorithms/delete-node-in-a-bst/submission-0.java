/*
"The earth, the water... they have no pride. They endure, and we must endure."
- Rains Fall, Red Dead Redemption 2
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val == key){
            if(root.right == null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                TreeNode successor = findInOrderSuccessor(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        }

        return root;
    }

    private TreeNode findInOrderSuccessor(TreeNode node){
        if(node != null && node.left!=null){
            return findInOrderSuccessor(node.left);
        }
        return node;
    }
}