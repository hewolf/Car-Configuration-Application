package util;

/*
 * Do the serialization 
 */

import java.io.*;
import java.util.*;

import adapter.BuildAuto;
import model.Automobile;

public class FileIO {

	static public Automobile UseProperties(String filename) throws IOException {
		Automobile automobile = new Automobile();
		automobile.setOptionset(5);
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(filename);
		props.load(in);
		String CarMake = props.getProperty("CarMake");
   
		if (CarMake!=null) {
			String CarBasePrice = props.getProperty("CarBasePrice");
			String CarModel = props.getProperty("CarModel");
			String Option1 = props.getProperty("Option1");
			String OptionValue1a = props.getProperty("OptionValue1a");
			String OptionValue1b = props.getProperty("OptionValue1b");
			String OptionValue1c = props.getProperty("OptionValue1c");
			String OptionValue1d = props.getProperty("OptionValue1d");
			String OptionValue1e = props.getProperty("OptionValue1e");
			String OptionValue1f = props.getProperty("OptionValue1f");
			String OptionValue1g = props.getProperty("OptionValue1g");
			String OptionValue1h = props.getProperty("OptionValue1h");
			String OptionValue1i = props.getProperty("OptionValue1i");
			String OptionValue1j = props.getProperty("OptionValue1j");
			String Option2 = props.getProperty("Option2");
			String OptionValue2a = props.getProperty("OptionValue2a");
			String OptionValue2b = props.getProperty("OptionValue2b");
			String Option3 = props.getProperty("Option3");
			String OptionValue3a = props.getProperty("OptionValue3a");
			String OptionValue3b = props.getProperty("OptionValue3b");
			String OptionValue3c = props.getProperty("OptionValue3c");
			String Option4 = props.getProperty("Option4");
			String OptionValue4a = props.getProperty("OptionValue4a");
			String OptionValue4b = props.getProperty("OptionValue4b");
			String Option5 = props.getProperty("Option5");
			String OptionValue5a = props.getProperty("OptionValue5a");
			String OptionValue5b = props.getProperty("OptionValue5b");
			
			String OptionPrice1a = props.getProperty("OptionPrice1a");
			String OptionPrice1b = props.getProperty("OptionPrice1b");
			String OptionPrice1c = props.getProperty("OptionPrice1c");
			String OptionPrice1d = props.getProperty("OptionPrice1d");
			String OptionPrice1e = props.getProperty("OptionPrice1e");
			String OptionPrice1f = props.getProperty("OptionPrice1f");
			String OptionPrice1g = props.getProperty("OptionPrice1g");
			String OptionPrice1h = props.getProperty("OptionPrice1h");
			String OptionPrice1i = props.getProperty("OptionPrice1i");
			String OptionPrice1j = props.getProperty("OptionPrice1j");
			String OptionPrice2a = props.getProperty("OptionPrice2a");
			String OptionPrice2b = props.getProperty("OptionPrice2b");
			String OptionPrice3a = props.getProperty("OptionPrice3a");
			String OptionPrice3b = props.getProperty("OptionPrice3b");
			String OptionPrice3c = props.getProperty("OptionPrice3c");
			String OptionPrice4a = props.getProperty("OptionPrice4a");
			String OptionPrice4b = props.getProperty("OptionPrice4b");
			String OptionPrice5a = props.getProperty("OptionPrice5a");
			String OptionPrice5b = props.getProperty("OptionPrice5b");
		
			automobile.setMake(CarMake);
			automobile.setBaseprice(Integer.parseInt(CarBasePrice));
			automobile.setModel(CarModel);
			automobile.setOptionsetName(0, Option1);
			automobile.setOptionsetName(1, Option2);
			automobile.setOptionsetName(2, Option3);
			automobile.setOptionsetName(3, Option4);
			automobile.setOptionsetName(4, Option5);
			
			automobile.setOption(automobile.opset.get(0), 10);
			automobile.setOptionPrice(0, 0, Integer.parseInt(OptionPrice1a));
			automobile.setOptionPrice(1, 0, Integer.parseInt(OptionPrice1b));
			automobile.setOptionPrice(2, 0, Integer.parseInt(OptionPrice1c));
			automobile.setOptionPrice(3, 0, Integer.parseInt(OptionPrice1d));
			automobile.setOptionPrice(4, 0, Integer.parseInt(OptionPrice1e));
			automobile.setOptionPrice(5, 0, Integer.parseInt(OptionPrice1f));
			automobile.setOptionPrice(6, 0, Integer.parseInt(OptionPrice1g));
			automobile.setOptionPrice(7, 0, Integer.parseInt(OptionPrice1h));
			automobile.setOptionPrice(8, 0, Integer.parseInt(OptionPrice1i));
			automobile.setOptionPrice(9, 0, Integer.parseInt(OptionPrice1j));
			
			automobile.setOptionValue(0, 0, OptionValue1a);
			automobile.setOptionValue(1, 0, OptionValue1b);
			automobile.setOptionValue(2, 0, OptionValue1c);
			automobile.setOptionValue(3, 0, OptionValue1d);
			automobile.setOptionValue(4, 0, OptionValue1e);
			automobile.setOptionValue(5, 0, OptionValue1f);
			automobile.setOptionValue(6, 0, OptionValue1g);
			automobile.setOptionValue(7, 0, OptionValue1h);
			automobile.setOptionValue(8, 0, OptionValue1i);
			automobile.setOptionValue(9, 0, OptionValue1j);
			
			automobile.setOption(automobile.opset.get(1),2);
			automobile.setOptionPrice(0, 1, Integer.parseInt(OptionPrice2a));
			automobile.setOptionPrice(1, 1, Integer.parseInt(OptionPrice2b));
			automobile.setOptionValue(0, 1, OptionValue2a);
			automobile.setOptionValue(1, 1, OptionValue2b);
			
			automobile.setOption(automobile.opset.get(2),3);
			automobile.setOptionPrice(0, 2, Integer.parseInt(OptionPrice3a));
			automobile.setOptionPrice(1, 2, Integer.parseInt(OptionPrice3b));
			automobile.setOptionPrice(2, 2, Integer.parseInt(OptionPrice3c));
			automobile.setOptionValue(0, 2, OptionValue3a);
			automobile.setOptionValue(1, 2, OptionValue3b);
			automobile.setOptionValue(2, 2, OptionValue3c);
			
			automobile.setOption(automobile.opset.get(3),2);
			automobile.setOptionPrice(0, 3, Integer.parseInt(OptionPrice4a));
			automobile.setOptionPrice(1, 3, Integer.parseInt(OptionPrice4b));
			automobile.setOptionValue(0, 3, OptionValue4a);
			automobile.setOptionValue(1, 3, OptionValue4b);
			
			automobile.setOption(automobile.opset.get(4),2);
			automobile.setOptionPrice(0, 4, Integer.parseInt(OptionPrice5a));
			automobile.setOptionPrice(1, 4, Integer.parseInt(OptionPrice5b));
			automobile.setOptionValue(0, 4, OptionValue5a);
			automobile.setOptionValue(1, 4, OptionValue5b);
		}
		return automobile;
	}

	static public void SerializeAuto(BuildAuto buildauto) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("auto.ser"));
			out.writeObject(buildauto);
			out.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			System.exit(1);
		}
	}

	static public Automobile DeserializeAuto(String name) {
		try {
			Automobile automobile;
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					name));
			automobile = (Automobile) in.readObject();
			in.close();
			return automobile;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
