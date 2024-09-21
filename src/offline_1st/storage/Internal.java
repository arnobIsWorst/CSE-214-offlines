package offline_1st.storage;

public class Internal implements Storage {
    public String storageInfo() {
        return "Storage system is built upon Internal Storage";
    }
    
    @Override
    public String toString() {
        return "Internal Storage is by default added to the system & fully functional.";
    }
}
