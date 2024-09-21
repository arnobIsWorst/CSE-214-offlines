package offline_1st.Builder;

import offline_1st.display_unit.display.OLED;
import offline_1st.display_unit.microcontroller.RaspberryPi;

public class AdvancedPackage extends IBuilder{

    public void buildPackage() {
        microcontroller = new RaspberryPi();
        System.out.println(microcontroller.getMicrocontrollerInfo());
        display = new OLED();
        System.out.println(display.getDisplayInfo());
    }

    public String getControllerType() {
        return "External";
    }
}
