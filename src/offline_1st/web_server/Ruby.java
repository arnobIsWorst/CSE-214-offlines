package offline_1st.web_server;

public class Ruby implements Server {
    public String storageInfo() {
        return "This server is using Ruby";
    }

    @Override
    public String toString() {
        return "Ruby Server is running";
    }
}
