package me.xtrm.avaj.exception;

import java.io.IOException;

/**
 * {@link Exception} for an invalid provided input file.
 *
 * @author kiroussa
 */
public class InvalidInputFileException extends IOException {
    public InvalidInputFileException() { super(); }
    public InvalidInputFileException(String msg) { super(msg); }
    public InvalidInputFileException(Throwable t) { super(t); }
    public InvalidInputFileException(String msg, Throwable t) { super(msg, t); }

    public static InvalidInputFileException fileError(String msg, String absolutePath) {
        return new InvalidInputFileException(String.format(msg, absolutePath));
    }

    public static InvalidInputFileException fileError(String msg, String absolutePath, Throwable t) {
        return new InvalidInputFileException(String.format(msg, absolutePath), t);
    }
}
