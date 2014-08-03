package scale;

/* Edit the options and define the behaviors of different threads */

import model.Automobile;

public class EditOptions extends Thread implements EditThread{
	private Automobile automobile;
	private int operation;
	
	/* Constructor */
	public EditOptions( int operation, Automobile automobile ) {
		this.operation= operation;
		this.automobile = automobile;
	}
	
	/* Set the option price and update it  */
	public void editOptionPrice(int index, int index2, int price) {
		automobile.setOptionPrice(index, index2, price);
		automobile.updateOption();
	}
	
	/* Set the option name and update it */
	public void editOptionName(int index, int index2, String value) {
		automobile.setOptionValue(index, index2, value);
		automobile.updateOption();
	}
	
	/* Set the option price and update it */
	public void editOptionChoice(String setname, String optionname){
		automobile.setOptionChoice(setname, optionname);
	}
	
	/* Return the name of the option chosen */
	public synchronized String getOptionChoiceName(String setname) {
		return automobile.getOptionChoice(setname);
	}
	
	/* Return the price of the option chosen */
	public synchronized float getOptionChoicePrice(String setname) {
		return automobile.getOptionChoicePrice(setname);
	}
	
	/* Randomly wait for a while */
	void randomWait() {
        try {
            Thread.currentThread().sleep((long)(3000*Math.random()));
        } catch(InterruptedException e) {
            System.out.println("Interrupted!");
        }
    }    
	
	/* Run the threads */
    public void run() {
        synchronized(System.out) {
            if(operation==0) {
            	thread1();
            }
            else if(operation==1) {
            	thread2();
            }
            else {
            	System.out.println("---------------------");
            }
        }
    }

    /* The behavior of the second thread */
	private void thread2() {
		System.out.println("Thread 2 is running...");
		
		randomWait();
	    
		editOptionChoice("Transmission", "manual");
		
		System.out.println("Thread 2 finishes waiting");
	}

	/* The behavior of the first thread */
	private void thread1() {
		System.out.println("Thread 1 is running...");
		
		randomWait();
	//	editOptionChoice("Transmission", "manual");
		System.out.println("Thread 1 finishes waiting");
		System.out.println("ooooooooooooooooooooooooooo" + getOptionChoiceName("Transmission"));
	}   
}
