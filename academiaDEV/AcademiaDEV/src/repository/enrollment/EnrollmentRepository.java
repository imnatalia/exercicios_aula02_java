package repository.enrollment;

import model.Enrollment;

import java.util.List;

public interface EnrollmentRepository {
    public void save(Enrollment enrollment);
    public List<Enrollment> findAll();
    public boolean cancelEnroll(String courseTitle);
    public boolean updateProgress(String courseTitle, float progress);
//    public List<Enrollment> getEnrollmentsByStudent(Student student);
//    public Enrollment getEnrollmentByStudentAndCourse(Student student, Course course);
}
