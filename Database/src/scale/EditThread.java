package scale;

public interface EditThread {
	public void editOptionPrice(int index, int index2, int price);
	public void editOptionName(int index, int index2, String value);
	public void editOptionChoice(String setname, String optionname);
}
