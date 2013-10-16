package cs576P2.UPGMA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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
		List<sequenceString> sequences = new ArrayList<sequenceString>();

		try{
			File s1file = new File(seq1FileName + ending);
			BufferedReader  reader = new BufferedReader(new FileReader(s1file));
			String s1 = reader.readLine();
			sequenceString ss;
			if(Pattern.matches("[>].+", s1)){
				s1 = s1.substring(1);
				ss = new sequenceString(s1, reader.readLine());
				sequences.add(ss);
			}
			else throw new Exception("Bad File Format");
		}catch(Exception e){
			System.out.println("Failed to open file");
		}
		



	}

	
	
	
	
	
	
	public static class sequenceString{
		public String seqName;
		public String seqString;
		public sequenceString(String seqName, String seqString){
			this.seqName = seqName;
			this.seqString = seqString;
		}
	}
}
