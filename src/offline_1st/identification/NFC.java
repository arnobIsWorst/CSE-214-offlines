package offline_1st.identification;

public class NFC implements Identification {
    @Override
    public String getIdentificationInfo() {
        return "This system is using NFC cards for identification";
    }
}
