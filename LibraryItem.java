import java.util.Objects;

/**
 * <code>LibraryItem</code> is the abstract base class of all library items.
 *
 * <p>
 * A <code>LibraryItem</code> object encapsulates all the information that describe
 * the state of an item in the library at any given time. These include:
 * <ul>
 *     <li>The total number of copies of it registered in the library
 *     <li>The total number of copies of it currently available for loan
 * </ul>
 * The class additionally provides operations that allow the update of an item's state.
 */
public abstract class LibraryItem {
    private int totalCopies;
    private int availForLoan;
    private final String serialNumber;
    private final String title;

    /**
     * Constructs a new item with the specified serial number and title.
     * <p>
     * The constructor also sets the state of the new item in the library,
     * by initializing the total number of copies and the number of those
     * available for loan to one.
     *
     * There are no case restrictions set for the serial number and title arguments.
     *
     * @param serialNumber  the item's serial number
     * @param title         the item's title
     */
    public LibraryItem(String serialNumber, String title){
        this.serialNumber = serialNumber;
        this.title = title;
        totalCopies = 1;
        availForLoan = 1;
    }

    /**
     * Returns the serial number of this library item,
     * as was defined by the time of its construction.
     *
     * @return this item's serial number
     */
    public String getSerialNumber(){
        return serialNumber;
    }

    /**
     * Adds a new copy of this item in the library.
     * The new copy is also added to those available for loan.
     */
    public void getsAdded(){
        ++totalCopies;
        ++availForLoan;
    }

    /**
     * Determines if this item has an available copy for loan.
     * <p>
     * In case a copy is free, the method decrements the total number of copies
     * that are loan available by one, otherwise no additional action is taken.
     *
     * @return  true if a copy is available for loan, false otherwise
     */
    public boolean isLoaned(){
        if (availForLoan == 0){
            return false;
        }
        --availForLoan;
        return true;
    }

    /**
     * Determines if a loaned copy of this item is successfully returned.
     * <p>
     * If the return carries trough, the method increments the total
     * number of loan available copies by one.
     *
     * @return  true if the return was successful, false otherwise
     */
    public boolean isReturned(){
        if (availForLoan == totalCopies){
            return false;
        }
        ++availForLoan;
        return true;
    }

    /**
     * Checks if this Item's title contains the given term.
     * <p>
     * If the given term is character '*', this library item is always a match.
     * @param term  term to be searched for in this Item's title
     * @return  true if the specified term is found
     */
    protected boolean search(String term){
        return title.toUpperCase().contains(term)
                || term.equals("*");
    }

    /**
     *Generates a string representation for this Library Item.
     * <p>
     * Form: (availForLoan/totalCopies) SerialNumber, "Title"
     * @return a string representing this Library Item
     */
    @Override
    public String toString() {
        return "(" + availForLoan + "/" + totalCopies +
                ") " + serialNumber.toUpperCase() + ", \"" +
                title.toUpperCase() + "\"";
    }

    /**
     * Compares this Library Item with another for equality.
     * <p>
     * Two Library items are considered to be equal,
     * if they have the same serial number.
     * @param otherItem  an other Library Item to be checked for equality with this Library Item
     * @return  true if the two items have the same serial number
     */
    @Override
    public boolean equals(Object otherItem) {
        if (this == otherItem) return true;
        if (otherItem == null || getClass() != otherItem.getClass()) return false;
        LibraryItem that = (LibraryItem) otherItem;
        return Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

}
