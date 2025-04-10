import java.util.ArrayList;

public class ListPasswordPage {
    private String title, appNameHeader, usernameHeader, categoryHeader;
    private int width;
    private ArrayList<PasswordStore> savedPasswords;

    private final HLine hline;
    private final Space space;

    public ListPasswordPage(String title, int width) {
        this.title = title;
        this.width = width;

        this.appNameHeader = "App Name";
        this.usernameHeader = "Username";
        this.categoryHeader = "Category";

        this.hline = new HLine(width);
        this.space = new Space(width);

        this.savedPasswords = DataPassword.data;
    }

    public void draw() {
        new MainPage(this.title, this.width).drawHeader();
        drawListContent();
    }

    private void drawListContent() {
        this.space.draw();
        new Label("You have " + this.savedPasswords.size() + " passwords saved.", this.width).draw();
        this.space.draw();

        int appNameMaxWidth = getMaxAppName();
        int usernameMaxWidth = getMaxUsername();
        int categoryMaxWidth = getMaxCategory();
        int maxWidth = appNameMaxWidth + usernameMaxWidth + categoryMaxWidth;

        new Label(this.headerLine(maxWidth + 8), this.width).draw();
        String header = "|" + formatString(this.appNameHeader, appNameMaxWidth) + "|";
        header += formatString(this.usernameHeader, usernameMaxWidth) + "|";
        header += formatString(this.categoryHeader, categoryMaxWidth) + "|";
        new Label(header, this.width).draw();
        new Label(this.headerLine(maxWidth + 8), this.width).draw();

        for (PasswordStore ps : DataPassword.data) {
            String details = "|" + formatString(ps.name, appNameMaxWidth) + "|";
            details += formatString(ps.username, usernameMaxWidth) + "|";
            details += formatString(PasswordStore.CATEGORIES[ps.category], categoryMaxWidth) + "|";

            new Label(details, this.width).draw();
        }

        new Label(this.headerLine(maxWidth + 8), this.width).draw();
    }

    private int getMaxAppName() {
        String longestAppName = "";

        for (PasswordStore ps : this.savedPasswords) {
            if (ps.name.length() > longestAppName.length()) {
                longestAppName = ps.name;
            }
        }

        if (this.appNameHeader.length() > longestAppName.length()) {
            longestAppName = this.appNameHeader;
        }

        return longestAppName.length();
    }

    private int getMaxUsername() {
        String longestUsername = "";

        for (PasswordStore ps : this.savedPasswords) {
            if (ps.username.length() > longestUsername.length()) {
                longestUsername = ps.username;
            }
        }

        if (this.usernameHeader.length() > longestUsername.length()) {
            longestUsername = this.usernameHeader;
        }

        return longestUsername.length();
    }

    private int getMaxCategory() {
        String longestCategory = "";

        for (PasswordStore ps : this.savedPasswords) {
            if (PasswordStore.CATEGORIES[ps.category].length() > longestCategory.length()) {
                longestCategory = PasswordStore.CATEGORIES[ps.category];
            }
        }

        if (this.categoryHeader.length() > longestCategory.length()) {
            longestCategory = this.categoryHeader;
        }

        return longestCategory.length();
    }

    private String formatString(String data, int maxLength) {
        String formattedString = " ";

        int spaceCount = maxLength - data.length();

        if (data.length() > maxLength) {
            spaceCount = 1;
        }

        formattedString += data;

        for (int i = 0; i < spaceCount; i++) {
            formattedString += " ";
        }

        formattedString += " ";

        return formattedString;
    }

    private String headerLine(int maxWidth) {
        String header = "+";

        for (int i = 0; i < maxWidth; i++) {
            header += "=";
        }

        header += "+";

        return header;
    }
}
