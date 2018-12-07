package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Nearest common ancestor using parent pointer
 * 
 * Grab interview question solution
 * 
 * @author polymath
 *
 */
public class NearestCommonAncestor {
	private static Map<Integer, CustomNode> nodesReverseMapForForest 
		= new HashMap<Integer, CustomNode>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		for (int j = 0; j < N; j++) {
			int num = s.nextInt();
			int[] arr = new int[num];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
			}

			int a = s.nextInt();
			int b = s.nextInt();
			
			CustomNode root = new CustomNode(-1);
			nodesReverseMapForForest.put(-1, root);
			constructForestFromParents(arr);
			
			CustomNode aNode = nodesReverseMapForForest.get(a);
			CustomNode bNode = nodesReverseMapForForest.get(b);
			System.out.println(nearestCommonAncestor(aNode, bNode));
			nodesReverseMapForForest.clear();
		}
		s.close();
	}
	
	// O(N) In space solution - Later
	/**
	private static int leastCommonAncestor(CustomNode a, CustomNode b) {
		if (a.parent.data == -1) {
			return -1;
		} else if (a.parent.equals(b.parent)) {
			return a.parent.data;
		}
		return leastCommonAncestor(a.parent, b.parent);
	}**/
	
	private static int nearestCommonAncestor(CustomNode a, CustomNode b) {
		if (a.equals(b))
			return a.data;
		
		Set<Integer> aParentSet = new HashSet<Integer>();
		while (a.parent != null) {
			aParentSet.add(a.parent.data);
			a = a.parent;
		}
		
		while(b.parent != null) {
			if (aParentSet.contains(b.parent.data))
				return b.parent.data;
			b = b.parent;
		}
		return -1;
	}
	
	private static void constructForestFromParents(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			CustomNode childNode = nodesReverseMapForForest.get(i);
			if (childNode == null) {
				childNode = new CustomNode(i);
				nodesReverseMapForForest.put(i, childNode);
			}
			int parent = arr[i];
			CustomNode parentNode = nodesReverseMapForForest.get(parent);
			if (parentNode == null) {
				parentNode = new CustomNode(parent);
				nodesReverseMapForForest.put(parent, parentNode);
			}
			parentNode.childNodes.add(childNode);
			childNode.parent = parentNode;
		}
	}
}

class CustomNode {
	int data;
	List<CustomNode> childNodes = new ArrayList<CustomNode>();
	CustomNode parent;
	
	CustomNode(int data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((childNodes == null) ? 0 : childNodes.hashCode());
		result = prime * result + data;
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
		CustomNode other = (CustomNode) obj;
		if (childNodes == null) {
			if (other.childNodes != null)
				return false;
		} else if (!childNodes.equals(other.childNodes))
			return false;
		if (data != other.data)
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomNode [data=" + data + ", childNodes=" + childNodes + ", parent=" + parent + "]";
	}


}
