
/**
 * Super Class Course
 *
 * @author (Aaditya Chaulagain)
 * @version (11+)
 * @Islington College
 */
public class Course {
    // defining attributes of the class
    String courseID;
    String courseName;
    String courseLeader;
    String duration;

    public Course(String courseID, String courseName, String courseLeader, String duration) {
        this.courseID = courseID;
        this.duration = duration;
        this.courseName = courseName;
        this.courseLeader = courseLeader;
    }

    // creating class constructor
    public Course(String id, String name, String time) {
        courseID = id;
        courseName = name;
        this.courseLeader = "";
        duration = time;
    }

    // Defining accessor/getter methods

    // getter for courseID
    public String getCourseID() {
        return this.courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    // getter for courseName
    public String getCourseName() {
        return this.courseName;
    }

    // getter for courseLeader
    public String getCourseLeader() {
        return this.courseLeader;
    }

    // getter for duration
    public String getDuration() {
        return this.duration;
    }

    // Defining Setter/Mutator for courseLeader
    public void setCourseLeader(String courseLeader) {
        this.courseLeader = courseLeader;
    }

    // creating display method to print data on the console
    public void display() {
        System.out.println("The courseID is " + courseID);
        System.out.println("The course name is " + courseName);
        System.out.println("The duration is " + duration + " months");

        // Display info only if courseLeader is not an empty string.
        if (this.courseLeader.equals("") == false) {
            System.out.println("The Course Leader is " + courseLeader);
        }
        System.out.println();
    }
}
