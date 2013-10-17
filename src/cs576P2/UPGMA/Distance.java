package cs576P2.UPGMA;

import java.util.LinkedList;

public class Distance {
	private Double distance;
	private LinkedList<TreeNode> nodeOne;
	private LinkedList<TreeNode> nodeTwo;

	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Distance(Double distance, TreeNode nodeOne, TreeNode nodeTwo) {
		super();
		this.distance = distance;
		this.nodeOne = new LinkedList<TreeNode>();
		this.nodeOne.add(nodeOne);
		this.nodeTwo = new LinkedList<TreeNode>();
		this.nodeTwo.add(nodeTwo);
	}
	@SuppressWarnings("unchecked")
	public Distance(Double distance, LinkedList<TreeNode> nodeOne, LinkedList<TreeNode> nodeTwo) {
		super();
		this.distance = distance;
		this.nodeOne = (LinkedList<TreeNode>) nodeOne.clone();
		this.nodeTwo = (LinkedList<TreeNode>) nodeTwo.clone();
	}
	public LinkedList<TreeNode> getNodeOne() {
		return nodeOne;
	}
	public LinkedList<TreeNode> getNodeTwo() {
		return nodeTwo;
	}
	public void addNodeTwo(TreeNode node) {
		this.nodeTwo.add(node);
	}
	public void setNodeOne(TreeNode node) {
		this.nodeOne.add(node);
	}
}
