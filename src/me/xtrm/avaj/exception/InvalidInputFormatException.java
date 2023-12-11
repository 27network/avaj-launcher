package me.xtrm.avaj.exception;

/**
 * {@link InvalidInputFileException} extension that occurs when the input file data is wrongly formatted.
 *
 * @author kiroussa
 */
public class InvalidInputFormatException extends InvalidInputFileException {
    public InvalidInputFormatException() { super(); }
    public InvalidInputFormatException(String msg) { super(msg); }
    public InvalidInputFormatException(Throwable t) { super(t); }
    public InvalidInputFormatException(String msg, Throwable t) { super(msg, t); }

    public static InvalidInputFormatException formatError(String msg) {
        return new InvalidInputFormatException(msg);
    }

    public static InvalidInputFormatException formatError(String msg, Throwable t) {
        return new InvalidInputFormatException(msg, t);
    }

    public static InvalidInputFormatException formatError(String msg, String absolutePath) {
        return new InvalidInputFormatException(String.format(msg, absolutePath));
    }

    public static InvalidInputFormatException formatError(String msg, String absolutePath, Throwable t) {
        return new InvalidInputFormatException(String.format(msg, absolutePath), t);
    }
}
