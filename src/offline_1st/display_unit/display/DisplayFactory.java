package offline_1st.display_unit.display;

public class DisplayFactory {
    public Display getDisplay(String displayType) {
        String choice = displayType.toLowerCase();

        switch (choice) {
            case "oled":
                return new OLED();
            case "led":
                return new LED();
            case "touchscreen":
                return new TouchScreen();
            case "lcd":
                return new LCD(); 
            default:
                return null;       
        }
    }
}
