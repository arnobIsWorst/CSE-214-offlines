package offline_1st.display_unit.display;

public class TouchScreen implements Display {
    public String getDisplayInfo() {
        return "System uses TouchScreen Display for display unit";
    } 

    @Override   
    public String toString() {
        return "TouchScreen Display is running";
    }
}
