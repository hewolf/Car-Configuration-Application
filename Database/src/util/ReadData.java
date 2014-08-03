package util;

/*
 * Read data from a text file and populate the model
 */

import java.io.*;
import java.util.*;

import model.Automobile;

public class ReadData {
	public Automobile readFile(String filename) {
		Automobile automobile = new Automobile();
		try {
			/* Read the file with the given name */
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);

			/* First line is the number of optionsets */
			String firstline = buff.readLine();
			if(firstline==null) {
				System.out.println("Invalid input!");
				return null;
			}
			int optionsetsize = Integer.parseInt(firstline);
			automobile.setOptionset(optionsetsize);

			/* Second line has the sizes of all optionsets */
			String secondline = buff.readLine();
			if(secondline==null) {
				System.out.println("Invalid input!");
				return null;
			}
			StringTokenizer st = new StringTokenizer(secondline);
			int index = 0;
			int[] size = new int[optionsetsize];
			int totalsize = 0;
			try {
				while (st.hasMoreTokens()) {
					size[index] = Integer.parseInt(st.nextToken());
					totalsize += size[index];
					automobile.setOption(automobile.opset.get(index),
							size[index]);
					index++;
					if (index == optionsetsize) {
						break;
					}
				}
			} catch (Exception a) {
				System.out.println("Missing optionsets sizes" + a);
			}

			/* Third line has the baseprice of the automobile */
			try {
				String thirdline = buff.readLine();
				if(thirdline==null) {
					System.out.println("Invalid input!");
					return null;
				}
				automobile.setBaseprice(Integer.parseInt(thirdline));
			} catch (Exception b) {
				System.out.println("Missing baseprice data" + b);
			}

			/* Fourth line has the name of the automobile */
			try {
				String fourthline = buff.readLine();
				automobile.setModel(fourthline);
			} catch (Exception c) {
				System.out.println("Missing name data" + c);
			}

			int indexOption = 0;
			int indexMoveOn = 0;
			int indexTotal = 0;
			int indexPrices = 0;
			int[] prices = new int[totalsize];

			/* Fifth line has the name of the optionsets */
			try {
				String fifthline = buff.readLine();
				if(fifthline==null) {
					System.out.println("Invalid input!");
					return null;
				}
				StringTokenizer st2 = new StringTokenizer(fifthline);

				while (st2.hasMoreTokens()) {
					prices[indexPrices] = Integer.parseInt(st2.nextToken());
					indexPrices++;
				}

				for (int i = 0; i < totalsize; i++) {
					automobile.setOptionPrice(indexMoveOn, indexOption,
							prices[i]);
					indexTotal++;
					indexMoveOn++;
					if (indexMoveOn == size[indexOption]) {
						indexOption++;
						indexMoveOn = 0;
					}
					if (indexTotal == totalsize) {
						break;
					}
					if (indexOption == optionsetsize) {
						break;
					}
				}

				String[] lines = new String[optionsetsize];
				int indexOptionSetName = 0;
				for (int i = 0; i < optionsetsize; i++) {
					lines[i] = buff.readLine();
					automobile.setOptionsetName(indexOptionSetName, lines[i]);
					indexOptionSetName++;
				}
			} catch (Exception d) {
				System.out.println("Missing option set name data" + d);
			}

			/* The rest are the names of the options */
			boolean eof = false;
			int indexOfValue = 0;
			String[] values = new String[totalsize];

			while (!eof) {
				String line = buff.readLine();
				if (line == null)
					eof = true;
				else
					values[indexOfValue] = line;
				indexOfValue++;
			}
			int index2 = 0;
			int index3 = 0;
			for (int i = 0; i < totalsize; i++) {
				automobile.setOptionValue(index3, index2, values[i]);
				index3++;
				if (index3 == size[index2]) {
					index3 = 0;
					index2++;
				}
			}

			buff.close();
		} catch (IOException e) {
			System.out.println("Error-- " + e.toString());
		}
		return automobile;
	}
}
