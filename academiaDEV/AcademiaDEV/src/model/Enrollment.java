package model;

import model.enums.EnrollStatus;
import model.user.Student;

import java.util.UUID;

public class Enrollment {
    private UUID id;
    private Course course;
    private Student student;
    private float progress;
    private EnrollStatus status;

    public Enrollment(Student student, Course course) {
        this.id = UUID.randomUUID();
        this.student = student;
        this.course = course;
        this.progress = 0;
        this.status = EnrollStatus.ON_GOING;
    }

    public Student getStudent() {
        return student;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public void setStatus(EnrollStatus status) {
        this.status = status;
    }

    public float getProgress() {
        return progress;
    }

    public EnrollStatus getStatus() {
        return status;
    }

    public Course getCourse() {
        return course;
    }
}
