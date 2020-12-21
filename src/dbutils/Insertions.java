package dbutils;

import cmdutils.Command;
import models.AssignmentsPerCourse;
import models.AssignmetsPerStudentPerCourse;
import models.StudentsPerCourse;
import models.TrainersPerCourse;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;

public class Insertions extends Database {

    private Command cmd = new Command();

    public int insertCourse(Course c) {

        int result = 0;
        try {
            prStatement = con.prepareStatement(
                    "INSERT IGNORE INTO courses"
                    + "(title,"
                    + "stream,"
                    + " type,"
                    + " start_date,"
                    + " end_date)"
                    + " VALUES (?,?,?,?,?)");

            prStatement.setString(1, c.getTitle());
            prStatement.setString(2, c.getStream());
            prStatement.setString(3, c.getType());
            prStatement.setDate(4, Date.valueOf(c.getStartDate()));
            prStatement.setDate(5, Date.valueOf(c.getEndDate()));

            result = prStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (result);
    }

    public int insertStudent(Student s) {

        int result = 0;
        try {
            prStatement = con.prepareStatement(
                    "INSERT IGNORE INTO students"
                    + "(first_name,"
                    + "last_name,"
                    + " date_of_birth,"
                    + " tuition_fees)"
                    + " VALUES (?,?,?,?)");

            prStatement.setString(1, s.getFirstName());
            prStatement.setString(2, s.getLastName());
            prStatement.setDate(3, Date.valueOf(s.getBirthDate()));
            prStatement.setDouble(4, s.getTuitionFees());

            result = prStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (result);
    }

    public int insertTrainer(Trainer t) {

        int result = 0;
        try {
            prStatement = con.prepareStatement(
                    "INSERT IGNORE INTO trainers"
                    + "(first_name,"
                    + "last_name,"
                    + " subject)"
                    + " VALUES (?,?,?)");

            prStatement.setString(1, t.getFirstName());
            prStatement.setString(2, t.getLastName());
            prStatement.setString(3, t.getSubject());

            result = prStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (result);
    }

    public int insertAssignment(Assignment a) {

        int result = 0;
        try {
            prStatement = con.prepareStatement(
                    "INSERT IGNORE INTO assignments"
                    + "(title,"
                    + " description,"
                    + " sub_date,"
                    + " oral_mark,"
                    + " total_mark)"
                    + " VALUES (?,?,?,?,?)");

            prStatement.setString(1, a.getTitle());
            prStatement.setString(2, a.getDescription());
            prStatement.setDate(3, Date.valueOf(a.getSubmissionDate()));
            prStatement.setInt(4, a.getOralMark());
            prStatement.setInt(5, a.getTotalMark());

            result = prStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (result);
    }

    public int insertStudentsToCourse(List<StudentsPerCourse> spc) {
        int result = 0;
        for (StudentsPerCourse StudentPerCourse : spc) {
            try {
                prStatement = con.prepareStatement(
                        "INSERT IGNORE INTO students_courses"
                        + "(st_id,"
                        + " c_id)"
                        + " VALUES (?,?)");

                prStatement.setInt(1, StudentPerCourse.getStudentId());
                prStatement.setInt(2, StudentPerCourse.getCourseId());

                result = prStatement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);
    }

    public int insertTrainerssToCourse(List<TrainersPerCourse> tpc) {
        int result = 0;
        for (TrainersPerCourse TrainerPerCourse : tpc) {
            try {
                prStatement = con.prepareStatement(
                        "INSERT IGNORE INTO trainers_courses"
                        + "(t_id,"
                        + " c_id)"
                        + " VALUES (?,?)");

                prStatement.setInt(1, TrainerPerCourse.getTrainerId());
                prStatement.setInt(2, TrainerPerCourse.getCourseId());

                result = prStatement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);
    }

    public int insertAssignmentsToCourse(List<AssignmentsPerCourse> apc) {
        int result = 0;
        for (AssignmentsPerCourse AssignmentPerCourse : apc) {
            try {
                prStatement = con.prepareStatement(
                        "INSERT IGNORE INTO assignments_courses"
                        + "(a_id,"
                        + " c_id)"
                        + " VALUES (?,?)");

                prStatement.setInt(1, AssignmentPerCourse.getAssignmentId());
                prStatement.setInt(2, AssignmentPerCourse.getCourseId());

                result = prStatement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);
    }

    public int insertAssignmentsToStudentsPerCourse(List<AssignmetsPerStudentPerCourse> apspc) {
        int result = 0;
        for (AssignmetsPerStudentPerCourse AssignmetPerStudentPerCourse : apspc) {
            try {
                prStatement = con.prepareStatement(
                        "INSERT IGNORE INTO assignments_students_courses"
                        + "(a_id, "
                        + "c_id, "
                        + "st_id, "
                        + "oral_mark, "
                        + "total_mark)"
                        + " VALUES (?,?,?,?,?)");

                prStatement.setInt(1, AssignmetPerStudentPerCourse.getAssignmentId());
                prStatement.setInt(2, AssignmetPerStudentPerCourse.getCourseId());
                prStatement.setInt(3, AssignmetPerStudentPerCourse.getStudentId());
                prStatement.setInt(4, AssignmetPerStudentPerCourse.getOralMark());
                prStatement.setInt(5, AssignmetPerStudentPerCourse.getTotalMark());

                result = prStatement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);
    }

    public List<StudentsPerCourse> enrollStudentsToCourse(Scanner sc) {
        List<StudentsPerCourse> studentsToAdd = new ArrayList<>();

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT id, title, stream, type "
                    + " FROM courses");
            System.out.println("ID | Title | Stream | Type");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "."
                        + rs.getString("title") + " "
                        + rs.getString("stream") + " "
                        + rs.getString("type"));
            }
            int cId = cmd.getIntField(sc, "Please select a course");

            int choice = 1;
            
            while (choice == 1) {
                statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = statement.executeQuery("SELECT id, concat (first_name, ' ', last_name) 'Full Name' "
                        + " FROM students");
                System.out.println("ID | Full Name ");
                while (rs.next()) {
                    System.out.println(rs.getString("id") + ","
                            + rs.getString("Full Name"));
                }

                int stId = cmd.getIntField(sc, "Please select a student to enroll");

                StudentsPerCourse spc;
                spc = new models.StudentsPerCourse(cId, stId);

                studentsToAdd.add(spc);

                choice = cmd.getIntField(sc, "Would you like to add another student? "
                        + "Ιf yes press 1, otherwise press any other number");
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (studentsToAdd);
    }

    public List<TrainersPerCourse> AssignTrainersToCourse(Scanner sc) {
        List<TrainersPerCourse> trainersToAdd = new ArrayList<>();

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT id, title, stream, type "
                    + " FROM courses");
            System.out.println("ID | Title | Stream | Type");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "."
                        + rs.getString("title") + " "
                        + rs.getString("stream") + " "
                        + rs.getString("type"));
            }
            int cId = cmd.getIntField(sc, "Please select a course");

            int choice = 1;
            while (choice == 1) {
                statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = statement.executeQuery("SELECT id, concat (first_name, ' ', last_name) 'Full Name', subject "
                        + " FROM trainers");
                System.out.println("ID | Full Name | Subject");
                while (rs.next()) {
                    System.out.println(rs.getString("id") + ","
                            + rs.getString("Full Name") + ", "
                            + rs.getString("subject"));
                }

                int tId = cmd.getIntField(sc, "Please select a trainer to assign");

                TrainersPerCourse tpc;
                tpc = new models.TrainersPerCourse(cId, tId);

                trainersToAdd.add(tpc);

                choice = cmd.getIntField(sc, "Would you like to add assign another trainer? "
                        + "Ιf yes press 1, otherwise press any other number");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (trainersToAdd);
    }

    public List<AssignmentsPerCourse> matchAssignmentsToCourse(Scanner sc) {
        List<AssignmentsPerCourse> assignmentsToAdd = new ArrayList<>();

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT id, title, stream, type "
                    + " FROM courses");
            System.out.println("ID | Title | Stream | Type");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "."
                        + rs.getString("title") + " "
                        + rs.getString("stream") + " "
                        + rs.getString("type"));
            }
            int cId = cmd.getIntField(sc, "Please select a course");

            int choice = 1;
            while (choice == 1) {
                statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = statement.executeQuery("SELECT id, title, description "
                        + " FROM assignments");
                System.out.println("ID | Title | Description ");
                while (rs.next()) {
                    System.out.println(rs.getString("id") + ","
                            + rs.getString("title") + " "
                            + rs.getString("description"));
                }

                int aId = cmd.getIntField(sc, "Please select an assignment to match");

                AssignmentsPerCourse apc;
                apc = new models.AssignmentsPerCourse(aId, cId);

                assignmentsToAdd.add(apc);

                choice = cmd.getIntField(sc, "Would you like to match another assignment? "
                        + "Ιf yes press 1, otherwise press any other number");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (assignmentsToAdd);
    }

    public List<AssignmetsPerStudentPerCourse> gradeAssignmentsOfStudents(Scanner sc) {
        List<AssignmetsPerStudentPerCourse> assignmentsToHand = new ArrayList<>();

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT * FROM courses");
            System.out.println("ID | Title | Stream | Type");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "."
                        + rs.getString("title") + " "
                        + rs.getString("stream") + " "
                        + rs.getString("type"));
            }
            int cId = cmd.getIntField(sc, "Please select a course");

            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT * FROM assignments");
            System.out.println("ID | Title | Description");
            while (rs.next()) {
                System.out.println(rs.getString("id") + ","
                        + rs.getString("title") + " "
                        + rs.getString("description"));
            }

            int aId = cmd.getIntField(sc, "Please select an assignment to grade");

            int choice = 1;
            while (choice == 1) {
                statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = statement.executeQuery("SELECT id, concat (first_name, ' ', last_name) 'Full Name' "
                        + " FROM students ORDER BY id");
                System.out.println("ID | Full Name ");
                while (rs.next()) {
                    System.out.println(rs.getString("id") + ","
                            + rs.getString("Full Name"));
                }

                int stId = cmd.getIntField(sc, "Please select which student's assignment you will grade");

                int om = cmd.getIntField(sc, "Set the oral mark for this student's assignment");
                while (om < 0 || om > 20) {
                    om = cmd.getIntField(sc, "The oral mark should be from 0 to 20.");
                }
                int tm = cmd.getIntField(sc, "Set the total mark for this student's assignment");
                while (tm < 0 || tm > 80) {
                    om = cmd.getIntField(sc, "The total mark should be from 0 to 80.");
                }
                AssignmetsPerStudentPerCourse apspc;
                apspc = new models.AssignmetsPerStudentPerCourse(aId, cId, stId, om, tm);

                assignmentsToHand.add(apspc);

                choice = cmd.getIntField(sc, "Would you like to add grade another student's assignment? "
                        + "Ιf yes press 1, otherwise press any other number");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (assignmentsToHand);
    }
}
