
import java.util.Objects;


public class Date {
    private final int year, month, day, hours, minutes, seconds;

    // constructs a date with the specified values for all fields
    public Date(int year, int month, int day, int hours, int minutes, int seconds){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /* constructs a date with the specified year, month, day and hours fields
       and grounds the minutes and seconds fields to zero */
    public Date(int year, int month, int day, int hours){
        this(year, month, day, hours, 0, 0);
    }

    /* constructs a date with the specified year, month and day
       grounds hours, minutes, seconds to zero */
    public Date(int year, int month, int day){
        this(year, month, day, 0, 0, 0);
    }


    //returns the year of the constructed date object
    public int getYear() {
        return year;
    }

    //returns the value of the month field of the date object
    public int getMonth() {
        return month;
    }

    //returns the day
    public int getDay() {
        return day;
    }

    //returns the hour
    public int getHour() {
        return hours;
    }

    //returns the minutes
    public int getMinute() {
        return minutes;
    }

    //returns the seconds
    public int getSecond() {
        return seconds;
    }

    // returns a string representation of the date fields's values in the format
    // "year-month-day, hours:minutes:seconds"
    @Override
    public String toString() {
        return String.format("%d-%02d-%02d, %02d:%02d:%02d", year, month, day, hours, minutes, seconds);
    }

    // checks the specified object with this date object for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return year == date.year && month == date.month && day == date.day &&
                hours == date.hours && minutes == date.minutes && seconds == date.seconds;
    }

    // returns the hash code value for this date
    @Override
    public int hashCode() {
        return Objects.hash(year, month, day, hours, minutes, seconds);
    }

}
