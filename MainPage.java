public class MainPage {
    public String title;
    public int width;

    private final HLine hline;
    private final Space space;
    private final Label label;

    public MainPage(String title, int width) {
        this.title = title;
        this.width = width;

        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title.toUpperCase(), width);
    }

    public void draw() {
        drawHeader();
        drawContent();
    }

    public void drawHeader() {
        this.hline.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.hline.draw();
    }

    private void drawContent() {
        String[] pages = {
                "Add Password",
                "Show Password",
                "Quit"
        };
        SelectInput pageOptions = new SelectInput("What do you want?", pages, this.width);

        this.space.draw();
        this.label.text = "Welcome to Password Storage App!";
        this.label.draw();

        this.label.text = "You can save your password here.";
        this.label.draw();
        this.space.draw();

        pageOptions.draw();

        int selectedOption = pageOptions.getValueInt() - 1;

        switch (selectedOption) {
            case 0 -> {
                drawFooter();
                new InputPage("Add New Password", this.width).draw();
                new MainPage(this.title, this.width).draw();
            }
            case 1 -> {
                new ListPasswordPage("Saved Password", this.width).draw();
                drawFooter();
            }
            case 2 -> {
                this.space.draw();
                this.hline.draw();
                this.space.draw();

                new Label("Thank you for choosing this app!", this.width).draw();
                drawFooter();
            }
            default -> {
                new MainPage(this.title, this.width).draw();
            }
        }
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }
}
