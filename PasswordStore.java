import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordStore {
    public String name, username;
    public int category;

    private String password, hashkey;
    private double score;

    public static final int UNCATEGORIZED = 0;
    public static final int CAT_WEBAPP = 1;
    public static final int CAT_MOBILEAPP = 2;
    public static final int CAT_OTHER = 3;

    public static final String[] CATEGORIES = {
            "Uncategorized",
            "Web Application",
            "Mobile Application",
            "Others"
    };

    public PasswordStore(String name, String username, String plainPass, int category) {
        try {
            this.hashkey = Encryptor.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.name = name;
        this.username = username;

        this.setCategory(category);
        this.setPassword(plainPass);
    }

    public void setPassword(String plainPass) {
        String encryptedPass;

        try {
            encryptedPass = Encryptor.encrypt(plainPass, this.hashkey);

            this.password = encryptedPass;
            this.calculateScore(plainPass);
        } catch (Exception ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPassword() {
        return this.password;
    }

    public String getPlainPassword() {
        try {
            return Encryptor.decrypt(this.password, this.hashkey);
        } catch (Exception ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static String formatPassword(String encryptedPassword, String savedHashkey) {
        try {
            return Encryptor.decrypt(encryptedPassword, savedHashkey);
        } catch (Exception ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void setCategory(int category) {
        if (category >= 0 || category <= 3) {
            this.category = category;
        } else {
            this.category = 0;
        }
    }

    public String getCategory() {
        return CATEGORIES[this.category];
    }

    private void calculateScore(String plainPass) {
        double len = plainPass.length();

        if (len > 15) {
            this.score = 10;
        } else {
            this.score = (len / 15) * 10;
        }
    }

    public double getScore() {
        return this.score;
    }

    public String toStringCSVFormat() {
        return "\"" + this.name + "\",\"" + this.username + "\",\"" + this.password + "\",\"" + this.hashkey + "\",\""
                + this.category + "\",\"" + this.score + "\"";
    }

    @Override
    public String toString() {
        return this.name;
    }
}
