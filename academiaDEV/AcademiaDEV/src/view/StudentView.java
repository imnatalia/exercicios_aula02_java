package view;

import model.Course;
import model.enums.DifficultyLevel;
import model.user.Student;
import view.utils.ConsoleUtils;

import java.util.Scanner;

import controller.StudentController;

public class StudentView {
    private final Scanner scanner;
    private final StudentController studentController;

    public StudentView(Scanner scanner) {
        this.scanner = scanner;
        this.studentController = new StudentController();
    }

    public void displayMenu(Student student) {
        String choice;
        do {
            ConsoleUtils.clearScreen();
            System.out.println("=========================================");
            System.out.println("||           PORTAL DO ALUNO           ||");
            System.out.println("=========================================");
            System.out.println("Olá, " + student.getName() + "!");
            System.out.println("\nO que você gostaria de fazer?");
            System.out.println("1 - Ver Cursos Disponíveis");
            System.out.println("2 - Matricular-se em um Curso");
            System.out.println("3 - Minhas Matrículas e Progresso");
            System.out.println("4 - Atualizar Progresso de um Curso");
            System.out.println("5 - Cancelar Matrícula");
            System.out.println("6 - Abrir Ticket de Suporte");
            System.out.println("7 - Sair (Logout)");
            System.out.print("\nOpção: ");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    this.studentController.listActiveCourses();
                    break;
                case "2":
                    Course course = new Course("curso", "descricao", "nome", 10, DifficultyLevel.BEGINNER);
                    Student studentNew = new Student("nome", "email");
                    this.studentController.enrollStudentInCourse(studentNew, course);
                    break;
                case "3":
                    this.studentController.viewEnrollments();
                    break;
                case "4":
                    this.studentController.updateProgress("curso", 50);
                    break;
                case "5":
                    this.studentController.cancelEnrollment("curso");
                    break;
                case "6":
                    this.studentController.createSupportTicket("titulo", "descricao do problema");
                    break;
                case "7":
                    System.out.println("\nFazendo logout...");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }

            if (!choice.equals("7")) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (!choice.equals("7"));
    }
}
