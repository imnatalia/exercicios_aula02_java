package service;

import model.SupportTicket;
import model.enums.TicketStatus;
import repository.supportticket.InMemorySupportTicketRepository;
import repository.supportticket.SupportTicketRepository;

public class SupportTicketService {
    private SupportTicketRepository supportTicketRepository;

    public SupportTicketService() {
        this.supportTicketRepository = new InMemorySupportTicketRepository();
    }

    public String createTicket(String title, String description) {
        SupportTicket ticket = new SupportTicket(title, description, TicketStatus.NEW);
        return supportTicketRepository.add(ticket) ? "Ticket created successfully" : "Failed to create ticket";
    }

    public SupportTicket processNextTicket() {
        return supportTicketRepository.processTicket();
    }

    public long countTickets() {
        return supportTicketRepository.countTicket();
    }

}
