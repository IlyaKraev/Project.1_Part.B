package models;


public class AssignmentsPerCourse {
private int assignmentId;
private int courseId;

    public AssignmentsPerCourse() {
    }

    public AssignmentsPerCourse(int assignmentId, int courseId) {
        this.assignmentId = assignmentId;
        this.courseId = courseId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
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
        sb.append("AssignmentsPerCourse{assignmentId= ").append(assignmentId);
        sb.append(", courseId= ").append(courseId);
        sb.append('}');
        return sb.toString();
    }

    
}
