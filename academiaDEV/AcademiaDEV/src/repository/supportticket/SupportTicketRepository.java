package repository.supportticket;

import model.SupportTicket;

public interface SupportTicketRepository {
    public boolean add(SupportTicket supportTicket);
    public SupportTicket processTicket();
    public long countTicket();
}
