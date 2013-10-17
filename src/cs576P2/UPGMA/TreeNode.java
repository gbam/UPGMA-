package cs576P2.UPGMA;

public class TreeNode {
private String seq1;
private TreeNode childNode1;
private TreeNode childNode2;
private String name;
private int childrenCount;


public TreeNode(String seq1, TreeNode childNode1, TreeNode childNode2,
		String name, int childrenCount) {
	super();
	this.seq1 = seq1;
	this.childNode1 = childNode1;
	this.childNode2 = childNode2;
	this.name = name;
	this.childrenCount = childrenCount;
}

public String getSeq1() {
	return seq1;
}
public void setSeq1(String seq1) {
	this.seq1 = seq1;
}
public TreeNode getChildNode1() {
	return childNode1;
}
public void setChildNode1(TreeNode childNode1) {
	this.childNode1 = childNode1;
}
public TreeNode getChildNode2() {
	return childNode2;
}
public void setChildNode2(TreeNode childNode2) {
	this.childNode2 = childNode2;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getChildrenCount() {
	return childrenCount;
}
public void setChildrenCount(int childrenCount) {
	this.childrenCount = childrenCount;
}
}