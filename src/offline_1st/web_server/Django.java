package offline_1st.web_server;

public class Django implements Server {
    public String storageInfo() {
        return "This server is using Django";
    }

    @Override
    public String toString() {
        return "Django Server is running";
    }
}
