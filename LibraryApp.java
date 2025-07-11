import java.util.ArrayList;
import java.util.Scanner;


class Book {
    private int id;
    private String title;
    private String author;

 
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
    }
}


class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("❌ Library is empty.");
        } else {
            System.out.println("\n📚 Books in Library:");
            for (Book b : books) {
                b.displayDetails();
            }
        }
    }

    public Book searchBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public boolean deleteBookById(int id) {
        Book b = searchBookById(id);
        if (b != null) {
            books.remove(b);
            return true;
        }
        return false;
    }
}


public class LibraryApp {
    static Scanner sc = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========= 📖 Library Management Menu =========");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Delete Book by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: library.viewBooks(); break;
                case 3: searchBook(); break;
                case 4: deleteBook(); break;
                case 5: System.out.println("👋 Exiting Library System. Goodbye!"); break;
                default: System.out.println("⚠️ Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();  
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        Book book = new Book(id, title, author);
        library.addBook(book);
    }

    private static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();
        Book book = library.searchBookById(id);
        if (book != null) {
            System.out.println("✅ Book Found:");
            book.displayDetails();
        } else {
            System.out.println("❌ Book not found.");
        }
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();
        boolean deleted = library.deleteBookById(id);
        if (deleted) {
            System.out.println("✅ Book deleted successfully.");
        } else {
            System.out.println("❌ Book not found.");
        }
    }
}
