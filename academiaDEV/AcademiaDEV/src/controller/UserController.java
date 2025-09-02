package controller;

import service.CourseService;
import service.SupportTicketService;

/*
 * Consultar Catálogo de Cursos: Listar cursos ativos disponíveis.
Abrir Ticket de Suporte: Criar um novo ticket para a fila de atendimento.
 */
public class UserController {
    // Consultar Catálogo de Cursos: Listar cursos ativos disponíveis.
    public void listActiveCourses() {
        CourseService courseService = new CourseService();
        courseService.listActiveCourses();
    }

    // Abrir Ticket de Suporte: Criar um novo ticket para a fila de atendimento.
    public void createTicket(String title, String description) {
        SupportTicketService supportTicketService = new SupportTicketService();
        supportTicketService.createTicket(title, description);
    }
}
