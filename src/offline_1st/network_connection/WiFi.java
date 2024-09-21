package offline_1st.network_connection;

public class WiFi implements Connection {
    @Override
    public String connectionInfo() {
        return "Server is connected via WiFi";
    }
    
    @Override
    public String toString() {
        return "WiFi Connection is established";
    }  
}
