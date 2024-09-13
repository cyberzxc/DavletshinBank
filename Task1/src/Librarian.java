import java.util.Scanner;

public class Librarian {
    private static final String login = "admin";
    private static final String password = "password";
    private static int numOfAttempts = 0;

    public static boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        if (login.equals(login) && password.equals(password)) {
            return true;
        } else {
            numOfAttempts++;
            System.out.println("Неверные логин или пароль. Оставшиеся попытки: " + (3 - numOfAttempts));
            if (numOfAttempts == 3) {
                System.out.println("Слишком много неудачных попыток. Программа завершена.");
                return false;
            }
            return login();
        }
    }
}
