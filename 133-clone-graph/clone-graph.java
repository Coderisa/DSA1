class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val);
        visited.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }

        return clone;
    }
}
