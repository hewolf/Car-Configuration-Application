package scale;

/* Editthread interface which can edit the choice of option as well as the price
 *  and name of options*/

public interface EditThread {
	public void editOptionPrice(int index, int index2, int price);

	public void editOptionName(int index, int index2, String value);

	public void editOptionChoice(String setname, String optionname);
}
