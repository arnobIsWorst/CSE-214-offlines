package offline_1st;

import java.util.Scanner;

import offline_1st.Builder.AdvancedPackage;
import offline_1st.Builder.BasicPackage;
import offline_1st.Builder.IBuilder;
import offline_1st.Builder.PremiumPackage;
import offline_1st.Builder.StandardPackage;
import offline_1st.Builder.SystemBuilder;


public class MainApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Ticket management system");

        System.out.println("Choose one of the following packages for building your ticketing system: ");
        System.out.println("1. Basic Package - ATMega32 with LCD display");
        System.out.println("2. Standard Package - ArduinoMega with LED display");
        System.out.println("3. Advanced Package - RaspberryPi with OLED display");
        System.out.println("4. Premium Package - RaspberryPi with TouchScreen display");
        
        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();

        Director director = new Director();
        IBuilder packageBuilder = null;
        
        switch (choice) {
            case "1":
                packageBuilder = new BasicPackage();
                break;
            case "2":
                packageBuilder = new StandardPackage();
                break;
            case "3":
                packageBuilder = new AdvancedPackage();
                break;
            case "4":
                packageBuilder = new PremiumPackage();
                break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return;
        }
        
        packageBuilder.buildPackage();
        System.out.println("Building your ticketing system...");
        
        director.setBuilder(packageBuilder);
        SystemBuilder systemBuilder = new SystemBuilder();
        director.constructSystem(systemBuilder);
        System.out.println(systemBuilder.build());
        scanner.close();
    }
}
