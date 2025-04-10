public class App {
    public static void main(String[] args) {
        new MainPage("Simple Password Store App", 100).draw();
    }

    public static void testPasswordStore() {
        PasswordStore userA = new PasswordStore("Raharjo Dwi", "raharjodwi22", "thisissecurepassword", 1);

        userA.setCategory(PasswordStore.CAT_WEBAPP);

        System.out.println("User A :");
        System.out.println(userA);
        System.out.println("USERNAME: " + userA.username + " | PASSWORD: " +
                userA.getPassword() + " | PLAIN PASSWORD: " + userA.getPlainPassword());

        System.out.println("\n");

        PasswordStore userB = new PasswordStore("Fiony", "fiony41", "mypassWordisStr0ng", 0);

        userA.setCategory(PasswordStore.CAT_MOBILEAPP);

        System.out.println("User B :");
        System.out.println(userB);
        System.out.println("USERNAME: " + userB.username + " | PASSWORD: " + userB.getPassword() + " | PLAIN PASSWORD: "
                + userB.getPlainPassword());
    }

    public static void testLabel() {
        new Label("Simple PasswordStore - Learn OOP in Java", 50).draw();
    }

    public static void testHLine() {
        new HLine(50).draw();
    }

    public static void testSpace() {
        new Space(50).draw();
    }

    public static void testInput() {
        Input input = new Input("Fullname");
        Input input2 = new Input("Age");

        input.draw();
        input.getValue();

        input2.draw();
        input2.getValueInt();
    }

    public static void testSelectInput() {
        SelectInput opt = new SelectInput("Choose categories :",
                PasswordStore.CATEGORIES, 50);
        opt.draw();
    }
}
