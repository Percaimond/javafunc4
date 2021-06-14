package task3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AlgorithmTest {


    @Test                                               
    public void testSimpleTreeTransformation() {  
    	Node inputRoot = createInputTree();
    	Node expectedRoot = createOutputTree();
    	Node submittedRoot = Algorithm.transformToBinary(inputRoot);
    	boolean result = areIdenticalTrees(submittedRoot, expectedRoot);
    	assertEquals("Not identical:", true, result);
    }
    
    
    //areIdenticalTrees() finds whether two trees are identical or not  
    public static boolean areIdenticalTrees(Node root1, Node rootRef) {  

        //Checks if both the trees are empty  
        if(root1 == null && rootRef == null)  
            return true;  

        //Trees are not identical if root of only one tree is null thus, return false  
        if(root1 == null && rootRef == null)  
            return true;  

        //If both trees are not empty, check whether the data of the nodes is equal  
        //Repeat the steps for left subtree and right subtree  
        if(root1 != null  && rootRef != null) {  

        	assertEquals("The different id: ", rootRef.getId(), root1.getId());
        	if (root1.getChildren() != null && rootRef.getChildren() != null) {
            	assertEquals("Different number of children: ", rootRef.getChildren().size(), root1.getChildren().size());
        	}
        	
            return ((root1.getId() == rootRef.getId()) &&   
                    (areIdenticalTrees(root1.getFirst(), rootRef.getFirst()) &&  
                    (areIdenticalTrees(root1.getSecond(), rootRef.getSecond()))));  
        }  
        return false;  
    }  
    
    
    public Node createInputTree() {
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
    
    
    public Node createOutputTree() {
    	/*
    	 * Example output tree:
    	 * 	root
    	 * 		1
    	 * 		2
    	 * 			3
    	 * 			-1   <---- artificial, with a default id = -1
    	 * 				4
    	 * 				5	
    	 * 
    	 */
    	Node root = new Node(null, 0);
    	
    	Node root_1 = new Node(root, 1);
    	Node root_2 = new Node(root, 2);

    	List<Node> rootChildren = new ArrayList<Node>(
    		    Arrays.asList(root_1, root_2));
    	root.setChildren(rootChildren);
    	
    	Node root_2_3 = new Node(root_2, 3);	
    	Node root_2_n4 = new Node(root_2, -1);	
    	List<Node> root_2Children = new ArrayList<Node>(
    		    Arrays.asList(root_2_3, root_2_n4));
    	root_2.setChildren(root_2Children);

    	Node root_2_n4_4 = new Node(root_2_n4, 4);	
    	Node root_2_n4_5 = new Node(root_2_n4, 5);	
    	List<Node> root_2_n4Children = new ArrayList<Node>(
    		    Arrays.asList(root_2_n4_4, root_2_n4_5));
    	root_2_n4.setChildren(root_2_n4Children);
    	
		return root;

    }
}
