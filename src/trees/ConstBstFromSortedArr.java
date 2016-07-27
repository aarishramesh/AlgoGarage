package trees;

// Need to improvise and get it better in further iterations
// Running time - 2 * O (logN) ~ O (logN)
public class ConstBstFromSortedArr {
    static int[] arr = {1, 3, 5, 7, 9, 11, 13, 20, 23, 27, 29};

    public static void main(String[] args) {
        int mid = arr.length / 2;
        int rootIndex = mid;
        TreeNode<Integer> root = new TreeNode<Integer>(arr[mid]);

        //Forming a recursive solution
        if (arr.length > 3) {
            root.setLeftChild(constLeftSubTree(rootIndex - 2));
            root.setRightChild(constRightSubTree(rootIndex + 2));
        } else {
            if (mid - 1 >= 0) {
                root.setLeftChild(new TreeNode<Integer>(arr[mid - 1]));
            }
            if (mid + 1 < arr.length) {
                root.setRightChild(new TreeNode<Integer>(arr[mid + 1]));
            }
        }
        System.out.println("----- Printing out tree's elements ---------");
        printTree(root);
    }

    static TreeNode<Integer> printTree(TreeNode<Integer> root) {
        System.out.println(root.getData());
        if (root.getLeftChild() != null) {
            printTree(root.getLeftChild());
        }
        if (root.getRightChild() != null) {
            printTree(root.getRightChild());
        }
        return root;
    }
    
    static TreeNode<Integer> constLeftSubTree(int rootIndex) {
        TreeNode<Integer> rootNode = new TreeNode<Integer>(arr[rootIndex]);
        rootNode.setRightChild(new TreeNode<Integer>(arr[rootIndex + 1]));
        int leftIndex = rootIndex - 2;
        if (leftIndex >= 0) {
            rootNode.setLeftChild(constLeftSubTree(leftIndex));
        } else if (rootIndex - 1 >= 0) {
            rootNode.setLeftChild(new TreeNode<Integer>(arr[rootIndex - 1]));
        }
        return rootNode;
    }

    static TreeNode<Integer> constRightSubTree(int rootIndex) {
        TreeNode<Integer> rootNode = new TreeNode<Integer>(arr[rootIndex]);
        rootNode.setLeftChild(new TreeNode<Integer>(arr[rootIndex - 1]));
        int rightIndex = rootIndex + 2;
        if (rightIndex < arr.length) {
            rootNode.setRightChild(constRightSubTree(rightIndex));
        } else if (rootIndex + 1 < arr.length) {
            rootNode.setRightChild(new TreeNode<Integer>(arr[rootIndex + 1]));
        }
        return rootNode;
    }
}

class TreeNode<T> {
    T data;
    TreeNode<T> leftChild;
    TreeNode<T> rightChild;

    TreeNode(T data) {
        this.data = data;
    }

    void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    T getData() {
        return this.data;
    }
    
    TreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    TreeNode<T> getRightChild() {
        return this.rightChild;
    }
}