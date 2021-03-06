package iteratorImplemenation.BinaryTree;

import java.util.NoSuchElementException;
import java.util.Stack;

import node.TreeNode;
import binaryTreeiterator.InOrderIterator;

public class BinaryTreeInOrderIteratorImplementation implements InOrderIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();

	/**
	 * Returns the next integer a in the post-order traversal of the given
	 * binary tree. For example, given a binary tree below,  example, given a binary tree below,
	   *       4
	   *      / \
	   *     2   6
	   *    / \ / \
	   *   1  3 5  7
	   *    the outputs will be 4, 2, 1, 3, 6, 5, 7
	 */

	@Override
	public boolean hasNext() {
		if (stack.isEmpty())
			return false;
		return true;
	}

	public BinaryTreeInOrderIteratorImplementation(TreeNode root) {
		super();
		if (root == null)
			throw new RuntimeException(
					"Can't create iterator for null Binary Tree");
		insertChildren(root);
	}

	private void insertChildren(TreeNode root) {
		while (root != null) {
			this.stack.push(root);
			root = root.getLeft();
		}
	}

	@Override
	public Integer next() {
		if (!hasNext())
			throw new NoSuchElementException("All element has visited!");

		TreeNode node = stack.pop();
		insertChildren(node.getRight());
		return node.getData();

	}

}
