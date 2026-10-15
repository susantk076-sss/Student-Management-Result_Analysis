public class Result {

    private int javaMarks;
    private int dsaMarks;
    private int dbmsMarks;
    private int pythonMarks;
    private int computerNetworksMarks;

    public Result(int javaMarks, int dsaMarks, int dbmsMarks,
                  int pythonMarks, int computerNetworksMarks) {

        this.javaMarks = javaMarks;
        this.dsaMarks = dsaMarks;
        this.dbmsMarks = dbmsMarks;
        this.pythonMarks = pythonMarks;
        this.computerNetworksMarks = computerNetworksMarks;
    }

    public int getTotalMarks() {

        return javaMarks +
               dsaMarks +
               dbmsMarks +
               pythonMarks +
               computerNetworksMarks;
    }

    public double getPercentage() {

        return getTotalMarks() / 5.0;
    }

    public String getGrade() {

        double percentage = getPercentage();

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    public boolean isPass() {

        return javaMarks >= 33 &&
               dsaMarks >= 33 &&
               dbmsMarks >= 33 &&
               pythonMarks >= 33 &&
               computerNetworksMarks >= 33;
    }

    public void displayResult() {

        System.out.println("----- RESULT -----");

        System.out.println("Java              : " + javaMarks);
        System.out.println("DSA               : " + dsaMarks);
        System.out.println("DBMS              : " + dbmsMarks);
        System.out.println("Python            : " + pythonMarks);
        System.out.println("Computer Networks : " + computerNetworksMarks);

        System.out.println("Total Marks       : " + getTotalMarks());
        System.out.println("Percentage        : " + getPercentage() + "%");
        System.out.println("Grade             : " + getGrade());

        if (isPass()) {
            System.out.println("Status            : PASS");
        } else {
            System.out.println("Status            : FAIL");
        }
    }
}
