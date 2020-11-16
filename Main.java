import java.util.*;
/*TO DO

Add a function that goes through all the schedules of students in studentsList and prints out the ones that have a course in the schedule
basically print out the student roster for that course. also fix setCourseComplete in student.java since it is always returning false



 */
public class Main {
    static List<Student> studentList = new ArrayList<>();
    static List<Course> courseList = new ArrayList<>();

    public static void registerStudent() {
        Scanner nameInput = new Scanner(System.in);
        int num = 1;
        try {
            while (num == 1) {
                System.out.println("Enter the students Last name");
                String newName = nameInput.nextLine();
                Student newStudent = new Student();
                newStudent.setLastName(newName);
                System.out.println("Enter the students first name");
                String newName1 = nameInput.nextLine();
                newStudent.setFirstName(newName1);
                newStudent.setStudentID(randomNumberString());
                studentList.add(newStudent);

                num = 2;

            }
        } catch (IllegalStateException | NoSuchElementException e)
        {
            System.out.println("System.in was closed; exiting");
        }
        System.out.println("=========================");
        System.out.println("Returning to main menu");
        mainMenu();
        System.out.println(" ");
    }



    public static void searchStudent(){


        System.out.println("Would you like to search by Name or student ID?");
        System.out.println("================================================");
        System.out.println("1: Search student by Name");
        System.out.println("2: Search student by ID");
        System.out.println("3: Back to previous menu");
        Scanner searchNameInput = new Scanner(System.in);

        try{
            switch (searchNameInput.nextInt()) {
                case 1 -> {
                    System.out.println(" ");
                    searchStudentName();
                }
                case 2 -> {
                    System.out.println(" ");
                    searchStudentID();
                }
                case 3 -> {
                    System.out.println(" ");
                    mainMenu();
                }
                default -> {
                    System.err.println("Invalid Choice...returning to previous menu");
                    mainMenu();
                }
            }
        } catch (Exception e){
            System.out.print("Invalid input");
        }

    }


    public static void searchStudentName(){

        System.out.println("Enter the students last name");
        System.out.println("=============================");
        Scanner studentNameSearch = new Scanner(System.in);
        String nameToSearch = studentNameSearch.nextLine();
        try{
            for (Student searchStudent : studentList) { //basic loop to search through the list of student by the name
                if (searchStudent.getLastName().equals(nameToSearch)) {
                    searchStudent.printStudentInfo();
                } else {
                    System.err.println("Could not find a student with that last name");
                }
            }
        } catch (Exception e){
            System.out.println("Invalid input...returning to previous menu");
            searchStudent();
        }
        mainMenu();
    }

    public static void searchStudentID(){
        System.out.println("Enter the students ID");
        System.out.println("=============================");
        Scanner studentNameSearch = new Scanner(System.in);
        String idToSearch = studentNameSearch.nextLine();
        for (Student searchStudent : studentList){ //basic loop to search through the list of student by the ID
            if (searchStudent.getStudentID().equals(idToSearch)){
                searchStudent.printStudentInfo();
            }
            else{
                System.err.println("Could not find student based on that ID");
            }
        }
        System.out.println("Returning to main menu");
        mainMenu();
    }

    public static void registerCourse(){
        Scanner nameInput = new Scanner(System.in);
        int num = 1;
        try {
            while (num == 1) {
                System.out.println("Enter the course name");
                String newName = nameInput.nextLine();
                System.out.println(newName);
                Course newCourse = new Course();
                newCourse.setCourseName(newName);
                System.out.println("Enter the course subject code");
                String newSubject = nameInput.nextLine();
                newCourse.setCourseSubject(newSubject);
                System.out.println("Enter the course level");
                String newLevel = nameInput.nextLine();
                newCourse.setCourseLevel(newLevel);
                System.out.println("Enter the professors name");
                String newProf = nameInput.nextLine();
                newCourse.setProfessorName(newProf);
                System.out.println("Give a short description of the course");
                String newDescription = nameInput.nextLine();
                newCourse.setCourseDesc(newDescription);
                System.out.println("Enter the number of hours for the course (in decimal form)");
                double newHours = nameInput.nextDouble();
                newCourse.setCourseHours(newHours);
                courseList.add(newCourse);
                newCourse.setCourseID(randomNumberString());
                num = 2;

            }
        } catch (Exception e)
        {
            System.err.println("Error registering course");
        }
        System.out.println("=========================");
        System.out.println("Returning to main menu");
        mainMenu();
        System.out.println(" ");
    }


