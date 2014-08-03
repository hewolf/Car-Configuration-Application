package exception;

public class Exceptions extends Exception{
	private int errorNumber;
    private String errorMessage;

    public Exceptions(int errorNumber, String errorMessage) {
        super(errorMessage);
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
    }

    
    public int getErrorNumber(){
        return errorNumber;
    }

	@Override
	public String toString() {
		return "GroupExceptions [errorNumber=" + errorNumber
				+ ", errorMessage=" + errorMessage + "]";
	}
}
