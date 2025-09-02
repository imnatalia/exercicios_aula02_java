package repository.enrollment;

import model.Enrollment;
import model.enums.EnrollStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryEnrollmentRepository implements EnrollmentRepository {
    private final Map<String, Enrollment> enrollments = new HashMap<>();

    public void save(Enrollment enrollment) {
        enrollments.put(enrollment.getStudent().getEmail(), enrollment);
    }

    public List<Enrollment> findAll() {
        return new ArrayList<>(enrollments.values());
    }

    public boolean cancelEnroll(String courseTitle) {
        Enrollment enrollmentToUpdate = enrollments.get(courseTitle);

        if (enrollmentToUpdate != null) {
            enrollmentToUpdate.setStatus(EnrollStatus.CANCELED);
            save(enrollmentToUpdate);
            return true;
        }

        return false;
    }

    public boolean updateProgress(String courseTitle, float progress) {
        Enrollment enrollmentToUpdate = enrollments.get(courseTitle);

        if (enrollmentToUpdate != null) {
            enrollmentToUpdate.setProgress(progress);
            save(enrollmentToUpdate);
            return true;
        }

        return false;
    }

//    public List<Enrollment> getEnrollmentsByStudent(Student student) {
//        return new ArrayList<>(enrollments.values().equals(student.getEmail().toString()));
//    }
//
//    public Enrollment getEnrollmentByStudentAndCourse(Student student, Course course) {
//
//    }


}
