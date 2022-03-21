import java.util.ArrayList;
import java.util.List;

public class Student {

    // firstname, which stores the first name of a Student
    // lastname, which stores the last name of a Student
    // gpa, which stores the GPA of a Student
    // major, which stores the major of a Student
    // coursesTaken, which stores the list of courses a Student has taken. Use
    // ArrayList.

    String firstname;
    String lastname;
    Double gpa;
    Major major;
    List<Course> coursesTaken;

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.coursesTaken = new ArrayList<>();
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getInitials() {
        return "" + this.firstname.charAt(0) + "." + this.lastname.charAt(0);
    }

    public Double getGpa() {
        return this.gpa;
    }

    public void updateGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Major getMajor() {
        return this.major;
    }

    public void declareMajor(Major major) {
        this.major = major;
    }

    // This method takes a course name and returns true if this course satisfies the major requirement.
    public boolean satisfyMajor(String courseName) {
        for (Course requriedCourse : this.major.requiredCourses) {
            if (requriedCourse.getCourseName().equals(courseName)) {
                return true;
            }
        }
        return false;
    }

    // This method takes a course and returns true if the student is able to
    // register for this course. The student has to not have taken the same course
    // before and also has taken all the prerequisites of this course in order to
    // register. If the student is able to register, add the course to coursesTaken
    // and return true. Otherwise, return false.
    public boolean register(Course course) {
        if (coursesTaken.contains(course)) {
            return false;
        }
        // check that prerequisites are met
        for (Course prerequisiteCourse : course.getPrereqs()) {
            // if any prerequisites have not been taken return false
            if (!coursesTaken.contains(prerequisiteCourse)) {
                return false;
            }
        }
        coursesTaken.add(course);
        return true;

    }

    // This method returns true if this student has a gpa of at least 2.0 and has
    // taken all of the required courses of the major. Otherwise, return false.
    public boolean canYouGraduate() {
        if (gpa < 2.0) {
            return false;
        }
        for (Course course : major.requiredCourses) {
            // check that all major reqs have beeen taken
            if (!coursesTaken.contains(course)) {
                return false;
            }
        }
        return true;
    }

}