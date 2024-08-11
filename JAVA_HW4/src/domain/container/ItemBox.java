package domain.container;
import domain.exceptions.LoadedItemException;
import domain.exceptions.MismatchItemTypeException;

import domain.items.Item;

import java.util.ArrayList;

import domain.exceptions.BoxCapacityException;

public abstract class ItemBox<T extends Item> {
	private String code;
	private ArrayList<T> list;
	
    private double volume;
    private String serialNumber;
    private int costPerUnit;
    private double instantVolume;
    
    public ItemBox(String code, double volume, String serialNumber, int costPerUnit, ArrayList<T> list) {
        this.code = code;
        this.volume = volume;
        this.costPerUnit = costPerUnit;
        this.serialNumber = serialNumber;
        this.list = list;
        this.instantVolume = 0;
      
    }
    
    public abstract String toString();
    
    public ItemBox(){
    	this.costPerUnit = 0;
        this.code = "";
        this.volume = 10;
        this.serialNumber = "0";
        this.instantVolume=0;
    }
     
    public ItemBox(ItemBox<T> box){
    	this.costPerUnit = box.costPerUnit;
        this.code = box.code;
        this.volume = box.volume;
        this.serialNumber = box.serialNumber;
    }
	
	
    public String getCode() {
        return code;
    }
    
    
    public double getVolume() {
        return volume;
    }
    
    public ArrayList<T> getList(){
    	return list;
    }
    
    protected double getInstantVolume() {
        return instantVolume;
    }
  
    public String getSerialNumber() {
        return serialNumber;
    }
    
    public abstract ItemBox<T> clone();
    
   
   
    public abstract void add(T item) throws MismatchItemTypeException, BoxCapacityException, LoadedItemException;
  
    public double getCost() {
        return costPerUnit*getVolume();
    }
    
    public void setInstantVolume(double number) {
    	this.instantVolume = number;
    }
    public double getRevenue(){
        double revenue = 0;
        for (T item : list){
            revenue += item.getPrice();
        }
        return revenue;
    }
    
    public void remove(T item){
        list.remove(item);
    }
    
    public abstract String stringOfProduction();
}
