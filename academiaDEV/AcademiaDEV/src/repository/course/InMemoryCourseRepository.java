package repository.course;

import model.Course;
import model.enums.CourseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCourseRepository implements CourseRepository {
    private final Map<String, Course> courses = new HashMap<>();

    public void save(Course course) {
        courses.put(course.getTitle(), course);
    }

    public boolean updateStatus(String title, CourseStatus status) {
        Course courseToUpdate = courses.get(title);

        if (courseToUpdate != null) {
            courseToUpdate.setStatus(status);
            save(courseToUpdate);
            return true;
        }

        return false;
    }

    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }

    public Course findByTitle(String title) {
        return courses.get(title);
    }

}