    public static void searchCourse(){
        System.out.println("How would you like to search for");
        System.out.println("================================================");
        System.out.println("1: Search course by Name");
        System.out.println("2: Search course by ID");
        System.out.println("3: Search course by course code");
        System.out.println("4: Search course by professor's last name");
        System.out.println("0: Back to previous menu");
        Scanner searchCourseInput = new Scanner(System.in);

        switch (searchCourseInput.nextInt()){
            case 1 ->{
                searchCourseName();
                System.out.println(" ");
            }
            case 2 ->{
                searchCourseID();
                System.out.println();
            }
            case 3 ->{
                searchCourseCode();
                System.out.println(" ");
            }
            case 4 ->{
                searchCourseProfessor();
                System.out.println(" ");
            }
            case 0 ->{
                System.out.println("Returning to main menu");
                mainMenu();
                System.out.println(" ");
            }
        }
    }

    public static void searchCourseName(){
        System.out.println("Enter the name of the course");
        System.out.println("=============================");
        Scanner courseNameSearch = new Scanner(System.in);
        String nameToSearch = courseNameSearch.nextLine();
        for (Course searchCourse : courseList){ //basic loop to search through the list of student by the name
            if (searchCourse.getSimpleName().equals(nameToSearch)){
                searchCourse.printCourseInfo();
            }
            else{
                System.err.println("Could not find a course with that name");
            }
        }
        System.out.println("Returning to main menu");
        mainMenu();
    }

    public static void searchCourseID(){
        System.out.println("Enter the course ID");
        System.out.println("=====================");
        Scanner courseIDSearch = new Scanner(System.in);
        String idToSearch = courseIDSearch.nextLine();
        for (Course course : courseList){
            if (course.getCourseID().equals(idToSearch)){
                course.printCourseInfo();
            }
        }
        System.out.println("Returning to main menu");
        mainMenu();
    }

    public static void searchCourseCode(){
        System.out.println("Enter the 4 character course subject");
        System.out.println("=====================================");
        Scanner userInput = new Scanner(System.in);
        String subjectCode = userInput.nextLine();
        System.out.println(" ");
        System.out.println("Enter the course level");
        System.out.print(" ");
        String courseLevel = userInput.nextLine();
        for (Course course : courseList){
            if (course.getCourseLevel().equals(courseLevel) && course.getCourseSubject().equals(subjectCode)){
                course.printCourseInfo();
            }
        }
        System.out.println("Returning to main menu");
        mainMenu();
    }

    public static void searchCourseProfessor(){
        System.out.println("Enter the professors name");
        System.out.println("====================================");
        Scanner userInput = new Scanner(System.in);
        String profName = userInput.nextLine();
        System.out.print(" ");
        for (Course course : courseList){
            if (course.getProfessorName().equals(profName)){
                course.printCourseInfo();
            }
        }
        System.out.println("Returning to main menu");
        mainMenu();
    }

    public static void editStudentInfo(){
        //The user searches for a student by ID and is able to change their last name and schedule
        System.out.println("Enter the students ID");
        System.out.println("=============================");
        Scanner studentNameSearch = new Scanner(System.in);
        String idToSearch = studentNameSearch.nextLine();
        for (Student searchStudent : studentList){ //basic loop to search through the list of student by the ID
            if (searchStudent.getStudentID().equals(idToSearch)){
                searchStudent.printStudentInfo();
                System.out.println("What would you like to do?");
                System.out.println("===========================");
                System.out.println("1: Change a students name");
                System.out.println("2: Add a course");
                System.out.println("3: Remove a course");
                System.out.println("4: Set course as completed");
                System.out.println(" ");
                Scanner editChoice = new Scanner(System.in);

                switch (editChoice.nextInt()){
                    case 1 -> {
                        //Edit first and last name
                        Scanner newNameInput = new Scanner(System.in);
                        System.out.println("Enter the students Last name");
                        String newName = newNameInput.nextLine();
                        searchStudent.setLastName(newName);
                        System.out.println("Enter the students First name");
                        String newName1 = newNameInput.nextLine();
                        searchStudent.setFirstName(newName1);
                        searchStudent.getFullName();
                        mainMenu();
                    }
                    case 2 -> {
                        //search for a course and add a course to the students schedule
                        System.out.println("Enter the course ID");
                        Scanner courseToAdd = new Scanner(System.in);
                        String courseIdToSearch = courseToAdd.nextLine();
                        for (Course searchCourse : courseList){
                            if (searchCourse.getCourseID().equals(courseIdToSearch)){
                                searchStudent.addClasstoSchedule(searchCourse);
                            }
                        }
                        mainMenu();
                    }
                    case 3 -> {
                        //remove a course from the students schedule
                        System.out.println("Enter the course ID");
                        Scanner courseToAdd = new Scanner(System.in);
                        String courseIdToSearch = courseToAdd.nextLine();
                        for (Course searchCourse : courseList){
                            if (searchCourse.getCourseID().equals(courseIdToSearch)){
                                searchStudent.removeClassFromSchedule(searchCourse);
                            }
                        }
                        mainMenu();
                    }
                    case 4 ->{
                        //Set a course as completed
                        System.out.println("Enter the course ID");
                        Scanner courseToAdd = new Scanner(System.in);
                        String courseIdToSearch = courseToAdd.nextLine();
                        for (Course searchCourse : courseList){
                            if (searchCourse.getCourseID().equals(courseIdToSearch)){
                                searchStudent.setCourseComplete(courseIdToSearch);
                            }
                        }
                        mainMenu();
                    }
                    default -> {
                        //does nothing
                    }

                }

            }
            else{
                System.err.println("Could not find student based on that ID");
                mainMenu();
            }
        }
    }



