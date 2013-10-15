package cs576P2.UPGMA;

public class TreeNode {
private String seq1;
private TreeNode childNode1;
private TreeNode childNode2;
private TreeNode parentNode;
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
public TreeNode getParentNode() {
	return parentNode;
}
public void setParentNode(TreeNode parentNode) {
	this.parentNode = parentNode;
}
public TreeNode(String seq1) {
	super();
	this.seq1 = seq1;
}




}
