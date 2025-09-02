package service;

import java.util.List;
import java.util.stream.Collectors;

import model.Course;
import model.enums.CourseStatus;
import repository.course.CourseRepository;
import repository.course.InMemoryCourseRepository;

public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService() {
        this.courseRepository = new InMemoryCourseRepository();
    }

    public void updateCourseStatus(String title, CourseStatus status) {
        courseRepository.updateStatus(title, status);
    }

    public List<Course> listActiveCourses() {
        return courseRepository.findAll().stream()
            .filter(course -> course.getStatus() == CourseStatus.ACTIVE)
            .collect(Collectors.toList());
    }

}
