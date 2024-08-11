package simulation;

import java.util.ArrayList;
import java.util.Queue;


import domain.exceptions.*;



public class MarketShipmentSimulation{
    
    public static void runApp(){
        Queue<ArrayList<String>> commands = fileIO.FileIO.commands;
        while(!commands.isEmpty()){
            ArrayList<String> command = commands.poll();
            switch(command.get(0)){
                case "1":
                try{
                    CommandMethods.produce(command);}
                    catch(SameSerialNumberException e){
                        System.out.println(e.getMessage()+"\n");
                    }
                    break;
                case "2":
                    try {
                        CommandMethods.load(command);
                    } catch (BoxCapacityException|LoadedItemException|ContainerCapacityException | MismatchItemTypeException|LoadedBoxException | ItemPlacedDirectlyException e) {
                        System.out.println(e.getMessage()+"\n");
                    }
                    break;
                case "3":
                    try {
                        CommandMethods.ship(command);
                    } catch (ShippedContainerException e) {
                        System.out.println(e.getMessage()+"\n");
                    } 
                    break;
                case "4":
                    CommandMethods.revenue(command);
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        } 
    }
}
