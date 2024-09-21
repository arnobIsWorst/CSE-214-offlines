package offline_1st.display_unit.microcontroller;

public class MicrocontrollerFactory {
    public Microcontroller getMicrocontroller(String microcontrollerType) {
        String type = microcontrollerType.toLowerCase();

        switch (type) {
            case "raspberry pi":
                return new RaspberryPi();
            case "atmega32":
                return new ATMega32();
            case "arduino":
                return new ArduinoMega();    
            default:
                return null;
        }
    }
}
