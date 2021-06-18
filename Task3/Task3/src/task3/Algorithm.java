package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Algorithm {
	static boolean  flag = false;
	static List<Node> toVisitNodes = new ArrayList<>();
	/**
	* Convert a n-children tree in a max 2 children tree
	*
	* @param  root of the tree to transform
	*/

	public static Node transformToBinary(Node root){
		if(!flag){
			toVisitNodes.add(root);//hinzufügen root
		}
		if(toVisitNodes.size()!=0){//solange visitnodes nicht leer
			Node currentNode = toVisitNodes.get(0);//jetzige node ist die erste node der visitnodes
			List<Node> availableChildren = currentNode.getChildren();//alle children
			if(currentNode.hasChildren()){
				toVisitNodes.addAll(currentNode.getChildren());
			}
			if(currentNode.hasChildren() && currentNode.getChildren().size()>2){
				Node firstChild = availableChildren.remove(0);
				Node artificialNode = new Node(currentNode,-1);
				currentNode.setChildren(new ArrayList<Node>(Arrays.asList(firstChild, artificialNode)));
				artificialNode.setChildren(availableChildren);
				flag = true;
			}
			transformToBinary(toVisitNodes.remove(0));
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
		/*
		0
			1
				2
				3
				4
				5
		 */
		Node root_1 = new Node(root, 1);
		List<Node> rootChildren = new ArrayList<Node>(
				Arrays.asList(root_1));
		root.setChildren(rootChildren);

		Node root_2 = new Node(root_1, 2);
		Node root_3 = new Node(root_1, 3);
		Node root_4 = new Node(root_1, 4);
		Node root_5 = new Node(root_1, 5);
		List<Node> rootChildren2 = new ArrayList<Node>(
				Arrays.asList(root_2,root_3,root_4,root_5));
		root_1.setChildren(rootChildren2);


		Node root_7 = new Node(root, 7);
		Node root_8 = new Node(root, 8);
		List<Node> root_2Children = new ArrayList<Node>(
				Arrays.asList( root_7, root_8));
		root_5.setChildren(root_2Children);

		Node root_9 = new Node(root_8, 7);
		Node root_10 = new Node(root_8, 8);
		Node root_11 = new Node(root_8, 9);

		List<Node> root_4Children = new ArrayList<Node>(
				Arrays.asList( root_9, root_10, root_11));
		root_8.setChildren(root_4Children);

		Node submittedRoot = Algorithm.transformToBinary(root);
		//Node submittedRoot = Algorithm.transformToBinary(root);
		printTree(submittedRoot);
	}
	
}
