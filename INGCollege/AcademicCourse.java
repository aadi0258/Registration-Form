
/**
 * Write a description of class AcademicCourse here.
 *
 * @author (Aaditya Chaulagain)
 * @version (11+)
 * @Islington College
 */
class AcademicCourse extends Course {
    String lecturerName;
    String level;
    String credit;
    String startingDate;
    String completionDate;
    String numberOfAssessments;
    boolean isRegistered;

    public AcademicCourse(String courseID, String courseName, String duration, String level, String credit,
            String numberOfAssessments, String courseLeader, String lecturerName, String startingDate,
            String completionDate) {
        super(courseID, courseName, (duration));
        this.courseID = courseID;
        this.courseName = courseName;
        this.duration = (duration);
        this.level = level;
        this.credit = credit;
        this.numberOfAssessments = (numberOfAssessments);
        this.courseLeader = courseLeader;
        this.lecturerName = lecturerName;
        this.startingDate = startingDate;
        this.completionDate = completionDate;
    }

    // creating class constructor
    public AcademicCourse(String id, String name, String time, String levels, String credits, String assessments,
            boolean isRegistered) {
        super(id, name, time);

        level = levels;
        credit = credits;
        numberOfAssessments = assessments;
        this.lecturerName = "";
        this.startingDate = "";
        this.completionDate = "";
        this.isRegistered = false;

    }

    // Accessor method for each attribute

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getNumberOfAssessments() {
        return numberOfAssessments;
    }

    public void setNumberOfAssessments(String numberOfAssessments) {
        this.numberOfAssessments = numberOfAssessments;
    }

    // accessor method for lecturerName
    public String getLecturerName() {
        return this.lecturerName;
    }

    // accessor method for level
    public String getLevel() {
        return this.level;
    }

    // accessor method for credit
    public String getCredit() {
        return this.credit;
    }

    // accessor method for startingdate
    public String getStartingDate() {
        return this.startingDate;
    }

    // accessor method for numberOfAssessments
    public String getAssessment() {
        return this.numberOfAssessments;
    }

    // accessor method for isRegistered
    public boolean getIsRegistered() {
        return this.isRegistered;
    }

    // accessor method for lecturerName
    public void changeLecturer(String name) {
        this.lecturerName = name;
    }

    // defining Setter/Mutator for numberOfAssessments
    public void setchangeAssessments(String number) {
        this.numberOfAssessments = number;
    }

    // creting a method for registration
    public void register(String courseLeader, String lecturerName, String startingDate, String completionDate) {

        if (this.isRegistered == true) {
            System.out.println("The lecturer name is " + lecturerName);
            System.out.println("The starting date is " + startingDate);
            System.out.println("The completion date is " + completionDate);
        }

        else {
            super.setCourseLeader(courseLeader);
            this.lecturerName = lecturerName;
            this.startingDate = startingDate;
            this.completionDate = completionDate;
        }

    }

    // method to display/print data on the console
    @Override
    public void display() {
        super.display();
        if (isRegistered == true) {
            System.out.println("Lecturer name: " + this.lecturerName);
            System.out.println("Level: " + this.level);
            System.out.println("Credit: " + this.credit);
            System.out.println("Starting Date: " + this.startingDate);
            System.out.println("Completion Date: " + this.completionDate);
            System.out.println("Number of Assessments: " + this.numberOfAssessments);

        }
        System.out.println();
    }
}
