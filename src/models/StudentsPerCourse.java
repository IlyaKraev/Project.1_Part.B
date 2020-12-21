package models;


public class StudentsPerCourse {

    private int studentId;
    private int courseId;

    public StudentsPerCourse() {
    }

    public StudentsPerCourse(int cId, int stId) {
        this.courseId = cId;
        this.studentId = stId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StudentsPerCourse{studentId=").append(studentId);
        sb.append(", courseId=").append(courseId);
        sb.append('}');
        return sb.toString();
    }
    
    
}
