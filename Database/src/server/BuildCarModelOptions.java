package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.ArrayList;

import adapter.BuildAuto;
import model.Automobile;

public class BuildCarModelOptions implements AutoServer{

	static BuildAuto auto = null;
	public void buildwithProperty(String filename) {
		if(auto == null) {
    		auto = new BuildAuto();
    	}
		auto.buildwithProperties(filename);
	}

	public ArrayList<String> getModelList() { 
		ArrayList<String> ret = new ArrayList<String>();
		ret.add("");
		if(auto!=null) {
		ret.addAll(auto.getModelList());}
//		ret.add("www3");
		return ret;
	}

	public void sendSelectedAuto(ObjectOutputStream oos, String modelname) {
		auto.sendSelectedAuto(oos, modelname);
	}
}