import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (!Librarian.login()) {
            return;
        }

        Bookshelf bookshelf = new Bookshelf();

        while (true) {
            System.out.println("\nСистема управления библиотекой:");
            System.out.println("1. Просмотр количества полок");
            System.out.println("2. Добавить новую книгу");
            System.out.println("3. Отсортировать полку (А-Я)");
            System.out.println("4. Отсортировать полку (Я-А)");
            System.out.println("5. Просмотр полки");
            System.out.println("6. Выход");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите ваш выбор: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Количество полок: " + bookshelf.getNumShelves());
                    break;
                case 2:
                    System.out.print("Введите название книги: ");
                    String title = scanner.next();
                    System.out.print("Введите автора книги: ");
                    String author = scanner.next();
                    System.out.print("Введите количество страниц: ");
                    int pages = scanner.nextInt();
                    Book book = new Book(title, author, pages);
                    bookshelf.addBook(book);
                    System.out.println("Книга добавлена в библиотеку.");
                    break;
                case 3:
                    System.out.print("Введите номер полки для сортировки (1-" + bookshelf.getNumShelves() + "): ");
                    int shelfNum = scanner.nextInt();
                    bookshelf.sortShelf(shelfNum, true);
                    System.out.println("Полка " + shelfNum + " отсортирована по возрастанию.");
                    break;
                case 4:
                    System.out.print("Введите номер полки для сортировки (1-" + bookshelf.getNumShelves() + "): ");
                    shelfNum = scanner.nextInt();
                    bookshelf.sortShelf(shelfNum, false);
                    System.out.println("Полка " + shelfNum + " отсортирована по убыванию.");
                    break;
                case 5:
                    System.out.print("Введите номер полки для просмотра (1-" + bookshelf.getNumShelves() + "): ");
                    shelfNum = scanner.nextInt();
                    Book[][] books = bookshelf.getBooks();
                    for (int i = 0; i < Bookshelf.maxNumOfBooks; i++) {
                        if (books[shelfNum - 1][i] != null) {
                            System.out.println(books[shelfNum - 1][i].getTitle() + " - " + books[shelfNum - 1][i].getAuthor() + " - " + books[shelfNum - 1][i].getPages() + " страниц");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Выход из системы управления библиотекой...");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
    }
}