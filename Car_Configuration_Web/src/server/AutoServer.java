package server;

/* Interface implemented in BuildCarModelOptions class */

import java.io.ObjectOutputStream;
import java.util.ArrayList;

public interface AutoServer {
	public void buildwithProperty(String filename);
	public ArrayList<String> getModelList();
	public void sendSelectedAuto(ObjectOutputStream oos, String modelname);
}
