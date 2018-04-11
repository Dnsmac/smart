package org.qidian.exception;

public class TipException extends RuntimeException {

    /** @Fields serialVersionUID : */
    private static final long serialVersionUID = 2989180931682540369L;

    public TipException() {
    }

    public TipException(String message) {
        super(message);
    }

    public TipException(String message, Throwable cause) {
        super(message, cause);
    }

    public TipException(Throwable cause) {
        super(cause);
    }

}
