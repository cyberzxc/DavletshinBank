import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество строк (n):");
        int n = scanner.nextInt();
        System.out.println("Введите количество столбцов (m):");
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] rowSums = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSums[i] += matrix[i][j];
            }
        }

        int[] colSums = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                colSums[j] += matrix[i][j];
            }
        }

        System.out.print("Сумма строк: ");
        for (int i = 0; i < n; i++) {
            System.out.print(rowSums[i] + " ");
        }
        System.out.println();

        System.out.print("Сумма столбцов: ");
        for (int j = 0; j < m; j++) {
            System.out.print(colSums[j] + " ");
        }
    }
}