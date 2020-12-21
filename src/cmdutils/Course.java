package cmdutils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Course {

    private Scanner sc;

    public Course(Scanner sc) {
        this.sc = sc;
    }

    public models.Course askData() {
        Command cmd = new Command();
        models.Course course = new models.Course();

        course.setTitle(cmd.getField(sc, "Type the name of your course"));
        course.setStream(cmd.getField(sc, "Select stream"));
        course.setType(getType(sc, "Select type: Full time or Part time"));

        int flag = 0;
        do {
            DateTimeFormatter formatter;
            formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            course.setStartDate(null);
            course.setEndDate(null);
            try {
                System.out.print("Select a Start Date (dd/mm/yyyy): \n");
                course.setStartDate(LocalDate.parse(sc.next(), formatter));
                System.out.print("Select an End Date (dd/mm/yyyy): \n");
                course.setEndDate(LocalDate.parse(sc.next(), formatter));
                if (course.getStartDate().isAfter(course.getEndDate())) {
                    System.out.println("End Date Must be Later Than Start Date!");
                    continue;
                }
                flag = 1;
            } catch (Exception e) {
                System.out.println("Invalid Date Input.");
            }
        } while (flag == 0);

        return (course);
    }

    public String getType(Scanner sc, String message) {
        System.out.println(message);
        String type = sc.nextLine();
        while (!type.equalsIgnoreCase("full time") && !type.equalsIgnoreCase("part time")) {
            System.out.println("Invalid type. Please input Full time or Part time");
            type = sc.nextLine();
        }
        return (type);
    }
}
