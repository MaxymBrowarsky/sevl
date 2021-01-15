package ua.nulp.sevl.coding.form;

public class AttemptForm {
    private String solution;

    public AttemptForm(String solution) {
        this.solution = solution;
    }

    public String getSolution() {
        return solution;
    }

    public AttemptForm setSolution(String solution) {
        this.solution = solution;
        return this;
    }
}
