package offline_1st.storage;

public class SDcard implements Storage {
    public String storageInfo() {
        return "Storage system is built upon SD Card.";
    }
    
    @Override
    public String toString() {
        return "SD Card is added to the system & fully functional.";
    }
}
