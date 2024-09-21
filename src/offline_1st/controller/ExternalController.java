package offline_1st.controller;

public class ExternalController implements Controller {
    public String getControllerInfo() {
        return "This system is using external controllers(Mouse, Keyboard) for access control";
    }
}
