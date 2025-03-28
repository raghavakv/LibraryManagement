import java.io.*;
import java.util.*;

class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    public Book(String bookID, String title, String author, String genre, String availabilityStatus) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    public String getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getAvailabilityStatus() { return availabilityStatus; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setAvailabilityStatus(String status) { this.availabilityStatus = status; }

    @Override
    public String toString() {
        return "[ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Status: " + availabilityStatus + "]";
    }
}

class Library {
    private List<Book> books;
    private static final String FILE_NAME = "books.txt";

    public Library() {
        books = new ArrayList<>();
        loadBooks();
    }

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getBookID().equals(book.getBookID())) {
                System.out.println("Error: Book ID must be unique!");
                return;
            }
        }
        books.add(book);
        saveBooks();
        System.out.println("Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(String keyword) {
        for (Book book : books) {
            if (book.getBookID().equals(keyword) || book.getTitle().equalsIgnoreCase(keyword)) {
                System.out.println("Book Found: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void updateBook(String bookID, String title, String author, String status) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setAvailabilityStatus(status);
                saveBooks();
                System.out.println("Book details updated successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void deleteBook(String bookID) {
        books.removeIf(book -> book.getBookID().equals(bookID));
        saveBooks();
        System.out.println("Book deleted successfully!");
    }

    private void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            books = new ArrayList<>(); // File doesn't exist yet
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability (Available/Checked Out): ");
                    String status = scanner.nextLine();
                    library.addBook(new Book(id, title, author, genre, status));
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID or Title to search: ");
                    String searchKey = scanner.nextLine();
                    library.searchBook(searchKey);
                    break;
                case 4:
                    System.out.print("Enter Book ID to update: ");
                    String updateID = scanner.nextLine();
                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter New Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter New Availability Status: ");
                    String newStatus = scanner.nextLine();
                    library.updateBook(updateID, newTitle, newAuthor, newStatus);
                    break;
                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    String deleteID = scanner.nextLine();
                    library.deleteBook(deleteID);
                    break;
                case 6:
                    System.out.println("Exiting System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
