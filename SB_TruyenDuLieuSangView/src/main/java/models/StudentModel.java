package models;

import lombok.Getter;

public class StudentModel {
    @Getter
    private String stuId;
    @Getter
    private String stuName;
    private boolean gender;
    @Getter
    private String stuDOB;

    public StudentModel(String stuId, String stuName, boolean gender, String stuDOB) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.gender = gender;
        this.stuDOB = stuDOB;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setStuDOB(String stuDOB) {
        this.stuDOB = stuDOB;
    }
}
