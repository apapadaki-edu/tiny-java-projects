/**
 * Represents a Journal in the Library.
 * <p>
 * It is characterized by a unique serial number. <br>
 * Multiple copies of the same Journal can be stored in the Library.
 * <p>
 * A Journal is available in digital form and a link for downloading a copy can
 * be provided upon request.
 */
public class Journal extends LibraryItem implements Downloadable{
    private final String publisher;
    private final int volume;
    private final int issue;

    /**
     * Creates a Journal registry with the specified publisher, volume,
     * issue, serialNumber and title.
     *
     * @param publisher   this Journal's publisher
     * @param volume      this Journal's volume
     * @param issue       this Journal's issue
     * @param serialNumber  this Journal's serial number
     * @param title         this Journal's title
     */
    public Journal(String publisher, int volume, int issue,
                   String serialNumber, String title){
        super(serialNumber, title);
        this.publisher = publisher;
        this.volume = volume;
        this.issue = issue;
    }

    /**
     * Checks if this Journal's title or publisher contain the given term.
     * <p>
     * If the given term is character '*', this Journal is always a match.
     *
     * @param term  term to be searched for in this Journal's title or its publisher
     * @return  true if the specified term is found
     */
    @Override
    public boolean search(String term) {
        return super.search(term) || publisher.toUpperCase().contains(term);
    }

    /**
     * Provides a url for downloading a digital copy of this Journal.
     * @see  Downloadable
     *
     * @return the absolute url for this Journal
     */
    @Override
    public String download(){
        return libUrl + "mag?serial=" + this.getSerialNumber().toUpperCase() +
                "&volume=" + volume + "&issue=" + issue;
    }

    /**
     * Generates a string representation for this Journal.
     * <p>
     * Form: (availForLoan/totalCopies) SerialNumber, "Title" publisher, volume #issue
     * @return a string representing this Journal
     */
    @Override
    public String toString() {
        return super.toString() + " " + publisher.toUpperCase() +
                ", " + volume + " #" + issue ;
    }
}
