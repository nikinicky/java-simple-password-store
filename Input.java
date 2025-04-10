import java.util.Scanner;

public class Input {
    private String label;
    private Scanner input;
    private String value;

    public Input(String label) {
        this.label = label;
        this.input = new Scanner(System.in);
    }

    public void draw() {
        System.out.print("|  " + label + " : ");
        value = input.nextLine();
    }

    public String getValue() {
        return value;
    }

    public int getValueInt() {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public double getValueDouble() {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
