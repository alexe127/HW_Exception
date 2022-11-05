package exceptions;

public class DateFormatException extends RuntimeException {
    private static String message = "Unrecognized date format exception.";

    public DateFormatException(String wrongString) {
        super(wrongString + " --- " + message);
    }
}
