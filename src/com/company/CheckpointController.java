package com.company;

public class CheckpointController {
    private final Database registeredPlates;
    private final Database blacklist;
    private final Database addresses;

    public CheckpointController() {
        this.registeredPlates = new Database("plates.db");
        this.blacklist = new Database("blacklist.db");
        this.addresses = new Database("addresses.db");
    }

    public void requestAccess(String plate, String address){
        //TODO: Que si la placa ya esta registrada pero la direccion no es correcta
        System.out.println(registeredPlates);
        if (registeredPlates.getContent().contains(plate)){
            System.out.println("Calling "+ address);
            return;
        }
        if (addresses.getContent().contains(address)){
            registeredPlates.getContent().add(plate);
        } else {
            System.out.println("Address not found, blacklisting plate");
            blacklistPlate(plate);
        }
    }

    public void registerAddress(String address){
        addresses.getContent().add(address);
    }

    public void removeAddress(String address){
        addresses.getContent().remove(address);
    }



    public void blacklistPlate(String plate){
        blacklist.getContent().add(plate);
    }
}
