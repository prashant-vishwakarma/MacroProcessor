/*Author: Prashant Vishwakarma
 * */

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		FileReader input1 = new FileReader("input1.txt");
		BufferedReader br = new BufferedReader(input1);
		String[][] mdt, mnt;
		int mdtp = 0, mntp = 0;
		mdt = new String[100][10];
		String prev = "RANDOM";
		/*
		 * Macro Definition Table
		 * | MacroName | ArgLen | Arg1 | ArgValConst | Arg2 | ArgValConst |
		 */
		mnt = new String[100][2];
		/*
		 * Macro Name Table | MacroName | Location@MDT |
		 */
		System.out.println("Macro Pass 1\n");
		String line;
		boolean read = false; // to read line into MDT or not
		while ((line = br.readLine()) != null) {
			String[] temp = line.split("[ ,]");
			int tempLen = temp.length;
			System.out.println(temp[0] + " length --> " + tempLen + "\n");
			if (read == true) {
				// Logic to Write to MDT
				System.out.println("Writing to MDT Line#" + mdtp);
				for (int i = 0; i < tempLen; i++) {
					mdt[mdtp][i] = temp[i];
					System.out.print(mdt[mdtp][i] + " ");
				}
				System.out.println("\n");
				// Logic to Write to MNT
				if (prev.equals("MACRO")) {
					System.out.println("MNT Update Line#" + mntp + "\n");
					mnt[mntp][0] = temp[0]; // Added MacroName
					mnt[mntp][1] = Integer.toString(mdtp); // Added Location@MDT
					mntp++;
				}
				mdtp++;
			}
			if (temp[0].equals("MACRO")) {
				read = true;
			}
			if (temp[0].equals("MEND")) {
				read = false;
			}
			prev = temp[0];
		}
		br.close();
	}
}
