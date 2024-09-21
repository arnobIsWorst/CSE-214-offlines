package offline_1st.display_unit.display;

public class OLED implements Display {
    public String getDisplayInfo() {
        return "System uses OLED Display for display unit";
    } 

    @Override   
    public String toString() {
        return "OLED Display is running";
    }
}
