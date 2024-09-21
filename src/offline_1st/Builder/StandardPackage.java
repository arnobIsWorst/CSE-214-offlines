package offline_1st.Builder;

import offline_1st.display_unit.display.LED;
import offline_1st.display_unit.microcontroller.ArduinoMega;

public class StandardPackage extends IBuilder{
   
    public void buildPackage() {
        microcontroller = new ArduinoMega();
        System.out.println(microcontroller.getMicrocontrollerInfo());
        display = new LED();
        System.out.println(display.getDisplayInfo());
    }

    public String getControllerType() {
        return "External";
    }
}
