package trees;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class TreeTraversals {
	
	public static void inorderIterative(Node root) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		Set<Node> visitedNodes = new HashSet<Node>();
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (visitedNodes.contains(node.left)) {
				System.out.print(node.data + " ");
				visitedNodes.add(node);
				continue;
			}
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null) {
				stack.add(node);
				stack.add(node.left);
			} else {
				System.out.print(node.data + " ");
				visitedNodes.add(node);
			}
		}
	}
	
	public void inorderItr(Node root){
        Deque<Node> stack = new LinkedList<Node>();
        Node node = root;
        while(true){
            if(node != null){
                stack.addFirst(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pollFirst();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }
	
	public static void preorderIterative(Node root) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.data + " ");
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null)
				stack.add(node.left);
		}
	}
	
	public static void postorderIterative(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Set<Node> visitedNodes = new HashSet<Node>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (visitedNodes.contains(node.right)) {
				System.out.print(node.data + " ");
				visitedNodes.add(node);
				continue;
			}
			if (node.left == null && node.right == null) {
				System.out.print(node.data + " ");
				visitedNodes.add(node);
			} else {
				stack.add(node);
				if (node.right != null)
					stack.add(node.right);
				if (node.left != null) 
					stack.add(node.left);
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(3);
		root.left = left;
		root.right = right;
		left.left = new Node(7);
		left.right = new Node(6);
		right.left = new Node(5);
		right.right = new Node(4);
		
		inorderIterative(root);
		System.out.println();
		preorderIterative(root);
		System.out.println();
		postorderIterative(root);
	}
	
	static class Node {
		int data;
		Node left;
		Node right;

		Node (int data) {
			this.data = data;
		}
	}
}
