package exceptions;

public class IncorrectNumberOfWords extends RuntimeException {
    private static String message = "A number of words is incorrect in the input string.";

    public IncorrectNumberOfWords(String wrongString) {
        super(wrongString + " --- " + message);
    }
}
