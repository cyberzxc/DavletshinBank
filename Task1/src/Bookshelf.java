public class Bookshelf {
    static final int maxNumOfBooks = 3;
    private Book[][] books;
    private int numShelves;

    public Bookshelf() {
        this.books = new Book[1][maxNumOfBooks];
        this.numShelves = 1;
    }

    public void addBook(Book book) {
        for (int i = 0; i < numShelves; i++) {
            for (int j = 0; j < maxNumOfBooks; j++) {
                if (books[i][j] == null) {
                    books[i][j] = book;
                    return;
                }
            }
        }

        Book[][] newBooks = new Book[numShelves + 1][maxNumOfBooks];
        for (int i = 0; i < numShelves; i++) {
            for (int j = 0; j < maxNumOfBooks; j++) {
                newBooks[i][j] = books[i][j];
            }
        }
        newBooks[numShelves][0] = book;
        books = newBooks;
        numShelves++;
    }

    public Book[][] getBooks() {
        return books;
    }

    public int getNumShelves() {
        return numShelves;
    }

    public void sortShelf(int shelfNum, boolean ascending) {
        Book[] shelf = books[shelfNum - 1];
        for (int i = 0; i < maxNumOfBooks - 1; i++) {
            for (int j = 0; j < maxNumOfBooks - i - 1; j++) {
                if (shelf[j] == null || shelf[j + 1] == null)
                    continue;

                boolean condition;
                if (ascending) {
                    condition = shelf[j].getTitle().compareToIgnoreCase(shelf[j + 1].getTitle()) > 0;
                } else {
                    condition = shelf[j].getTitle().compareToIgnoreCase(shelf[j + 1].getTitle()) < 0;
                }

                if (condition) {
                    Book temp = shelf[j];
                    shelf[j] = shelf[j + 1];
                    shelf[j + 1] = temp;
                }
            }
        }
    }
}
