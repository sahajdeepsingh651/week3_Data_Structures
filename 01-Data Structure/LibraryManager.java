class Book {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManager {
    private Book head = null;
    private Book tail = null;

    // Add at beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add at end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (pos <= 1 || head == null) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book current = head;

        for (int i = 1; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }

        newBook.next = current.next;
        newBook.prev = current;

        if (current.next != null)
            current.next.prev = newBook;
        else
            tail = newBook;

        current.next = newBook;
    }

    // Remove by Book ID
    public void removeByBookId(int bookId) {
        Book current = head;
        while (current != null && current.bookId != bookId)
            current = current.next;

        if (current == null) {
            System.out.println("Book ID not found.");
            return;
        }

        if (current == head)
            head = current.next;
        if (current == tail)
            tail = current.prev;

        if (current.prev != null)
            current.prev.next = current.next;
        if (current.next != null)
            current.next.prev = current.prev;

        System.out.println("Book removed successfully.");
    }

    // Search by title
    public void searchByTitle(String title) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                printBook(current);
                found = true;
            }
            current = current.next;
        }
        if (!found)
            System.out.println("No book found with title: " + title);
    }

    // Search by author
    public void searchByAuthor(String author) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                printBook(current);
                found = true;
            }
            current = current.next;
        }
        if (!found)
            System.out.println("No books found by author: " + author);
    }

    // Update availability status
    public void updateAvailability(int bookId, boolean status) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book ID not found.");
    }

    // Display all books (forward)
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Books in library (forward):");
        Book current = head;
        while (current != null) {
            printBook(current);
            current = current.next;
        }
    }

    // Display all books (reverse)
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Books in library (reverse):");
        Book current = tail;
        while (current != null) {
            printBook(current);
            current = current.prev;
        }
    }

    // Count total books
    public void countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of books: " + count);
    }

    // Utility to print book
    private void printBook(Book b) {
        System.out.println("ID: " + b.bookId + ", Title: " + b.title + ", Author: " + b.author +
                ", Genre: " + b.genre + ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }

    // Main for testing
    public static void main(String[] args) {
        LibraryManager lib = new LibraryManager();

        lib.addAtEnd("1984", "George Orwell", "Fiction", 101, true);
        lib.addAtBeginning("The Alchemist", "Paulo Coelho", "Philosophy", 102, true);
        lib.addAtPosition(2, "Clean Code", "Robert C. Martin", "Programming", 103, false);

        lib.displayForward();
        lib.updateAvailability(103, true);
        lib.searchByTitle("Clean Code");
        lib.searchByAuthor("George Orwell");
        lib.countBooks();

        lib.displayReverse();
        lib.removeByBookId(102);
        lib.displayForward();
    }
}
