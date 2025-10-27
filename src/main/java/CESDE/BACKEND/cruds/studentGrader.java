/*

Exercise: Student Grading and Statistics System (Student Grader) 📊

Statement:

Implement an interactive Java program to record the grades of multiple subjects for a single student, calculate their averages, and generate a performance report.

Data Model Requirements:

You must use collections (`ArrayList` and `HashMap`) to store the information. The system must manage:

	1.  Subject (Course): Each course must have a name and a list of grades.

	    ID: An auto-incrementing integer.
	    Subject Name (String).
	    Grades: A collection of type `ArrayList<Double>` that stores between 3 and 5 grades per subject.

	2.Storage Structure: The main system should use a structure to contain all subjects and their grades.

Data Input and Validation Requirements:

When registering a grade, the system must ensure the grade is within the range of 0.0 to 5.0. If the user enters a grade outside this range, they must be prompted to enter it again.
When registering the number of grades per subject, it must be enforced to be between **3 and 5** grades.

Menu Functionalities:

The program must offer the following options:

    1. Register New Subject 📚:

	    Prompts for the subject name.
    	    Prompts for the number of grades (3 to 5).
    	    Prompts for the grades one by one, validating that each grade is between 0.0 and 5.0.

    2. Calculate Global Average 🎯:

	    Iterates through **all** registered subjects.
    	    Sums all grades from **all** subjects.
    	    Calculates the student's total average (Total sum of grades / Total number of grades).
    	    Displays the result and the status:

		        If the average is $\ge 3.5$: Displays **"Approved with honors! 🌟"
	            If the average is $\ge 3.0$ and $< 3.5$: Displays **"Approved, but can improve. ✅"
        	    If the average is $< 3.0$: Displays **"Requires reinforcement. ⚠️"

    3. Subject Report 📋:

    	Displays a detailed list for each subject.
	    For each subject, calculates and displays:

            The Name of the subject.
            The simple Average for the subject.
            The Highest Grade obtained in the subject.
            The Lowest Grade obtained in the subject.


    4. Exit 🚪: Terminates the program execution.


*/
package CESDE.BACKEND.cruds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class studentGrader {
    public static void main(String[] args) {

        /* DECLARING ENTRY VARIABLES */

        Scanner read = new Scanner(System.in);
        ArrayList<HashMap<String, Object>> subjects = new ArrayList<>();
        Integer menuOption;

        /* STUDENT VARIABLES */

        Integer id = 0;
        String subjectName;


        System.out.println("Welcome 👋🏼");

        while (true) { // Main menu Loop

            System.out.println("""
                                        
                    1. Register New Subject 📚
                    2. Calculate Global Average 🎯
                    3. Subject Report 📋
                    4. Logout 🚪
                                        
                    """);

            menuOption = read.nextInt();
            read.nextLine();

            if (menuOption == 1) { // Register a new Subject 📚

                HashMap<String, Object> subject = new HashMap<>();
                ArrayList<Double> grades = new ArrayList<>();
                Integer gradeNumber = 3;

                id++;

                System.out.println("Write the subject's Name: ");
                subjectName = read.nextLine();

                while (gradeNumber > 0 && gradeNumber <= 3) {

                    double gradeToAdd;
                    System.out.println("Type a note between 0.0 and 5.0");
                    gradeToAdd = read.nextDouble();

                    if (gradeToAdd >= 0 && gradeToAdd <= 5) {
                        gradeNumber--;
                        grades.add(gradeToAdd);
                    } else {
                        System.out.println("Invalid note. ");
                    }
                }

                subject.put("id", id);
                subject.put("name", subjectName);
                subject.put("grades", grades);
                subjects.add(subject);

                System.out.println(" Subject registered ✅");
                System.out.println(subject);


            } else if (menuOption == 2) { // Calculate Global Average 🎯

                // initialize counters

                Double totalSumGrades = 0.0;
                Integer totalNumberOfGrades = 0;

                for (HashMap<String, Object> subject : subjects) {

                    ArrayList<Double> gradesList = (ArrayList<Double>) subject.get("grades");

                    for (double grade: gradesList) {
                        totalSumGrades += grade;
                        totalNumberOfGrades ++;
                    }

                }

                if (totalNumberOfGrades == 0){
                    System.out.println("No grades registered. ");
                }else{



                }


            } else if (menuOption == 3) { // Subject Report 📋
                System.out.println("3...");
            } else if (menuOption == 4) { // logout
                System.out.println("Good bye 👋🏼");
                break;
            } else {
                System.out.println("Invalid Option ❌");
            }


        }


    }
}
