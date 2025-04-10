public class Label {
    public String text;
    private int width;

    public Label(String text, int width) {
        this.text = text;
        this.width = width;
    }

    public void draw() {
        System.out.print("|  ");

        int spaceCount = width - 2 - text.length();

        if (text.length() >= width) {
            spaceCount = 1;
        }

        System.out.print(text);

        for (int i = 0; i < spaceCount; i++) {
            System.out.print(" ");
        }

        System.out.print("|");
        System.out.println();
    }
}
