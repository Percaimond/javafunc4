package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
			if (cNode.hasChildren())
				toVisitNodes.addAll(cNode.getChildren());
			
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

	public static Node transformToBinaryRecursively(Node root){
		List<Node> toVisitNodes = new ArrayList<>();
		toVisitNodes.add(root);
		Node currentNode = toVisitNodes.remove(0);
		List<Node> availableChildren = currentNode.getChildren();
		if(!toVisitNodes.isEmpty()){
			if(currentNode.getChildren().size()==0){
				availableChildren.remove(toVisitNodes.remove(0));
				toVisitNodes.remove(0);
			}
			else if(currentNode.getChildren().size()==1){
				currentNode.setChildren(currentNode.getChildren());
				availableChildren.remove(toVisitNodes.remove(0));
				toVisitNodes.remove(0);
				toVisitNodes.add(currentNode.getFirst());
			}
			else if(currentNode.getChildren().size()==2){
				currentNode.setChildren(currentNode.getChildren());
				availableChildren.remove(toVisitNodes.remove(0));
				availableChildren.remove(toVisitNodes.remove(1));
				toVisitNodes.add(currentNode.getFirst());
				toVisitNodes.add(currentNode.getSecond());
			}
			else if(currentNode.getChildren().size()>2){

				Node firstChild = availableChildren.remove(0);
				Node artificialNode = new Node(currentNode, -1);

				// current node now has only two children
				currentNode.setChildren(new ArrayList<Node>(
						Arrays.asList(firstChild, artificialNode)));
				artificialNode.setChildren(availableChildren);
				return transformToBinaryRecursively(artificialNode);
			}
		}
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
	public static Node createInputTree() {
		/*
		 * Example input tree:
		 * 	root
		 * 		1
		 * 		2
		 * 			3
		 * 			4
		 * 			5
		 *
		 */
		Node root = new Node(null, 0);

		Node root_1 = new Node(root, 1);
		Node root_2 = new Node(root, 2);
		List<Node> rootChildren = new ArrayList<Node>(
				Arrays.asList(root_1, root_2));
		root.setChildren(rootChildren);

		Node root_2_3 = new Node(root_2, 3);
		Node root_2_4 = new Node(root_2, 4);
		Node root_2_5 = new Node(root_2, 5);
		List<Node> root_2Children = new ArrayList<Node>(
				Arrays.asList(root_2_3, root_2_4, root_2_5));
		root_2.setChildren(root_2Children);

		return root;
	}
	public static void main(String[] args){
		Node sampleTree = createInputTree();
		Node submittedRoot = Algorithm.transformToBinaryRecursively(sampleTree);
		printTree(submittedRoot);
	}
	
}
