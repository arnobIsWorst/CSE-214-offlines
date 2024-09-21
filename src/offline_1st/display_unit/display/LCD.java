package offline_1st.display_unit.display;

public class LCD implements Display {
    public String getDisplayInfo() {
        return "System uses LCD Display for display unit";
    } 

    @Override   
    public String toString() {
        return "LCD Display is running";
    }
}
