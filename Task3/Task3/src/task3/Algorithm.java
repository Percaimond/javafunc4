package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Algorithm {
	static boolean  flag = false;
	static int negativID = 0;

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
		/*System.out.println("BEFORE");
		printTree(root);
		*/
		
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
				negativID--;
				Node artificialNode = new Node(cNode, negativID);
				artificialNode.setChildren(availableChildren);
				// current node now has only two children

				cNode.setChildren(new ArrayList<Node>(
						Arrays.asList(firstChild, artificialNode)));
			}
			
		}
		
		// THIS SHOWS THE TREE AFTER THE TRANSFORMATION
		// Suggestion: REMOVE THIS IN YOUR RECURSIVE FORMULATION
		//System.out.println("AFTER");
		//printTree(root);
		return root;
	}

	public static Node transformToBinaryRecursively(Node root){

		//abzuarbeitende knoten
		List<Node> toVisitNodes = new ArrayList<>();
		if(!flag){
			toVisitNodes.add(root);//hinzufügen root


		}

		if(!toVisitNodes.isEmpty()){//solange visitnodes nicht leer


			Node currentNode = toVisitNodes.get(0);//jetzige node ist die erste node der visitnodes
			List<Node> availableChildren = currentNode.getChildren();//alle children

			if(currentNode.getChildren().size()==0){
				toVisitNodes.remove(0);
			}
			else if(currentNode.getChildren().size()==1){
				toVisitNodes.add(currentNode.getFirst());
				toVisitNodes.remove(0);
			}
			else if(currentNode.getChildren().size()==2){
				toVisitNodes.add(currentNode.getFirst());
				toVisitNodes.add(currentNode.getSecond());
				toVisitNodes.remove(0);
			}
			else if(currentNode.getChildren().size()>2){
				//negativID--;
				Node firstChild = availableChildren.remove(0);
				Node artificialNode = new Node(currentNode,-1);
				currentNode.setChildren(new ArrayList<Node>(Arrays.asList(firstChild, artificialNode)));
				artificialNode.setChildren(availableChildren);
				toVisitNodes.add(firstChild);
				toVisitNodes.add(artificialNode);
				toVisitNodes.remove(0);
				flag = true;
			}
			transformToBinaryRecursively(toVisitNodes.get(0));
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

	public static void main(String[] args){
		Node root = new Node(null, 0);

		Node root_1 = new Node(root, 1);
		List<Node> rootChildren = new ArrayList<Node>(
				Arrays.asList(root_1));
		root.setChildren(rootChildren);

		Node root_2 = new Node(root, 2);
		Node root_3 = new Node(root, 3);
		Node root_4 = new Node(root_1, 4);
		List<Node> rootChildren2 = new ArrayList<Node>(
				Arrays.asList(root_2,root_3,root_4));
		root_1.setChildren(rootChildren2);


		Node root_5 = new Node(root_1, 5);
		Node root_6 = new Node(root_1, 6);
		List<Node> root_2Children = new ArrayList<Node>(
				Arrays.asList( root_5, root_6));
		root_2.setChildren(root_2Children);

		Node root_7 = new Node(root_4, 7);
		Node root_8 = new Node(root_4, 8);
		Node root_9 = new Node(root_4, 9);

		List<Node> root_4Children = new ArrayList<Node>(
				Arrays.asList( root_7, root_8, root_9));
		root_4.setChildren(root_4Children);

		Node submittedRoot = Algorithm.transformToBinaryRecursively(root);
		//Node submittedRoot = Algorithm.transformToBinary(root);
		printTree(submittedRoot);
	}
	
}
