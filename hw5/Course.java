import java.util.ArrayList;
import java.util.List;

public class Course {

    String department;
    String courseId;
    String courseName;
    List<Course> prereqs;

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Course> getPrereqs() {
        return this.prereqs;
    }

    public void setPrereqs(List<Course> prereqs) {
        this.prereqs = prereqs;
    }

    public Course(String department, String courseId, String courseName) {
        this.department = department;
        this.courseId = courseId;
        this.courseName = courseName;
        this.prereqs = new ArrayList<>();
    }

    @Override
    public String toString() {
        if (prereqs.isEmpty()) {
            return String.format("%s: %s (Prerequisites: none)", courseId, courseName);

        }
        String prereqString = "";
        for (Course course : prereqs) {
            prereqString += " " + course.toString();
        }
        return String.format("%s: %s (Prerequisites: none)", courseId, courseName, prereqString);
    }

    public void addPrereq(Course course) {
        this.prereqs.add(course);
    }

    public boolean isPrereq(Course course) {
        return this.prereqs.contains(course);
    }
}
