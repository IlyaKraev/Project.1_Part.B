package cmdutils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Student {

    private final Scanner sc;

    public Student(Scanner sc) {
        this.sc = sc;
    }

    public models.Student askData() {
        Command cmd = new Command();
        models.Student student = new models.Student();
        student.setFirstName(cmd.getField(sc, "First name of student"));
        student.setLastName(cmd.getField(sc, "Last name of student"));
        int flag1 = 0;
        do {
            DateTimeFormatter formatter;
            formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            student.setBirthDate(null);
            try {
                System.out.print("Set Birth Date (dd/mm/yyyy): \n");
                student.setBirthDate(LocalDate.parse(sc.nextLine(), formatter));
                flag1 = 1;
            } catch (Exception e) {
                System.out.println("Invalid Date Input.");
            }
        } while (flag1 == 0);
        int flag2 = 0;
        do {
            try {
                student.setTuitionFees(cmd.getDoubleField(sc, "Set Tuition Fees"));
                flag2 = 1;
            } catch (Exception e) {
                System.out.println("Invalid Tuition Fees Input.");
            }

        } while (flag2 == 0);

        return (student);
    }
}
