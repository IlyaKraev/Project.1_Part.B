package models;

import java.time.LocalDate;


public class Assignment {
    private String title;
    private String description;
    private LocalDate submissionDate;
    private int oralMark;
    private int totalMark;

    public Assignment() {
    }

    public Assignment(String title, String description, LocalDate submissionDate, int oralMark, int totalMark) {
        this.title = title;
        this.description = description;
        this.submissionDate = submissionDate;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
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
        sb.append("Assignment{title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", submissionDate=").append(submissionDate);
        sb.append(", oralMark=").append(oralMark);
        sb.append(", totalMark=").append(totalMark);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
