package domain.vehicle.automobile;
import domain.vehicle.Vehicle;
/**
* Subclass of Vehicle and super class of other classes. 
* @author Hasan Basri Erdoğan 280201002
* @author Serhat Eren Taş 280201020
* @author Osman Çelik 280201053
* @author Kerem Buğra Kasal 280201005
*
*/
public class Automobile extends Vehicle{
    private double engineVolume;
    protected static final double BASE_PRICE = 200000;
    
    /**
     * Fully constructor
     * @param vehicleID
     * @param monthOfSale
     * @param cityOfSale
     * @param productionYear
     * @param engineVolume
     * @param vat
     */
    public Automobile(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, double engineVolume, double vat) {
        super(vehicleID, monthOfSale, cityOfSale, productionYear, vat);
        this.engineVolume = engineVolume;
    }
    /**
    *Copy constructor
     */
    public Automobile(Automobile originalObject){
    	super(originalObject);
    	this.engineVolume = originalObject.engineVolume;
    }
    /**
    *Default constructor
     */
    public Automobile() throws Exception {
    	super();
    	this.engineVolume = 0;
    	
    }

    
    public double getEngineVolume() {
    	return new Automobile(this).engineVolume;
    }

    public void setEngineVolume(double engineVolume){
        this.engineVolume = engineVolume;
    }
    

	public String toString() {  
		  return "VehicleID:" + getvehicleID() + ", Month:" + getMonthOfSale().months + ", City:" + getCityOfSale().city 
				  + ", Production Year:" + getProductionYear().year;
	}

}

