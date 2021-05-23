package com.company;

import java.io.*;
import java.util.ArrayList;

public class Database {
    public ArrayList<String> content;
    private final String databaseName;

    public ArrayList<String> getContent() {
        return content;
    }

    public Database(String databaseName) {
        this.databaseName = databaseName;
        this.content = readDatabase(databaseName);
    }

    public void saveDatabase(){
       try
       {
           FileOutputStream fos = new FileOutputStream(databaseName);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(content);
           oos.close();
           fos.close();
       }
       catch (IOException ioe)
       {
           ioe.printStackTrace();
       }
   }

   private ArrayList<String> readDatabase(String databaseName){
       ArrayList<String> content;

       try
       {
           FileInputStream fis = new FileInputStream(databaseName);
           ObjectInputStream ois = new ObjectInputStream(fis);

           content = (ArrayList) ois.readObject();

           if (content == null){
               content = new ArrayList<>();
           }


           ois.close();
           fis.close();
       }
       catch (IOException ioe)
       {

           System.out.println("Database was null, creating a new one");
           content = new ArrayList<>();
           saveDatabase();

           return content;
       }
       catch (ClassNotFoundException c)
       {
           System.out.println("Class not found");
           c.printStackTrace();
           System.out.println("WARNING: DATABASE RETURNED NULL");
           return null;
       }
       return content;
   }

    @Override
    public String toString() {
        return content.toString();
    }
}
