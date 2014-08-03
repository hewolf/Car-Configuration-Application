package model;

/*
 * Build the model and print all information out
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import exception.Exceptions;
import model.OptionSet.Option;

public class Automobile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String make;
	private String model;
	private int baseprice;
	public ArrayList<OptionSet> opset = new ArrayList<OptionSet>();

	/* Constructor */
	public Automobile() {
		super();
	}

	/* Return the make of the automobile */
	public String getMake() {
		return make;
	}

	/* Return the model of the automobile */
	public String getModel() {
		return model;
	}

	/* Set the make of the automobile with a given string */
	public void setMake(String make) {
		this.make = make;
	}

	/* Set the model of the automobile with a given string */
	public void setModel(String model) {
		this.model = model;
	}

	/* Get the name of the chosen option */
	public String getOptionChoice(String setname) {
		return findOptionSet(setname).choice.name;
	}

	/* Get the price of the chosen option */
	public float getOptionChoicePrice(String setname) {
		return findOptionSet(setname).choice.price;
	}

	/* Choose the option and return */
	public void setOptionChoice(String setname, String optionname) {
		findOptionSet(setname).choice = findOptionSet(setname).findOption(
				optionname);
	}

	/* Return the total price of the automobile */
	public int getTotalPrice() {
		int totalprice = baseprice;
		for (int i = 0; i < opset.size(); i++) {
			totalprice += getOptionChoicePrice(opset.get(i).getName());
		}
		return totalprice;
	}

	/* Return the name of the automobile */
	public String getName() {
		return name;
	}

	/* Return the value of the baseprice */
	public int getBaseprice() {
		return baseprice;
	}

	/* Return the optionset of a given index */
	public OptionSet getOpset(int index) {
		return opset.get(index);
		// perhaps called before the setup step
	}

	/* Set the name of the optionset */
	public OptionSet findOptionSet(String name) {
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).name.equals(name)) {
				return opset.get(i);
			}
		}
		return null;
	}

	/* Find an option with a given name */
	public Option findOption(String name) {
		for (int i = 0; i < opset.size(); i++) {
			opset.get(i).findOption(name);
		}
		return null;
	}

	/* Set the name of the automobile */
	public void setName(String name) {
		this.name = name;
	}

	/* Set the baseprice of the automobile */
	public void setBaseprice(int baseprice) {
		this.baseprice = baseprice;
	}

	/* Initialize an optionset array with a given size */
	public void setOptionset(int optionsetsize) {

		for (int i = 0; i < optionsetsize; i++) {
			OptionSet optionset = new OptionSet();
			opset.add(optionset);
		}
	}

	/* Initialize an option array with a given size for a given optionset */
	public void setOption(OptionSet opset, int optionsize) {
		opset.setOption(optionsize);
	}

	/* Delete an option with given indexes */
	public void deleteOption(int indexoptset, int indexopt) {
		opset.get(indexoptset).deleteOptionp(indexopt);
	}

	/* Delete an optionset with a given index */
	public void deleteOpset(int index) {
		opset.set(index, null);
	}

	/* Update the optionsets */
	public void updateOpset() {
		ArrayList<OptionSet> newopset = new ArrayList<OptionSet>();
		int index = 0;
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i) != null) {
				newopset.set(index, opset.get(i));
				index++;
			}
		}
		opset = newopset;
	}

	/* Update the options */
	public void updateOption() {
		ArrayList<OptionSet> newopset = new ArrayList<OptionSet>();
		for (int i = 0; i < opset.size(); i++) {
			opset.get(i).updateOption();
		}
		opset = newopset;
	}

	/* Print all the information of the automobile */
	public void print() {
		StringBuffer sb = new StringBuffer();
		sb.append("The name of the vehicle is: ");
		sb.append(name);
		sb.append("\nThe base price of the vehicle is: ");
		sb.append(baseprice);
		System.out.println(sb);
		for (int i = 0; i < opset.size(); i++) {
			opset.get(i).print();
		}
	}

	/* Set the names of optionsets */
	public void setOptionValue(int index, int index2, String value) {
		opset.get(index2).setOptionValue(index, value);
	}

	/* Set the prices of options */
	public void setOptionPrice(int index, int index2, int price) {
		opset.get(index2).setOptionPrice(index, price);
	}

	/* Set the names of options */
	public void setOptionsetName(int index, String string) {
		opset.get(index).name = string;
	}

	public synchronized void makeChoice() throws Exceptions {
		System.out
				.println("Choose in the following OptionSets:[Input option name]");
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < opset.size(); i++) {
			System.out.println("OptionSet:" + opset.get(i).getName());
			System.out.println("Available options are:");
			for (int j = 0; j < opset.get(i).getOpt().size(); j++) {
				System.out.println(opset.get(i).getOpt().get(j));
			}
			String chose = scanner.nextLine();
			boolean match = false;
			for (int j = 0; j < opset.get(i).getOpt().size(); j++) {
				if (opset.get(i).getOpt().get(j).getName().equals(chose)) {
				//	opset.get(i).setOptionValue(i, chose);
				//	opset.get(i).setOptionPrice(i, (int)opset.get(i).getOpt().get(j).getPrice());
					opset.get(i).setChoice(opset.get(i).findOption(chose));
					opset.get(i).getChoice().setName(chose);
					opset.get(i).getChoice()
							.setPrice(opset.get(i).getOpt().get(j).getPrice());
					match = true;
				}
			}
			if (!match) {
				throw new Exceptions(5, "The selected choice is not available!");
			}
		}
	}

	public synchronized void printChoice() {
		System.out.println("Choices are:");
		float sum=baseprice;
		for (int i = 0; i < opset.size(); i++) {
			OptionSet os = opset.get(i);
			Option choice = os.getChoice();
			sum+=choice.getPrice();
			System.out.println(choice.getName() + " : " + choice.getPrice());
		}
		System.out.println("The total price is: " + sum);
		
	}
}
