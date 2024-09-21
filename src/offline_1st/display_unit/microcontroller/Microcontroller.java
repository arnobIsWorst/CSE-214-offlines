package offline_1st.display_unit.microcontroller;

import java.util.ArrayList;
import java.util.List;

public abstract class Microcontroller {
    protected List<String> supportedConnections;

    public Microcontroller(){
        supportedConnections = new ArrayList<String>();
    }

    public abstract String getMicrocontrollerInfo();

    public String getStorageType(){
        return "SD card";
    }

    public void addSupportedConnection(String connection){
        supportedConnections.add(connection);
    }

    public abstract List<String> getSupportedConnections();

    public String getIdentificationType(){
        return "RFID";
    }
} 
