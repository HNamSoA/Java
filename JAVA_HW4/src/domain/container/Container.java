package domain.container;

import java.util.ArrayList;

import domain.exceptions.ItemPlacedDirectlyException;
import domain.exceptions.LoadedBoxException;
import domain.items.Item;
import domain.exceptions.ContainerCapacityException;
import java.lang.Math;


public class Container <T extends ItemBox<Item>> {
    private ArrayList<T> list;
    private String code;
    private double volume;
    private double instantVolume;
    private String serialNumber;
    private final int costPerUnit = 1;


    public Container(String code, double volume, String serialNumber) {
        this.code = code;
        this.volume = volume;
        this.serialNumber = serialNumber;
        this.list = new ArrayList<T>();
        this.instantVolume = 0;
    }

    public Container() {
        this.code = "";
        this.volume = 10;
        this.serialNumber = "";
        this.list = new ArrayList<T>();
        this.instantVolume = 0;
    }

    @SuppressWarnings("unchecked")
	public Container(Container<T> container) {
        this.code = container.code;
        this.volume = container.volume;
        this.serialNumber = container.serialNumber;
        this.list = new ArrayList<>();
        this.instantVolume = container.instantVolume;
        for(T itemBox : (ArrayList<T>)container.list){
            list.add((T) itemBox.clone());
        }
    }
    private void ContainerCapacityExceptionChecker(T box) throws ContainerCapacityException{
        if(instantVolume+box.getVolume()>this.volume){
            throw new ContainerCapacityException("The box with serial number " + box.getSerialNumber() + " can not be added to the container with serial number " + serialNumber + " because the container is full") ;
        }
    }
	public void add(T itemBox) throws ContainerCapacityException, LoadedBoxException{
        ContainerCapacityExceptionChecker(itemBox);
        list.add((T) itemBox);
        printLoadedString(itemBox);
        instantVolume += itemBox.getVolume();
        
    }

    private void printLoadedString(T itemBox){
        System.out.println("Box "+ itemBox.getSerialNumber()+" has been placed to the container "+ getSerialNumber()+"\n");
    }



    public void add(Item item)throws ItemPlacedDirectlyException{
        throw new ItemPlacedDirectlyException("Item with serial number " + item.getSerialNumber() + " can not be placed directly into the container");
    }

    public void remove(T box){
        list.remove(box);
    }

    public String getCode() {
        return code;
    }

    public double getCost(){
        return costPerUnit * volume;
    }

    public double getVolume() {
        return volume;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Container<T> clone() {
        return new Container<T>(this);
    }

    public double getRevenue(){
        double revenue = 0;
        for(T itemBox : list){
            revenue += itemBox.getRevenue();
        }
        return revenue;
    }

    public String toString() {
        return "Code: " + code + " Volume: " + volume + " Serial Number: " + serialNumber +" Cost: " + getCost();
    }
    
    /*
     * This method returns the string of the production of the container
     */
    public String stringOfProduction(){
        return Math.round(getVolume())+" liters of container has been produced with the serial number " + getSerialNumber();
    }


}
