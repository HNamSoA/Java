package domain.vehicle.automobile.automobiletype;

import domain.vehicle.automobile.Automobile;

/**
 * @author Hasan Basri Erdoğan 280201002
 * @author Serhat Eren Taş 280201020
 * @author Osman Çelik 280201053
 * @author Kerem Buğra Kasal 280201005
 *
 */
public class Sedan extends Automobile{
    private RoofType roofType;
    private final static String TYPE_NAME = "Sedan"; 
    
    /**
     * Fully constructor
     * @param vehicleID
     * @param monthOfSale
     * @param cityOfSale
     * @param productionYear
     * @param roofType
     * @param engineVolume
     * @param vat
     */
    public Sedan(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, String roofType, double engineVolume, double vat){
        super(vehicleID, monthOfSale,cityOfSale, productionYear, engineVolume, vat);
        try {
			this.roofType = toEnumRoofType(roofType);
		} catch (Exception e) {
			System.out.println("Roof Type is not valid");
			e.printStackTrace();
			System.exit(0);
		}
        sctCalculator();
        totalPriceCalculator();
    }
    
    public Sedan() throws Exception{
    	this(null, null, null, 0, null, 0, 0);
    }
    
    public Sedan(Sedan originalObject) {
    	super(originalObject);
    	try {
			this.roofType = toEnumRoofType(originalObject.roofType.roofType);
		} catch (Exception e) {
			System.out.println("Roof Type is not valid");
			e.printStackTrace();
			System.exit(0);
		}
    }
    

    enum RoofType{
        REGULAR(0.5, "regular"),MOONROOF(0.6, "moonroof"),SUNROOF(0.8, "sunroof");
        double sctValue;
        String roofType;

        RoofType(double sctValue, String roofType){
            this.sctValue = sctValue;
            this.roofType = roofType;
        }
    }

    private RoofType toEnumRoofType(String roofType) throws Exception{
        RoofType enumRoofType = null;
        switch(roofType){
            case "regular":
                enumRoofType = RoofType.REGULAR;
                break;
            case "moonroof":
                enumRoofType = RoofType.MOONROOF;
                break;
            case "sunroof":
                enumRoofType = RoofType.SUNROOF;
                break;
            default:			//to avoid assigning null to instance variable cityOfSale
                throw new Exception("Unsupported input");
        }
        return enumRoofType;
    }

    

    public RoofType getRoofType(){
    	return new Sedan(this).roofType;
    }

    public void setRoofType(RoofType roofType){
        this.roofType = roofType;
    }
    
    private void sctCalculator(){
        setSctValue((getEngineVolume()*0.2*roofType.sctValue)/getProductionYear().sctValue);
    }

    private void totalPriceCalculator(){
        setTotalPrice(BASE_PRICE*(1+getSctValue()*0.8)+(1+getVat()/100));
    }

    public String toString(){
        return "Vehicle: "+TYPE_NAME + ", VehicleID: " + getvehicleID() + ", Month: " + getMonthOfSale().months
        		+ ", City: " + getCityOfSale().city + ", Production Year: " + getProductionYearInt() + ", SCT: " + getSctValue()+ "\nThe total price paid for " + getvehicleID() + " is " + getTotalPrice() + " TL\n";
    }
}
