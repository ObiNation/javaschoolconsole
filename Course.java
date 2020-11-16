public class Course {
    private String courseSubject;
    private String courseLevel;
    private String courseName;
    private String professorName;
    private double courseHours;
    private double coursePoints;
    private boolean isComplete;
    private String courseDesc;
    private char grade;
    private String courseID;

    public Course()
    {
        courseSubject = "NULL";
        courseLevel = "000";
        courseHours = 0.0;
        coursePoints = 0.0;
        isComplete = false;
        professorName = "Null";
        courseDesc = "Null";
        courseID = "000000";
        grade = 'A';
    }

    /*public void getCourseName(){
        System.out.println(courseSubject + " " + courseLevel + ": " + courseName );

    }
    idk if i really need this function but ill keep it here just in case
    */
    public String getSimpleName() { return courseName; } //the function you want to call only for searching

    public double getCourseHours() {
        return courseHours;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public String getCourseSubject() {
        return courseSubject;
    }

    public String getProfessorName() {
        return professorName;
    }

    public String getCourseLevel() {
        return courseLevel;
    }



    public void setCourseHours(double courseHours) {
        this.courseHours = courseHours;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public void setCourseSubject(String courseSubject) {
        this.courseSubject = courseSubject;
    }

    public void setComplete(boolean complete) { this.isComplete = complete; }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseID() {
        return courseID;
    }

    public double givePointsEarned(char newGrade){
        //multiplies the grade by the total hours of the course to give the points earned
        this.grade = newGrade;
        switch (this.grade){
            case 'A' -> this.coursePoints = 4 * this.courseHours;
            case 'B' -> this.coursePoints = 3 * this.courseHours;
            case 'C' -> this.coursePoints = 2 * this.courseHours;
            case 'D' -> this.coursePoints = 1 * this.courseHours;
            case 'F' -> this.coursePoints = 0 * this.courseHours;
            default -> throw new IllegalStateException("Unexpected value: " + this.grade);
        }
        return this.coursePoints;
    }

    public void printCourseInfo(){
        System.out.println(this.courseSubject + " " + this.courseLevel + ": " + this.courseName);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Instructor: " + this.professorName);
        System.out.println("Course ID: " + this.courseID);
        System.out.println("Hours: " + this.courseHours);
        System.out.println(courseDesc);
        System.out.println(" ");
    }
}

