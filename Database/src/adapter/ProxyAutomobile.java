package adapter;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import util.FileIO;
import util.ReadData;
import model.Automobile;

/* The ProxyAutomobile abstract class implements all the methods in the CreateAuto interface and the UpdateAuto interface */

public abstract class ProxyAutomobile {

	private Automobile a1;
	private static LinkedHashMap<String, Automobile> mobileHash = new LinkedHashMap<String, Automobile>();
	private ArrayList<String> modelLists;
	
	public static LinkedHashMap<String, Automobile> getMobileHash() {
		return mobileHash;
	}
	
	public void updateOptionSetName(String Modelname, String OptionSetname,
			String optionname, String newName) {
		a1 = mobileHash.get(Modelname);
		a1.findOptionSet(OptionSetname).findOption(optionname).setName(newName);
	}

	public void updateOptionPrice(String modelname, String optionsetname,
			String optionname, float newprice) {
		a1 = mobileHash.get(modelname);
		a1.findOptionSet(optionsetname).findOption(optionname)
				.setPrice(newprice);
	}

	public void BuildAuto(String filename) {
		System.out.println("can't believe it!");
		if (filename.endsWith(".txt")) {
			ReadData readData = new ReadData();
			a1 = readData.readFile(filename);
			mobileHash.put(a1.getModel(), a1);
		}
		if (filename.endsWith(".Properties")) {
			System.out.println("this problem?");
			try {
				System.out.println("wuuuuuuuuuuw!!!");
				a1 = FileIO.UseProperties(filename);
				System.out.println("wow!!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("it's indeed building");
			mobileHash.put(a1.getModel(), a1);
		}
	}

	public void PrintAuto(String Modelname) {
		a1 = mobileHash.get(Modelname);
		a1.print();
	}

	public Automobile returnAutomobile(String name) {
		return mobileHash.get(name);
	}
	
	public void buildwithProperties(String filename){
		try {
			a1 = FileIO.UseProperties(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mobileHash.put(a1.getModel(), a1);
	}
	
	public void sendSelectedAuto(ObjectOutputStream oos, String modelname) {
		Automobile configAuto = mobileHash.get(modelname);
	//	System.out.println("test"+ configAuto.getOpset(1).get());
		if(configAuto == null) {
			System.err.println("No such model in server");
		}
		try {
			oos.writeObject(configAuto);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getModelList() {
		modelLists = new ArrayList<String>();
		modelLists.add("");
		Iterator<Entry<String, Automobile>> itr = mobileHash.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Automobile> entry = (Entry<String, Automobile>) itr
					.next();
			System.out.println("Entry key: " + entry.getKey());
			modelLists.add(entry.getKey());
		}
		return modelLists;
	}
}
