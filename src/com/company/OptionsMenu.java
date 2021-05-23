package com.company;

import java.util.HashMap;
import java.util.Scanner;

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

        options.put("print--plate",()-> {
            System.out.println(controller.getRegisteredPlates());
        });

        options.put("print--blacklist",()-> {
            System.out.println(controller.getBlacklist());
        });

        options.put("print--addr",()-> {
            System.out.println(controller.getAddresses());
        });



        while (true){
            System.out.println("Please select one on the following\n" +
                    "register: register a new address\n" +
                    "remove: remove an adress\n" +
                    "request: request access\n" +
                    "exit: exit system");
            String arg = scanner.next();
            if (options.containsKey(arg)){
                options.get(arg).run();

            } else {
                System.out.println("Invalid argument");
            }
        }



    }
}
