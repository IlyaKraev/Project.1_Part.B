package cmdutils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignment {

    private final Scanner sc;

    public Assignment(Scanner sc) {
        this.sc = sc;
    }

    public models.Assignment askData() {
        Command cmd = new Command();
        models.Assignment assignment = new models.Assignment();
        assignment.setTitle(cmd.getField(sc, "Type the title of your assignment"));
        assignment.setDescription(cmd.getField(sc, "Give a description"));
        int flag = 0;
        do {
            DateTimeFormatter formatter;
            formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            assignment.setSubmissionDate(null);
            try {
                System.out.print("Select a Submission date (dd/mm/yyyy): \n");
                assignment.setSubmissionDate(LocalDate.parse(sc.next(), formatter));

                flag = 1;
            } catch (Exception e) {
                System.out.println("Invalid Date Input.");
            }
        } while (flag == 0);
        assignment.setOralMark(20);
        assignment.setTotalMark(80);
        return (assignment);
    }



}
