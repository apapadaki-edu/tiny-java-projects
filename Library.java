import java.util.ArrayList;

/**
 * Comprises the main Database for all Items in the Library.
 * Items that can be found currently are:
 * <ul>
 *     <li> Books (only physical copies)
 *     <li> Journals (physical and digital copies)
 *     <li> Movies (physical and digital copies)
 * </ul>
 * <p>
 * There is a limited number of physical copies available for all three current categories.
 * However, there is an unlimited number of digital copies for those having downloadable items.
 */
public class Library {
    private final ArrayList<LibraryItem> libraryItemsList;

    /**
     * Creates an new empty Library.
     */
    public Library(){
        libraryItemsList = new ArrayList<LibraryItem>();
    }

    /**
     * Registers a new item in the Database.
     * <p>
     * The new item must belong to the categories
     * supported by the library at the time of addition.<br>
     * If the specified item already exists in the library,
     * the number of its copies is increased by one.
     *
     * @param newItem the library item to be added in the library
     */
    public void addItem(LibraryItem newItem){
        for(LibraryItem itemInLib: libraryItemsList) {
            if (itemInLib.equals(newItem)) {
                itemInLib.getsAdded();
                return;
            }
        }
        libraryItemsList.add(newItem);
    }

    /**
     * Determines if there is a copy of the item with the given serial number
     * available for load and carries trough with the rent accordingly.
     *
     * @param serialNo  the serial number of the item to be loaned
     * @return  thue if the loan is successful
     */
    public boolean loanOut(String serialNo){
        for (LibraryItem itemInLib: libraryItemsList){
            if(itemInLib.getSerialNumber().equals(serialNo)) {
                return itemInLib.isLoaned();
            }
        }
        return false;
    }

    /**
     * Determines if the return of the item with the specified serial
     * number is properly performed.
     * <p>
     * In case the total number of copies stored in the library
     * at the time of return is already at its maximum, the return fails.
     *
     * @param serialNo  the serial number of the item to be returned
     * @return  true if the return is successful
     */
    public boolean putBack(String serialNo){
        for (LibraryItem itemInLib: libraryItemsList) {
            if(itemInLib.getSerialNumber().equals(serialNo)){
                return itemInLib.isReturned();
            }
        }
        return false;
    }

    /**
     * Searches all the items present which contain the specified term.
     * <p>
     * If the term given is character '*', all library items are returned.<br>
     * The search is performed accordingly for every item category.<br>
     * @see Movie#search(String term)
     * @see Book#search(String term)
     * @see Journal#search(String term)
     *
     * @param term the term to be searched for
     * @return a list of all the items which matched the search term
     */
    public ArrayList<String> search(String term) {
        ArrayList<String> results = new ArrayList<>();
        term = term.toUpperCase();
        for (LibraryItem item : libraryItemsList) {
            if (item.search(term)) {
                results.add(item.toString());
            }
        }
        return results;
    }

    /**
     * Provides a download url for the library item with the specified serial number.
     * <p>
     * For those item categories that do not possess digital copies,<br>
     * a url is provided notifying the users of that fact. <br>
     * For requested items not registered in the database, a not found page url is returned.
     *
     * @param serialNumber the serial number of the requested item
     * @return  the download url of the requested item
     */
    public String download(String serialNumber) {
        for (LibraryItem item: libraryItemsList){
            if (item.getSerialNumber().equalsIgnoreCase(serialNumber)){
                if (item instanceof Downloadable) {
                    return ((Downloadable) item).download();
                }
                return "https://projectlibrary.net/noDL.html";
            }
        }
        return "https://projectlibrary.net/404.html";
    }

}
