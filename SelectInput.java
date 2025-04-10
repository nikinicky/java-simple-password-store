import java.util.Scanner;

public class SelectInput {
    private String label;
    private String[] options;
    private int value;
    private int width;

    public SelectInput(String label, String[] options, int width) {
        this.options = options;
        this.label = label;
        this.width = width;
    }

    public void draw() {
        new Label(label, width).draw();

        for (int i = 0; i < options.length; i++) {
            int number = i + 1;
            new Label("  [" + number + "] " + options[i], width).draw();
        }

        new Space(width).draw();

        Input input = new Input("Your choice");
        input.draw();

        this.value = input.getValueInt();
    }

    public int getValueInt() {
        return value;
    }
}
