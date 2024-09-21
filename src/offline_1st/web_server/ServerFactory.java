package offline_1st.web_server;

public class ServerFactory {
    public static Server getServer(String serverType){
        String choice = serverType.toLowerCase();
        switch (choice) {
            case "nodejs":
                return new NodeJS();
            case "ruby":
                return new Ruby();
            case "django":
                return new Django();
            default:
                return null;
        }
    }
}
