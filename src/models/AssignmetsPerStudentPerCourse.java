package models;

public class AssignmetsPerStudentPerCourse {

    private int assignmentId;
    private int courseId;
    private int studentId;
    private int oralMark;
    private int totalMark;

    public AssignmetsPerStudentPerCourse() {
    }

    public AssignmetsPerStudentPerCourse( int assignmentId, int courseId, int studentId, int oralMark, int totalMark) {
        this.assignmentId = assignmentId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
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

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AssignmetsPerStudentPerCourse{assignmentId=").append(assignmentId);
        sb.append(", studentId=").append(studentId);
        sb.append(", courseId=").append(courseId);
        sb.append(", oralMark=").append(oralMark);
        sb.append(", totalMark=").append(totalMark);
        sb.append('}');
        return sb.toString();
    }

   

}
