package task3;

import java.util.List;

public class Node {

	private List<Node> children;
	private Node parent;
	private Integer id;

	public Node(Node parent, Integer id) {
		super();
		this.parent = parent;
		this.id = id;
		this.children = null;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Node getFirst() {
		if (this.children != null) {
			return this.children.get(0);
		}
		return null;
	}

	public Node getSecond() {
		if (this.children != null) {
			return this.children.get(1);
		}
		return null;
	}

	public void printChildren() {
		if (this.children != null) {
			System.out.println("Children of " + this.id + ":");
			for (Node child : this.children) {
				System.out.println(child.getId());
			}
		}
	}

	public boolean hasChildren() {
		return this.children != null;
	}
	

}
