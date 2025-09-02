package controller;

import model.enums.CourseStatus;
import model.user.Student;
import repository.supportticket.InMemorySupportTicketRepository;
import repository.supportticket.SupportTicketRepository;
import service.CourseService;
import service.UserService;
import service.ReportService;

/*
 * 
    Gerenciar Status de Cursos: Ativar/inativar cursos existentes (não precisa implementar CRUD completo).
    Gerenciar Planos de Alunos: Alterar o plano de assinatura de um aluno existente.
    Atender Tickets de Suporte: Processar tickets da fila em ordem FIFO.
    Gerar Relatórios e Análises: Acessar todos os relatórios da plataforma.
    Exportar Dados: Gerar a String CSV com colunas selecionáveis dinamicamente.

 */

public class AdminController {
    // Gerenciar Status de Cursos: Ativar/inativar cursos existentes (não precisa implementar CRUD completo).
    public void updateCourseStatus(String title, CourseStatus status) {
        CourseService courseService = new CourseService();
        courseService.updateCourseStatus(title, status);
    }

    // Gerenciar Planos de Alunos: Alterar o plano de assinatura de um aluno existente.
    public void updateStudentPlan(Student student) {
        UserService userService = new UserService();
        userService.updateUser(student);
    }

    // Atender Tickets de Suporte: Processar tickets da fila em ordem FIFO.
    public void processSupportTicket() {
        SupportTicketRepository supportTicketRepository = new InMemorySupportTicketRepository();
        supportTicketRepository.processTicket();
    }

    // Gerar Relatórios e Análises: Acessar todos os relatórios da plataforma.
    public void generateReports() {
        ReportService reportService = new ReportService();
        reportService.generateReports();
    }

    // Exportar Dados: Gerar a String CSV com colunas selecionáveis dinamicamente.
    public String exportData() {
        // Implementar lógica para exportar dados
        StringBuilder csvBuilder = new StringBuilder();
        UserService userService = new UserService();
        csvBuilder.append("ID,Nome,Email\n");
        userService.findAll().forEach(user -> {
            csvBuilder.append(user.getId()).append(",")
                      .append(user.getName()).append(",")
                      .append(user.getEmail()).append("\n");
        });
        return csvBuilder.toString();
    }

}
