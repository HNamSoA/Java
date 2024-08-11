package domain.enums;

import java.util.ArrayList;
import java.util.Map;

import domain.container.Container;
import domain.container.ItemBox;
import domain.container.MassBox;
import domain.container.NumberBox;
import domain.items.CountableItem;
import domain.items.Item;
import domain.items.UncountableItem;
/**
 * Enum class for producing items
 */
public enum Produce {
    @SuppressWarnings("unchecked")
    B1 {public <T> double produceItem(ArrayList<String> command, Map<String, T> map, double revenue ){
        ItemBox<Item> numberBox = new NumberBox<Item>(command.get(1), Integer.parseInt(command.get(2)),Integer.parseInt(command.get(3)), command.get(4));
        map.put(numberBox.getSerialNumber(),(T) numberBox);
        revenue -= numberBox.getCost();
        System.out.printf(numberBox.stringOfProduction()+ "\t Revenue:"+"%.2f"+"\n\n",revenue);
        return revenue;
    }}, 
    
    @SuppressWarnings("unchecked")
    B2{public <T> double produceItem(ArrayList<String> command, Map<String, T> map, double revenue){
        ItemBox<Item> massBox = new MassBox<Item>(command.get(1), Integer.parseInt(command.get(2)),Integer.parseInt(command.get(3)), command.get(4));
        map.put(massBox.getSerialNumber(),(T) massBox);
        revenue -= massBox.getCost();
        System.out.printf(massBox.stringOfProduction()+ "\t Revenue:"+"%.2f"+"\n\n",revenue);
        return revenue;
    }}, 

    
    @SuppressWarnings("unchecked")
    C1{public <T> double produceItem(ArrayList<String> command, Map<String, T> map, double revenue){
        Container<ItemBox<Item>> container = new Container<>(command.get(1), Integer.parseInt(command.get(2)), command.get(3));
        map.put(container.getSerialNumber(),(T) container);
        revenue -= container.getCost();
        System.out.printf(container.stringOfProduction()+ "\t\t\t\t Revenue:"+"%.2f"+"\n\n",revenue);
        return revenue;
    }}, 

    
    @SuppressWarnings("unchecked")
    COUNTABLE{public <T> double produceItem(ArrayList<String> command, Map<String, T> map, double revenue){
        CountableItem countableItem = new CountableItem(command.get(1),Double.parseDouble(command.get(2)), command.get(3));
        map.put(countableItem.getSerialNumber(), (T)countableItem);
        revenue -= countableItem.getCost();
        System.out.printf(countableItem.stringOfProduction()+ "\t\t\t\t Revenue:"+"%.2f"+"\n\n",revenue);
        return revenue;
    }}, 

    
    @SuppressWarnings("unchecked")
    UNCOUNTABLE{public <T> double produceItem(ArrayList<String> command, Map<String, T> map, double revenue){
        UncountableItem uncountableItem = new UncountableItem(command.get(1), Double.parseDouble(command.get(2)),Double.parseDouble(command.get(3)), command.get(4));
        map.put(uncountableItem.getSerialNumber(), (T) uncountableItem);
        revenue -= uncountableItem.getCost();
        System.out.printf(uncountableItem.stringOfProduction()+ "\t\t\t\t\t Revenue:"+"%.2f"+"\n\n",revenue);
        return revenue;
    }};

   
    
    public abstract <T> double produceItem(ArrayList<String> command, Map<String, T> map, double revenue );
}
