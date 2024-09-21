package offline_1st.identification;

public class IdentificationFactory {
    public static Identification getIdentification(String identificationType) {
        if (identificationType.equalsIgnoreCase("RFID")) {
            return new RFID();
        } else if (identificationType.equalsIgnoreCase("NFC")) {
            return new NFC();
        } 
        return null;
    }
}
