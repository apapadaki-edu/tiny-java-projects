// Professor's Code
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static Library lib = new Library();
    private static Scanner sc = new Scanner(System.in);

    public static void main (String [] args) {
        while (true) {
            printMenu();
            String action = sc.nextLine().strip().toLowerCase();
            switch(action) {
                case "b":
                    addBook();
                    break;
                case "j":
                    addJournal();
                    break;
                case "m":
                    addMovie();
                    break;
                case "s":
                    search();
                    break;
                case "l":
                    loanOutItem();
                    break;
                case "d":
                    downloadItem();
                    break;
                case "r":
                    returnItem();
                    break;
                case "q":
                    return;
                case "h":
                    System.out.println("##"); // autolab delimiter
                    break;
                default:
                    System.err.println("Invalid selection. Try again.");
            }
        }
    }

    /**
     *  Returns a borrowed item to the library.
     */
    private static void returnItem() {
        System.out.println("Serial number:");
        String serialNo = sc.nextLine().strip();
        if (lib.putBack(serialNo)) {
            System.out.println(serialNo + " return OK");
        }
        else {
            System.out.println(serialNo + " return NOT OK");
        }
    }

    /**
     *  Loans an item.
     */
    private static void loanOutItem() {
        System.out.println("Serial number:");
        String serialNo = sc.nextLine().strip();
        if (lib.loanOut(serialNo)) {
            System.out.println(serialNo + " loan OK");
        }
        else {
            System.out.println(serialNo + " loan NOT OK");
        }
    }

    /**
     * Searches for all items that match a given term.
     * The search is case-insensitive.
     */
    private static void search() {
        System.out.println("Search term (hit * to search for everything):");
        String term = sc.nextLine().strip();
        ArrayList<String> results = lib.search(term);
        if (results.isEmpty()) {
            System.out.println("No results for \"" + term +"\"");
        }
        Collections.sort(results);
        for (String item : results) {
            System.out.println(item);
        }
    }

    /**
     * Downloads an item, if possible.
     */
    private static void downloadItem() {
        System.out.println("Serial number:");
        String serialNo = sc.nextLine().strip();
        String link = lib.download(serialNo);
        System.out.println("link: " + link);
    }

    /**
     * Adds a movie to the library.
     */
    private static void addMovie() {
        System.out.println("Serial number:");
        String serialNo = sc.nextLine().strip();
        System.out.println("Title:");
        String title = sc.nextLine().strip();
        System.out.println("Year:");
        int year = sc.nextInt();
        sc.nextLine(); // eat up the newline
        Movie newMovie = new Movie(year, serialNo, title);
        lib.addItem(newMovie);
        System.out.println("\"" + serialNo + "\" movie added.");
    }

    /**
     * Adds a journal to the library.
     */
    private static void addJournal() {
        System.out.println("Serial number:");
        String serialNo = sc.nextLine().strip();
        System.out.println("Title:");
        String title = sc.nextLine().strip();
        System.out.println("Editor:");
        String editor = sc.nextLine().strip();
        System.out.println("Volume:");
        int volume = sc.nextInt();
        System.out.println("Issue:");
        int issue = sc.nextInt();
        sc.nextLine(); // eat up the newline
        Journal newJournal = new Journal(editor, volume, issue, serialNo, title);
        lib.addItem(newJournal);
        System.out.println("\"" + serialNo + "\" journal added.");
    }

    /**
     * Adds a book to the library.
     */
    private static void addBook() {
        System.out.println("Serial number:");
        String serialNo = sc.nextLine().strip();
        System.out.println("Title:");
        String title = sc.nextLine().strip();
        System.out.println("Main author:");
        String author = sc.nextLine().strip();
        ArrayList<String> authors = new ArrayList<>();
        do {
            authors.add(author);
            System.out.println("Other author (hit Enter if none):");
            author = sc.nextLine().strip();
        } while (!author.equals(""));
        Book newBook = new Book(authors, serialNo, title);
        lib.addItem(newBook);
        System.out.println("\"" + serialNo + "\" book added.");
    }

    /**
     * Prints the main menu.
     */
    public static void printMenu() {
        System.out.println("\n-----");
        System.out.println("Add [b]ook");
        System.out.println("Add [m]ovie");
        System.out.println("Add [j]ournal");
        System.out.println("[S]earch for item");
        System.out.println("[L]oan item");
        System.out.println("[D]ownload item");
        System.out.println("[R]eturn item");
        System.out.println("[Q]uit");
    }

}
