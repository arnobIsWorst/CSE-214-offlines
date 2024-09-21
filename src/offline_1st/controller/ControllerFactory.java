package offline_1st.controller;

public class ControllerFactory {
    public static Controller getController(String controllerType) {
        if (controllerType.equalsIgnoreCase("internal")) {
            return new InternalController();
        } else if (controllerType.equalsIgnoreCase("external")) {
            return new ExternalController();
        }
        return null;
    }
}
