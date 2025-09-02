package repository.supportticket;

import model.SupportTicket;

import java.util.ArrayDeque;
import java.util.Queue;

public class InMemorySupportTicketRepository implements SupportTicketRepository {
    private final Queue<SupportTicket> supportTickets = new ArrayDeque<>();

    public boolean add(SupportTicket supportTicket) {
        if (supportTickets.add(supportTicket)) {
            return true;
        };
        return false;
    }

    public SupportTicket processTicket() {
        return supportTickets.peek();
    }

    public long countTicket() {
        return supportTickets.size();
    }


}
