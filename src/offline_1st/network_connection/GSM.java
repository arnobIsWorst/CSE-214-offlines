package offline_1st.network_connection;

public class GSM implements Connection {
    @Override
    public String connectionInfo() {
        return "Server is connected via GSM";
    }
    
    @Override
    public String toString() {
        return "GSM Connection is established";
    }
}
