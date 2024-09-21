package offline_1st.Builder;

import offline_1st.display_unit.display.TouchScreen;
import offline_1st.display_unit.microcontroller.RaspberryPi;

public class PremiumPackage extends IBuilder{

    public void buildPackage() {
        microcontroller = new RaspberryPi();
        System.out.println(microcontroller.getMicrocontrollerInfo());
        display = new TouchScreen();
        System.out.println(display.getDisplayInfo());
    }

    public String getControllerType() {
        return "Internal";
    }
}
