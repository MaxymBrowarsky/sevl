package ua.nulp.sevl.coding.form;

public class CreateTaskForm {
    private String title;
    private String labels;
    private String theme;
    private String description;

    public CreateTaskForm() {
    }

    public CreateTaskForm(String title, String labels, String theme, String description) {
        this.title = title;
        this.labels = labels;
        this.theme = theme;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public CreateTaskForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLabels() {
        return labels;
    }

    public CreateTaskForm setLabels(String labels) {
        this.labels = labels;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateTaskForm setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTheme() {
        return theme;
    }

    public CreateTaskForm setTheme(String theme) {
        this.theme = theme;
        return this;
    }
}