    /*public static void courseRoster(){
        /iterate through studentSchedule in every element inside studentList and if they have a course that matches the
        course ID, print out their name/
        System.out.println("How would you like to search for");
        System.out.println("================================================");
        System.out.println("1: Search course by Name");
        System.out.println("2: Search course by ID");
        System.out.println("3: Search course by course code");
        System.out.println("4: Search course by professor's last name");
        System.out.println("0: Back to previous menu");


    }*/

    /*

    MENU BASED METHODS

    */

    public static void mainMenu(){
        System.out.println("What would you like to do?");
        System.out.println("1: Register a new student");
        System.out.println("2: Search for a Student");
        System.out.println("3: Search for a Course");
        System.out.println("4: Register a new course");
        System.out.println("5: Post list of current students");
        System.out.println("6: Print out a list of available courses");
        System.out.println("7: Edit a students info");
        System.out.println("0: Quit");
        System.out.print("Selection: ");
        System.out.println(" ");
        Main.inputMenu();

    }

    public static void quitMenu(){
        System.out.println("Quit?");
        System.out.println("9: Back to previous menu");
        System.out.println("0: Quit");

        Scanner scan = new Scanner(System.in);

        switch (scan.nextInt()) {
            case 0 -> {
                System.out.println(" ");
                System.out.println("Quitting...");
            }
            case 9 -> {
                System.out.println(" ");
                System.out.println("Returning to previous menu...");
                mainMenu();
            }
            default -> {
                System.out.println(" ");
                System.err.println("Invalid Choice...");
            }
        }
    }

         public static void inputMenu(){
        Scanner input = new Scanner(System.in);
        boolean isEmpty = studentList.isEmpty();
        boolean isEmpty1 = courseList.isEmpty();
        try {
            //searchCourse method that searches the list of courses based on course code
            switch (input.nextInt()) {
                case 1 -> {
                    System.out.println("Registering a new student");
                    System.out.println(" ");
                    registerStudent();
                }
                case 2 -> {
                    if (isEmpty){
                        System.err.println("There are no students yet. Returning to previous menu");
                        mainMenu();
                    }
                    else {
                        System.out.println("Searching for student");
                        System.out.println(" ");
                        searchStudent();//searchStudent method that searches the list of students based on last name
                    }
                }
                case 3 -> {
                    if (isEmpty1){
                        System.err.println("There are no courses yet... returning to previous menu");
                        mainMenu();
                    }
                    else {
                        System.out.println("Loading menu...");
                        System.out.println(" ");
                        searchCourse();
                    }
                }
                case 4 -> {
                        System.out.println("Register a new course");
                        System.out.println(" ");
                        registerCourse();
                    }

                case 5 -> {
                    if (isEmpty) {
                        System.err.println("There are no students yet. Returning to previous menu");
                        mainMenu();
                    }
                    else {
                        System.out.println("Getting list of Students...");
                        System.out.println(" ");
                        printAllStudents();
                    }
                }
                case 6 -> {
                    if (isEmpty1){
                        System.err.println("There are no courses yet... returning to previous menu");
                        mainMenu();
                    }
                    else {
                        System.out.println("Getting a list of courses");
                        System.out.println(" ");
                        printAllCourse();
                    }
                }
                case 7 -> {
                    if (isEmpty) {
                        System.err.println("There are no students yet. Returning to previous menu");
                        mainMenu();
                    }
                    else {
                        editStudentInfo();
                    }
                }
                case 0 -> {
                    System.out.println(" ");
                    quitMenu();
                }
                default -> {
                }
            }
        } catch (Exception e){
            System.err.println("Invalid choice...returning to previous menu");
            mainMenu();
        }
        }

        public static void printAllStudents(){
            for (Student student : studentList) {
                System.out.println(" ");
                student.printStudentInfo();
                System.out.println(" ");
            }
        mainMenu();
        }

    public static void printAllCourse(){
        for (Course course : courseList) {
            System.out.println(" ");
            course.printCourseInfo();
            System.out.println(" ");
        }
        mainMenu();
    }

    public static String randomNumberString() {
        // generate a random 6 digit number and convert it into a string

        Random random = new Random();
        int i = random.nextInt(999999);


        return String.format("%06d", i);
    }

    public static void main(String[] args) {


        Main.mainMenu();

    }
}
