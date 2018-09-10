package trees;

/**
* 
* Given a root of binary tree, return size of binary tree
* 
* Solution:
* Recursively find size of left side, right side and add one to them and return that to calling function.
* 
* Time complexity - O(n)
* Space complexity(because of recursion stack) - height of binary tree. Worst case O(n)
* 
* Test cases:
* Null tree
* 1 node tree
* multi node tree
*/
public class SizeOfBinaryTree {

   public static int size(Node root) {
       if(root == null){
           return 0;
       }
       return size(root.left) + size(root.right) + 1;
   }
   
   static class Node {
	   int data;
	   Node left;
	   Node right;
   }
}
