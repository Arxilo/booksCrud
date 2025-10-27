/*

Exercise: Simple Payroll Calculator for Employees 💰

Main Topic:
Handling numerical data, business logic, and calculations (`float`/`double`), and control structures to apply bonus/deduction rules.

Statement:

Develop a Java application to manage and calculate the basic monthly payroll for a group of employees.
The calculation must include salaries, deductions, and incentives based on fixed rules.

Data Model Requirements:
Each employee must be stored with the following information:

	ID: An auto-incrementing, unique integer.
	Name: The full name of the employee (String).
	Hourly Rate: The cost per hour of work (decimal numeric type, e.g., `float` or `double`).
	Hours Worked in the Month: The total hours worked (integer numeric type, e.g., `int`).

Menu Functionalities:
The program must offer the following options in its main menu:

	1. Register Employee 👨‍💼:

	Prompts for the Name, Hourly Rate, and Hours Worked in the Month.
	Assigns an **ID** and adds the new employee to the collection.

	2. Calculate Employee Payroll 💵:

	Requests the employee's ID.

	Performs and displays the following calculations (using the provided ID):

		Gross Salary: `Hourly Rate` $\times$ `Hours Worked in the Month`.
		Tax Deduction: $10\%$ of the Gross Salary.
        Productivity Bonus: A fixed bonus of **$\$50.00$** is awarded if the **Hours Worked** exceed 160. 		Otherwise, the bonus is $\$0.00$. Net Salary: `Gross Salary` $-$ `Tax Deduction` $+$ `Productivity Bonus`.

	Shows a detailed summary of the calculation (Gross, Tax, Bonus, Net).


	3. Generate General Report 📊:

	Iterates through the list of all employees.
	For each employee, calculates their Net Salary (using the same logic from point 2) and displays a concise list 	with the Name and the Net Salary.

	4. Exit 🚪: Terminates the program execution.

*/

package CESDE.BACKEND.cruds;

