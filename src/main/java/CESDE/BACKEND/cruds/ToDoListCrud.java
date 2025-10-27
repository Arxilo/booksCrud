/*

Implement an interactive Java program to manage a personal list of tasks (To-Do List). The program must allow the user to add, mark as completed,
list by status/priority, and delete tasks.

Data Model Requirements:
Each task must be stored with the following information:

    ID: An auto-incrementing integer, unique for each task.
    Title: The short name of the task (String).
    Description: A broader detail of the task (String).
    Priority: Must be one of the following String values: "High 🔥", "Medium ⚠️", or "Low 💚".
    Status: Initially "Pending ⌛". Must be changeable to "Completed ✅".

Menu Functionalities:
The program must offer the following options in its main menu:

    Add Task ➕:

        Prompts the user for the Title, Description, and Priority.
        Automatically assigns a new ID and sets the Status as "Pending" (Pending).
        Adds the new task to the collection.

    Show list of Tasks 📋:

        Iterates over the list and displays the tasks whose Status is "Pending".
        Iterates over the list and displays the tasks whose Status is "Completed".
        Iterates over the list and displays all the tasks.

    Show Tasks by Priority 🌟:

        Prompts the user for the Priority level ("High 🔥", "Medium ⚠️", or "Low 💚").
        Displays all tasks that match the entered priority.

    Mark Task as Completed ✅:

        Requests the ID of the task to be marked.
        If the task exists, updates its Status to "Completed".
        If it does not exist, displays an error message.

    Edit Task ✏️:

        Requests the ID of the task to be edited.
        If the task exists, Show a menu with the option tu edit and set the new value
        If it does not exist, displays an error message.

    Delete Task 🗑️:

        Requests the ID of the task to be deleted.
        Deletes the task from the collection if it exists, or notifies the user if the ID is not found.

    Exit 🚪: Terminates the program execution.

*/
package CESDE.BACKEND.cruds;
import CESDE.BACKEND.colors.TerminalColors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ToDoListCrud {
    public static void main(String[] args) {

        // DECLARING SCANNER AND ARRAYLIST

        Scanner read = new Scanner(System.in); // To capture values
        ArrayList<HashMap<String, Object>> tasks = new ArrayList<>(); // To save all the values.

        // DECLARING LOGIN VARIABLES

        String savedEmail = "task@email.com";
        String savedPassword = "123";
        String typedEmail;
        String typedPassword;
        Integer attemptsNumber = 3;

        // DECLARING TASK'S VARIABLES

        Integer menuOption; // This will state which action will be executed by the menu.
        Integer id = 0;
        String taskTitle;
        String taskDescription;
        String taskPriority;
        boolean taskStatus = false;


        System.out.println(TerminalColors.CYAN + "\n Welcome to the Task Manager Let's Login 📋\n");

        // CREATING LOGIN'S LOOP

        while (true) {

            // ASKING FOR CREDENTIALS

            System.out.print(TerminalColors.MAGENTA + " 📧 Type your email: ");
            typedEmail = read.nextLine();

            System.out.print(TerminalColors.MAGENTA + " 🔒 Type your password: ");
            typedPassword = read.nextLine();

            // VALIDATING CREDENTIALS

            if (typedEmail.equalsIgnoreCase(savedEmail) && typedPassword.equals(savedPassword)) {  // CONDITIONAL IF LOGIN'S CREDENTIALS ARE VALID ✅

                System.out.print(TerminalColors.GREEN + "\n Your Credentials are valid, Welcome 👋🏼 \n");


                // MAIN MENU LOOP
                while (true) {

                    System.out.println(TerminalColors.BLUE + """

                            1. Add task ➕
                            2. List Of tasks 📋
                            3. Show task by priority 🌟
                            4. Mark a task as completed ✅
                            5. Edit a task ✏️
                            6. Delete a task 🗑️
                            7. Logout 🚪

                            """);

                    menuOption = read.nextInt();
                    read.nextLine(); // This read.nextLine is used, so we have no interferences with the next Scanner.

                    // CONDITIONS MAIN MENU

                    // ADDING A TASK

                    if (menuOption == 1) {

                        HashMap<String, Object> task = new HashMap<>(); // This HashMap will save all the individuals task

                        id++; // This is to simulate the auto Increment of a Database

                        System.out.print(TerminalColors.BLUE + "Name your task: ");
                        taskTitle = read.nextLine();

                        System.out.print(TerminalColors.BLUE + "Write a quick description of your task: ");
                        taskDescription = read.nextLine();


                        // This loop repeats as long as the user Doesn't type a valid priority High , Medium or Low
                        while (true) {

                            System.out.print(TerminalColors.BLUE + """
                                    What's the Priority of your task?

                                    - High
                                    - Medium
                                    - Low

                                    """);
                            taskPriority = read.nextLine();

                            // ADDING ALL THE VALUES TO THE HASHMAP AS LONG AS PRIORITY MEETS THE REQUIREMENTS

                            if (taskPriority.equalsIgnoreCase("high") || taskPriority.equalsIgnoreCase("medium") || taskPriority.equalsIgnoreCase("low")) {

                                task.put("id", id);
                                task.put("title", taskTitle);
                                task.put("description", taskDescription);
                                task.put("priority", taskPriority.equalsIgnoreCase("high") ? taskPriority : taskPriority.equalsIgnoreCase("medium") ? taskPriority : taskPriority.equalsIgnoreCase("low") ? taskPriority : ""); // Adding emojis to the status with a ternary condition
                                task.put("status", taskStatus ? "Completed ✅" : "Pending ⌛"); // This Ternary Condition will state a name to the status instead of just saving a true or false

                                System.out.println(TerminalColors.GREEN + "\n Task added Successfully ✅ \n");

                                tasks.add(task); // Saving the task in the ArrayList

                                break; // Breaking the loop

                            } else {
                                System.out.println(TerminalColors.RED + "\n Type a valid Priority ❌ \n");
                            }
                        }
                    }

                    // LIST OF TASKS

                    else if (menuOption == 2) {

                        // CONDITION TO VALIDATE THAT THERE IS ITEMS ON THE LIST

                        if (tasks.isEmpty()) {

                            System.out.println(TerminalColors.BRIGHT_YELLOW + "\n Not Items Yet  \n");

                        } else {

                            System.out.print(TerminalColors.CYAN + "\n LIST OF TASKS 📋 \n");
                            System.out.print(TerminalColors.RED + "\n 🔥 RED: means that the Task's priority is High\n");
                            System.out.print(TerminalColors.YELLOW + "\n ⚠️ YELLOW: means that the Task's priority is Medium\n");
                            System.out.print(TerminalColors.GREEN + "\n 🔰 GREEN: means that the Task's priority is Low \n");

                            // ITERATING ALL THE LIST ELEMENTS WITH A FOREACH

                            for (HashMap<String, Object> taskList : tasks) {

                                String paintText = taskList.get("priority").toString().equalsIgnoreCase("high") ? TerminalColors.RED : taskList.get("priority").toString().equalsIgnoreCase("medium") ? TerminalColors.YELLOW : TerminalColors.GREEN;
                                // This long line of code 👆🏼 is only using a ternary conditional that prints a color depending on the task's priority. is long but simple.

                                System.out.println(paintText + "----------------------------------------------------------------");
                                System.out.println("| #️⃣ ID: " + taskList.get("id"));
                                System.out.println("| 📋 Title: " + taskList.get("title"));
                                System.out.println("| 🌟 Priority: " + (taskList.get("priority").toString().equalsIgnoreCase("high") ? taskList.get("priority") + " 🔥" : taskList.get("priority").toString().equalsIgnoreCase("medium") ? taskList.get("priority") + " ⚠️" : taskList.get("priority") + " 🔰"));
                                System.out.println("| 💻 Status: " + taskList.get("status"));
                                System.out.println("| 💬 Description " + taskList.get("description"));
                                System.out.println("----------------------------------------------------------------");


                            }

                        }

                    }

                    // SHOWING TASK LISTED BY PRIORITY

                    else if (menuOption == 3) {

                        // CONDITION TO VALIDATE THAT THERE IS ITEMS ON THE LIST

                        if (tasks.isEmpty()) {

                            System.out.println(TerminalColors.BRIGHT_YELLOW + "\n Not Items Yet  \n");

                        } else {

                            boolean found = false; // This boolean will be used to state if the value couldn't be found
                            String priorityToFind;
                            System.out.print(TerminalColors.BLUE + "\n Type the priority you want to List: ");
                            priorityToFind = read.nextLine();

                            // ForEach to iterate the list

                            for (HashMap<String, Object> prioryList : tasks) {

                                String paintText = prioryList.get("priority").toString().equalsIgnoreCase("high") ? TerminalColors.RED : prioryList.get("priority").toString().equalsIgnoreCase("medium") ? TerminalColors.YELLOW : TerminalColors.GREEN;
                                // This long line of code 👆🏼 is only using a ternary conditional that prints a color depending on the task's priority. is long but simple.

                                if (prioryList.get("priority").toString().equalsIgnoreCase(priorityToFind) && priorityToFind.equalsIgnoreCase("high")) { // CONDITION TO FIND ALL THE HIGH PRIORITY TASKS

                                    found = true;

                                    System.out.println(paintText + "----------------------------------------------------------------");
                                    System.out.println("| #️⃣ ID: " + prioryList.get("id"));
                                    System.out.println("| 📋 Title: " + prioryList.get("title"));
                                    System.out.println("| 🌟 Priority: " + prioryList.get("priority") + " 🔥");
                                    System.out.println("| 💻 Status: " + prioryList.get("status"));
                                    System.out.println("| 💬 Description " + prioryList.get("description"));
                                    System.out.println("----------------------------------------------------------------");


                                } else if (prioryList.get("priority").toString().equalsIgnoreCase(priorityToFind) && priorityToFind.equalsIgnoreCase("medium")) { // CONDITION TO FIND ALL THE MEDIUM PRIORITY TASKS

                                    found = true;

                                    System.out.println(paintText + "----------------------------------------------------------------");
                                    System.out.println("| #️⃣ ID: " + prioryList.get("id"));
                                    System.out.println("| 📋 Title: " + prioryList.get("title"));
                                    System.out.println("| 🌟 Priority: " + prioryList.get("priority") + " ⚠️");
                                    System.out.println("| 💻 Status: " + prioryList.get("status"));
                                    System.out.println("| 💬 Description " + prioryList.get("description"));
                                    System.out.println("----------------------------------------------------------------");

                                } else if (prioryList.get("priority").toString().equalsIgnoreCase(priorityToFind) && priorityToFind.equalsIgnoreCase("low")) { // CONDITION TO FIND ALL THE LOW PRIORITY TASKS

                                    found = true;

                                    System.out.println(paintText + "----------------------------------------------------------------");
                                    System.out.println("| #️⃣ ID: " + prioryList.get("id"));
                                    System.out.println("| 📋 Title: " + prioryList.get("title"));
                                    System.out.println("| 🌟 Priority: " + prioryList.get("priority") + " 🔰");
                                    System.out.println("| 💻 Status: " + prioryList.get("status"));
                                    System.out.println("| 💬 Description " + prioryList.get("description"));
                                    System.out.println("----------------------------------------------------------------");
                                }
                            }

                            if (!found) { // CONDITION TO STATE THAT THE VALUE WAS NOT FOUND
                                System.out.println(TerminalColors.WHITE + "\n TASK NOT FOUND ❔ \n");
                            }
                        }
                    }

                    // MARK A TASK AS COMPLETED

                    else if (menuOption == 4) {

                        // CONDITION TO VALIDATE THAT THERE IS ITEMS ON THE LIST

                        if (tasks.isEmpty()) {

                            System.out.println(TerminalColors.BRIGHT_YELLOW + "\n Not Items Yet  \n");

                        } else {

                            boolean taskFound = false; // Boolean that States that the Task Were Found
                            boolean isComplete = true; // Boolean that States that the task Were Complete
                            Integer taskToFind;

                            System.out.print(TerminalColors.BLUE + "\n Type the id of the task: \n");
                            taskToFind = read.nextInt();

                            // ForEach to Iterate all the list
                            for (HashMap<String, Object> taskToCheck : tasks) {

                                // Condition that indicates that the task were found
                                if (taskToCheck.get("id").equals(taskToFind)) {

                                    taskFound = true;
                                    taskToCheck.put("status", isComplete ? "Completed ✅" : "Pending ⌛"); // This put method updates the status of the task and has a ternary condition that changes the status to complete ✅

                                    System.out.println(TerminalColors.GREEN + "\n Task Checked Well done. ✅ \n");

                                }

                            }

                            // Condition that indicates that the Task Wasn't found
                            if (!taskFound) {
                                System.out.println(TerminalColors.BLACK + "\n TASK NOT FOUND ❔ \n");
                            }

                        }
                    }

                    // EDIT A TAS
                    else if (menuOption == 5) {

                        // CONDITION TO VALIDATE THAT THERE IS ITEMS ON THE LIST

                        if (tasks.isEmpty()) {

                            System.out.println(TerminalColors.BRIGHT_YELLOW + "\n Not Items Yet  \n");

                        } else {

                            Integer taskToEdit;
                            Integer menuEditOption;
                            boolean taskFound = false;

                            System.out.print(TerminalColors.BLUE + "\n Type the id of the task that you need to edit: \n");
                            taskToEdit = read.nextInt();

                            for (HashMap<String, Object> editTask : tasks) {

                                if (editTask.get("id").equals(taskToEdit)) {

                                    System.out.println(TerminalColors.BLUE + """

                                              WHAT DO YOU WANT TO EDIT?
                                                                                   \s
                                             ============================
                                                                                   \s
                                              1. Edit the Title 🖊️
                                              2. Edit The Description 📝
                                              3. Edit Priority 🌟
                                              4. Back/Cancel ❌
                                                                                   \s
                                             ============================
                                                                                   \s
                                            \s""");

                                    menuEditOption = read.nextInt();
                                    read.nextLine();

                                    String newValue; // Variable to State the new value of the Item

                                    // EDIT THE TITLE
                                    if (menuEditOption == 1) {

                                        System.out.print(TerminalColors.BLUE + "Type the new Title: ");
                                        newValue = read.nextLine();

                                        editTask.put("title", newValue);
                                        System.out.println(TerminalColors.GREEN + "\n The new title has been set. ✅ \n");


                                    }

                                    // EDIT THE DESCRIPTION
                                    else if (menuEditOption == 2) {

                                        System.out.print(TerminalColors.BLUE + "Type the new Description: ");
                                        newValue = read.nextLine();

                                        editTask.put("description", newValue);

                                        System.out.println(TerminalColors.GREEN + "\n The new Description has been set. ✅ \n");

                                    }

                                    // EDIT THE PRIORITY
                                    else if (menuEditOption == 3) {

                                        // This loop repeats as long as the user Doesn't type a valid priority High , Medium or Low
                                        while (true) {

                                            System.out.print(TerminalColors.BLUE + "Type the new priority (Remember only High, Medium Or Low): ");
                                            newValue = read.nextLine();

                                            // Condition in case the user types a valid Option
                                            if (newValue.equalsIgnoreCase("high") || newValue.equalsIgnoreCase("medium") || newValue.equalsIgnoreCase("low")) {

                                                editTask.put("priority", newValue); // Setting the new value
                                                System.out.println(TerminalColors.GREEN + "\n The new Priority has been set. ✅ \n");
                                                break; // Breaking the loop

                                            } else {
                                                System.out.println(TerminalColors.RED + "\n Type a valid Priority ❌ \n");
                                            }

                                        }

                                    }

                                    // TO CANCEL THE EDITION
                                    else if (menuEditOption == 4) {

                                        System.out.println(TerminalColors.YELLOW + " Action Canceled. 🛑");

                                    }

                                    // INVALID OPTION
                                    else {
                                        System.out.println(TerminalColors.RED + "\n Invalid Option ❌ \n");
                                    }
                                }
                            }

                        }
                    }

                    // DELETE A TASK

                    else if (menuOption == 6) {

                        // CONDITION TO VALIDATE THAT THERE IS ITEMS ON THE LIST

                        if (tasks.isEmpty()) {

                            System.out.println(TerminalColors.BRIGHT_YELLOW + "\n Not Items Yet  \n");

                        } else {

                            Integer taskToDel;
                            String confirmation;

                            System.out.print(TerminalColors.BLUE + "\n Type the id of the task that you need to Delete: \n");
                            taskToDel = read.nextInt();
                            read.nextLine();

                            System.out.println("Are you sure you want to delete this task? (Yes/No) ");
                            confirmation = read.nextLine();

                            if (confirmation.equalsIgnoreCase("Yes")) { // confirmation that the user wants to delete the item

                                boolean delete = tasks.removeIf(del -> del.get("id").equals(taskToDel)); // this boolean use the method removeIF to delete the item if the id is equals to the id typed by the user

                                if (delete) { // if delete is true a success message will be printed
                                    System.out.println(TerminalColors.GREEN + " Task Deleted successfully 🗑️");
                                } else { // if delete is false will mean that the id was not found
                                    System.out.println(TerminalColors.YELLOW + " Task was not found ⚠️");
                                }

                            } else { // The user decided not delete this item.
                                System.out.println(TerminalColors.YELLOW + " Deletion Cancelled. 🛑");
                            }
                        }

                    }

                    // LOGOUT

                    else if (menuOption == 7) {
                        System.out.print(TerminalColors.GREEN + "\n Good bye 👋🏼 \n");
                        break;
                    }

                    /* IN CASE THE USER CHOOSES AN INVALID OPTION */

                    else {
                        System.out.println(TerminalColors.RED + "\n Invalid Option ❌ \n");
                    }

                }

                break;


            } else if (!typedEmail.equalsIgnoreCase(savedEmail) || !typedPassword.equals(savedPassword)) { // CONDITIONAL IF LOGIN'S CREDENTIALS ARE NOT VALID ❌

                attemptsNumber--;
                System.out.println(TerminalColors.RED + "\n Invalid Credentials ❌ \n");
                System.out.println(TerminalColors.YELLOW + "\n Attempts left: " + attemptsNumber + " ⚠️ \n");

                // BREAKING THE LOOP IF ATTEMPTS NUMBER REACH ZERO
                if (attemptsNumber == 0) {

                    System.out.println(TerminalColors.BACKGROUND_RED + TerminalColors.BLACK + "\n\n YOUR ACCOUNT HAS BEEN BLOCKED TRY AGAIN LATTER. 🚫\n\n");
                    break;

                }

            }

        }

        read.close(); // Closing the Scanner as a good practice.

    }
}
