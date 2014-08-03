package bean;

/* A packaged automobile bean for jsp web page */

import java.io.PrintStream;
import java.util.*;

import model.Automobile;
import model.OptionSet;
import model.OptionSet.Option;

public class AutomobileBean
{
  private String model;
  private double basePrice;
  private Map<String, Float> color;
  private Map<String, Float> transmission;
  private Map<String, Float> abs;
  private Map<String, Float> bags;
  private Map<String, Float> moonroof;

  public Map<String, Float> getColor()
  {
    return this.color;
  }

  public void setColor(Map<String, Float> color) {
    this.color = color;
  }

  public Map<String, Float> getTransmission()
  {
    return this.transmission;
  }

  public void setTransmission(Map<String, Float> transmission)
  {
    this.transmission = transmission;
  }

  public Map<String, Float> getAbs()
  {
    return this.abs;
  }

  public void setAbs(Map<String, Float> abs)
  {
    this.abs = abs;
  }

  public Map<String, Float> getBags()
  {
    return this.bags;
  }

  public void setBags(Map<String, Float> bags)
  {
    this.bags = bags;
  }

  public Map<String, Float> getMoonroof()
  {
    return this.moonroof;
  }

  public void setMoonroof(Map<String, Float> moonroof)
  {
    this.moonroof = moonroof;
  }

  public double getBasePrice()
  {
    return this.basePrice;
  }

  public void setBasePrice(double basePrice)
  {
    this.basePrice = basePrice;
  }

  public String getModel()
  {
    return this.model;
  }

  public void setModel(String model)
  {
    this.model = model;
  }

  public String toString()
  {
    return "CarBean [color=" + this.color + ", transmission=" + this.transmission + 
      ", abs=" + this.abs + ", bags=" + this.bags + ", moonroof=" + this.moonroof + 
      "]";
  }

  public void setWithAutomobile(Automobile auto) {
	     model = auto.getModel();
		basePrice = auto.getBaseprice();
		color = new LinkedHashMap<String, Float>();
		OptionSet colorOptionSet = auto.findOptionSet("Color");
		ArrayList<Option> colorOptions = colorOptionSet.getOpt();
		for(Option opt : colorOptions) {
			color.put(opt.getName(), opt.getPrice());
		}
		
		transmission = new LinkedHashMap<String, Float>();
		OptionSet transmissionOptionSet = auto.findOptionSet("Transmission");
		ArrayList<Option> transmissionOptions = transmissionOptionSet.getOpt();
		for(Option opt : transmissionOptions) {
			transmission.put(opt.getName(), opt.getPrice());
		}
		
		abs = new LinkedHashMap<String, Float>();
		OptionSet absOptionSet = auto.findOptionSet("Brakes/Traction Control");
		ArrayList<Option> absOptions = absOptionSet.getOpt();
		for(Option opt : absOptions) {
			abs.put(opt.getName(), opt.getPrice());
		}
		
		bags = new LinkedHashMap<String, Float>();
		OptionSet bagOptionSet = auto.findOptionSet("Side Impact Air Bags");
		ArrayList<Option> bagOptions = bagOptionSet.getOpt();
		for(Option opt : bagOptions) {
			bags.put(opt.getName(), opt.getPrice());
		}
		
		moonroof = new LinkedHashMap<String, Float>();
		OptionSet moonroofOptionSet = auto.findOptionSet("Power Moonroof");
		ArrayList<Option> moonroofOptions = moonroofOptionSet.getOpt();
		for(Option opt : moonroofOptions) {
			moonroof.put(opt.getName(), opt.getPrice());
		}
  }

  public String getSerializedModel()
  {
    String ret = "model~" + this.model;
    ret = ret + ";";
    return ret;
  }

  public String getSerializedPrice() {
    String ret = "basicPrice~" + this.basePrice;
    ret = ret + ";";
    return ret;
  }

  public String getSerializedColor() {
    String ret = "color~";
    Iterator itr = this.color.entrySet().iterator();
    while (itr.hasNext()) {
      ret = ret + itr.next() + "%";
    }
    ret = ret + ";";
    return ret;
  }

  public String getSerializedTransmission() {
    String ret = "transmission~";
    Iterator itr = this.transmission.entrySet().iterator();
    while (itr.hasNext()) {
      ret = ret + itr.next() + "%";
    }
    ret = ret + ";";
    return ret;
  }

  public String getSerializedABS() {
    String ret = "abs~";
    Iterator itr = this.abs.entrySet().iterator();
    while (itr.hasNext()) {
      ret = ret + itr.next() + "%";
    }
    ret = ret + ";";
    System.out.println("getSerializedABS:" + ret);
    return ret;
  }

  public String getSerializedBags() {
    String ret = "bags~";
    Iterator itr = this.bags.entrySet().iterator();
    while (itr.hasNext()) {
      ret = ret + itr.next() + "%";
    }
    ret = ret + ";";
    return ret;
  }

  public String getSerializedMoonroof() {
    String ret = "moonroof~";
    Iterator itr = this.moonroof.entrySet().iterator();
    while (itr.hasNext()) {
      ret = ret + itr.next() + "%";
    }
    ret = ret + ";";
    return ret;
  }
}