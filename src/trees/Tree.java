package trees;

/**
 * Represents an abstract tree class from which various implementations such as Binary Search Tree, AVL, Redblack trees
 * can be written
 * 
 * @author aarish-1867
 *
 * @param <T>
 */
public abstract class Tree<T> {
	public abstract boolean insert(Node<T> n);
	public abstract boolean search(T obj);
	public abstract void print();
}

/**
 * Represents a basic tree entity.
 * All basic entities such as nodes of a BST, AVL, RedBlack trees all implement this basic node interface
 * 
 * @author aarish-1867
 *
 * @param <T>
 */
interface Node<T> {
	public T getElement();
}