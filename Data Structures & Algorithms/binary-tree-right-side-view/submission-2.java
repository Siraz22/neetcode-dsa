/*
"I'm trying to realize
It's alright to not be fine on your own"
- Comethru, Jeremy Zucker
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        List<Integer> answer = new ArrayList<Integer>();

        if(root == null) return answer;

        queue.add(root);
        queue.add(null);

        while(queue.size() > 0){
            TreeNode node = queue.remove();

            if(!queue.isEmpty() && queue.peek()== null){
                answer.add(node.val);
            }
            if(node == null){
                if(queue.isEmpty())
                    break;
                
                queue.add(null);
                continue;
            }

            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }

        return answer;
    }
}
