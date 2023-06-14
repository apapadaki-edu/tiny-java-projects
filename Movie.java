
/**
 * Represents a Movie in the Library.
 * <p>
 * It is characterized by a unique serial number.<br>
 * Multiple copies of the same Movie can be stored in the Library.
 * <p>
 * A Movie is available in digital form and a link for downloading a copy can
 * be provided upon request.
 */
public class Movie extends LibraryItem implements Downloadable{
    private final int releaseYear;

    /**
     * Creates a new Movie registry with the given release year, serial number and title
     * @param releaseYear  this Movie's year of release
     * @param serialNumber this Movie's serial number
     * @param title this movies title
     */
    public Movie(int releaseYear, String serialNumber, String title){
        super(serialNumber, title);
        this.releaseYear = releaseYear;
    }

    /**
     * Provides a url for downloading a digital copy of this Movie.
     * @see  Downloadable
     *
     * @return the absolute url for this Movie
     */
    @Override
    public String download(){
        return libUrl + "movie?serial=" + this.getSerialNumber().toUpperCase() +
                "&year="  + releaseYear;
    }

    /**
     *Generates a string representation for this Movie.
     * <p>
     * Form: (availForLoan/totalCopies) SerialNumber, "Title" (releaseYear)
     * @return a string representing this Movie
     */
    @Override
    public String toString() {
        return super.toString() + " (" + releaseYear + ")";
    }
}
