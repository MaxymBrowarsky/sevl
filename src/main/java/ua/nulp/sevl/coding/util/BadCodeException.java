package ua.nulp.sevl.coding.util;

public class BadCodeException extends Exception {
    String errMessage;

    public String getErrMessage() {
        return errMessage;
    }

    public BadCodeException setErrMessage(String errMessage) {
        this.errMessage = errMessage;
        return this;
    }
}
