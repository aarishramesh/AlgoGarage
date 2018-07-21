package trees;

import java.util.ArrayList;
import java.util.List;

/**

 * Given an array reprsentation of binary tree where index is data while value at index is
 * parent create the binary tree. Value of -1 indicates root Node8.
 * 
 * References:
 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
 */
public class BinaryTreeFromParentRep {

    public Node8 create(int input[]) {
        Node8 t[] = new Node8[input.length];

        for(int i = 0; i < input.length; i++) {
            t[i] = new Node8();
            t[i].data = i;
        }

        Node8 root = null;
        for(int i = 0; i < input.length; i++) {
            int parentIndex = input[i];
            if(parentIndex == -1) {
                root = t[i];
                continue;
            }
            Node8 parent = t[parentIndex];
            if(parent.left == null) {
                parent.left = t[i];
            } else {
                parent.right = t[i];
            }
        }
        return root;
     }

     public static void main(String args[]) {
         BinaryTreeFromParentRep btpp = new BinaryTreeFromParentRep();
         int input[] =  {1, 5, 5, 2, 2, -1, 3};
         Node8 root = btpp.create(input);
         printLevelOrder(root);
     }
     
     private static void printLevelOrder(Node8 head) {
 		if (head == null)
 			return;
 		List<Node8> nodes = new ArrayList<Node8>();
 		nodes.add(head);
 		while (!nodes.isEmpty()) {
 			System.out.print(nodes.get(0).data + " ");
 			if (nodes.get(0).left != null)
 				nodes.add(nodes.get(0).left);
 			if (nodes.get(0).right != null)
 				nodes.add(nodes.get(0).right);
 			nodes.remove(0);
 		}
 	}
}

class Node8 {
	int data;
	Node8 left;
	Node8 right;
}