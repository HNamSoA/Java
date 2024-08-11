package domain.items;

public class CountableItem extends Item { 
    public static final String countability = "Countable";
    


    public CountableItem(String code, double volume, String serialNumber) {
        super(code, volume, serialNumber);    
    }

   

    public CountableItem(){
        super();
    }
    
    public CountableItem(CountableItem item){
        super(item); 
    }

    public double getCost() {
        return getCostPerUnit()*getVolume();
    }

    public CountableItem clone(){
        return new CountableItem(this);
    }

    public String getCountability(){
        return countability;
    }
    
    public String toString(){
        return "Name: "+ getName()+" Code: " + getCode() + " Volume: " + getVolume() + " Serial Number: " + getSerialNumber()+" Cost:" +getCost()+" Price:"+getPrice();
    }

    /*
     * This method returns the string of the production of the container
     */
    public String stringOfProduction(){
        
        return Math.round(getVolume())+" liters of "+getName()+" has been produced with serial number "+getSerialNumber();
    }
}
