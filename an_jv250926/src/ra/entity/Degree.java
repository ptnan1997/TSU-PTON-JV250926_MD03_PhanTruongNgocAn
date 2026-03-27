package ra.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Degree {
    private int degreeId;
    private String degreeName;
    private String empId;
    private LocalDate degreeDate;
    private String schoolName;
    private int degreeYear;
    private String degree_classification;

    public Degree() {
    }

    public Degree(String degreeName, String empId, LocalDate degreeDate, String schoolName, int degreeYear, String degree_classification) {
        this.degreeName = degreeName;
        this.empId = empId;
        this.degreeDate = degreeDate;
        this.schoolName = schoolName;
        this.degreeYear = degreeYear;
        this.degree_classification = degree_classification;
    }

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public LocalDate getDegreeDate() {
        return degreeDate;
    }

    public void setDegreeDate(LocalDate degreeDate) {
        this.degreeDate = degreeDate;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getDegreeYear() {
        return degreeYear;
    }

    public void setDegreeYear(int degreeYear) {
        this.degreeYear = degreeYear;
    }

    public String getDegree_classification() {
        return degree_classification;
    }

    public void setDegree_classification(String degree_classification) {
        this.degree_classification = degree_classification;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "degreeId=" + degreeId +
                ", degreeName='" + degreeName + '\'' +
                ", empId=" + empId +
                ", degreeDate=" + degreeDate +
                ", schoolName='" + schoolName + '\'' +
                ", degreeYear=" + degreeYear +
                ", degree_classification='" + degree_classification + '\'' +
                '}';
    }
}
