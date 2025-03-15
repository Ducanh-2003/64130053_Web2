package models;

import lombok.Getter;
@Getter
public class StudentModel {

    private final String stuId;
    private final String stuName;
    private final boolean gender;
    private final String stuDOB;

    public StudentModel(String stuId, String stuName, boolean gender, String stuDOB) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.gender = gender;
        this.stuDOB = stuDOB;
    }
}
