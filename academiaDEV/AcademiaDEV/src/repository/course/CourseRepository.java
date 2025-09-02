package repository.course;

import model.Course;
import model.enums.CourseStatus;

import java.util.List;

public interface CourseRepository {
    public void save(Course course);
    public boolean updateStatus(String title, CourseStatus status);
    public List<Course> findAll();
    public Course findByTitle(String title);
}
