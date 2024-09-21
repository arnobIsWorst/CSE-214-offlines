package offline_1st;

import java.util.List;
import java.util.Scanner;

import offline_1st.Builder.*;
import offline_1st.identification.*;
import offline_1st.network_connection.*;
import offline_1st.payment.payment_terminal;
import offline_1st.storage.*;
import offline_1st.controller.*;
import offline_1st.web_server.*;

public class Director {
    IBuilder builder;

    public void setBuilder(IBuilder builder) {
        this.builder = builder;
    }

    public String UserPromptNetConnection(){
        Scanner scanner = new Scanner(System.in);

        List<String> allowedNetConnecList = builder.getMicrocontroller().getSupportedConnections();

        System.out.println("Choose a network connection type:");

        for (int i = 0; i < allowedNetConnecList.size(); i++) {
            System.out.println(i + 1 + ". " + allowedNetConnecList.get(i));
        }

        Integer choice = Integer.parseInt(scanner.nextLine());

        if (choice > 0 && choice <= allowedNetConnecList.size()) {
            return allowedNetConnecList.get(choice - 1);
        } else {
            System.out.println("Invalid choice");
            return UserPromptNetConnection();
        }
    }

    public String UserPromptServer(){

        Scanner scanner = new Scanner(System.in);

        List<String> allowedServerList = List.of("Django", "NodeJS", "Ruby");

        System.out.println("Choose a server type:");

        for (int i = 0; i < allowedServerList.size(); i++) {
            System.out.println(i + 1 + ". " + allowedServerList.get(i));
        }

        Integer choice = Integer.parseInt(scanner.nextLine());

        if (choice > 0 && choice <= allowedServerList.size()) {
            return allowedServerList.get(choice - 1);
        } else {
            System.out.println("Invalid choice");
            return UserPromptServer();
        }
    }

    public Identification builIdentification(){
        String idType = builder.getMicrocontroller().getIdentificationType();
        return IdentificationFactory.getIdentification(idType);
    }

    public Connection buildConnection(String choice){
        return ConnectionFactory.getConnection(choice);
    }

    public Storage buildStorage(){
        String choice = builder.getMicrocontroller().getStorageType();
        return StorageFactory.getStorage(choice);
    }

    public void constructSystem(SystemBuilder systemBuilder) {
        systemBuilder.packageSystem(builder)
                     .ticketing(builIdentification())
                     .terminal(new payment_terminal());
    
        String connectionChoice = UserPromptNetConnection();

        systemBuilder.netConnection(buildConnection(connectionChoice))
                     .storage(buildStorage())
                     .controller(ControllerFactory.getController(this.builder.getControllerType()));

        String serverChoice = UserPromptServer();
        
        systemBuilder.server(ServerFactory.getServer(serverChoice));

    }
}
