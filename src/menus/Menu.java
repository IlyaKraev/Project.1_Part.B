package menus;

import dbutils.Selections;
import dbutils.Insertions;
import java.util.Scanner;

public class Menu {

    public Menu() {
        mainMenu();
    }

    Scanner sc = new Scanner(System.in);
    private int c;

    private void mainMenu() {

        String inf = "+--------------------------------------------------------+\n"
                + "|     Welcome to the Private School management system    |\n"
                + "+--------------------------------------------------------+\n"
                + "|        PLEASE TYPE YOUR SELECTION AND PRESS ENTER      |\n"
                + "+--------------------------------------------------------+\n"
                + "|  1. Read entries                                       |\n"
                + "|  2. Add entry                                          |\n"
                + "|  3. Exit                                               |\n"
                + "+--------------------------------------------------------+";
        System.out.println(inf);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid argument. Input '1-3'");
            sc.next();
        }
        c = sc.nextInt();
        sc.nextLine();
        while (!(c == 1) && !(c == 2) && !(c == 3)) {
            System.out.println("Invalid argument. Input '1-3'.");
            c = sc.nextInt();
            sc.nextLine();
        }
        switch (c) {
            case 1:
                selectionMenu();
                break;
            case 2:
                insertionMenu();
                break;
            case 3:
                System.out.println("See you :)");
                System.exit(0);
                break;
        }
    }

    private void selectionMenu() {
        Selections sel = new Selections();
        String inf = "+--------------------------------------------------------+\n"
                + "|                     Selection Menu                     |\n"
                + "+--------------------------------------------------------+\n"
                + "|    You may view already existing entries, such as      |\n"
                + "|    courses, students, trainers and assignments         |\n"
                + "+--------------------------------------------------------+\n"
                + "|        PLEASE TYPE YOUR SLECTION AND PRESS ENTER       |\n"
                + "+--------------------------------------------------------+\n"
                + "|  1.  View all courses                                  |\n"
                + "|  2.  View all students                                 |\n"
                + "|  3.  View all trainers                                 |\n"
                + "|  4.  View all assignments                              |\n"
                + "|  5.  View all students per course                      |\n"
                + "|  6.  View all trainers per course                      |\n"
                + "|  7.  View all assignments per course                   |\n"
                + "|  8.  View all assignments per student per course       |\n"
                + "|  9.  View students enrolled in more than one course    |\n"
                + "|  10. Return to central menu hub                        |\n"
                + "|  11. EXIT the program                                  |\n"
                + "+--------------------------------------------------------+";
        System.out.println(inf);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid argument. Input '1-11'.");
            sc.next();
        }
        c = sc.nextInt();
        while (c < 1 || c > 11) {
            System.out.println("Invalid argument. Input '1-11'.");
            c = sc.nextInt();
            sc.nextLine();
        }

        switch (c) {
            case 1:
                sel.SelectCourses();
                selectionMenu();
                break;
            case 2:
                sel.SelectStudents();
                selectionMenu();
                break;
            case 3:
                sel.SelectTrainers();
                selectionMenu();
                break;
            case 4:
                sel.SelectAssignments();
                selectionMenu();
                break;
            case 5:
                sel.SelectStudentsPerCourse();
                selectionMenu();
                break;
            case 6:
                sel.SelectTrainersPerCourse();
                selectionMenu();
                break;
            case 7:
                sel.SelectAssignmentsPerCourse();
                selectionMenu();
                break;
            case 8:
                sel.SelectAssignmentsPerStudentPerCourse();
                selectionMenu();
                break;
            case 9:
                sel.SelectStudentsInMultipleCourses();
                selectionMenu();
                break;
            case 10:
                mainMenu();
                break;
            case 11:
                System.out.println("Until next time :)");
                System.exit(0);
                break;
        }

    }

    private void insertionMenu() {
        Insertions ins = new Insertions();
        cmdutils.Course cmdc = new cmdutils.Course(sc);
        cmdutils.Assignment cmda = new cmdutils.Assignment(sc);
        cmdutils.Student cmds = new cmdutils.Student(sc);
        cmdutils.Trainer cmdt = new cmdutils.Trainer(sc);
        String inf = "+---------------------------------------------------------+\n"
                + "|             Entry creation and addition menu            |\n"
                + "+---------------------------------------------------------+\n"
                + "|    You may manage the school by creating and managing   |\n"
                + "|       courses students, trainers and assignments.       |\n"
                + "|---------------------------------------------------------+\n"
                + "|       PLEASE TYPE YOUR SELECTION AND PRESS ENTER        |\n"
                + "+---------------------------------------------------------+\n"
                + "|  1.  Create new course                                  |\n"
                + "|  2.  Create new student                                 |\n"
                + "|  3.  Create new trainer                                 |\n"
                + "|  4.  Create new assignment                              |\n"
                + "|  5.  Add existing students to course                    |\n"
                + "|  6.  Add existing trainers to course                    |\n"
                + "|  7.  Add existing assignments to course                 |\n"
                + "|  8.  Add and grade assignments for students in courses  |\n"
                + "|  9.  Return to central menu hub                         |\n"
                + "|  10. EXIT the program                                   |\n"
                + "+---------------------------------------------------------+";
        System.out.println(inf);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid argument. Input '1-10'.");
            sc.next();
        }
        c = sc.nextInt();
        sc.nextLine();
        while (c < 1 || c > 10) {
            System.out.println("Invalid argument. Input '1-10'.");
            c = sc.nextInt();
        }

        switch (c) {
            case 1:
                ins.insertCourse(cmdc.askData());
                insertionMenu();
                break;
            case 2:
                ins.insertStudent(cmds.askData());
                insertionMenu();
                break;
            case 3:
                ins.insertTrainer(cmdt.askData());
                insertionMenu();
                break;
            case 4:
                ins.insertAssignment(cmda.askData());
                insertionMenu();
                break;
            case 5:
                ins.insertStudentsToCourse(ins.enrollStudentsToCourse(sc));
                insertionMenu();
                break;
            case 6:
                ins.insertTrainerssToCourse(ins.AssignTrainersToCourse(sc));
                insertionMenu();
                break;
            case 7:
                ins.insertAssignmentsToCourse(ins.matchAssignmentsToCourse(sc));
                insertionMenu();
                break;
            case 8:
                ins.insertAssignmentsToStudentsPerCourse(ins.gradeAssignmentsOfStudents(sc));
                insertionMenu();
                break;
            case 9:
                mainMenu();
                break;
            case 10:
                System.out.println("So long :)");
                System.exit(0);
                break;

        }
    }
}
