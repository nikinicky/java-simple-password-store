public class App {
    public String getGreeting() {
        return "Hello!";
    }

    public static void main(String[] args) {
        PasswordStore userA = new PasswordStore("Raharjo Dwi", "raharjodwi22", "thisissecurepassword");

        userA.setCategory(PasswordStore.CAT_WEBAPP);

        System.out.println("User A :");
        System.out.println(userA);
        System.out.println("USERNAME: " + userA.username + " | PASSWORD: " + userA.getPassword() + " | PLAIN PASSWORD: " + userA.getPlainPassword());

        System.out.println("\n");

        PasswordStore userB = new PasswordStore("Fiony", "fiony41", "mypassWordisStr0ng");

        userA.setCategory(PasswordStore.CAT_MOBILEAPP);

        System.out.println("User B :");
        System.out.println(userB);
        System.out.println("USERNAME: " + userB.username + " | PASSWORD: " + userB.getPassword() + " | PLAIN PASSWORD: " + userB.getPlainPassword());
    }
}
