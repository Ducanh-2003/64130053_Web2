package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentModel {
    private String stuId;
    private String stuName;
    private double stuGrade;

    public StudentModel() {}

    public StudentModel(String stuId, String stuName, double stuGrade) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuGrade = stuGrade;
    }
}
