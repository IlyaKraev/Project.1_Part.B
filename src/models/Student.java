package models;

import java.time.LocalDate;


public class Student {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private double tuitionFees;

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate birthDate, double tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.tuitionFees = tuitionFees;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", tuitionFees=").append(tuitionFees);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
