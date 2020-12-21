package dbutils;

import cmdutils.Command;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Selections extends Database {

    private Command cmd = new Command();

    public void SelectCourses() {

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT * FROM courses");
            System.out.println("ID | Title | Stream | Type | Start Date | End Date");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "."
                        + rs.getString("title") + " "
                        + rs.getString("stream") + " "
                        + rs.getString("type") + " "
                        + rs.getString("start_date") + " "
                        + rs.getString("end_date"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Press any key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SelectStudents() {

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT * FROM students");
            System.out.println("ID | First Name | Last Name | Date of Birth | Tuition Fees");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "."
                        + rs.getString("first_name") + " "
                        + rs.getString("last_name") + " "
                        + rs.getString("date_of_birth") + " "
                        + rs.getString("tuition_fees"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Press any key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SelectTrainers() {

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT * FROM trainers ORDER BY id");
            System.out.println("ID | First Name | Last Name | Subject");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "."
                        + rs.getString("first_name") + " "
                        + rs.getString("last_name") + " "
                        + rs.getString("subject"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Press any key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SelectAssignments() {

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT * FROM assignments");
            System.out.println("ID | Title | Description | Submission Date | Oral Mark | Total Mark");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "."
                        + rs.getString("title") + " "
                        + rs.getString("description") + " "
                        + rs.getString("sub_date") + " "
                        + rs.getString("oral_mark") + " "
                        + rs.getString("total_mark"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Press any key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SelectStudentsPerCourse() {

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT	`title` 'Course Title',\n"
                    + "        `stream` 'Stream',\n"
                    + "        `type` 'Type',\n"
                    + "		concat(first_name, ' ', last_name) 'Full Name'\n"
                    + "FROM students\n"
                    + "	INNER JOIN students_courses ON students.id = students_courses.st_id\n"
                    + "		INNER JOIN courses ON courses.id = students_courses.c_id\n"
                    + "ORDER BY courses.type, stream, first_name;");
            System.out.println("Course Title | Stream | Type | Full Name");
            while (rs.next()) {
                System.out.println(rs.getString("Course Title") + " "
                        + rs.getString("Stream") + " "
                        + rs.getString("Type") + " "
                        + rs.getString("Full Name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Press any key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SelectTrainersPerCourse() {

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT	`title` 'Course Title',\n"
                    + "        `stream` 'Stream',\n"
                    + "        `type` 'Type',\n"
                    + "		concat(first_name, ' ', last_name) 'Full Name',\n"
                    + "        `subject` 'Subject'\n"
                    + "FROM trainers\n"
                    + "	INNER JOIN trainers_courses ON trainers.id = trainers_courses.t_id\n"
                    + "		INNER JOIN courses ON courses.id = trainers_courses.c_id\n"
                    + "ORDER BY courses.type, stream, first_name;");
            System.out.println("Course Title | Stream | Type | Full Name");
            while (rs.next()) {
                System.out.println(rs.getString("Course Title") + " "
                        + rs.getString("Stream") + " "
                        + rs.getString("Type") + " "
                        + rs.getString("Full Name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Press any key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SelectAssignmentsPerCourse() {

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT	courses.title 'Course Title',\n"
                    + "        stream 'Stream',\n"
                    + "        type 'Type',\n"
                    + "		assignments.title 'Title',\n"
                    + "		description 'Description'\n"
                    + "FROM assignments\n"
                    + "	INNER JOIN assignments_courses ON assignments.id = assignments_courses.a_id\n"
                    + "		INNER JOIN courses ON courses.id = assignments_courses.c_id\n"
                    + "ORDER BY courses.title, stream, type;");
            System.out.println("Course Title | Stream | Type | Assignment Title | Description");
            while (rs.next()) {
                System.out.println(rs.getString("Course Title") + " "
                        + rs.getString("Stream") + " "
                        + rs.getString("Type") + " "
                        + rs.getString("Title") + " "
                        + rs.getString("Description"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Press any key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SelectAssignmentsPerStudentPerCourse() {

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT	courses.title 'Course Title',\n"
                    + "        stream Stream,\n"
                    + "        type Type,\n"
                    + "        assignments.title 'Assignment',\n"
                    + "        assignments.description 'Description',\n"
                    + "		concat(first_name, ' ', last_name) 'Full Name',\n"
                    + "        assignments_students_courses.oral_mark 'Oral Mark',\n"
                    + "        assignments_students_courses.total_mark 'Total Mark'\n"
                    + "FROM assignments_students_courses\n"
                    + "	INNER JOIN assignments ON assignments.id = assignments_students_courses.a_id\n"
                    + "		INNER JOIN courses ON courses.id = assignments_students_courses.c_id\n"
                    + "			INNER JOIN students ON students.id = assignments_students_courses.st_id\n"
                    + "ORDER BY assignments.title, courses.title, stream, type;");
            System.out.println("Course Title | Stream | Type | Assignment Title | Description | Full Name | Oral Mark | Total Mark");
            while (rs.next()) {
                System.out.println(rs.getString("Course Title") + " "
                        + rs.getString("Stream") + " "
                        + rs.getString("Type") + " "
                        + rs.getString("Assignment") + " "
                        + rs.getString("Description") + " "
                        + rs.getString("Full Name") + " "
                        + rs.getString("Oral Mark") + " "
                        + rs.getString("Total Mark"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Press any key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SelectStudentsInMultipleCourses() {

        ResultSet rs;
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery("SELECT	concat(first_name, ' ', last_name) 'Full Name',\n"
                    + "		title 'Course Title',\n"
                    + "		stream Stream,\n"
                    + "		type Type\n"
                    + "FROM students\n"
                    + "	INNER JOIN students_courses ON students.id = students_courses.st_id\n"
                    + "		INNER JOIN courses ON courses.id = students_courses.c_id\n"
                    + "where students.id in	(SELECT st_id \n"
                    + "						 FROM students_courses\n"
                    + "						 GROUP BY st_id \n"
                    + "						 HAVING COUNT(st_id) > 1)\n"
                    + "ORDER BY first_name;");
            System.out.println("Full Name | Course Title | Stream | Type");
            while (rs.next()) {
                System.out.println(rs.getString("Full Name") + " "
                        + rs.getString("Course Title") + " "
                        + rs.getString("Stream") + " "
                        + rs.getString("Type"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Press any key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
