import java.util.ArrayList;
import java.util.List;

//Create the class for students
public class Student{
    private String firstName;
    private String lastName;
    private String studentID;
    private String eduLevel;
    private double hoursDone;
    private String fullName;
    private double GPA;
    private double totalPoints;
    List<Course> studentSchedule = new ArrayList<>();
    List<Course> completedCourse = new ArrayList<>();


    public Student()
    {
        firstName = "John";
        lastName = "Doe";
        studentID = "00000000";
        eduLevel = "NONE";
        hoursDone = 1.0;
        fullName = "John Doe";
        totalPoints = 0.0;
        GPA = totalPoints / hoursDone;
    }
    //accessors
    public String getLastName()
    {
        return lastName;
    }

    public void getFullName()
    {
        System.out.println(firstName + " " + lastName);
    }

    public void setFirstName(String newFName)
    {
        this.firstName = newFName;
    }

    public void setLastName(String newLName)
    {
        this.lastName = newLName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }



    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getGPA() {
        return GPA;
    }

    public void calculateGPA(){
        //add up all the points earned over to calculate gpa
        for (Course course : this.studentSchedule){
            totalPoints = course.givePointsEarned() + totalPoints;
        }

        this.GPA = totalPoints / this.hoursDone;
    }

    public void printStudentInfo(){
        System.out.println("Student info");
        System.out.println("====================================");
        System.out.println("Name: " + this.firstName + " " + this.lastName );
        System.out.println("Student ID: " + this.studentID);
        System.out.println("Level: " + this.eduLevel);
        System.out.println("Hours done: " + this.hoursDone);
        System.out.println("Student is currently a " + getEdu());
        System.out.println("Getting schedule...");
        System.out.print(" ");
        System.out.print(" ");
        for (Course course : studentSchedule){
            System.out.print(" ");
            course.printCourseInfo();
            System.out.println(" ");
        }


    }

    public String getEdu(){ //check how many hours the student has completed to see their education level
        if (hoursDone < 30){
          return "Freshman";
        }
        else if ( hoursDone >= 30 && hoursDone < 65){
            return "Sophomore";
        }
        else if (hoursDone >= 65 && hoursDone < 100 ){
            return "Junior";
        }
        else if (hoursDone >= 100 && hoursDone < 145 ){
            return "Senior";
        }
        else{
            return "Graduated";
        }

    }

    public void addClasstoSchedule(Course coursetoAdd){
        //adds the course the students schedule
        this.studentSchedule.add(coursetoAdd);
        System.out.println("Successfully added course!");
        System.out.println(" ");
    }

    public void removeClassFromSchedule(Course courseToRemove){
        //removes the course from the students schedule
        this.studentSchedule.remove(courseToRemove);
        System.out.println("Successfully removed the course");
        System.out.println(" ");
    }

    public void setCourseComplete(String courseIDToCheck){
        //set "isComplete to true for that course and call givesPointsEarned method and add getCourseHours too hoursDone
        for (Course course : this.studentSchedule ){
            if (course.getCourseID().equals(courseIDToCheck)){
                course.setComplete(true);
                this.totalPoints = this.totalPoints + course.givePointsEarned();
                hoursDone = hoursDone + course.getCourseHours();
                completedCourse.add(course);
                studentSchedule.remove(course);
            }

        }
    }

}
