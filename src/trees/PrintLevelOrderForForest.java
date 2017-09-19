package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Printing level order traversal given a forest (single tree or more than one tree) with N nodes
 * Each node is given an integer value of 0 to (N - 1)
 * 
 * Sample input
 * 
 * 2
 * 6
 * 5 -1 1 1 5 2
 * 13
 * 4 3 -1 -1 1 2 7 3 1 4 2 1 2
 * 
 * Sample output
 * 
 * 1
 * 2 3 
 * 5
 * 0 4
 * 
 * 2 3
 * 1 5 7 10 12
 * 4 6 8 11
 * 0 9
 * 
 * Space complexity - O(N) - Map of N nodes + Map of level order nodes
 * Time complexity - O(N) - Traversal of N nodes to store nodes depth wise
 * 
 * @author aarishramesh
 *
 */
public class PrintLevelOrderForForest {
	private static Map<Integer, Node> nodesReverseMapForForest 
	= new HashMap<Integer, Node>();

	private static HashMap<Integer, StringBuilder> levelNodesList =
			new HashMap<Integer, StringBuilder>();

	public static void main(String[] args) {
		Scanner s = null;
		try {
			s = new Scanner(System.in);
			int N = s.nextInt();

			for (int j = 0; j < N; j++) {
				int num = s.nextInt();
				int[] arr = new int[num];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = s.nextInt();
				}
				Node root = new Node(-1);
				nodesReverseMapForForest.put(-1, root);
				constructForestFromParents(arr);
				addNodeToLevel(root, 0);
				printNodesLevelWise();
				nodesReverseMapForForest.clear();
				levelNodesList.clear();
			}
		} finally {
			if (s != null)
				s.close();
		}
	}

	private static void printNodesLevelWise() {
		int i = 0;
		for (Entry<Integer, StringBuilder> entry : levelNodesList.entrySet()) {
			if (i != 0) {
				System.out.println(entry.getValue().toString());
			} else {
				i = 1;
			}
		}
	}

	private static void constructForestFromParents(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			Node childNode = nodesReverseMapForForest.get(i);
			if (childNode == null) {
				childNode = new Node(i);
				nodesReverseMapForForest.put(i, childNode);
			}
			int parent = arr[i];
			Node parentNode = nodesReverseMapForForest.get(parent);
			if (parentNode == null) {
				parentNode = new Node(parent);
				nodesReverseMapForForest.put(parent, parentNode);
			}
			parentNode.childNodes.add(childNode);
		}
	}

	private static void addNodeToLevel(Node root, int level) {
		StringBuilder nodesAtLevel = levelNodesList.get(level);
		if (nodesAtLevel == null) {
			nodesAtLevel = new StringBuilder();
			levelNodesList.put(level, nodesAtLevel);
		}
		nodesAtLevel.append(root.data).append(" ");
		for (Node child : root.childNodes) {
			addNodeToLevel(child, level+1);
		}
	}
}

class Node {
	int data;
	List<Node> childNodes = new ArrayList<Node>();

	Node(int data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
	}
}
