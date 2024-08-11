package domain.vehicle.automobile.automobiletype;

import domain.vehicle.automobile.Automobile;

/**
 * @author Hasan Basri Erdoğan 280201002
 * @author Serhat Eren Taş 280201020
 * @author Osman Çelik 280201053
 * @author Kerem Buğra Kasal 280201005
 *
 */
public class Minivan extends Automobile{
    private NumberOfSeats numberOfSeats;
    private final static String TYPE_NAME = "Minivan";
    
    /**
     * Fully constuctor
     * @param vehicleID
     * @param monthOfSale
     * @param cityOfSale
     * @param productionYear
     * @param numberOfSeats
     * @param engineVolume
     * @param vat
     */
    public Minivan(String vehicleID, String monthOfSale, String cityOfSale , int productionYear, int numberOfSeats, double engineVolume, double vat) {
        super(vehicleID, monthOfSale,cityOfSale, productionYear, engineVolume, vat);
        try {
			this.numberOfSeats = toEnumNumberOfSeats(numberOfSeats);
			 sctCalculator();
		     totalPriceCalculator();
		} catch (Exception e) {
			System.out.println("Number of seats is not valid");
			e.printStackTrace();
			System.exit(0);
		}
    }
    
    public Minivan(){
    	this(null, null, null, 0, 0, 0, 0);
    }
    
    public Minivan(Minivan originalObject) {
    	super(originalObject);
    	try {
			this.numberOfSeats = toEnumNumberOfSeats(originalObject.numberOfSeats.numberOfSeats);
		} catch (Exception e) {
			System.out.println("Number of seats is not valid");
			e.printStackTrace();
			System.exit(0);
		}
    }
    
    enum NumberOfSeats{
        FOUR(0.1, 4),FIVE(0.4, 5),SIX(0.6, 6),SEVEN(0.8, 7);
        double sctValue;
        int numberOfSeats;
        
        NumberOfSeats(double sctValue, int numberOfSeats){
            this.sctValue = sctValue;
            this.numberOfSeats = numberOfSeats;
        }
    }

    private NumberOfSeats toEnumNumberOfSeats(int numberOfSeats) throws Exception{
        NumberOfSeats enumNumberOfSeats = null;
        switch(numberOfSeats){
        case 4 :
            enumNumberOfSeats = NumberOfSeats.FOUR;
            break;
        case 5 :
            enumNumberOfSeats = NumberOfSeats.FIVE;
            break;        
        case 6 :
            enumNumberOfSeats = NumberOfSeats.SIX;
            break;
        case 7 :
            enumNumberOfSeats = NumberOfSeats.SEVEN;
            break;
        default://to avoid assigning null to instance variable ProductionYear
			throw new Exception("Unsupported input");
        }
        return enumNumberOfSeats;
    }

    public NumberOfSeats getNumberOfSeats(){
       return new Minivan(this).numberOfSeats;
    }

    public void setNumberOfSeats(NumberOfSeats numberOfSeats){
        this. numberOfSeats =  numberOfSeats;
    }
   
    private void sctCalculator(){
        setSctValue((0.6*getProductionYear().sctValue)/(getEngineVolume() + getNumberOfSeats().sctValue));
    }

    private void totalPriceCalculator(){
        setTotalPrice(BASE_PRICE*(1+getSctValue()*0.8)+(1+getVat()/100));
    }

    public String toString(){
        return "Vehicle: "+TYPE_NAME + ", VehicleID: " + getvehicleID() + ", Month: " + getMonthOfSale().months + ", City: " 
    + getCityOfSale().city + ", Production Year: " + getProductionYearInt() + ", SCT: " + getSctValue()+ "\nThe total price paid for " + getvehicleID() + " is " + getTotalPrice() + " TL\n";
    }
}
