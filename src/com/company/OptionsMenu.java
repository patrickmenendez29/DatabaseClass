package com.company;

import javax.lang.model.type.NullType;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

public class OptionsMenu {

    CheckpointController controller = new CheckpointController();

    public OptionsMenu() {
        Scanner scanner = new Scanner(System.in);

        //TODO: dile a tu pinche maestro que les ensene a hacer esto o que sino le corto un huevo

        HashMap<String, Runnable> options = new HashMap<>();

        options.put("register",()->{
            System.out.println("Please enter the address");
            controller.registerAddress(scanner.next());
        });
        options.put("remove",()->{
            System.out.println("Please enter the address");
            controller.removeAddress(scanner.next());
        });
        options.put("request",()->{
            System.out.println("Please enter the license plate and address");
            controller.requestAccess(scanner.next(),scanner.next());
        });
        options.put("exit",()-> {
            System.exit(0);
        });



        while (true){
            System.out.println("Please select one on the following\n" +
                    "register: register a new address\n" +
                    "remove: remove an adress\n" +
                    "request: request access\n" +
                    "exit: exit system");
            options.get(scanner.next()).run();
        }



    }
}
