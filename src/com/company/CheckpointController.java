package com.company;

public class CheckpointController {
    private final Database registeredPlates;
    private final Database blacklist;
    private final Database addresses;

    public Database getRegisteredPlates() {
        return registeredPlates;
    }

    public Database getBlacklist() {
        return blacklist;
    }

    public Database getAddresses() {
        return addresses;
    }

    public CheckpointController() {
        this.registeredPlates = new Database("plates.db");
        this.blacklist = new Database("blacklist.db");
        this.addresses = new Database("addresses.db");
    }

    public void requestAccess(String plate, String address){
        if (blacklist.getContent().contains(plate)){
            System.out.println("Access denied");
            return;
        }
        //TODO: Que si la placa ya esta registrada pero la direccion no es correcta
        if (registeredPlates.getContent().contains(plate)){
            System.out.println("Calling "+ address);
            return;
        }
        if (addresses.getContent().contains(address)){
            registeredPlates.getContent().add(plate);
            System.out.println("Calling "+ address);
        } else {
            System.out.println("Address not found, blacklisting plate");
            blacklistPlate(plate);
        }
    }

    public void registerAddress(String address){
        addresses.content.add(address);
        System.out.println("Address registere");
    }

    public void removeAddress(String address){
        addresses.content.remove(address);
    }



    public void blacklistPlate(String plate){
        blacklist.content.add(plate);
    }
}
