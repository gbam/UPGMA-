package cs576P2.UPGMA;


import java.io.BufferedReader;
import cs576P2.GlobalAlignment.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class makeTree {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		if(args.length != 2){
			System.out.println("Not Correct # of Arguements");
			System.exit(0);
		}
		String seq1FileName = args[0];
		String ending = args[1];
		List<SequenceString> sequences = new ArrayList<SequenceString>();
		//Obviously reads the file
		try{
			File s1file = new File(seq1FileName + "." + ending);
			BufferedReader  reader = new BufferedReader(new FileReader(s1file));
			while(reader.ready()){
				String s1 = reader.readLine();
				SequenceString ss;
				//Parses input off of regex to grab name and make sure format is correct
				if(Pattern.matches("[>].+", s1)){
					String seq = reader.readLine();
					s1 = s1.substring(1);
					ss = new SequenceString(s1, seq);
					sequences.add(ss);
				}
				else throw new Exception("Bad File Format");
			}
		}catch(Exception e){
			System.out.println("Failed to open file");
		}
		//Input is parsed at this point
		Distance[][] dt = calclateDistanceMatrix(sequences);

		//Now we have a distance matrix and need to find the lowest

		findLowest(dt);


	}

	private static void findLowest(Distance[][] dt){
		Distance lowest = null;
		int col = -1;
		int row = -1;
		TreeNode lowestNodeA = null;
		TreeNode lowestNodeB = null;
		for(int i = 0; i < dt.length; i++){
			for(int j = dt.length; j  > i; j--){
				if(lowest == null || lowest.getDistance() > dt[i][j].getDistance()){
					lowest = dt[i][j];
					col = i;
					row = j;
					lowestNodeA = lowest.getNodeOne(); 
					lowestNodeB = lowest.getNodeTwo();
				}

			}

		}

		mergeCells(lowestNodeA, lowestNodeB);
		dt = newDistances(dt, row, col);
	}

	//Calculates the new distance matrix given a row, col, and the old matrix
	private static Distance[][] newDistances(Distance[][] dt, int row, int col){
		Distance[][] newDT = new Distance[dt.length-1][dt.length-1];
		List<Distance> partOne = new ArrayList<Distance>();

		for(int i = 0; i < dt.length; i++){
			Double cost = 0.0;
			TreeNode n1 = null;
			TreeNode n2 = null;
			for(int j = dt[0].length; j  > i; j--){
				if((col != i && row != j) || (col != j && row != i)){
					partOne.add(dt[i][j]);
				}
				else{
					cost += dt[i][j].getDistance();
				}

			}
			Distance d = new Distance(cost,n1,n2);
			newDT[i][newDT.length-1] = d;
		}
		Iterator<Distance> itr = partOne.iterator();

		for(int i = 1; i < newDT.length-1; i++){
			for(int j = i + 1; j < newDT.length - 1; j++){
				newDT[i][j] = itr.next();
			}
		}


		return newDT;
	}
	//Merges two tree nodes
	private static TreeNode mergeCells(TreeNode a, TreeNode b){
		TreeNode rt = new TreeNode("", a, b, a.getName() + "," + b.getName(), a.getChildrenCount() + b.getChildrenCount() + 2);
		System.out.println(rt.getName() + " - " + a.getName());
		System.out.println(rt.getName() + " - " + b.getName());
		return rt;
	}




	private static Distance[][] calclateDistanceMatrix(List<SequenceString> sequences) throws Exception{
		Distance[][] dt = new Distance[sequences.size()][sequences.size()];
		for(int i = 0; i < sequences.size(); i++){
			//Only looking at half the array
			for(int j = sequences.size()-1; j  > i; j--){
				SequenceString row = sequences.get(i);
				SequenceString column = sequences.get(j);

				globalAlign ga = new cs576P2.GlobalAlignment.globalAlign();
				ga.ga(row.seqString, column.seqString);
				String s1 = ga.StringOne();
				String s2 = ga.StringTwo();
				TreeNode nRow = new TreeNode(s1, null,null, row.seqName, 0);
				TreeNode nCol = new TreeNode(s2, null,null, row.seqName, 0);
				Distance d = new Distance(similarity(s1, s2), nRow, nCol);
				dt[j][i] = d;
			}
		}
		return dt;


	}

	//Determines the similarity of two strings based. 
	//Iterates through char by char!
	public static Double similarity(String s1, String s2){
		Double sim = 0.0;
		int matches = 0;
		int total = 0;
		int index = 0;
		for (char ch: s1.toCharArray()) {
			if(ch == s2.charAt(index)){
				matches++;
			}
			total++;
			index++;
		}
		sim = (double) (matches) / (double) total;
		return sim;

	}
}
