
import java.util.Objects;

public class Earthquake {
    private final Location epicenter;
    private double magnitude;
    private final double depth;
    private final Date date;

    // constructs an Earthquake with the specified epicenter, magnitude, depth and date
    public Earthquake(Location epicenter, double magnitude, double depth, Date date){
        this.epicenter = epicenter;
        this.magnitude = magnitude;
        this.depth = depth;
        this.date = date;
    }

    // constructs an Earthquake with the specified epicenter's lat and lot, magnitude, depth and date
    public Earthquake(double lat, double lon, double magnitude, double depth, Date date){
        this(new Location(lat, lon), magnitude, depth, date);
    }

    // returns the this Earthquake's epicenter
    public Location getEpicenter() {
        return epicenter;
    }

    // returns this Earthquake's magnitude
    public double getMagnitude() {
        return magnitude;
    }

    // returns this Earthquake's depth
    public double getDepth() {
        return depth;
    }

    // returns this Earthquake's date
    public Date getDate() {
        return date;
    }

    // sets this Earthquake's magnitude to the specified value
    public void updateMagnitude(double newMagnitude){
        magnitude = newMagnitude;
    }

    // returns a string representation of this object's values, with the format
    // "date, epicenter, depth{km}, {M}magnitude"
    @Override
    public String toString() {
        return String.format("%s, %s, %3.1fkm, M%3.1f", date, epicenter, depth, magnitude);
    }

    // checks the specified object with this earthquake object for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Earthquake quake = (Earthquake) o;
        return magnitude == quake.magnitude && depth == quake.depth
                && epicenter.equals(quake.epicenter) && date.equals(quake.date);
    }

    // returns the hash code value for this location
    @Override
    public int hashCode() {
        return Objects.hash(epicenter, magnitude, depth, date);
    }
}

