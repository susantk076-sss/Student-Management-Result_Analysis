import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class StudentManager {

    private ArrayList<Student> students;
    private HashMap<Integer, Student> studentMap;

    public StudentManager() {

        students = new ArrayList<>();
        studentMap = new HashMap<>();
    }

    // Add Student

    public boolean addStudent(Student student) {

        if (studentMap.containsKey(student.getRollNumber())) {
            return false;
        }

        students.add(student);
        studentMap.put(student.getRollNumber(), student);

        return true;
    }

    // Search Student

    public Student searchStudent(int rollNumber) {

        return studentMap.get(rollNumber);
    }

    // Delete Student

    public boolean deleteStudent(int rollNumber) {

        Student student = studentMap.remove(rollNumber);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    // Display all students

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Update Student

    public boolean updateStudent(int rollNumber,
                                 String name,
                                 int age,
                                 String course) {

        Student student = searchStudent(rollNumber);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);

        return true;
    }

    // Add Result

    public boolean addResult(int rollNumber, Result result) {

        Student student = searchStudent(rollNumber);

        if (student == null) {
            return false;
        }

        student.setResult(result);

        return true;
    }

    // Sort by Percentage

    public void sortByPercentage() {

        students.sort(new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                if (s1.getResult() == null &&
                    s2.getResult() == null) {
                    return 0;
                }

                if (s1.getResult() == null) {
                    return 1;
                }

                if (s2.getResult() == null) {
                    return -1;
                }

                return Double.compare(
                        s2.getResult().getPercentage(),
                        s1.getResult().getPercentage()
                );
            }
        });

        System.out.println("Students sorted by percentage.");
    }

    // Show Top Students

    public void showTopStudents(int n) {

        sortByPercentage();

        int count = 0;

        for (Student student : students) {

            if (student.getResult() != null) {

                System.out.println(
                    student.getRollNumber()
                    + " | "
                    + student.getName()
                    + " | "
                    + student.getResult().getPercentage()
                    + "%"
                );

                count++;

                if (count == n) {
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.println("No result available.");
        }
    }

    // Search student by name

    public void searchByName(String name) {

        boolean found = false;

        for (Student student : students) {

            if (student.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                student.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Get all students

    public ArrayList<Student> getStudents() {
        return students;
    }
}
