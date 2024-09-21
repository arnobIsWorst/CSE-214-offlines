package offline_1st.display_unit.microcontroller;

import java.util.List;

public class RaspberryPi extends Microcontroller {
    @Override
    public String getMicrocontrollerInfo() {
        return "Raspberry Pi is used as a microcontroller for the display unit";
    }

    public List<String> getSupportedConnections() {
        supportedConnections.addAll(List.of("WiFi", "GSM", "Ethernet"));
        return supportedConnections;
    }

    @Override
    public String getStorageType() {
        return "Internal Storage";
    }

    @Override
    public String getIdentificationType() {
        return "NFC";
    }

    @Override
    public String toString() {
        return "Raspberry Pi is running";
    }
}
