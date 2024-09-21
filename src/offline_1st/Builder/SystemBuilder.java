package offline_1st.Builder;

import offline_1st.controller.Controller;
import offline_1st.identification.Identification;
import offline_1st.network_connection.Connection;
import offline_1st.payment.payment_terminal;
import offline_1st.storage.Storage;
import offline_1st.web_server.Server;

public class SystemBuilder {
    private IBuilder packageSystem;
    private Identification ticketing;
    private payment_terminal terminal;
    private Connection netConnection;
    private Storage storage;
    private Controller controller;
    private Server server;

    public SystemBuilder packageSystem(IBuilder packageSystem) {
        this.packageSystem = packageSystem;
        System.out.println(this.packageSystem.getMicrocontroller());
        System.out.println(this.packageSystem.getDisplay());
        return this;
    } 

    public SystemBuilder ticketing(Identification ticketing) {
        this.ticketing = ticketing;
        System.out.println(this.ticketing.getIdentificationInfo());
        return this;
    }

    public SystemBuilder terminal(payment_terminal terminal) {
        this.terminal = terminal;
        System.out.println(this.terminal);
        return this;
    }

    public SystemBuilder netConnection(Connection netConnection) {
        this.netConnection = netConnection;
        System.out.println(this.netConnection);
        return this;
    }

    public SystemBuilder storage(Storage storage) {
        this.storage = storage;
        System.out.println(this.storage);
        return this;
    }

    public SystemBuilder controller(Controller controller) {
        this.controller = controller;
        System.out.println(this.controller.getControllerInfo());
        return this;
    }

    public SystemBuilder server(Server server) {
        this.server = server;
        System.out.println(this.server);
        return this;
    }

    public TicketSystem build() {
        return new TicketSystem(packageSystem, ticketing, terminal, netConnection, storage, controller, server);
    }
}
