package domain.vehicle.pickupTruck;
import domain.vehicle.Vehicle;

/**
 * @author Hasan Basri Erdoğan 280201002
 * @author Serhat Eren Taş 280201020
 * @author Osman Çelik 280201053
 * @author Kerem Buğra Kasal 280201005
 *
 */
public class PickupTruck extends Vehicle{
	    private CapType capType;
    	private TruckBedType truckBedType;
		private static final double BASE_PRICE = 2500000;
		private final static String TYPE_NAME = "Pickup Truck";
		
		
		/**
		 * Fully constructor
		 * @param vehicleID
		 * @param monthOfSale
		 * @param cityOfSale
		 * @param productionYear
		 * @param capType
		 * @param truckBedType
		 * @param vat
		 */
		public PickupTruck(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, String capType, String truckBedType, double vat) {
			super(vehicleID, monthOfSale, cityOfSale, productionYear, vat);
			try {
				this.truckBedType = toEnumTruckBedType(truckBedType);
				this.capType = toEnumCapType(capType);
			} catch (Exception e) {
				System.out.println("Cap Type or Truck Bed Type is not valid");
				e.printStackTrace();
				System.exit(0);
			}
			sctCalculator();
			totalPriceCalculator();
		}
		
		public PickupTruck() throws Exception{
	    	this(null, null, null, 0, null, null, 0);
	    }
	    
	    public PickupTruck(PickupTruck originalObject) {
	    	super(originalObject);
	    	try {
				this.truckBedType = toEnumTruckBedType(originalObject.truckBedType.truckBedType);
				this.capType = toEnumCapType(originalObject.capType.capType);
			} catch (Exception e) {
				System.out.println("Cap Type or Truck Bed Type is not valid");
				e.printStackTrace();
				System.exit(0);
			}

	    }
	
	    enum CapType{
			REGULAR(2.5, "regular"),EXTENDED(2.8, "extended"),CREW(3, "crew");
			double stcValue;
			String capType;

			CapType(double stcValue, String capType){
				this.stcValue = stcValue;
				this.capType = capType;
			}
		}

		enum TruckBedType{
			REGULAR(0.5, "regular"),TANKER(0.8, "tanker"),TRAILER(1, "trailer");
			double sctValue;
			String truckBedType; 

			TruckBedType(double sctValue, String truckBedType){
				this.sctValue = sctValue;
				this.truckBedType = truckBedType;
			}
		}

		private CapType toEnumCapType(String capType) throws Exception{
			CapType enumCapType = null;
			switch(capType){
				case "regular":
					enumCapType = CapType.REGULAR;
					break;
				case "extended":
					enumCapType = CapType.EXTENDED;
					break;
				case "crew":
					enumCapType = CapType.CREW;
					break;
				default:			//to avoid assigning null to instance variable cityOfSale
					throw new Exception("Unsupported input");
			}
			return enumCapType;
		}

		private TruckBedType toEnumTruckBedType(String truckBedType) throws Exception{
			TruckBedType enumTruckBedType = null;
			switch(truckBedType){
				case "regular":
					enumTruckBedType = TruckBedType.REGULAR;
					break;
				case "tanker":
					enumTruckBedType = TruckBedType.TANKER;
					break;
				case "trailer":
					enumTruckBedType = TruckBedType.TRAILER;
					break;
				default:			//to avoid assigning null to instance variable cityOfSale
					throw new Exception("Unsupported input");
			}
			return enumTruckBedType;
		}

		public CapType getCapType(){
			return new PickupTruck(this).capType;
		}
		public void setCapType(CapType capType){
			this.capType = capType;
		}
		public TruckBedType getTruckBedType(){
			return new PickupTruck(this).truckBedType;
		}
		public void setTruckBedType(TruckBedType truckBedType){
			this.truckBedType = truckBedType;
		}

		
		private void sctCalculator(){
			setSctValue((truckBedType.sctValue*getProductionYear().sctValue) / capType.stcValue) ;  
		}

		private void totalPriceCalculator(){
			setTotalPrice(BASE_PRICE*(1+(getSctValue()*0.6))+(1+getVat()/100));
		}

		public String toString(){
			return "Vehicle: "+TYPE_NAME + ", VehicleID: " + getvehicleID() + ", Month: " + getMonthOfSale().months + ", City: " + getCityOfSale().city + ", Production Year: " + getProductionYearInt() + ", SCT: " + getSctValue()+ "\nThe total price paid for " + getvehicleID() + " is " + getTotalPrice() + " TL\n";
		}
	}
