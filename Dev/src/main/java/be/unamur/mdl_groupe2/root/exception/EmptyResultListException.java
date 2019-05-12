package be.unamur.mdl_groupe2.root.exception;

public class EmptyResultListException extends Exception {
    public EmptyResultListException() {
    }

    public EmptyResultListException(String message) {
        super(message);
    }
}
