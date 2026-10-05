package librarymanagementsystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// ================= BOOK CLASS =================

class Book {

    int id;
    String title;
    String author;
    boolean available;

    Book(int id, String title, String author) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    void displayBook() {

        System.out.println(
            "ID: " + id +
            " | Title: " + title +
            " | Author: " + author +
            " | Status: " +
            (available ? "Available" : "Borrowed")
        );
    }
}


// ================= MEMBER CLASS =================

class Member {

    int id;
    String name;

    Member(int id, String name) {

        this.id = id;
        this.name = name;
    }
}


// ================= MAIN CLASS =================

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store books
        ArrayList<Book> books = new ArrayList<>();

        // Store members
        ArrayList<Member> members = new ArrayList<>();

        // Book ID -> Member name
        HashMap<Integer, String> borrowedBooks = new HashMap<>();

        // Book ID -> Waiting list
        HashMap<Integer, Queue<String>> waitlists = new HashMap<>();


        // ================= MAIN MENU =================

        while (true) {

            System.out.println("\n======================================");
            System.out.println("       LIBRARY MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Register Member");
            System.out.println("4. Display All Members");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Search Book");
            System.out.println("8. Show Waiting List");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {


                // ================= ADD BOOK =================

                case 1:

                    System.out.println("\n---------- ADD BOOK ----------");

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();


                    // Check whether ID already exists

                    boolean bookExists = false;

                    for (Book book : books) {

                        if (book.id == bookId) {

                            bookExists = true;
                            break;
                        }
                    }


                    if (bookExists) {

                        System.out.println("Book ID already exists!");

                    } else {

                        Book newBook =
                            new Book(bookId, title, author);

                        books.add(newBook);

                        System.out.println(
                            "Book added successfully!"
                        );
                    }

                    break;


                // ================= DISPLAY BOOKS =================

                case 2:

                    System.out.println("\n---------- ALL BOOKS ----------");

                    if (books.isEmpty()) {

                        System.out.println("No books available.");

                    } else {

                        for (Book book : books) {

                            book.displayBook();
                        }
                    }

                    break;


                // ================= REGISTER MEMBER =================

                case 3:

                    System.out.println("\n---------- REGISTER MEMBER ----------");

                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Member Name: ");
                    String memberName = sc.nextLine();


                    boolean memberExists = false;

                    for (Member member : members) {

                        if (member.id == memberId) {

                            memberExists = true;
                            break;
                        }
                    }


                    if (memberExists) {

                        System.out.println(
                            "Member ID already exists!"
                        );

                    } else {

                        Member newMember =
                            new Member(memberId, memberName);

                        members.add(newMember);

                        System.out.println(
                            "Member registered successfully!"
                        );
                    }

                    break;


                // ================= DISPLAY MEMBERS =================

                case 4:

                    System.out.println("\n---------- ALL MEMBERS ----------");

                    if (members.isEmpty()) {

                        System.out.println(
                            "No members registered."
                        );

                    } else {

                        for (Member member : members) {

                            System.out.println(
                                "ID: " + member.id +
                                " | Name: " + member.name
                            );
                        }
                    }

                    break;


                // ================= BORROW BOOK =================

                case 5:

                    System.out.println("\n---------- BORROW BOOK ----------");

                    System.out.print("Enter Book ID: ");
                    int borrowBookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Member Name: ");
                    String borrowerName = sc.nextLine();


                    Book borrowBook = null;


                    // Find book

                    for (Book book : books) {

                        if (book.id == borrowBookId) {

                            borrowBook = book;
                            break;
                        }
                    }


                    if (borrowBook == null) {

                        System.out.println(
                            "Book not found!"
                        );

                    } else if (borrowBook.available) {

                        // Book is available

                        borrowBook.available = false;

                        borrowedBooks.put(
                            borrowBookId,
                            borrowerName
                        );

                        System.out.println(
                            "Book borrowed successfully!"
                        );

                    } else {

                        // Book already borrowed

                        System.out.println(
                            "Book is currently borrowed."
                        );

                        System.out.print(
                            "Do you want to join the waiting list? (yes/no): "
                        );

                        String answer = sc.nextLine();


                        if (answer.equalsIgnoreCase("yes")) {

                            Queue<String> queue =
                                waitlists.get(borrowBookId);


                            if (queue == null) {

                                queue = new LinkedList<>();

                                waitlists.put(
                                    borrowBookId,
                                    queue
                                );
                            }


                            queue.add(borrowerName);

                            System.out.println(
                                "You have been added to the waiting list."
                            );

                        } else {

                            System.out.println(
                                "Request cancelled."
                            );
                        }
                    }

                    break;


                // ================= RETURN BOOK =================

                case 6:

                    System.out.println("\n---------- RETURN BOOK ----------");

                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();
                    sc.nextLine();


                    Book returnBook = null;


                    // Find book

                    for (Book book : books) {

                        if (book.id == returnBookId) {

                            returnBook = book;
                            break;
                        }
                    }


                    if (returnBook == null) {

                        System.out.println(
                            "Book not found!"
                        );

                    } else if (returnBook.available) {

                        System.out.println(
                            "This book is already available."
                        );

                    } else {

                        // Return the book

                        returnBook.available = true;

                        borrowedBooks.remove(returnBookId);

                        System.out.println(
                            "Book returned successfully!"
                        );


                        // Check waiting list

                        Queue<String> queue =
                            waitlists.get(returnBookId);


                        if (queue != null && !queue.isEmpty()) {

                            String nextMember =
                                queue.poll();


                            returnBook.available = false;

                            borrowedBooks.put(
                                returnBookId,
                                nextMember
                            );


                            System.out.println(
                                "Book has been automatically assigned to: "
                                + nextMember
                            );


                            if (queue.isEmpty()) {

                                waitlists.remove(
                                    returnBookId
                                );
                            }
                        }
                    }

                    break;


                // ================= SEARCH BOOK =================

                case 7:

                    System.out.println("\n---------- SEARCH BOOK ----------");

                    System.out.print(
                        "Enter book title to search: "
                    );

                    String searchTitle = sc.nextLine();

                    boolean found = false;


                    for (Book book : books) {

                        if (
                            book.title
                                .toLowerCase()
                                .contains(
                                    searchTitle.toLowerCase()
                                )
                        ) {

                            book.displayBook();

                            found = true;
                        }
                    }


                    if (!found) {

                        System.out.println(
                            "No matching book found."
                        );
                    }

                    break;


                // ================= WAITING LIST =================

                case 8:

                    System.out.println(
                        "\n---------- WAITING LIST ----------"
                    );

                    System.out.print(
                        "Enter Book ID: "
                    );

                    int waitBookId = sc.nextInt();
                    sc.nextLine();


                    Queue<String> queue =
                        waitlists.get(waitBookId);


                    if (queue == null || queue.isEmpty()) {

                        System.out.println(
                            "No one is waiting for this book."
                        );

                    } else {

                        System.out.println(
                            "Waiting List:"
                        );

                        int position = 1;

                        for (String name : queue) {

                            System.out.println(
                                position + ". " + name
                            );

                            position++;
                        }
                    }

                    break;


                // ================= EXIT =================

                case 9:

                    System.out.println(
                        "\nThank you for using "
                        + "Library Management System!"
                    );

                    sc.close();

                    return;


                // ================= INVALID CHOICE =================

                default:

                    System.out.println(
                        "Invalid choice! "
                        + "Please enter 1-9."
                    );
            }
        }
    }
}