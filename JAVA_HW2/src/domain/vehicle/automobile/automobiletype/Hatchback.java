package domain.vehicle.automobile.automobiletype;


import domain.vehicle.automobile.Automobile;
/**
 * @author Hasan Basri Erdoğan 280201002
 * @author Serhat Eren Taş 280201020
 * @author Osman Çelik 280201053
 * @author Kerem Buğra Kasal 280201005
 *
 */

public class Hatchback extends Automobile{
    private CityMode cityMode;
    private final static String TYPE_NAME = "Hatchback";
    
    /**
     * Fully constructor
     * @param vehicleID
     * @param monthOfSale
     * @param cityOfSale
     * @param productionYear
     * @param cityMode
     * @param engineVolume
     * @param vat
     */
    public Hatchback(String vehicleID, String monthOfSale, String cityOfSale , int productionYear, String cityMode, double engineVolume, double vat) {
              super(vehicleID, monthOfSale, cityOfSale, productionYear, engineVolume, vat);
              try {
				this.cityMode = toEnumCityMode(cityMode);
			} catch (Exception e) {
				System.out.println("City Mode is not valid");
				e.printStackTrace();
                System.exit(0);
			}
              sctCalculator();
              totalPriceCalculator();
    }
    
    public Hatchback() {
    	this(null, null, null, 0, null, 0, 0);
    }
    
    public Hatchback(Hatchback originalObject) {
    	super(originalObject);
    	try {
			this.cityMode = toEnumCityMode(originalObject.cityMode.cityMode);
		} catch (Exception e) {
			System.out.println("City Mode is not valid");
			e.printStackTrace();
            System.exit(0);
		}
    }

    enum CityMode{
        YES(0.15, "yes"),NO(0.1, "no");
        double sctValue;
        String cityMode;

        CityMode(double sctValue, String cityMode){
            this.sctValue = sctValue;
            this.cityMode = cityMode;
        }
    }

    private CityMode toEnumCityMode(String cityMode) throws Exception {
        CityMode enumCityMode = null;
        switch(cityMode){
        case "yes" :
            enumCityMode = CityMode.YES;
            break;
        case "no" :
            enumCityMode = CityMode.NO;
            break;        
        default://to avoid assigning null to instance variable ProductionYear
			throw new Exception("Unsupported input");
        }
        return enumCityMode;
    }

    public CityMode getCityMode() {
    	return new Hatchback(this).cityMode;
    }

    public void setCityMode(CityMode cityMode){
        this.cityMode = cityMode;
    }

    private void sctCalculator() {
        setSctValue((getEngineVolume()*0.3*getProductionYear().sctValue)+getCityMode().sctValue);
    }

    private void totalPriceCalculator() {
        setTotalPrice(BASE_PRICE*(1+getSctValue()*0.8)+(1+getVat()/100));
    }

    public String toString() {
      return "Vehicle: "+TYPE_NAME + ", VehicleID: " + getvehicleID() + ", Month: " + getMonthOfSale().months + ", City: " + getCityOfSale().city 
    		  + ", Production Year: " + getProductionYearInt() + ", SCT: " + getSctValue()+ "\nThe total price paid for " + getvehicleID() + " is " + getTotalPrice() + " TL\n";
    }
}
