import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        // Load existing students

        ArrayList<Student> loadedStudents =
                FileManager.loadStudents();

        for (Student student : loadedStudents) {
            manager.addStudent(student);
        }

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Search Student By Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Add Result");
            System.out.println("8. Show Top Students");
            System.out.println("9. Sort By Percentage");
            System.out.println("10. Save Data");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");

            try {

                choice = sc.nextInt();

            } catch (Exception e) {

                System.out.println("Invalid input.");

                sc.nextLine();

                choice = -1;
            }

            switch (choice) {

                // ADD STUDENT

                case 1:

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student student =
                            new Student(
                                roll,
                                name,
                                age,
                                course
                            );

                    if (manager.addStudent(student)) {

                        System.out.println(
                            "Student added successfully."
                        );

                    } else {

                        System.out.println(
                            "Roll number already exists."
                        );
                    }

                    break;


                // VIEW STUDENTS

                case 2:

                    manager.displayAllStudents();

                    break;


                // SEARCH STUDENT

                case 3:

                    System.out.print(
                        "Enter Roll Number: "
                    );

                    int searchRoll = sc.nextInt();

                    Student found =
                            manager.searchStudent(searchRoll);

                    if (found != null) {

                        found.displayStudent();

                    } else {

                        System.out.println(
                            "Student not found."
                        );
                    }

                    break;


                // SEARCH BY NAME

                case 4:

                    sc.nextLine();

                    System.out.print(
                        "Enter student name: "
                    );

                    String searchName =
                            sc.nextLine();

                    manager.searchByName(searchName);

                    break;


                // UPDATE

                case 5:

                    System.out.print(
                        "Enter Roll Number: "
                    );

                    int updateRoll =
                            sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                        "Enter New Name: "
                    );

                    String newName =
                            sc.nextLine();

                    System.out.print(
                        "Enter New Age: "
                    );

                    int newAge =
                            sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                        "Enter New Course: "
                    );

                    String newCourse =
                            sc.nextLine();

                    if (manager.updateStudent(
                            updateRoll,
                            newName,
                            newAge,
                            newCourse)) {

                        System.out.println(
                            "Student updated successfully."
                        );

                    } else {

                        System.out.println(
                            "Student not found."
                        );
                    }

                    break;


                // DELETE

                case 6:

                    System.out.print(
                        "Enter Roll Number: "
                    );

                    int deleteRoll =
                            sc.nextInt();

                    if (manager.deleteStudent(deleteRoll)) {

                        System.out.println(
                            "Student deleted successfully."
                        );

                    } else {

                        System.out.println(
                            "Student not found."
                        );
                    }

                    break;


                // ADD RESULT

                case 7:

                    System.out.print(
                        "Enter Roll Number: "
                    );

                    int resultRoll =
                            sc.nextInt();

                    System.out.print(
                        "Java Marks: "
                    );

                    int java =
                            sc.nextInt();

                    System.out.print(
                        "DSA Marks: "
                    );

                    int dsa =
                            sc.nextInt();

                    System.out.print(
                        "DBMS Marks: "
                    );

                    int dbms =
                            sc.nextInt();

                    System.out.print(
                        "Python Marks: "
                    );

                    int python =
                            sc.nextInt();

                    System.out.print(
                        "Computer Networks Marks: "
                    );

                    int cn =
                            sc.nextInt();

                    Result result =
                            new Result(
                                java,
                                dsa,
                                dbms,
                                python,
                                cn
                            );

                    if (manager.addResult(
                            resultRoll,
                            result)) {

                        System.out.println(
                            "Result added successfully."
                        );

                    } else {

                        System.out.println(
                            "Student not found."
                        );
                    }

                    break;


                // TOP STUDENTS

                case 8:

                    System.out.print(
                        "How many top students? "
                    );

                    int n = sc.nextInt();

                    manager.showTopStudents(n);

                    break;


                // SORT

                case 9:

                    manager.sortByPercentage();

                    manager.displayAllStudents();

                    break;


                // SAVE

                case 10:

                    FileManager.saveStudents(
                        manager.getStudents()
                    );

                    break;


                // EXIT

                case 0:

                    FileManager.saveStudents(
                        manager.getStudents()
                    );

                    System.out.println(
                        "Thank you for using the system!"
                    );

                    break;


                default:

                    System.out.println(
                        "Invalid choice. Try again."
                    );
            }

        } while (choice != 0);

        sc.close();
    }
}