import java.util.Scanner;

public class SelectInput {
    private String label;
    private String value;
    private String[] options;
    private int width;

    public SelectInput(String label, String[] options, int width) {
        this.options = options;
        this.label = label;
        this.width = width;
    }

    public void draw() {
        new Label(label, width).draw();

        for (int i = 0; i < options.length - 1; i++) {
            int number = i + 1;
            new Label("  [" + number + "] " + options[i], width).draw();
        }

        new Input("Your choice").draw();
    }

    public String getValue() {
        return value;
    }
}
