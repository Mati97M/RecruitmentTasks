package dev.mati.tasks.LeetCode.Graphs;

import java.util.HashMap;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        return dfsClone(node, new HashMap<Node,Node>());
    }
    public Node dfsClone(Node node, HashMap<Node,Node> oldToNew) {
        if(oldToNew.containsKey(node))
            return oldToNew.get(node);

        Node copy = new Node(node.val);
        oldToNew.put(node,copy);
        for(int i = 0; i < node.neighbors.size(); i++) {
            copy.neighbors.add(dfsClone(node.neighbors.get(i), oldToNew));
        }
        return copy;
    }
}
