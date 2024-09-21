package offline_1st.network_connection;

public class Ethernet implements Connection {
    @Override
    public String connectionInfo() {
        return "Server is connected via Ethernet";
    }
    
    @Override
    public String toString() {
        return "Ethernet Connection is established";
    }
}
