package view;

import controller.AuthController;
import model.user.Admin;
import model.user.Student;
import model.user.User;
import view.utils.ConsoleUtils;

import java.util.Optional;
import java.util.Scanner;

public class MainView {
    private final Scanner scanner;
    private final AuthController authController;
    private final AdminView adminView;
    private final StudentView studentView;

    public MainView() {
        this.scanner = new Scanner(System.in);
        this.authController = new AuthController();
        this.adminView = new AdminView(scanner);
        this.studentView = new StudentView(scanner);
    }

    public void run() {
        while (true) {
            ConsoleUtils.clearScreen();
            System.out.println("=========================================");
            System.out.println("||       BEM-VINDO À ACADEMIADEV       ||");
            System.out.println("=========================================");
            System.out.println("\nPor favor, escolha uma opção:");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Sair");
            System.out.print("\nOpção: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleLogin();
                    break;
                case "2":
                    System.out.println("\nObrigado por usar a AcademiaDev. Até logo!");
                    return;
                default:
                    System.out.println("\nOpção inválida! Pressione Enter para tentar novamente.");
                    scanner.nextLine();
            }
        }
    }

    private void handleLogin() {
        ConsoleUtils.clearScreen();
        System.out.println("-----------------------------------------");
        System.out.println("|                 LOGIN                 |");
        System.out.println("-----------------------------------------");
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        Optional<User> loggedInUser = authController.login(email);

        if (loggedInUser.isPresent()) {
            User user = loggedInUser.get();

            if (user instanceof Admin) {
                adminView.displayMenu((Admin) user);
            } else if (user instanceof Student) {
                studentView.displayMenu((Student) user);
            }
        } else {
            System.out.println("\nE-mail não encontrado! Login falhou.");
            System.out.println("Pressione Enter para voltar ao menu principal.");
            scanner.nextLine();
        }
    }
}
