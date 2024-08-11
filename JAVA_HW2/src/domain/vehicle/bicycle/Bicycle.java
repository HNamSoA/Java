package domain.vehicle.bicycle; 
import domain.vehicle.Vehicle;


/**
 * @author Hasan Basri Erdoğan 280201002
 * @author Serhat Eren Taş 280201020
 * @author Osman Çelik 280201053
 * @author Kerem Buğra Kasal 280201005
 *
 */
public class Bicycle extends Vehicle{
    private ChainType chainType;
    private SeatPost seatPost;
    private static final double BASE_PRICE = 10000;
    private static final String TYPE_NAME = "Bicycle";
    

    /**
     * Fully constructor
     * @param vehicleID
     * @param monthOfSale
     * @param cityOfSale
     * @param productionYear
     * @param chainType
     * @param seatPost
     * @param vat
     */
    public Bicycle(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, String chainType, String seatPost, double vat ) {
        
        super(vehicleID, monthOfSale, cityOfSale, productionYear, vat);
        try {
			this.seatPost = toEnumSeatPostType(seatPost);
			 this.chainType = toEnumChainType(chainType);
		} catch (Exception e) {
			System.out.println("Seat Post or Chain Type is not valid");
			e.printStackTrace();
			System.exit(0);
		}
        sctCalculator();
        totalPriceCalculator();
    }
    
    public Bicycle() throws Exception{
    	this(null, null, null, 0, null, null, 0);
    }
    
    public Bicycle(Bicycle originalObject) {
    	super(originalObject);
    	try {
			this.chainType = toEnumChainType(originalObject.chainType.chainType);
			this.seatPost =  toEnumSeatPostType(originalObject.seatPost.seatPost);
		} catch (Exception e) {
			System.out.println("Seat Post or Chain Type is not valid");
			e.printStackTrace();
			System.exit(0);
		}		
    }
    
    
    enum ChainType{
        DERAILLEUR(1.1, "derailleur"),ONECHAIN(1.2, "onechain"),DOUBLECHAIN(1.3, "doublechain");
        double sctValue;
        String chainType;
        
        ChainType(double sctValue, String chainType){
            this.sctValue = sctValue;
            this.chainType = chainType;
            
        }
    }

    enum SeatPost{
        CARBONFIBER(0.8, "carbonfiber"),STEEL(0.7,"steel"),ALUMINUM(0.9, "aluminum"),TITANIUM(0.6, "titanium");
        double sctValue;
        String seatPost;
        
        SeatPost(double sctValue, String seatPost){
            this.sctValue = sctValue;
            this.seatPost = seatPost;
        }
    }

    private ChainType toEnumChainType(String chainType) throws Exception{
        ChainType enumChainType = null;
        switch(chainType){
            case "derailleur":
                enumChainType = ChainType.DERAILLEUR;
                break;
            case "onechain":
                enumChainType = ChainType.ONECHAIN;
                break;
            case "doublechain":
                enumChainType = ChainType.DOUBLECHAIN;
                break;
            default:    //to avoid assigning null to instance variable cityOfSale
                throw new Exception("Unsupported input");
        }
        return enumChainType;

    }

      private SeatPost toEnumSeatPostType(String seatPost) throws Exception{
        SeatPost enumSeatPostType = null;
        switch(seatPost){
            case "carbonfiber":
                enumSeatPostType = SeatPost.CARBONFIBER;
                break;
            case "steel":
                enumSeatPostType = SeatPost.STEEL;
                break;
            case "aluminum":
                enumSeatPostType = SeatPost.ALUMINUM;
                break;
            case "titanium":
                enumSeatPostType = SeatPost.TITANIUM;
                break;
            default:    //to avoid assigning null to instance variable cityOfSale
                throw new Exception("Unsupported input");
        }
        return enumSeatPostType;

    }

    public ChainType getChainType(){
    	return new Bicycle(this).chainType;
    }

    public SeatPost getSeatPost(){
    	return new Bicycle(this).seatPost;
    }

    public void setSeatPost(SeatPost seatPost){
        this.seatPost = seatPost;
    }

    public void setChainType(ChainType chainType){
        this.chainType = chainType;
    }
    
    private void sctCalculator(){
        setSctValue((chainType.sctValue*seatPost.sctValue*0.1) + getMonthOfSale().sctValue) ; 
    }

    private void totalPriceCalculator(){
        setTotalPrice((BASE_PRICE*0.9)*(1+getSctValue())+(1+getVat()/100));
    }

    public String toString(){
        return "Vehicle: "+TYPE_NAME + ", VehicleID: " + getvehicleID() + ", Month: " + getMonthOfSale().months + ", City: " + getCityOfSale().city + ", Production Year: " + getProductionYearInt() + ", SCT: " + getSctValue()+ " " + "\nThe total price paid for " + getvehicleID() + " is " + getTotalPrice() + " TL\n";
    }
}
