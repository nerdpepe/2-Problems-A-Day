import java.util.*;

class Node {
	Node left,right;
	int data;
	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BSTLevelOrderUsingQueue {
	
	static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		if(root!=null) {
			q.add(root);
		
		while(q.size() > 0) {
			//Dequeue node and print		
			Node cur = q.remove();
			System.out.print(cur.data + " ");
			
			//enqueue child node from next levelOrder
			if(cur.left!=null)
				q.add(cur.left);
			
			if(cur.right!=null)
				q.add(cur.right);
			}
		}
	}
	
	public static Node insert(Node root, int data) {
		if(root == null) {
			return new Node(data);
		}
		else {
			Node cur;
			if(data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}
	
	public static void main(String ...args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while(T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		levelOrder(root);
	}
}