package offline_1st.Builder;

import offline_1st.display_unit.display.Display;
import offline_1st.display_unit.microcontroller.Microcontroller;

public abstract class IBuilder {
    protected Microcontroller microcontroller;
    protected Display display;

    public Microcontroller getMicrocontroller() {
        return microcontroller;
    }

    public Display getDisplay() {
        return display;
    }

    public abstract void buildPackage();

    public abstract String getControllerType();
}
