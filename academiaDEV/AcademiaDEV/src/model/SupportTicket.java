package model;

import model.enums.TicketStatus;
import model.user.User;

public class SupportTicket {
    private int id;
    private String title;
    private String message;
    private TicketStatus status;

    public SupportTicket(String title, String message, TicketStatus status) {
        this.title = title;
        this.message = message;
        this.status = status;
    }
}