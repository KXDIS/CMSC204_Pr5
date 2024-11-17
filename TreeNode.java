/**
 * 
 * @author Hendrick Nguyen
 *
 * @param <T>
 */
public class TreeNode<T> {

	T data;
	TreeNode<T> left, right;

	/**
	 * Create a new TreeNode with left and right child set to null and data set to
	 * the dataNode
	 * 
	 * @param dataNode the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		this.data = dataNode;
		right = null;
		left = null;
	}

	/**
	 * used for making deep copies
	 * 
	 * @param node node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;

	}

	/**
	 * Return the data within this TreeNode
	 * 
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the data for the TreeNode
	 * 
	 * @param data data set in the treenode
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * gets the left child of the current node
	 * 
	 * @return left child
	 */
	public TreeNode<T> getLeftChild() {
		return left;
	}

	/**
	 * Sets the left child of the node
	 * 
	 * @param left left child of the given node
	 */
	public void setLeftChild(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * gets the right child of the given node
	 * 
	 * @return right child of given node
	 */
	public TreeNode<T> getRightChild() {
		return right;
	}

	public void setRightChild(TreeNode<T> right) {
		this.right = right;
	}
}
