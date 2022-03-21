import java.util.ArrayList;
import java.util.List;

public class Major {
    // majorName, which stores the name of this Major
    // requiredCourses, which stores a list of required Courses. Use an array (Each
    // element should be a Course object.)

    // Constructors
    // Write a constructor that takes the name of a major and a number of required
    // courses N, and create an array of N Courses for requiredCourses.

    String majorName;
    Course[] requiredCourses;

    public String getMajorName() {
        return this.majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Major(String majorName, Integer numberOfRequiredCourses) {
        this.majorName = majorName;
        this.requiredCourses = new Course[numberOfRequiredCourses];
    }

    public boolean addCourse(Course course) {

        for (int i = 0; i < requiredCourses.length; i++) {
        if (requiredCourses[i] != null && requiredCourses[i].equals(course)) {
                return false;
            }
            if (requiredCourses[i] == null) {
                requiredCourses[i] = course;
                return true;
            }

        }
        return false;
    }


    @Override
    public String toString() {
        System.out.println(String.format("List of required courses for %s:", this.majorName));
        for (Course course : requiredCourses) {
            System.out.println(String.format("  %s:", course.toString()));
        }

        return super.toString();
    }

// This method returns a formatted String with all information about a Major in the following format:

// List of required courses for Economics: 
// 	ECON301: Environmental Economics and Policy (Prerequisites: ECON101)
// 	ECON340: Behavioral Economics (Prerequisites: none)
// 	ECON101: Principles of Economics I (Prerequisites: none)
// 	ECON305: Game Theory (Prerequisites: ECON301)


}
