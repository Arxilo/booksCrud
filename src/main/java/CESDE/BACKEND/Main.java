/*

OPEN BOOK LIBRARY 📚 (Library Invent)

You need to implement a login with a maximum of three attempts
If the user fails more than three times you'll block the account and end the projects running.

    1. You will register Books,
    2. Look for specific Books based on their ISBN,
    3. Delete Books ,
    4. and show the full list of them
    5. Logout

Data to use

    1.  ISBN (International Standard Book Number): Book Identifier.
    2.  Book's Title
    3.  Author
    4.  Gender
    5.  Unit Price
    6.  Stock

*/
package CESDE.BACKEND;
import CESDE.BACKEND.colors.TerminalColors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // DECLARING ENTRIES

        Scanner read = new Scanner(System.in); // Scanner to get data Through the console.
        ArrayList<HashMap<String, Object>> books = new ArrayList<>(); // This arraylist will storage all the books

        // LOGIN VARIABLES

        String savedEmail = "books@gmail.com"; // This simulates the email saved in a database
        String savedPassword = "123"; // This simulates the password saved in a database
        String typedEmail; // typeEmail and typedPassword will be compared with the value saved on the last to variables
        String typedPassword;
        Integer attemptsNumber = 3; // This will count how many attempts has the user left.
        Integer menuOption; // This variable will be in charge of saving the option that the user chooses in the menu


        // DECLARING BOOK'S VARIABLES

        Integer id = 0;
        String booksIdentifier; // this will be the book's ISBN
        String bookTittle;
        String author;
        String gender;
        float unitPrice;
        Integer stock;

        System.out.println(TerminalColors.MAGENTA + "\n Welcome To the Open book's Library 📖 \n");

        // LOGIN'S LOOP
        while (true) {

            System.out.print(TerminalColors.CYAN + "\n 📧 Type your Email: ");
            typedEmail = read.nextLine();

            System.out.print(TerminalColors.CYAN + "\n 🔒 Type your Password: ");
            typedPassword = read.nextLine();

            // VALIDATING CREDENTIALS

            if (savedEmail.equalsIgnoreCase(typedEmail) && savedPassword.equals(typedPassword)) {

                System.out.println(TerminalColors.GREEN + "\n Your Credential are correct, Welcome to the Library. 📚 \n");

                while (true) {

                    System.out.println(TerminalColors.CYAN + """
                                                        \s
                             1. Add Books ➕
                             2. Find a Book 🔍
                             3. Delete a Book 🗑️
                             4. List of Books 📋
                             5. Update Books 📝
                             6. Logout 🚪
                                                        \s
                            \s""");

                    menuOption = read.nextInt();
                    read.nextLine(); // This nextLine() is used because if don't add it can make conflict with the next Scanners

                    // MENU CONDITIONALS

                    if (menuOption == 1) {

                        HashMap<String, Object> book = new HashMap<>(); // This hashMap will save the Book's data in a dictionary

                        id++; // Incrementing id variable to simulate the autoincrement of a Database

                        // Capturing the book's data with a Scanner

                        System.out.print(TerminalColors.BLUE + "\n #️⃣ Type the book's ISBN (International Standard Book Number): ");
                        booksIdentifier = read.nextLine();

                        System.out.print(TerminalColors.BLUE + "\n 📘️ Type the book's Title: ");
                        bookTittle = read.nextLine();

                        System.out.print(TerminalColors.BLUE + "\n ✒️ Type the book's author: ");
                        author = read.nextLine();

                        System.out.print(TerminalColors.BLUE + "\n 💭 Type the book's Genre: ");
                        gender = read.nextLine();

                        System.out.print(TerminalColors.BLUE + "\n 💲 Type the book's Unit Price: ");
                        unitPrice = read.nextFloat();

                        System.out.print(TerminalColors.BLUE + "\n 📋 Type the book's Stock: ");
                        stock = read.nextInt();

                        // SAVING VALUES CAPTURED WITH SCANNER ON THE DICTIONARY 🔻

                        book.put("id", id);
                        book.put("ISBN", booksIdentifier);
                        book.put("title", bookTittle);
                        book.put("author", author);
                        book.put("genre", gender);
                        book.put("unitPrice", unitPrice);
                        book.put("stock", stock);

                        books.add(book); // Turning the dictionary into a List

                        System.out.println(TerminalColors.GREEN + "\n  ✅ The books has been added Successfully  \n" + book);

                    } else if (menuOption == 2) {

                        // VALIDATING IF THERE IS BOOKS IN THE LIST

                        if (books.isEmpty()) {

                            System.out.println(TerminalColors.BRIGHT_YELLOW + "\n There is not any books yet  ️📙\n");

                        } else {

                            String BookToFind; // variable that captures the Book's ISBN to find

                            System.out.print(TerminalColors.BLUE + "\n #️⃣ Type the book's ISBN : ");
                            BookToFind = read.nextLine();

                            // This for each Below Creates a hasMap to list Data to find
                            boolean found = false;

                            for (HashMap<String, Object> findBooks : books) {

                                //This condition gets the book ISBN if it exists

                                if (findBooks.get("ISBN").equals(BookToFind)) {

                                    System.out.println(TerminalColors.GREEN + "✅ The books " + BookToFind + " has been found. It's information is listed bellow 🔻  \n");
                                    System.out.println(TerminalColors.BLUE + "#️⃣️ ISBN Number: " + findBooks.get("ISBN"));
                                    System.out.println(TerminalColors.BLUE + "📘 Title: " + findBooks.get("title"));
                                    System.out.println(TerminalColors.BLUE + "✒️ Author: " + findBooks.get("author"));
                                    System.out.println(TerminalColors.BLUE + "😶‍🌫️ Genre: " + findBooks.get("genre"));
                                    System.out.println(TerminalColors.BLUE + "💲 Unit Price: " + findBooks.get("unitPrice"));
                                    System.out.println(TerminalColors.BLUE + "📋 Stock: " + findBooks.get("stock"));
                                    found = true;

                                }
                            }

                            // in case The Book's ISBN is not found.

                            if (!found) {
                                System.out.println(TerminalColors.RED + "\n ❌ The book " + BookToFind + " couldn't be found. \n");
                            }
                        }

                    } else if (menuOption == 3) {

                        // VALIDATING THERE IS BOOKS IN THE LIST.

                        if (books.isEmpty()) {

                            System.out.println(TerminalColors.BRIGHT_YELLOW + "\n There is not any books yet  ️📙\n");

                        } else {

                            String BookToDelete; // variable that captures the Book's ISBN to Delete
                            String Confirmation; // Variable that confirms if the

                            System.out.print(TerminalColors.BLUE + "\n #️⃣ Type the book's ISBN : ");
                            BookToDelete = read.nextLine();

                            System.out.println(TerminalColors.BRIGHT_YELLOW + "\n Are you sure you want to delete this book  ️(Y/N) 📙\n");
                            Confirmation = read.nextLine();

                            // Validating if the user want's to Delete the book

                            if (Confirmation.equalsIgnoreCase("Y")) {

                                // This boolean variable removes an item from a list if the condition is correct
                                boolean delete = books.removeIf(delBook -> delBook.get("ISBN").equals(BookToDelete));

                                // Conditions in case the was deleted.
                                if (delete) {
                                    System.out.println(TerminalColors.GREEN + "\n  ✅ The books has been Deleted. 🗑️  \n");
                                } else {
                                    System.out.println(TerminalColors.RED + "\n ❌ The book " + BookToDelete + " couldn't be found. \n"); // in case The Book's ISBN is not found.
                                }

                            } else {

                                System.out.println(TerminalColors.BRIGHT_YELLOW + " +\n 🚫 Deletion cancelled. \n");

                            }
                        }

                    } else if (menuOption == 4) {

                        if (books.isEmpty()) {

                            System.out.println(TerminalColors.BRIGHT_YELLOW + "\n There is not any books yet  ️📙\n");

                        } else {

                            for (HashMap<String, Object> booksList : books) {

                                System.out.println(TerminalColors.MAGENTA + "📚: " + booksList);

                            }
                        }

                    } else if (menuOption == 5) {

                        // VALIDATING IF THERE IS ANY BOOK TO UPDATE

                        if (books.isEmpty()) {
                            System.out.println(TerminalColors.BRIGHT_YELLOW + "\n There is not any books yet  ️📙\n");
                        } else {

                            String bookToEditISBN;
                            boolean found = false;

                            System.out.print(TerminalColors.BLUE + "\n #️⃣ Type the ISBN of the book to EDIT: ");
                            bookToEditISBN = read.nextLine();

                            for (HashMap<String, Object> bookToEdit : books) {

                                if (bookToEdit.get("ISBN").equals(bookToEditISBN)) {

                                    found = true;
                                    System.out.println(TerminalColors.GREEN + "\n  ✅ The books has been found. \n");

                                    System.out.println(TerminalColors.CYAN + """
                                             \n
                                             Which field do you want to edit?
                                                                                       
                                            1. Title
                                            2. Author
                                            3. Genre
                                            4. Unit Price
                                            5. Stock
                                            6. Cancel/Back
                                                                                       
                                            \n
                                            """);

                                    Integer editOption;
                                    editOption = read.nextInt();
                                    read.nextLine();

                                    String newValue;

                                    if (editOption == 1) {

                                        System.out.print(TerminalColors.BLUE + " 📘️ Enter NEW Title: ");
                                        newValue = read.nextLine();
                                        bookToEdit.put("title", newValue);
                                        System.out.println(TerminalColors.GREEN + "\n  ✅ The new Title has been set. \n");

                                    } else if (editOption == 2) {

                                        System.out.print(TerminalColors.BLUE + " ✒️ Enter NEW Author: ");
                                        newValue = read.nextLine();
                                        bookToEdit.put("author", newValue);
                                        System.out.println(TerminalColors.GREEN + "\n  ✅ The new Author has been set. \n");

                                    } else if (editOption == 3) {

                                        System.out.print(TerminalColors.BLUE + " 💭 Enter NEW Genre: ");
                                        newValue = read.nextLine();
                                        bookToEdit.put("genre", newValue);
                                        System.out.println(TerminalColors.GREEN + "\n  ✅ The new Genre has been set. \n");

                                    } else if (editOption == 4) {

                                        float newPrice;
                                        System.out.print(TerminalColors.BLUE + " 💲 Enter NEW unit Price: ");
                                        newPrice = read.nextFloat();
                                        bookToEdit.put("unitPrice", newPrice);
                                        System.out.println(TerminalColors.GREEN + "\n  ✅ The new Unit Price has been set. \n");

                                    } else if (editOption == 5) {

                                        Integer newStock;
                                        System.out.print(TerminalColors.BLUE + " #️⃣ Enter NEW Stock: ");
                                        newStock = read.nextInt();
                                        bookToEdit.put("stock", newStock);
                                        System.out.println(TerminalColors.GREEN + "\n  ✅ The new Stock has been set. \n");

                                    } else if (editOption == 6) {
                                        System.out.println(TerminalColors.YELLOW + " ↪️ Returning to main menu.");
                                    } else {
                                        System.out.println(TerminalColors.YELLOW + "\n Invalid Option ⚠️ \n");
                                    }

                                }

                            }

                        }

                    } else if (menuOption == 6) {
                        System.out.println(TerminalColors.MAGENTA + "\n Thank you for time, have a great day 👋🏼📖 \n");
                        break;
                    } else {
                        System.out.println(TerminalColors.RED + "\n Invalid Option ❌ \n");
                    }

                }

                break;

            } else if (!savedEmail.equalsIgnoreCase(typedEmail) || !savedPassword.equals(typedPassword)) {

                attemptsNumber--; // Resting the Attempts the user have left.
                System.out.println(TerminalColors.RED + "\n Invalid Credentials 💥 \n");
                System.out.println(TerminalColors.YELLOW + "\n tries Left: " + attemptsNumber + " ⚠️\n");

                // This condition breaks the loop when the user has no tries left.
                if (attemptsNumber == 0) {

                    System.out.println(TerminalColors.BACKGROUND_RED + TerminalColors.BLACK + "\n Your account has been Blocked Try again Latter 🚫\n");
                    break;

                }

            }

        }

        // Closing the Scanner as a good Practice So it doesn't use memory Space once is not necessary anymore.
        read.close();

    }
}