import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class DataPassword {
    public static final ArrayList<PasswordStore> data = new ArrayList<>();

    private static final String csvPath = "./savedPasswords.csv";
    private static final String[] headers = {
            "appName",
            "username",
            "password",
            "hashkey",
            "category",
            "score"
    };

    public static void saveCSVData() {
        if (data.isEmpty()) {
            System.out.println("Empty data!");
        } else {
            System.out.println("yes");
            try {
                FileWriter writer = new FileWriter(csvPath);

                writer.write(String.join(",", headers) + "\n");

                for (PasswordStore ps : data) {
                    writer.write(ps.toStringCSVFormat() + "\n");
                }

                writer.close();
            } catch (IOException e) {
                Logger.getLogger(DataPassword.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public static void loadCSVData() {
        data.clear();

        try {
            String line;
            boolean isHeader = true;

            BufferedReader reader = new BufferedReader(new FileReader("savedPasswords.csv"));

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] row = line.replaceAll("\"", "").split(",");

                if (row.length == 6) {
                    String appName = row[0];
                    String username = row[1];
                    String savedPass = PasswordStore.formatPassword(row[2], row[3]);
                    int category = Integer.parseInt(row[4]);

                    PasswordStore password = new PasswordStore(appName, username, savedPass, category);
                    data.add(password);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(DataPassword.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
