class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = tail;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;
                if (current == head) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                System.out.println("Ticket " + ticketId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket ID not found.");
        }
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                    ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        boolean found = false;
        Ticket current = head;

        System.out.println("Search Results for: " + keyword);
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No matching tickets found.");
        }
    }

    public int getTotalTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding tickets
        system.addTicket(101, "Alice", "Avengers", "A1", "10:00 AM");
        system.addTicket(102, "Bob", "Batman", "B2", "12:00 PM");
        system.addTicket(103, "Alice", "Spiderman", "C3", "2:00 PM");

        // Display all tickets
        system.displayTickets();

        // Search by customer or movie
        system.searchTicket("Alice");
        system.searchTicket("Batman");

        // Get total tickets
        System.out.println("Total Tickets Booked: " + system.getTotalTickets());

        // Remove a ticket
        system.removeTicket(102);

        // Display updated ticket list
        system.displayTickets();
    }
}
