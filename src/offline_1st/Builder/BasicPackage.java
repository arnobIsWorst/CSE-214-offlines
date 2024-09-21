package offline_1st.Builder;
import offline_1st.display_unit.display.LCD;
import offline_1st.display_unit.microcontroller.ATMega32;


public class BasicPackage extends IBuilder{

    public void buildPackage() {
        microcontroller = new ATMega32();
        System.out.println(microcontroller.getMicrocontrollerInfo());
        display = new LCD();
        System.out.println(display.getDisplayInfo());
    }

    public String getControllerType() {
        return "External";
    }
}
