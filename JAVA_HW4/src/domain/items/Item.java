package domain.items;
import domain.enums.Items;
public abstract class Item {
 
    private String code;
    private double volume;
    private String serialNumber;
    private int costPerUnit;
    private int pricePerUnit;
    private String name;
   

    public Item(String code, double volume, String serialNumber) {
        this.code = code;
        this.volume = volume;
        this.serialNumber = serialNumber;
        this.costPerUnit = Items.searchItem(code).getCost();
        this.pricePerUnit = Items.searchItem(code).getPrice();
        this.name = Items.searchItem(code).getName();       
    }

   

    public Item(){
        this.code = "";
        this.volume = 0;
        this.serialNumber = "";
        this.costPerUnit = 0;
        this.pricePerUnit = 0;
        this.name = "";
    }
    
    public Item(Item item){
        this.code = item.code;
        this.volume = item.volume;
        this.serialNumber = item.serialNumber;
        this.costPerUnit = item.costPerUnit;
        this.pricePerUnit = item.pricePerUnit;
        this.name = item.name;    
    }
    
    
    public int getCostPerUnit(){
        return costPerUnit;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getVolume() {
        return volume;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public abstract double getCost();

    public double getPrice() {
        return pricePerUnit*volume;
    }

    public abstract Item clone();

    public abstract String getCountability();
    
    public abstract String toString();
    
    public abstract String stringOfProduction();
    
}
