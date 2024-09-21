package offline_1st.Builder;

import offline_1st.controller.Controller;
import offline_1st.identification.Identification;
import offline_1st.network_connection.Connection;
import offline_1st.payment.payment_terminal;
import offline_1st.storage.Storage;
import offline_1st.web_server.Server;

public class TicketSystem {
    private final IBuilder packageSystem;
    private final Identification ticketing;
    private final payment_terminal terminal;
    private final Connection netConnection;
    private final Storage storage;
    private final Controller controller;
    private final Server server;

    TicketSystem(IBuilder packageSystem, Identification ticketing, payment_terminal terminal, Connection netConnection, Storage storage, Controller controller, Server server) {
        this.packageSystem = packageSystem;
        this.ticketing = ticketing;
        this.terminal = terminal;
        this.netConnection = netConnection;
        this.storage = storage;
        this.controller = controller;
        this.server = server;
    }

    @Override   
    public String toString() {
        return "Your Ticket System is ready to use. You can now start selling tickets!";
    }
}
