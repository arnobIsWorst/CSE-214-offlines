package offline_1st.network_connection;

public class ConnectionFactory {
    public static Connection getConnection(String connectionType) {
        String choice = connectionType.toLowerCase();

        switch (choice) {
            case "ethernet":
                return new Ethernet();
            case "wifi":
                return new WiFi();    
            case "gsm":
                return new GSM();
            default:
                System.out.println("Invalid Connection Type");
                break;
        }
        return null;
    }
}
