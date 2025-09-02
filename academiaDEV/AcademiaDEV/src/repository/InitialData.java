package repository;

import model.Course;
import model.enums.DifficultyLevel;
import model.user.Admin;
import model.user.Student;
import repository.course.CourseRepository;
import repository.user.UserRepository;

public class InitialData {
    public void populateData(UserRepository userRepository, CourseRepository courseRepository) {
        // users
        Admin user1 = new Admin("Alice", "alice@mail.com");
        Student user2 = new Student("Bob", "bob@mail.com");
        userRepository.save(user1);
        userRepository.save(user2);

        // courses
        Course course1 = new Course("Math 101", "Basic Mathematics", "Dr. Smith", 40, DifficultyLevel.BEGINNER);
        Course course2 = new Course("CS 101", "Introduction to Computer Science", "Dr. Johnson", 60, DifficultyLevel.INTERMEDIATE);
        courseRepository.save(course1);
        courseRepository.save(course2);
    }
}