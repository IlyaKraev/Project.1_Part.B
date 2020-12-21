package models;


public class TrainersPerCourse {
private int trainerId;
private int courseId;

    public TrainersPerCourse() {
    }

    public TrainersPerCourse(int cId, int tId) {
        this.courseId = cId;
        this.trainerId = tId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainersId) {
        this.trainerId = trainersId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int coursesId) {
        this.courseId = coursesId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrainersPerCourse{trainerId=" ).append(trainerId);
        sb.append(", coursesId= ").append(courseId);
        sb.append('}');
        return sb.toString();
    }

    
}
