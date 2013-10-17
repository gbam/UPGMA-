package cs576P2.UPGMA;

public class Distance {
	private Double distance;
	private TreeNode nodeOne;
	private TreeNode nodeTwo;
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Distance(Double distance, TreeNode nodeOne, TreeNode nodeTwo) {
		super();
		this.distance = distance;
		this.nodeOne = nodeOne;
		this.nodeTwo = nodeTwo;
	}
	public TreeNode getNodeOne() {
		return nodeOne;
	}
	public TreeNode getNodeTwo() {
		return nodeTwo;
	}
	public void setNodeTwo(TreeNode node) {
		this.nodeTwo = node;
	}
	public void setNodeOne(TreeNode node) {
		this.nodeOne = node;
	}
}