import CESDE.BACKEND.colors.TerminalColors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class payRoll {
    public static void main(String[] args) {

        /*DECLARING ENTRY VARIABLES*/

        Scanner read = new Scanner(System.in);
        ArrayList<HashMap<String, Object>> employees = new ArrayList<>(); // Creating list of employees.

        /* DECLARING LOGIN VARIABLES */

        String typedEmail;
        String typedPassword;
        String savedEmail = "email@email.com"; // This simulates the email saved in a database
        String savedPassword = "123"; // This simulates the Password saved in a database
        Integer attemptsNumber = 3; // This variable states how many times the user can try to log in before it's account is blocked

        /* DECLARING EMPLOYEE'S DATA VARIABLES */

        Integer id = 0;
        String name;
        double hourlyRate;
        double hoursWorkedPerMonth;


        /* DECLARING OPERATION VARIABLE*/

        double grossSalary;
        double taxDeduction; // The tax deduction will be of 10%
        double productivityBonus; // The productivity bonus will be of $50,00 if worked Hours exceed 160 otherwise there is no bonus
        double netSalary;  // all the salary - Tax Deduction + Productivity bonus
        double hourlyRateToOperate;  // This variable will be used to do the operations in each Option
        double workedHoursToOperate; // This variable will be used to do the operations in each Option
        Integer menuOption; // This variable will be used to state the action that will be executed by the menu

        /* LOGIN */

        while (true) {

            System.out.print(TerminalColors.WHITE + "\n 📧 Type your email: ");
            typedEmail = read.nextLine();

            System.out.print(TerminalColors.WHITE + "\n 🔒 Type your Password: ");
            typedPassword = read.nextLine();

            if (savedEmail.equalsIgnoreCase(typedEmail) && savedPassword.equals(typedPassword)) { // Validation to valid login Credentials

                System.out.println(TerminalColors.GREEN + "Credentials are correct ✅");

                while (true) { // This internal loop will make that the Menu repeats until the user decide to Log out

                    /* MAIN MENU */
                    System.out.println(TerminalColors.BLUE + """
                             MAIN MENU
                             _________________________________
                                                    \s
                             1. Register an employee 💼
                             2. Calculate Payroll 💲
                             3. General Report 📊
                             4. List of employees 📋
                             5. Logout 🚪
                                                    \s
                             _________________________________

                            \s""");

                    menuOption = read.nextInt();
                    read.nextLine();


                    if (menuOption == 1) { // Register an employee 💼

                        HashMap<String, Object> employee = new HashMap<>();

                        id++; // This will simulate the auto Increment of a Database

                        System.out.print(TerminalColors.WHITE + " Type the employee's name: ");
                        name = read.nextLine();

                        System.out.print(TerminalColors.WHITE + " Type the employee's Hourly Rate: ");
                        hourlyRate = read.nextDouble();

                        System.out.print(TerminalColors.WHITE + " Type time how many hours has the employed worked this month: ");
                        hoursWorkedPerMonth = read.nextDouble();

                        employee.put("id", id);
                        employee.put("name", name);
                        employee.put("hourlyRate", hourlyRate);
                        employee.put("workedHours", hoursWorkedPerMonth);

                        employees.add(employee); // Adding the hashMap value to a list.

                        System.out.println(TerminalColors.GREEN + " Employee registered successfully ✅");

                    } else if (menuOption == 2) { // Calculate Employee's payroll 💲

                        if (employees.isEmpty()) { // Validating tha there is data on the List. 📋
                            System.out.println(TerminalColors.YELLOW + "There is not employees registered yet.");
                        } else {

                            Integer employeeToFind; // This variable will indicate the ID of the employee that needs to be found.
                            System.out.print(TerminalColors.WHITE + " Type the employee's id to Calculate the Payroll 💲: ");
                            boolean wereFound = false;
                            employeeToFind = read.nextInt();
                            read.nextLine();

                            for (HashMap<String, Object> findEmployee : employees) { // Iterate each position of list to find or not find the id of employee.

                                if (findEmployee.get("id").equals(employeeToFind)) { // condition if the employee is found

                                    wereFound = true;
                                    hourlyRateToOperate = (double) findEmployee.get("hourlyRate"); // taking the value "hourlyRate" from the list and saving it in variable of type double So we can calculate the gross salary.
                                    workedHoursToOperate = (double) findEmployee.get("workedHours"); // taking the value "workedHours" from the list and saving it in variable of type double So we can calculate the gross salary.

                                    grossSalary = hourlyRateToOperate * workedHoursToOperate;
                                    taxDeduction = grossSalary * 10 / 100;
                                    productivityBonus = workedHoursToOperate >= 160 ? 50.00 : 0.0; // Using a Ternary condition to validate if the employee earned the productivity bonus this month.

                                    netSalary = grossSalary - taxDeduction + productivityBonus;

                                    System.out.println(TerminalColors.GREEN + "\n ---------------------------------------------------------------- \n");
                                    System.out.println("| #️⃣ Employee's name: " + findEmployee.get("name"));
                                    System.out.println("| 🕑 " + findEmployee.get("name") + "'s Hourly rate: " + findEmployee.get("hourlyRate") + " $");
                                    System.out.println("| 💸 Gross Salary: " + "$ " + grossSalary);
                                    System.out.println("| 📋 Tax Deduction: " + "$ " + taxDeduction);
                                    System.out.println("| 📃 Productivity Bonus: " + "$ " + productivityBonus);
                                    System.out.println("| 💲 Net Salary: " + "$ " + netSalary);
                                    System.out.println("\n ---------------------------------------------------------------- \n");
                                }
                            }

                            if (!wereFound){ // Condition in case that the Employee was not found.
                                System.out.println(TerminalColors.YELLOW + "There employee couldn't be found.");
                            }


                        }

                    } else if (menuOption == 3) { // General Report 📊

                        if (employees.isEmpty()) {
                            System.out.println(TerminalColors.YELLOW + "There is not employees registered yet.");
                        } else {

                            for (HashMap<String, Object> netSalaries : employees) {   // ForEach to iterate Each position of list and print the report of each employee

                                hourlyRateToOperate = (double) netSalaries.get("hourlyRate"); // taking the value "hourlyRate" from the list and saving it in variable of type double So we can calculate the gross salary.
                                workedHoursToOperate = (double) netSalaries.get("workedHours"); // taking the value "workedHours" from the list and saving it in variable of type double So we can calculate the gross salary.
                                grossSalary = hourlyRateToOperate * workedHoursToOperate;
                                taxDeduction = grossSalary * 10 / 100;
                                productivityBonus = workedHoursToOperate >= 160 ? 50.00 : 0.0; // Using a Ternary condition to validate if the employee earned the productivity bonus this month.
                                netSalary = grossSalary - taxDeduction + productivityBonus;

                                System.out.println(TerminalColors.CYAN + "\n----------------------------------------------------------------\n");
                                System.out.println("| #️⃣ ID: " + netSalaries.get("id"));
                                System.out.println("| 👔 Name: " + netSalaries.get("name"));
                                System.out.println("| 💲 Net Salary: " + netSalary);
                                System.out.println("\n----------------------------------------------------------------\n");

                            }
                        }

                    } else if (menuOption == 4) { // list of employees 📋

                        if (employees.isEmpty()) {
                            System.out.println(TerminalColors.YELLOW + "There is not employees registered yet.");
                        } else {

                            for (HashMap<String, Object> listEmployees : employees) {  // ForEach to iterate each position of the Array and print the employee's data.

                                System.out.println(TerminalColors.YELLOW + "\n----------------------------------------------------------------\n");
                                System.out.println("| #️⃣ ID: " + listEmployees.get("id"));
                                System.out.println("| 👔 Name: " + listEmployees.get("name"));
                                System.out.println("| 💲 Hourly Rate: " + listEmployees.get("hourlyRate"));
                                System.out.println("| ⏰ Worked Hours: " + listEmployees.get("workedHours") + " hours.");
                                System.out.println("\n----------------------------------------------------------------\n");

                            }

                        }
                    } else if (menuOption == 5) { // Logout 🚪

                        System.out.println(TerminalColors.BACKGROUND_WHITE + TerminalColors.BLACK + "\n\n GOOD BYE 👋🏼 \n\n");
                        break;

                    } else { // Invalid Option ❌

                        System.out.println(TerminalColors.RED + "\n Invalid Option ❌ \n");

                    }
                }

                break; // Break The login's loop

            } else if (!savedEmail.equalsIgnoreCase(typedEmail) || !savedPassword.equals(typedPassword)) { // Validation to invalid login Credentials

                attemptsNumber--; // Everytime the user types valid credential the number of attempts left will decrease
                System.out.println(TerminalColors.RED + "\n Wrong Credentials ❌ \n");
                System.out.println(TerminalColors.YELLOW + "\n Attempts left: " + attemptsNumber + " ⚠️ \n");

                if (attemptsNumber == 0) { // Validation in case the user has not attempts left

                    System.out.println(TerminalColors.BACKGROUND_RED + TerminalColors.BLACK + "\n Your Account has been block Try again latter. 🚫\n");
                    break;

                }

            }

        }

        read.close(); // Closing the Scanner as a good Practice So it won't use more Space on memory.

    }
}