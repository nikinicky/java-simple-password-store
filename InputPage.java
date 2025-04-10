public class InputPage {
    private String title;
    private int width;

    private String appName;
    private String username;
    private String password;
    private int category;

    private final HLine hline;
    private final Space space;

    public InputPage(String title, int width) {
        this.title = title;
        this.width = width;

        this.hline = new HLine(width);
        this.space = new Space(width);
    }

    public void draw() {
        new MainPage(this.title, this.width).drawHeader();
        drawInputContent();
    }

    private void drawInputContent() {
        this.space.draw();
        new Label("Input your new password data", this.width).draw();
        this.space.draw();

        Input appNameInput = new Input("Application Name");
        appNameInput.draw();
        this.appName = appNameInput.getValue();

        Input usernameInput = new Input("Username");
        usernameInput.draw();
        this.username = usernameInput.getValue();

        Input passwordInput = new Input("Password");
        passwordInput.draw();
        this.password = passwordInput.getValue();

        SelectInput categoryOptions = new SelectInput("Categories :", PasswordStore.CATEGORIES, this.width);
        categoryOptions.draw();
        this.category = categoryOptions.getValueInt() - 1;

        this.storePassword();

        this.space.draw();
        this.hline.draw();
        this.space.draw();
        new Label("Password has been successfully saved!", this.width).draw();
        this.space.draw();
        this.hline.draw();
    }

    private void storePassword() {
        PasswordStore newPassword = new PasswordStore(
                this.appName,
                this.username,
                this.password,
                this.category);

        DataPassword.data.add(newPassword);
    }
}
