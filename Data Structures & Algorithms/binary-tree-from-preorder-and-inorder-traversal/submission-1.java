/*
"The ending isn't any more important than any of the moments leading to it."
- Dr. Rosalene, To The Moon
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

    public TreeNode recursion(int[] preorder, int[] inorder){
        if(preorder.length == 0) 
            return null;

        int elem = preorder[0];
        int indexOfElem = -1;
        for(int i=0;i<inorder.length;++i){
            if(inorder[i] == elem){
                indexOfElem = i;
                break;
            }
        }

        //left side
        int[] leftSide = Arrays.copyOfRange(inorder, 0, indexOfElem);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSide.length);
        
        //right side
        int[] rightSide = Arrays.copyOfRange(inorder, indexOfElem + 1, inorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSide.length, preorder.length);

        TreeNode leftNode = recursion(leftPreorder, leftSide);
        TreeNode rightNode = recursion(rightPreorder, rightSide);

        //self
        TreeNode localParent = new TreeNode(elem);
        localParent.left = leftNode;
        localParent.right = rightNode;

        return localParent;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, inorder);
    }
}
