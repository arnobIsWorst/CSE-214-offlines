package offline_1st.display_unit.display;

public class LED implements Display {
    public String getDisplayInfo() {
        return "System uses LED Display for display unit";
    } 

    @Override   
    public String toString() {
        return "LED Display is running";
    }
}
