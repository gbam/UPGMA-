package cs576P2.UPGMA;
import java.util.ArrayList;
import java.util.List;

import cs576P2.GlobalAlignment.globalAlign;

public class makeTree {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String[] args2 = new String[0];
		
		globalAlign ga = new globalAlign(args2);
		List<String> alignments = ga.getAligned1();

		Double[][] distanceMatrixies = new 	Double[alignments.size()][alignments.size()];
		String lowestIndex = "";
		Double lowestNumber = Double.MAX_VALUE;
		for(int i = 0; i < alignments.size(); i++){
			for(int j = alignments.size(); j > i; j--){
				distanceMatrixies[i][j] = returnDistance(alignments.get(i), alignments.get(j));
				if(distanceMatrixies[i][j] < lowestNumber){
					lowestNumber = distanceMatrixies[i][j];
					lowestIndex = i + "," + j;
				}
			}
		}

	}

	private static Double returnDistance(String aligned1, String aligned2) throws Exception{

		if(aligned1.length() != aligned2.length()){
			throw new Exception("Aligned pairs not the same size");
		}
		int similar = 0;
		for (int i = 0; i < aligned1.length(); i++){
			if(aligned2.charAt(i)== aligned1.charAt(i)) similar++;
		}
		Double distance = (double) (similar / aligned1.length());
		return distance;
		
		
	}


}
