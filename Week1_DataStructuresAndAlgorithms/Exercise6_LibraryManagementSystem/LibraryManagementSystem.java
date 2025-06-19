// DSA: Exercise 6

package Week1.DSA.Exercise6;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {

    // Book Class
    static class Book {
        int bookId;
        String title;
        String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String toString() {
            return "[" + bookId + "] " + title + " by " + author;
        }
    }

    // Linear Search by Title
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search by Title
    public static Book binarySearchByTitle(Book[] books, String title) {
        int left = 0, right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(101, "The Alchemist", "Paulo Coelho"),
                new Book(102, "To Kill a Mockingbird", "Harper Lee"),
                new Book(103, "1984", "George Orwell"),
                new Book(104, "Pride and Prejudice", "Jane Austen"),
                new Book(105, "Moby Dick", "Herman Melville")
        };

        // Sort books by title for binary search
        Arrays.sort(books, Comparator.comparing(book -> book.title.toLowerCase()));

        // Display sorted book list
        System.out.println("Book List (Sorted by Title):");
        for (Book b : books) {
            System.out.println(b);
        }

        // Linear Search
        System.out.println("\nLinear Search for '1984':");
        Book linearResult = linearSearchByTitle(books, "1984");
        System.out.println(linearResult != null ? linearResult : "Book not found.");

        // Binary Search
        System.out.println("\nBinary Search for 'Moby Dick':");
        Book binaryResult = binarySearchByTitle(books, "Moby Dick");
        System.out.println(binaryResult != null ? binaryResult : "Book not found.");
    }

}

// Understanding Search Algorithms:
// Linear Search - Time Complexity: Best O(1), Worst O(n)
// Binary Search - Time Complexity: Best O(1), Worst O(log n)
