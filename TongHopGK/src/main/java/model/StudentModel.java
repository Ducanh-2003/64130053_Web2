package model;
import lombok.Getter;
@Getter
public class StudentModel {
    private final String stuId;
    private final String stuName;
    private final double stuGrade;

    public StudentModel(String stuId, String stuName, double stuGrade) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuGrade = stuGrade;
    }
}
