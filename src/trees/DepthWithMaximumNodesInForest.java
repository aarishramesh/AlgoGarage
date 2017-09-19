package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Printing depth with maximum number of nodes given a forest (single tree or more than one tree) with N nodes
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
 * 3
 * 1
 * 
 * Space complexity - O(N) - Map of N nodes + Map of level order nodes
 * Time complexity - O(N) - Traversal of N nodes to store nodes depth wise
 * 
 * @author aarishramesh
 *
 */
public class DepthWithMaximumNodesInForest {
	private static Map<Integer, Node> nodesReverseMapForForest 
	= new HashMap<Integer, Node>();

	private static HashMap<Integer, List<Integer>> levelNodesList =
			new HashMap<Integer, List<Integer>>();

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
				addNodeToLevel(root, -1);
				System.out.println(findLevelWithMaxNodes());
				nodesReverseMapForForest.clear();
				levelNodesList.clear();
			}
		} finally {
			if (s != null)
				s.close();
		}
	}

	private static int findLevelWithMaxNodes() {
		int maxLevel = -1;
		int maxSize = 0;
		for (Entry<Integer, List<Integer>> entry : levelNodesList.entrySet()) {
			if (entry.getValue().size() >= maxSize) {
				maxSize = entry.getValue().size();
				maxLevel = entry.getKey();
			}
		}
		return maxLevel;
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
		List<Integer> nodesAtLevel = levelNodesList.get(level);
		if (nodesAtLevel == null) {
			nodesAtLevel = new ArrayList<Integer>();
			levelNodesList.put(level, nodesAtLevel);
		}
		nodesAtLevel.add(root.data);
		for (Node child : root.childNodes) {
			addNodeToLevel(child, level+1);
		}
	}
}
