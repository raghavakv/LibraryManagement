Digital Library Book Management System

📌 Objective

The Digital Library Book Management System is a Java-based application that allows librarians to efficiently add, update, search, and remove books while maintaining their availability status.

🚀 Features

Add a Book: Store book details such as ID, Title, Author, Genre, and Availability Status.

View All Books: Display a list of all books with their details.

Search Book: Search for a book using its ID or Title.

Update Book Details: Modify book details (Title, Author, or Availability Status).

Delete a Book: Remove a book from the catalog.

Persistent Storage: Books are saved to a file (books.txt) to retain data between sessions.

🛠️ Setup and Run Instructions

🔹 Prerequisites

Java Development Kit (JDK 8 or higher) installed

Any IDE or terminal to compile and run the Java program

🔹 Clone the Repository

git clone <repository_url>
cd Digital-Library-Management-System

🔹 Compile the Code

javac LibraryManagementSystem.java

🔹 Run the Application

java LibraryManagementSystem

📖 How to Use

When you run the program, you will see the following menu:

Library Management System
1. Add Book
2. View All Books
3. Search Book
4. Update Book Details
5. Delete Book
6. Exit
Choose an option:

🔹 Example Usage

➤ Adding a Book

Choose an option: 1
Enter Book ID: 101
Enter Title: The Alchemist
Enter Author: Paulo Coelho
Enter Genre: Fiction
Enter Availability (Available/Checked Out): Available
Book added successfully!

➤ Viewing Books

Choose an option: 2
[ID: 101, Title: The Alchemist, Author: Paulo Coelho, Genre: Fiction, Status: Available]

➤ Searching for a Book

Choose an option: 3
Enter Book ID or Title to search: 101
Book Found: [ID: 101, Title: The Alchemist, Author: Paulo Coelho, Genre: Fiction, Status: Available]

➤ Updating a Book

Choose an option: 4
Enter Book ID to update: 101
Enter New Title: The Alchemist (Updated)
Enter New Author: Paulo Coelho
Enter New Availability Status: Checked Out
Book details updated successfully!

➤ Deleting a Book

Choose an option: 5
Enter Book ID to delete: 101
Book deleted successfully!

➤ Exiting the System

Choose an option: 6
Exiting System. Goodbye!

🔥 Challenges & Improvements

Challenges Faced:

Ensuring persistent storage using file handling.

Handling edge cases such as duplicate book IDs.

Future Improvements:

Implement a GUI-based version using Java Swing or JavaFX.

Use a database (e.g., MySQL, PostgreSQL) instead of file storage for better scalability.

Implement user authentication for different roles (Librarian, User, Admin).

📜 License

This project is open-source and available for modification and use.

