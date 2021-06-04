import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepthNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    // Uses BFS
    static int maxDepth(Node root) {
        int depth = 0;
        List<Node> list;
        if (root == null)
            return depth;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for(int i = 0; i<size; i++) {
                Node n = q.poll();
                list =  n.children;
                for (Node node : List) {
                    q.add(node);
                }
            }
        }

        return depth;
    }

    public static void main(String... args) {
        int _val = 0;
        List<Node> _children = new ArrayList<>();
        _children.add(new Node(1));
        Node n = new Node(_val, _children);
        System.out.println(maxDepth(n));
    }
}