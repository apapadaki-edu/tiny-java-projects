
import java.util.Objects;

public class Location {
    private final double lat, lon;

    // Constructs a location object with the specified lat and lon values
    public Location(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }

    // returns the latitude of this object
    public double getLatitude() {
        return lat;
    }

    // returns the longitude
    public double getLongitude(){
        return lon;
    }

    // returns the distance (double) between the specified location and this one
    public double distanceFrom(Location otherLoc){
        int earthRadius = 6371;
        // helper variables to avoid confusion
        double lat1 = Math.toRadians(otherLoc.getLatitude());
        double lon1 = Math.toRadians(otherLoc.getLongitude());
        double lat2 = Math.toRadians(lat);
        double lon2 = Math.toRadians(lon);
        double base = Math.pow(Math.sin((lat2 - lat1)/2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin((lon2 - lon1)/2), 2);

        return 2 * earthRadius * Math.asin(Math.sqrt(base));
    }

    // returns a string representation of the this objects values, with the format
    // "[ lat, lon]"
    @Override
    public String toString() {
        return "[" + lat + ", " + lon + "]";
    }

    // checks the specified object with this location object for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return lat == location.lat && lon == location.lon;
    }

    // returns the hash code value for this location
    @Override
    public int hashCode() {
        return Objects.hash(lat, lon);
    }
}
