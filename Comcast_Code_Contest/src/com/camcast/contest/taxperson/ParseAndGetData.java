package com.camcast.contest.taxperson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ParseAndGetData {

	/**
	 * @author bijaya
	 * @since 01-05-2015
	 *
	 *        parseStringArray will get the data from a double dimensional array
	 *        which contains first element as Item Name, next price in cents and
	 *        category type for applying tax
	 * 
	 * @return double dimensional array with Items available in the inventory
	 */

	public String[][] parseStringArray() {

		return new String[][] { { "Shirts", "100", "N" },
				{ "SOFA", "1000", "L" }, { "BEER", "100", "L" },
				{ "MILK", "100", "N" } };

	}

	/**
	 * @author bijaya
	 * @since 01-05-2015
	 *
	 *        parseCSV will get the data from a CSV (Comma Separated File) First
	 *        value is considered as item, next value as price and last value is
	 *        Category for applying tax
	 * @return double dimensional array with Items available in the inventory
	 */

	public String[][] parseCSV() {
		String returnArray[][] = null;
		try {
			//TODO fix to get from the current location
			File f = new File("src" + File.separator + "com" + File.separator
					+ "camcast" + File.separator + "contest" + File.separator
					+ "taxperson" + File.separator + "itemsInStore.csv");
			BufferedReader br = new BufferedReader(new FileReader(f));
			returnArray = new String[4][3]; // TODO fix for dynamic size
											// calculation
			String line = br.readLine();
			for (int i = 0; line != null; i++) {
				int j = 0;
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreElements()) {
					returnArray[i][j] = st.nextElement().toString().trim();
					j++;
				}
				line = br.readLine();
			}

			br.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return returnArray;

	}

	
	//TODO In case if you want to fetch from database.
	public static String[][] parseDB() {
		return null;
	}
	
	//TODO In case if we ant to fetch from XLS file.

	public static String[][] parseXLS() {
		return null;
	}

}
