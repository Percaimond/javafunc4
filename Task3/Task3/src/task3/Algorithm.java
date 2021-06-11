package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm {

	/**
	* Convert a n-children tree in a max 2 children tree
	*
	* @param  root of the tree to transform
	*/
	public static Node transformToBinary(Node root) {

		// REPLACE THE ENTIRE METHOD CONTENT WITH YOUR RECURSIVE FORMUALTION.
		// "for" and "while" keywords are forbidden in the final solution file.
		// Avoid them also in the comments.

		// THIS SHOWS THE TREE BEFORE THE TRANSFORMATION.
		// Suggestion: REMOVE THIS IN YOUR RECURSIVE FORMULATION
		// (otherwise you will have the print of the tree at each 
		// recursive call)
		System.out.println("BEFORE");
		printTree(root);
		
		
		List<Node> toVisitNodes = new ArrayList<>();
		toVisitNodes.add(root);

		while (toVisitNodes.size() != 0) {
			Node cNode = toVisitNodes.remove(0);
			if (cNode.hasChildren()) toVisitNodes.addAll(cNode.getChildren());
			
			if (cNode.hasChildren() && cNode.getChildren().size() > 2) {
				// the first child remains there 
				List<Node> availableChildren = cNode.getChildren();
				Node firstChild = availableChildren.remove(0);
				// the rest is moved as children of a new artificial node
				// by default we assign id -1
				// this node contains the remaining children
				Node artificialNode = new Node(cNode, -1);
				artificialNode.setChildren(availableChildren);
				// current node now has only two children
				cNode.setChildren(new ArrayList<Node>(
						Arrays.asList(firstChild, artificialNode)));
			}
			
		}
		
		// THIS SHOWS THE TREE AFTER THE TRANSFORMATION
		// Suggestion: REMOVE THIS IN YOUR RECURSIVE FORMULATION
		System.out.println("AFTER");
		printTree(root);
		return root;
	}
	
	/**
	* Print a tree from the root down.
	* Only useful to visualize, not relevant for the functionality.
	*
	* @param  root of the tree
	*/
	public static void printTree(Node root) {
		System.out.println("Visiting node ID: " + root.getId().toString());
		root.printChildren();
		if (root.hasChildren()) {
			for (Node child : root.getChildren())
				printTree(child);
		}
	}
	
}
