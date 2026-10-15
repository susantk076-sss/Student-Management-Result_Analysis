public class Student {

    private int rollNumber;
    private String name;
    private int age;
    private String course;
    private Result result;

    public Student(int rollNumber, String name, int age, String course) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.course = course;
        this.result = null;
    }

    // Getters

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public Result getResult() {
        return result;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    // Display student details

    public void displayStudent() {

        System.out.println("----------------------------------");
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Course      : " + course);

        if (result != null) {
            result.displayResult();
        } else {
            System.out.println("Result      : Not Added");
        }

        System.out.println("----------------------------------");
    }

    @Override
    public String toString() {
        return rollNumber + " | " + name + " | " + age + " | " + course;
    }
}
