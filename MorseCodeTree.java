
import java.util.ArrayList;

/**
 * This is a MorseCodeTree which is specifically used for the conversion of
 * morse code to english
 * 
 * @author Hendrick Nguyen
 *
 */
public class MorseCodeTree extends Object implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root;

	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree() {

		buildTree();
	}

	/**
	 * Returns a reference to the root
	 * 
	 * @return TreeNode object
	 * 
	 */
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * Sets the root of the tree
	 * 
	 * @param newNode new node to be added to the tree
	 */
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;

	}

	/**
	 * This is a recursive method that adds element to the correct position in the
	 * tree based on the code
	 * 
	 * @param root   the root of the tree for this particular recursive instance of
	 *               addNode
	 * @param code   the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 * 
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {

		if (root != null) {
			TreeNode<String> current = root;
			for (int index = 0; index < code.length(); index++) {

				if (code.charAt(index) == '.') {
					if (current.left == null) {
						current.setLeftChild(new TreeNode<>(letter));
					}
					current = current.left;
				} else if (code.toString().charAt(index) == '-') {
					if (current.right == null) {
						current.setRightChild(new TreeNode<>(letter));
					}
					current = current.getRightChild();
				}
			}
		} else {
			this.root = new TreeNode<>(letter);
			this.root.left = null;
			this.root.right = null;
		}
	}

	/**
	 * Adds element to the correct position in the tree based on the code This
	 * method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @return result resulted letter that is added to the tree
	 */
	public void insert(String code, String result) {
		addNode(root, code, result);

	}

	/**
	 * fetch the data in the tree based on the code
	 * 
	 * @param code the code that describes the traversals to retrieve the string
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 * @param root the root of the tree for this particular recursive instance of
	 *             addNode
	 * @param code the code for this particular recursive instance of addNode
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (code.length() < 1) {
			return "";
		} else if (code.length() == 1) {
			if (code.equals(".")) {
				return root.left.getData();
			} else {
				return root.right.getData();
			}

		}
		if (code.charAt(0) == '.') {
			return fetchNode(root.left, code.substring(1));
		} else {
			return fetchNode(root.right, code.substring(1));
		}

	}

	/**
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level
	 * by level based on the code.
	 */
	@Override
	public void buildTree() {

		insert("", "");
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");

	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder)
	 * Traversal order Used for testing to make sure tree is built correctly
	 * 
	 * @return An ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		return list;

	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR
	 * (Inorder)
	 * 
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR
	 *             order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		else {
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
		}
	}

}
