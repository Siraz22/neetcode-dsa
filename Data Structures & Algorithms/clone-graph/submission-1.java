/*
"अरे ओ प्रिय चित्रकार, क्या यह आपके थंगके के लिए काफी है?"
- Kalinag, Far Cry 4
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> oldToNew = new HashMap<>();

    public Node cloneGraph(Node node) {

        if(node == null) return null;
        if(oldToNew.containsKey(node)){
            return null;
        }

        Node newNode = new Node();
        newNode.val = node.val;
        oldToNew.put(node, newNode);

        for(Node oldNode: node.neighbors){
            Node newNeighbor = null;
            if(oldToNew.containsKey(oldNode)){
                newNeighbor = oldToNew.get(oldNode);
            }
            else{
                newNeighbor = cloneGraph(oldNode);
            }
            newNode.neighbors.add(newNeighbor);
        }

        return newNode;
    }
}