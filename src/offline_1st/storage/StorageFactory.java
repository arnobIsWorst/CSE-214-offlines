package offline_1st.storage;

public class StorageFactory {
    public static Storage getStorage(String storageType) {
        if (storageType.equalsIgnoreCase("sd card")) {
            return new SDcard();
        } else if (storageType.equalsIgnoreCase("internal storage")) {
            return new Internal();
        }
        return null;
    }
}
