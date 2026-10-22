/*
"It is the nature of a thing that matters.
Not it's form"
- Kratos asking Brok to bless Draupnir Spear, God Of War : Ragnarok
*/

public class Codec {

    StringBuilder sb;
    int pos;

    private void preorder(TreeNode node){
        if(node == null){
            sb.append("null,");
            return;
        }

        sb.append(node.val);
        sb.append(",");
        
        preorder(node.left);
        preorder(node.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        this.preorder(root); 
        return sb.toString();
    }

    private TreeNode decodeRec(String[] arr){
        if(arr[pos].equals("null")){
            return null;
        }

        TreeNode localParent = new TreeNode(Integer.parseInt(arr[pos]));

        pos++;
        localParent.left = decodeRec(arr);
        pos++;
        localParent.right = decodeRec(arr);

        return localParent;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        pos = 0;
        TreeNode root = decodeRec(arr);
        return root;
    }
}