package service;

import java.util.Comparator;
import java.util.stream.Collectors;

import model.Course;
import model.Enrollment;
import model.enums.CourseStatus;
import model.enums.EnrollStatus;
import model.user.Student;
import repository.course.CourseRepository;
import repository.course.InMemoryCourseRepository;
import repository.enrollment.EnrollmentRepository;
import repository.enrollment.InMemoryEnrollmentRepository;
import repository.user.InMemoryUserRepository;
import repository.user.UserRepository;

public class ReportService {
    CourseRepository courseRepository;
    UserRepository userRepository;
    EnrollmentRepository enrollmentRepository;

    public ReportService() {
        this.courseRepository = new InMemoryCourseRepository();
        this.userRepository = new InMemoryUserRepository();
        this.enrollmentRepository = new InMemoryEnrollmentRepository();
    }

    public void generateReports() {
        // Lista de cursos por difficulty level
        courseRepository.findAll().stream()
            .collect(Collectors.groupingBy(Course::getDifficultyLevel))
            .forEach((difficulty, courses) -> {
                System.out.println("Cursos de dificuldade " + difficulty + ":");
                courses.forEach(course -> System.out.println(" - " + course.getTitle()));
            });

        // Relação de instrutores únicos que ministram cursos ACTIVE
        courseRepository.findAll().stream()
            .filter(course -> course.getStatus() == CourseStatus.ACTIVE)
            .map(Course::getInstructorName)
            .distinct()
            .forEach(instructor -> System.out.println("Instrutor ativo: " + instructor));

        // Agrupamento de alunos por subscription plan
        userRepository.findAll().stream()
            .filter(user -> user instanceof Student)
            .map(user -> (Student) user)
            .collect(Collectors.groupingBy(Student::getSubscriptionPlan))
            .forEach((plan, students) -> {
                System.out.println("Alunos do plano " + plan + ":");
                students.forEach(student -> System.out.println(" - " + student.getName()));
            });

        // Média geral de progresso de todas as matrículas
        double averageProgress = enrollmentRepository.findAll().stream()
            .mapToDouble(enrollment -> enrollment.getProgress())
            .average()
            .orElse(0);
        System.out.println("Média de progresso: " + averageProgress);

        // Aluno com maior número de matrículas ativas
        enrollmentRepository.findAll().stream()
            .filter(enrollment -> enrollment.getStatus() == EnrollStatus.ON_GOING)
            .collect(Collectors.groupingBy(Enrollment::getStudent))
            .entrySet().stream()
            .max(Comparator.comparingInt(entry -> entry.getValue().size()))
            .ifPresent(entry -> System.out.println("Aluno com mais matrículas ativas: " + entry.getKey().getName()));
    }
}
