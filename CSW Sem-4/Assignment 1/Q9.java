// Interface defining methods for enrollment system
interface EnrollmentSystem {
    void enrollStudent(Student student, Course course);
    void dropStudent(Student student, Course course);
    void displayEnrollmentDetails();
}

// Student class representing a student
class Student {
    private String studentId;
    private String studentName;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
}

// Course class representing a course
class Course {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}

// Enrollment class managing student enrollment in courses
class Enrollment implements EnrollmentSystem {
    private List<Student> enrolledStudents;
    private List<Course> enrolledCourses;

    public Enrollment() {
        this.enrolledStudents = new ArrayList<>();
        this.enrolledCourses = new ArrayList<>();
    }

    @Override
    public void enrollStudent(Student student, Course course) {
        enrolledStudents.add(student);
        enrolledCourses.add(course);
        System.out.println(student.getStudentName() + " enrolled in " + course.getCourseName());
    }

    @Override
    public void dropStudent(Student student, Course course) {
        int index = enrolledStudents.indexOf(student);
        if (index != -1 && enrolledCourses.get(index).equals(course)) {
            enrolledStudents.remove(index);
            enrolledCourses.remove(index);
            System.out.println(student.getStudentName() + " dropped from " + course.getCourseName());
        } else {
            System.out.println("Error: Student is not enrolled in the specified course");
        }
    }

    @Override
    public void displayEnrollmentDetails() {
        System.out.println("Enrollment Details:");
        for (int i = 0; i < enrolledStudents.size(); i++) {
            System.out.println("Student: " + enrolledStudents.get(i).getStudentName() +
                    ", Course: " + enrolledCourses.get(i).getCourseName());
        }
    }
}

// Main class to demonstrate the system's functionality
public class Main {
    public static void main(String[] args) {
        EnrollmentSystem enrollmentSystem = new Enrollment();

        // Creating sample students and courses
        Student student1 = new Student("101", "Alice");
        Student student2 = new Student("102", "Bob");
        Course course1 = new Course("CSC101", "Introduction to Computer Science");
        Course course2 = new Course("MAT201", "Calculus");

        // Enrolling students in courses
        enrollmentSystem.enrollStudent(student1, course1);
        enrollmentSystem.enrollStudent(student2, course2);

        // Displaying enrollment details
        enrollmentSystem.displayEnrollmentDetails();

        // Dropping a student from a course
        enrollmentSystem.dropStudent(student1, course1);

        // Displaying updated enrollment details
        enrollmentSystem.displayEnrollmentDetails();
    }
}
