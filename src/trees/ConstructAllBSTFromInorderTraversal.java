package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
 * 
 * @author polymath
 *
 */
public class ConstructAllBSTFromInorderTraversal {

    public List<Node> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return construct(1, n);
    }

    private List<Node> construct(int start, int end) {
        if (start > end) {
            return Collections.singletonList(null);
        }
        List<Node> allTrees = new ArrayList<>();
        for (int root = start; root <= end; root++) {
            //get all subtrees from left and right side.
            List<Node> allLeftSubstrees = construct(start, root - 1);
            List<Node> allRightSubstrees = construct(root + 1, end);
            //iterate through them in all combination and them connect them to root
            //and add to allTrees.
            for (Node left : allLeftSubstrees) {
                for (Node right : allRightSubstrees) {
                    Node node = new Node(root);
                    node.left = left;
                    node.right = right;
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }

    public static void main(String args[]) {
        ConstructAllBSTFromInorderTraversal ct = new ConstructAllBSTFromInorderTraversal();
        @SuppressWarnings("unused")
		List<Node> allTrees = ct.generateTrees(2);
    }
    
    static class Node {
    		int data;
    		Node left;
    		Node right;
    		
    		Node(int data) {
    			this.data = data;
    		}
    }
}