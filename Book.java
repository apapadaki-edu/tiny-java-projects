import java.util.ArrayList;
/**
 * Represents a Book in the Library.
 * <p>
 * As a Library item, it is characterizes by a unique serial number.
 * Multiple copies of the same Book can be stored in the Library.
 * <p>
 * Only printed copies of a book can be loaned.
 * Consequently, there are no download links for books in the library's web page.
 */
public class Book extends LibraryItem{
    private final ArrayList<String> authors;

    /**
     * Creates a new Book registry with the given authors list, serial number and title.
     * @param authors   this book's list of authors' first and last names
     * @param serialNumber  this books serial number, as registered in the library
     * @param title     this books title
     */
    public Book(ArrayList<String> authors, String serialNumber, String title){
        super(serialNumber, title);
        this.authors = new ArrayList<String>();     // in order to avoid passing references
        this.authors.addAll(authors);
    }

    /**
     * Checks if this book's title or any of its author names, contain the given term.
     * <p>
     * If the given term is character '*', this Book is always a match.
     * @param term  term to be searched for in this Book's title or in any of its author's names
     * @return  true if the specified term is found
     */
    @Override
    public boolean search(String term) {
        boolean isContained = super.search(term);
        for(String author: authors){
            isContained |= author.toUpperCase().contains(term);
        }
        return isContained;
    }

    /**
     * Generates a string representation for this Book.
     * <p>
     * Form: (availForLoan/totalCopies) SerialNumber, "Title" by author, author, ...
     * @return a string representing this Book
     */
    @Override
    public String toString() {
        String str = super.toString() + " by ";
        for (String author: authors){
            str += author.toUpperCase() + ", ";
        }
        return str += "-";
    }
}
