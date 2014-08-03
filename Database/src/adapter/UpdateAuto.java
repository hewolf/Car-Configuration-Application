package adapter;

/* The UpdateAuto interface has two methods that can update the properties of optionsets and options */

public interface UpdateAuto {
	public void updateOptionSetName(String Modelname, String OptionSetname, String optionname, String newName);
	public void updateOptionPrice(String modelname, String Optionname, String Option, float newprice);
}
