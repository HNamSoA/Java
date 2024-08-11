package simulation;

import java.util.ArrayList;
import java.util.HashMap;

import domain.container.*;
import domain.enums.Produce;
import domain.exceptions.*;
import domain.items.*;



public class CommandMethods {
    private static HashMap<String,Container<ItemBox<Item>>> containerMap = new HashMap<String,Container<ItemBox<Item>>>();
    private static HashMap<String,ItemBox<Item>> boxMap = new HashMap<String,ItemBox<Item>>();
    private static HashMap<String,Item> itemMap = new HashMap<String,Item>();
    private static ArrayList<String> serialNumberList = new ArrayList<String>();
    private static double revenue = 0;
   
    /**
     * This method is used to produce items
     * @param command
     * @throws SameSerialNumberException
     */
    public static void produce(ArrayList<String> command) throws SameSerialNumberException {
        serialNumberExceptionChecker(command);
        switch(command.get(1)){
            case "B1":
                revenue = Produce.B1.produceItem(command, boxMap, revenue);
                break;
            case "B2":
                revenue = Produce.B2.produceItem(command, boxMap, revenue);
                break;
            case "C1":
                revenue = Produce.C1.produceItem(command, containerMap, revenue);
                break;
            default:
            switch (domain.enums.Items.searchItem(command.get(1)).getCountability()) {
                case "Countable":
                    revenue = Produce.COUNTABLE.produceItem(command, itemMap, revenue);
                    break;
                case "Uncountable":
                    revenue = Produce.UNCOUNTABLE.produceItem(command, itemMap, revenue);
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
                break;
        }
        
    }

    private static void serialNumberExceptionChecker(ArrayList<String> command) throws SameSerialNumberException{
        if(serialNumberList.contains(command.get(command.size()-1))){
            throw new SameSerialNumberException("Item with the serial number "+ command.get(command.size()-1)+" cannot be produced because of existing serial number");
        }
        else{
            serialNumberList.add(command.get(command.size()-1));}
    }


    /**
     * This method is used to load items to boxes and containers
     * @param command
     * @throws LoadedBoxException
     * @throws ItemPlacedDirectlyException
     * @throws MismatchItemTypeException
     * @throws ContainerCapacityException
     * @throws LoadedItemException
     * @throws BoxCapacityException
     */
    public static void load(ArrayList<String> command) throws LoadedBoxException, ItemPlacedDirectlyException, MismatchItemTypeException, ContainerCapacityException, LoadedItemException, BoxCapacityException {
        String serialNumberOfLoader = command.get(2);
        String serialNumberOfLoadedItem = command.get(1);
        if(containerMap.containsKey(serialNumberOfLoader)){
            if(boxMap.containsKey(serialNumberOfLoadedItem)){
                containerMap.get(serialNumberOfLoader).add(boxMap.get(serialNumberOfLoadedItem));
                boxMap.remove(serialNumberOfLoadedItem);
            }else if(itemMap.containsKey(serialNumberOfLoadedItem)){
                containerMap.get(serialNumberOfLoader).add(itemMap.get(serialNumberOfLoadedItem));
                itemMap.remove(serialNumberOfLoadedItem);
            }
        }

        else if(boxMap.containsKey(serialNumberOfLoader)){
            if(itemMap.containsKey(serialNumberOfLoadedItem)){
                boxMap.get(serialNumberOfLoader).add(itemMap.get(serialNumberOfLoadedItem));
                itemMap.remove(serialNumberOfLoadedItem);
            }
            else{
                throw new LoadedItemException("The item with serial number "+serialNumberOfLoadedItem+"is already loaded to a box ");
            }
        }
        else{
            throw new LoadedBoxException(serialNumberOfLoadedItem+" cannot be loaded to "+serialNumberOfLoader);
        }
    }
     /**
      * This method is used to ship containers
      * @param command
      * @throws ShippedContainerException
      */
    public static void ship(ArrayList<String> command) throws ShippedContainerException {
        String serialNumberOfShippedItem = command.get(1);
        if(containerMap.containsKey(serialNumberOfShippedItem)){
            revenue += containerMap.get(serialNumberOfShippedItem).getRevenue();
            System.out.println("Container "+serialNumberOfShippedItem+" is shipped. \t" + "Revenue: "+Math.round(revenue*100.0)/100.0+"");
            containerMap.remove(serialNumberOfShippedItem);
        }
        else{
            throw new ShippedContainerException();
        }
 }


    /**
     * This method is used calculate revenue
     * @param command
     */
    public static void revenue(ArrayList<String> command) {
        if(command != null && command.get(1).equals("1")){
            double unearnedRevenue = 0;
            for(Container<ItemBox<Item>> container: containerMap.values()){
                unearnedRevenue += container.getRevenue();      
            }
            for(ItemBox<Item> itemBox : boxMap.values() ){
                unearnedRevenue += itemBox.getRevenue(); 
            }  
            for(Item item : itemMap.values()){
                unearnedRevenue += item.getPrice();
            }
            System.out.println("\nUnearned revenue: "+unearnedRevenue+"\n");
        }
        else if(command != null && command.get(1).equals("2")){
            System.out.println("Total revenue: " + Math.round(revenue*100.0)/100.0+"\n");
        }
    }
    
}
