package view;

import model.enums.CourseStatus;
import model.plan.PremiumPlan;
import model.plan.SubscriptionPlan;
import model.user.Admin;
import model.user.Student;
import view.utils.ConsoleUtils;

import java.util.Scanner;

import controller.AdminController;

public class AdminView {
    private final Scanner scanner;
    private final AdminController adminController;

    public AdminView(Scanner scanner) {
        this.scanner = scanner;
        this.adminController = new AdminController();
    }

    public void displayMenu(Admin admin) {
        String choice;
        do {
            ConsoleUtils.clearScreen();
            System.out.println("=========================================");
            System.out.println("||         PAINEL DO ADMINISTRADOR     ||");
            System.out.println("=========================================");
            System.out.println("Olá, " + admin.getName() + "!");
            System.out.println("\nO que você gostaria de fazer?");
            System.out.println("1 - Gerenciar Status de Cursos");
            System.out.println("2 - Gerenciar Plano de Assinatura de Aluno");
            System.out.println("3 - Atender Próximo Ticket de Suporte");
            System.out.println("4 - Gerar Relatórios e Análises");
            System.out.println("5 - Exportar Dados para CSV");
            System.out.println("6 - Sair (Logout)");
            System.out.print("\nOpção: ");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    this.adminController.updateCourseStatus("Curso Exemplo", CourseStatus.INACTIVE);
                    break;
                case "2":
                    Student student = new Student("ana@email.com", new PremiumPlan());
                    this.adminController.updateStudentPlan(student);
                    break;
                case "3":
                    this.adminController.processSupportTicket();
                    break;
                case "4":
                    this.adminController.generateReports();
                    break;
                case "5":
                    this.adminController.exportData();
                    break;
                case "6":
                    System.out.println("\nFazendo logout...");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
            if (!choice.equals("6")) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (!choice.equals("6"));
    }
}
