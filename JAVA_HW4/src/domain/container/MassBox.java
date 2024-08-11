package domain.container;

import java.util.ArrayList;


import domain.exceptions.LoadedItemException;
import domain.exceptions.MismatchItemTypeException;
import domain.exceptions.BoxCapacityException;
import domain.items.Item;
import domain.items.UncountableItem;



public class MassBox<T extends Item> extends ItemBox<T> {
    private double mass;
    private double instantMass;


    public MassBox(String code, double mass, double volume, String serialNumber) {
    	super(code, volume, serialNumber, 3,  new ArrayList<T>());
        this.mass = mass;
        this.instantMass = 0;
    }
    
    public MassBox(){
    	super();
        this.mass = 10;
        this.instantMass=0;
        
    }
    public MassBox(MassBox<T> box){
    	super(box);
        this.mass = box.mass;
    }


    @Override
    public void add(T item) throws MismatchItemTypeException, BoxCapacityException, LoadedItemException{
        misMatchChecker(item);
        capacityChecker(item);
        getList().add(item);
        setInstantVolume(getInstantVolume() + item.getVolume());
        instantMass += ((UncountableItem)item).getMass();
        printLoadedString(item);
    }

    
    private void printLoadedString(T item){
        System.out.println("Item "+ item.getSerialNumber()+" has been placed to the box "+ getSerialNumber()+"\n");
    }

	private void capacityChecker(T item)throws BoxCapacityException{
        if (getInstantVolume() + item.getVolume() > getVolume()|| instantMass + ((UncountableItem)item).getMass() > mass){
            throw new BoxCapacityException("Item with serial number "+item.getSerialNumber()+" cannot be added to massBox with serial number "+getSerialNumber()+" because it is full");
        }
    }

   
    private void misMatchChecker(Item item)throws MismatchItemTypeException{
         if (item.getCountability() == "Countable" ){
            throw new MismatchItemTypeException("Item with serial number "+item.getSerialNumber()+" cannot be added to massBox");
        }
    }
    

    public double getMass() {
        return mass;
    }

    public MassBox<T> clone(){
        return new MassBox<>(this);
    }
    
   

    public String toString(){
        return "Code: " + getCode() + " Mass: " + mass + " Volume: " + getVolume() + " Serial Number: " + getSerialNumber()+" Cost: " + getCost();
    }
    
    /*
     * This method returns the string of the production of the mass box
     */
    public String stringOfProduction(){
        return Math.round(getVolume()) + " liters of mass box has been produced with the capacity of " + getMass() + "with serial number of " + getSerialNumber();
    }
        
}
