/*
"Not everyone can become a great artist. But a great artist can come from anywhere."
- Anton Ego, Ratatouille
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        if(root == null) return answer;

        queue.add(root);
        queue.add(null);

        while(queue.size() > 0){
            TreeNode node = queue.remove();

            if(node == null){
                answer.add(temp);

                // Stop if there are no more nodes to process
                if(queue.isEmpty()) break;

                queue.add(null);
                temp = new ArrayList<Integer>();
                continue;
            }

            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);

            temp.add(node.val);
        }

        return answer;
    }
}