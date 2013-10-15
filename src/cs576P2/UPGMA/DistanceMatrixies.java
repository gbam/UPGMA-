package cs576P2.UPGMA;

public class DistanceMatrixies {
	private String alignment1;
	private String alignment2;
	private Double similarity;
	private int distance;
	private Double[][] distanceMatrix;
	
	public DistanceMatrixies(String alignment1, String alignment2,
			Double similarity, int distance, Double[][] distanceMatrix) {
		super();
		this.alignment1 = alignment1;
		this.alignment2 = alignment2;
		this.similarity = similarity;
		this.distance = distance;
		this.distanceMatrix = distanceMatrix;
	}
	public String getAlignment1() {
		return alignment1;
	}
	public void setAlignment1(String alignment1) {
		this.alignment1 = alignment1;
	}
	public String getAlignment2() {
		return alignment2;
	}
	public void setAlignment2(String alignment2) {
		this.alignment2 = alignment2;
	}
	public Double getSimilarity() {
		return similarity;
	}
	public void setSimilarity(Double similarity) {
		this.similarity = similarity;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Double[][] getDistanceMatrix() {
		return distanceMatrix;
	}
	public void setDistanceMatrix(Double[][] distanceMatrix) {
		this.distanceMatrix = distanceMatrix;
	}
	
	

}
