package service;

import model.Course;
import model.Enrollment;
import model.enums.CourseStatus;
import model.enums.EnrollStatus;
import model.plan.BasicPlan;
import model.user.Student;
import repository.enrollment.EnrollmentRepository;

public class EnrollmentService {
    EnrollmentRepository enrollmentRepository;

    public boolean enrollStudentInCourse(Student student, Course course) {
        // Verifica se o curso está ativo
        if (course.getStatus() != CourseStatus.ACTIVE) {
            System.out.println("Curso não está ativo.");
            return false;
        }

        // Verifica se o aluno já está matriculado no curso
        if (enrollmentRepository.findAll()
            .stream()
            .anyMatch(enrollment -> enrollment.getStudent().equals(student) && enrollment.getCourse().equals(course))) {
            System.out.println("Aluno já está matriculado neste curso.");
            return false;
        }

        // Verifica limite de matrículas ativas para o plano básico
        if (student.getSubscriptionPlan() instanceof BasicPlan) {
            long activeEnrollments = enrollmentRepository.findAll().stream()
                .filter(enrollment -> enrollment.getStudent().equals(student) && enrollment.getStatus() == EnrollStatus.ON_GOING)
                .count();
            if (activeEnrollments >= 3) {
                System.out.println("Limite de 3 matrículas ativas atingido.");
                return false;
            }
        }

        // Cria nova matrícula
        Enrollment enrollment = new Enrollment(student, course);
        enrollmentRepository.save(enrollment);
        System.out.println("Matrícula realizada com sucesso.");
        return true;
    }

    public void viewEnrollments() {
        enrollmentRepository.findAll();
    }

    public void updateProgress(String title, float progress) {
        enrollmentRepository.updateProgress(title, progress);
    }

    public void cancelEnrollment(String title) {
        enrollmentRepository.cancelEnroll(title);
    }

}
