package domain.container;

import java.util.ArrayList;


import domain.exceptions.LoadedItemException;
import domain.exceptions.MismatchItemTypeException;
import domain.exceptions.BoxCapacityException;
import domain.items.Item;



public class NumberBox<T extends Item> extends ItemBox<T> {
    
 
    private int numberOfItems;
    private int instantNumberOfItems;

    public NumberBox(String code, int numberOfItems, double volume, String serialNumber) {
    	super(code, volume, serialNumber, 2,  new ArrayList<T>());
        this.numberOfItems = numberOfItems;
        this.instantNumberOfItems= 0;
    }
    
    public NumberBox() {
        super();
        this.numberOfItems = 10;
        this.instantNumberOfItems = 0;
    }

    public NumberBox(NumberBox<T> box) {
    	super(box);
        this.numberOfItems = box.numberOfItems;
        this.instantNumberOfItems = box.instantNumberOfItems;
    }


    public void add(T item) throws MismatchItemTypeException, BoxCapacityException,  LoadedItemException{
        misMatchChecker(item);
        capacityChecker(item);
        getList().add(item);
        setInstantVolume(item.getVolume()+ getInstantVolume());
        instantNumberOfItems += 1;
        printLoadedString(item);
    }

    private void printLoadedString(T item){
        System.out.println("Item "+ item.getSerialNumber()+" has been placed to the box "+ getSerialNumber()+"\n");
    }
    
    private void misMatchChecker(Item item)throws MismatchItemTypeException{
         if (item.getCountability() == "Uncountable" ){
            throw new MismatchItemTypeException("Item with serial number "+item.getSerialNumber()+" cannot be added to massBox");
        }
    }

    private void capacityChecker(Item item) throws BoxCapacityException {
        if(getInstantVolume()+item.getVolume() >getVolume()|| instantNumberOfItems+1 >numberOfItems){
            throw new BoxCapacityException("Item with serial number "+item.getSerialNumber()+" cannot be added to massBox with serial number "+getSerialNumber());
        }
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }
    
   
    public NumberBox<T> clone() {
        return new NumberBox<>(this);
    }
    

    public String toString() {
        return "Code: " + getCode() + " Number of Items: " + numberOfItems + " Volume: " + getVolume() + " Serial Number: "
                + getSerialNumber()+" Cost: " + getCost();
    }

    /*
     * This method returns the string of the production of the number box
     */
    public String stringOfProduction(){
        return Math.round(getVolume())+" liters of number box has been produced with capacity of "+ getNumberOfItems()+" with the serial number "+getSerialNumber();
    }
    
}
