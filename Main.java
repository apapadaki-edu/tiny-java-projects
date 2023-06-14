
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        EarthquakeDB db = new EarthquakeDB();  // creates a new earthquake database object

        // populates the database
        db.add(new Earthquake(39.7, 22.1, 2.6, 2,
                new Date(2021,2,10,13,45,57)));
        db.add(new Earthquake(38.7, 20.5, 4.2, 6,
                new Date(2021,2,10,14,50,13)));
        db.add(new Earthquake(39.1, 21.5, 3.2, 6,
                new Date(2021,2,11,18,19,13)));
        db.add(new Earthquake(38.5, 21.1, 3, 2,
                new Date(2021,2,10, 14)));
        db.add(new Earthquake(38.5, 20.8, 4, 8,
                new Date(2021,2,12,5,30,0)));


        System.out.println(db);
        System.out.println("##");
        // Creates lists comprised from earthquakes that fall within date, magnitudes range
        // and distance from the specified values, respectively
        ArrayList<Earthquake> withinDay = db.withinDay(new Date(2021, 2, 10));
        ArrayList<Earthquake> withinMagnitudeRange = db.withinMagnitudeRange(2.9, 4.5);
        ArrayList<Earthquake> withinDistance = db.withinDistance(new Location(38.5, 21.1), 60);

        //finds the earthquakes that are elements of all of the above lists
        // and adds them in a newly created ArrayList Object
        EarthquakeDB dbIntersection = new EarthquakeDB();
        for(Earthquake quake: withinDay){
            if (withinDistance.contains(quake) && withinMagnitudeRange.contains(quake)){
                dbIntersection.add(quake);
            }
        }
        System.out.println(dbIntersection);
    }
}
