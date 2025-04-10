public class HLine {
    private int width;

    public HLine(int width) {
        this.width = width;
    }

    public void draw() {
        System.out.print("+");

        for (int i = 0; i < width; i++) {
            System.out.print("=");
        }

        System.out.print("+");
        System.out.println();
    }
}
