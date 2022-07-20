
/**
 * Write a description of class NonAcademicCourse here.
 *
 * @author (Aaditya Chaulagain)
 * @version (11+)
 * @Islington College
 */

public class NonAcademicCourse extends Course {
    String instructorName;
    String startDate;
    String completionDate;
    String examDate;
    String preRequisite;
    boolean isRegistered;
    boolean isRemoved;

    String courseID2, courseName2, duration2, prerequisite, courseLeader2, startingDate2, completionDate2;

    public NonAcademicCourse(String courseID2, String courseName2, String duration2, String prerequisite,
            String courseLeader2, String startingDate2, String instructorName, String completionDate2) {
        super(courseID2, courseName2, duration2);
        this.courseID2 = courseID2;
        this.courseName2 = courseName2;
        this.duration2 = duration2;
        this.prerequisite = prerequisite;
        this.courseLeader2 = courseLeader2;
        this.startingDate2 = startingDate2;
        this.instructorName = instructorName;
        this.completionDate2 = completionDate2;

    }

    // A constructor for NonAcademicCourse
    public NonAcademicCourse(String id, String name, String duration, String preRequisite) {
        super(id, name, duration);
        this.preRequisite = preRequisite;
        this.startDate = "";
        this.completionDate = "";
        this.examDate = "";
        this.isRegistered = false;
        this.isRemoved = true;
    }

    // Accessor method for each attribute

    // Accessor method for instructorName
    public String getInstructorName() {
        return this.instructorName;
    }

    // Accessor method for startDate
    public String getStartDate() {
        return this.startDate;
    }

    // Accessor method for completionDate
    public String getCompletionDate() {
        return this.completionDate;
    }

    // Accessor method for examDate
    public String getExamDate() {
        return this.examDate;
    }

    // Accessor method for preRequisite
    public String getPreRequisite() {
        return this.preRequisite;
    }

    // Accessor method for isRegistered
    public boolean getIsRegistered() {
        return this.isRegistered;
    }

    // Accessor method for isRemoved
    public boolean getIsRemoved() {
        return this.isRemoved;
    }

    // Creating a method to set the Instructor
    public void setInstructor(String instructorName) {
        if (isRegistered == false) {
            this.instructorName = instructorName;
        } else
            System.out.println("The instructor name has been set to: " + this.instructorName);
    }

    // Creating a method to register a new course
    public void register(String courseLeader, String instructorName, String startDate, String completionDate,
            String examDate) {
        if (isRegistered == true) {
            System.out.println("The Non-Academic course has already been registered with: ");
            System.out.println("Instructor is: " + this.instructorName);
            System.out.println("Starting Date is: " + this.startDate);
            System.out.println("Completion Date is: " + this.completionDate);
        } else {
            setInstructor(instructorName);
            super.setCourseLeader(courseLeader);

            this.startDate = startDate;
            this.completionDate = completionDate;
            this.examDate = examDate;
        }
    }

    // Creating a method to remove an existing course
    public void remove() {
        if (isRemoved == true) {
            System.out.println("The course does not exists.");
        } else {
            super.setCourseLeader("");
            instructorName = ("");
            startDate = ("");
            completionDate = ("");
            examDate = ("");

            isRegistered = false;
        }
        System.out.println();
    }

    // Creating a method to display the attribute values
    @Override
    public void display() {
        super.display();

        if (isRegistered == true) {
            System.out.println("The Instructor name is " + this.instructorName);
            System.out.println("The Starting Date is " + this.startDate);
            System.out.println("The Completion Date is " + this.completionDate);
            System.out.println("The Exam Date is " + this.examDate);

        }
        System.out.println();
    }
}
