package controller;

import model.Course;
import model.user.Student;
import service.CourseService;
import service.EnrollmentService;
import service.SupportTicketService;

public class StudentController {
    EnrollmentService enrollmentService;
    SupportTicketService supportTicketService;

    public StudentController() {
        this.enrollmentService = new EnrollmentService();
        this.supportTicketService = new SupportTicketService();
    }

    public boolean enrollStudentInCourse(Student student, Course course) {
        return enrollmentService.enrollStudentInCourse(student, course);
    }

    public void createSupportTicket(String title, String issueDescription) {
        supportTicketService.createTicket(title, issueDescription);
    }

    public void viewEnrollments() {
        enrollmentService.viewEnrollments();
    }

    public void updateProgress(String title, float progress) {
        enrollmentService.updateProgress(title, progress);
    }

    public void cancelEnrollment(String title) {
        enrollmentService.cancelEnrollment(title);
    }

    public void listActiveCourses() {
        CourseService courseService = new CourseService();
        courseService.listActiveCourses();    
    }
}
