package exceptions;

public class NullDataInClassException extends RuntimeException {
    private static String message = "Not all fields are filled out.";

    public NullDataInClassException(String wrongString) {
        super(wrongString + " --- " + message);
    }
}
