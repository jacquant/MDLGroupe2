package be.unamur.mdl_groupe2.root.exception;

public class EmptyListException extends Exception {
    public EmptyListException() {
    }

    public EmptyListException(String message) {
        super(message);
    }
}
