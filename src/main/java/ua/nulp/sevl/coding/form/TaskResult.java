package ua.nulp.sevl.coding.form;

public class TaskResult {
    boolean success;
    String expected;
    String current;

    public TaskResult(boolean success, String expected, String current) {
        this.success = success;
        this.expected = expected;
        this.current = current;
    }

    public boolean isSuccess() {
        return success;
    }

    public TaskResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getExpected() {
        return expected;
    }

    public TaskResult setExpected(String expected) {
        this.expected = expected;
        return this;
    }

    public String getCurrent() {
        return current;
    }

    public TaskResult setCurrent(String current) {
        this.current = current;
        return this;
    }
}
