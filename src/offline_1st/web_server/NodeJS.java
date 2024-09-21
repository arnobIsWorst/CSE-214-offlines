package offline_1st.web_server;

public class NodeJS implements Server {
    public String storageInfo() {
        return "This server is using NodeJS";
    }
    
    @Override
    public String toString() {
        return "NodeJS Server is running";
    }
}
