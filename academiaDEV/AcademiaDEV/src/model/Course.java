package model;

import model.enums.CourseStatus;
import model.enums.DifficultyLevel;

public class Course {
    private int id;
    private String title;
    private String description;
    private String instructorName;
    private float durationInHours;
    private DifficultyLevel difficultyLevel;
    private CourseStatus status;

    public Course(String title, String description, String instructorName, float durationInHours, DifficultyLevel difficultyLevel) {
        this.title = title;
        this.description = description;
        this.instructorName = instructorName;
        this.durationInHours = durationInHours;
        this.difficultyLevel = difficultyLevel;
        this.status = CourseStatus.ACTIVE;
    }

    public String getTitle() {
        return this.title;
    }

    public CourseStatus getStatus() {
        return this.status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public String getDifficultyLevel() {
        return this.difficultyLevel.name();
    }

    public String getInstructorName() {
        return this.instructorName;
    }

}
