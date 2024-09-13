import java.util.Scanner;

public class Main {
    private static final char[] chars = {'А', 'Б', 'Н', 'Р', 'И', 'П'};
    private static final String[] codes = {"00", "01", "1100", "111", "1010", "1001"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите закодированное слово: ");
        String binaryWord = scanner.nextLine();

        StringBuilder decodedWord = new StringBuilder();
        int currentIndex = 0;

        while (currentIndex < binaryWord.length()) {
            int matchingIndex = -1;
            for (int i = 0; i < codes.length; i++) {
                if (binaryWord.startsWith(codes[i], currentIndex)) {
                    matchingIndex = i;
                    break;
                }
            }

            if (matchingIndex != -1) {
                decodedWord.append(chars[matchingIndex]);
                currentIndex += codes[matchingIndex].length();
            } else {
                System.out.println("Ошибка: Недопустимый двоичный код.");
                return;
            }
        }

        System.out.println("Исходное слово: " + decodedWord.toString());
    }
}