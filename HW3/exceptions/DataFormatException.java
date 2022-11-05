package exceptions;

public class DataFormatException extends RuntimeException {
    private static String message = "Unrecognized data format exception.";

    public DataFormatException(String wrongString) {
        super(wrongString + " --- " + message);
    }
}
