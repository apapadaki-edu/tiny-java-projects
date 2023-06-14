/**
 * Describes items that can be downloaded from the library's main page.
 *
 *<p>
 * Downloadable items can be found in digital form. <br>
 * A specific url is provided for each one available. <br>
 * There is an unlimited number of digital copies in supply
 * for Downloadable Items.
 */
public interface Downloadable {
    /**
     * The library's main page url
     */
    public static final String libUrl = "https://projectlibrary.net/";

    /**
     * Provides a download link for a library item that has digital copies.
     * @return  the absolute url in string format.
     */
    public String download();
}
