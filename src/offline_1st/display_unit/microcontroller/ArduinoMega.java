package offline_1st.display_unit.microcontroller;

import java.util.Arrays;
import java.util.List;

public class ArduinoMega extends Microcontroller {
    @Override
    public String getMicrocontrollerInfo() {
        return "System uses ArduinoMega Microcontroller for display unit";
    } 

    public List<String> getSupportedConnections() {
        supportedConnections.addAll(Arrays.asList("WiFi", "GSM"));
        return supportedConnections;
    }

    @Override   
    public String toString() {
        return "ArduinoMega Microcontroller is running";
    }
}
