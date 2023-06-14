
import java.util.ArrayList;

public class EarthquakeDB {
    private final ArrayList<Earthquake> quakeList;

    //Constructs an empty EarthquakeDatabase object
    public EarthquakeDB() {
        this.quakeList = new ArrayList<Earthquake>();
    }

    // Inserts the specified earthquake element to the end of the database and returns True
    // if the element already exists it returns false
    public boolean add(Earthquake quake) {
        if (quakeList.contains(quake)) {
            return false;
        }
        quakeList.add(quake);
        return true;
    }

    // Returns a list of all the earthquakes in the database that are within the specified radius
    // from the specified location
    public ArrayList<Earthquake> withinDistance(Location loc, double radius) {
        ArrayList<Earthquake> withinDistList = new ArrayList<Earthquake>();
        for (Earthquake quake : quakeList) {
            if (quake.getEpicenter().distanceFrom(loc) < radius) {
                withinDistList.add(quake);
            }
        }
        return withinDistList;
    }

    // Returns a list of all the earthquakes in the database that hava magnitude within the range
    // of the specified min and max values
    public ArrayList<Earthquake> withinMagnitudeRange(double minMagn, double maxMagn) {
        ArrayList<Earthquake> withinRangeList = new ArrayList<Earthquake>();
        for (Earthquake quake : quakeList) {
            if (quake.getMagnitude() > minMagn && quake.getMagnitude() < maxMagn) {
                withinRangeList.add(quake);
            }
        }
        return withinRangeList;
    }

    // Returns a list of all the earthquakes in the database that have the same year,
    // month and date with the specified date
    public ArrayList<Earthquake> withinDay(Date date) {
        ArrayList<Earthquake> withinDateList = new ArrayList<Earthquake>();
        for (Earthquake quake : quakeList) {
            if (quake.getDate().getYear() == date.getYear()
                    && quake.getDate().getMonth() == date.getMonth()
                    && quake.getDate().getDay() == date.getDay()) {
                withinDateList.add(quake);
            }
        }
        return withinDateList;
    }

    // Returns the average magnitude of the earthquakes in the database, or zero for an empty db
    public double getAverageMagnitude() {
        if (quakeList.isEmpty()) {
            return 0;
        }
        double magnitudeSum = 0;
        for (Earthquake quake : quakeList) {
            magnitudeSum += quake.getMagnitude();
        }
        return  magnitudeSum / (double) quakeList.size();
    }

    // Returns the median magnitude of the earthquakes in the database, or zero for an empty db
    public double getMedianMagnitude() {
        if (quakeList.isEmpty()) {
            return 0;
        }
        // to find the median, the list must be sorted by magnitude
        quakeList.sort(java.util.Comparator.comparingDouble(Earthquake::getMagnitude));
        int middle;

        // for odd numbered lists, median = the (n + 1)/2 element
        if (quakeList.size() % 2 != 0) {
            middle = (quakeList.size()) / 2; // indexing starts from zero => n = size - 1
            return quakeList.get(middle).getMagnitude();
        }
        // for even numbered, median = mean magnitude of (n/2) and (n/2 + 1) elements
        middle = (quakeList.size() - 1)/ 2;  // n = size - 1
        return (quakeList.get(middle).getMagnitude()
                + quakeList.get(++middle).getMagnitude()) / 2;
    }

    // Returns the maximum magnitude of the earthquakes in the database
    public double getMaxMagnitude() {
        double maxMagnitude = 0;
        for (Earthquake quake : quakeList) {     // first earthquake in the arrayList
            if (quake.getMagnitude() > maxMagnitude) {
                maxMagnitude = quake.getMagnitude();
            }
        }
        return maxMagnitude;
    }

    //returns a string representation of this object's values in the format
    // "1. earthquake\n 2. earthquake\n etc."
    @Override
    public String toString() {
        quakeList.sort(java.util.Comparator.comparingDouble(Earthquake::getMagnitude));
        String str = "";
        int count = 1;
        for(Earthquake quake: quakeList){
            str += String.format("%d. %s\n", count++, quake);
        }
        return str;
    }
}

