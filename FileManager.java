import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "students.txt";

    // Save students

    public static void saveStudents(ArrayList<Student> students) {

        try {

            FileWriter writer = new FileWriter(FILE_NAME);

            for (Student student : students) {

                writer.write(
                    student.getRollNumber() + ","
                    + student.getName() + ","
                    + student.getAge() + ","
                    + student.getCourse()
                    + "\n"
                );
            }

            writer.close();

            System.out.println("Student data saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving data.");
        }
    }

    // Load students

    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {

                    int rollNumber =
                            Integer.parseInt(data[0]);

                    String name = data[1];

                    int age =
                            Integer.parseInt(data[2]);

                    String course = data[3];

                    Student student =
                            new Student(
                                rollNumber,
                                name,
                                age,
                                course
                            );

                    students.add(student);
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error while loading data.");
        }

        return students;
    }
}
