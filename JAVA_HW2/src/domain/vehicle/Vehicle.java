package domain.vehicle;

/**
 * 
 *This class is base class of other derived classes.
 *This class have some private instance variables, enum type objects, their getters and setters.
 * @author Hasan Basri Erdoğan 280201002
 * @author Serhat Eren Taş 280201020
 * @author Osman Çelik 280201053
 * @author Kerem Buğra Kasal 280201005
 *
 */
public class Vehicle {
	private String vehicleID;
	private MonthOfSale monthOfSale;
	private CityOfSale cityOfSale;
	private ProductionYear productionYear;
	private double sctValue;
	private double vat;
	private double totalPrice;
	private int year;
	

/**
	 * Fully constructor of Vehicle class type.
	 * @param vehicleID
	 * @param monthOfSale
	 * @param cityOfSale
	 * @param productionYear
	 * @param vat
	 */
	
	public Vehicle(String vehicleID, String monthOfSale, String cityOfSale, int productionYear, double vat)  { //null is handled in the functions.
		this.vehicleID = vehicleID;
		try {
			this.monthOfSale = toEnumMonthOfSale(monthOfSale);
			this.cityOfSale = toEnumCityOfSale(cityOfSale);
			this.productionYear = toEnumProductionYear(productionYear);
		} catch (Exception e) {
			System.out.println("Month of sale, city of sale or production year is not valid");
			e.printStackTrace();
			System.exit(0);
		}
		this.year = productionYear;
		this.vat = vat;
	}
	/**
	 * Default constructor
	 * @throws Exception
	 */
	public Vehicle() throws Exception {
		this(null, null, null, 0, 0);
	}
	/**
	Copy constructor in order avoid privacy leak.
	 */
	public Vehicle(Vehicle sameObject)  {
		this.vehicleID = sameObject.vehicleID;
		try {
			this.monthOfSale = toEnumMonthOfSale(sameObject.monthOfSale.months);
			this.cityOfSale = toEnumCityOfSale(sameObject.cityOfSale.city);
			this.productionYear = toEnumProductionYear(sameObject.year);
		} catch (Exception e) {
			System.out.println("Month of sale, city of sale or production year is not valid");
			e.printStackTrace();
			System.exit(0);
		}
		this.year = sameObject.year;	
	}
	/**
	*Enum type class definition that holds months
	 */
	protected enum MonthOfSale {
		JANUARY(0.3,"January") ,MAY(0.4,"May"), AUGUST(0.5,"August"), OCTOBER(0.6,"October"), DECEMBER(0.7,"December");
		public double sctValue;
		public String months ;

		MonthOfSale(double sctValue, String months){
			this.sctValue = sctValue;
			this.months = months; 
		}
	}
	/**
	*Enum type class definition that holds cities
	 */
	protected enum CityOfSale {
		IZMIR(0.1,"Izmir"), ISTANBUL(0.3, "Istanbul"), ANKARA(0.2,"Ankara");
		public double sctValue;
		public String city;

		CityOfSale(double sctValue, String city){
			this.sctValue = sctValue;
			this.city = city;
		}
	}

	/**
	*Enum type class definition that holds year rangeç
	 */
	protected enum ProductionYear {
		year2001_2008(1.0), year2012_2017(1.2), year2018_2022(1.6);
		public double sctValue;
		public int year;

		ProductionYear(double sctValue){
			this.sctValue = sctValue;
		}
		
	/**
	*Enum type class definition that holds vehicle type
	 */
	}
	protected enum VehicleType{
		HATCHBACK("Hatchback"), MINIVAN("Minivan"), SEDAN("Sedan"), BICYCLE("Bicycle"), PICKUP_TRUCK("Pickup Truck");
		String stringVehicleType;

		VehicleType(String vehicleType){
			this.stringVehicleType = vehicleType;
		}
	}
	/**
	*This methods passes String as an argument and then returns MonthOfSale
	* @param String
	 */
	private MonthOfSale toEnumMonthOfSale(String monthOfSale) throws Exception  {
		MonthOfSale enumMonth = null;
		switch(monthOfSale){
			case "December":
				enumMonth = MonthOfSale.DECEMBER;
				break;
			case "January":
				enumMonth = MonthOfSale.JANUARY;
				break;
			case "May":
				enumMonth = MonthOfSale.MAY;
				break;
			case "August":
				enumMonth = MonthOfSale.AUGUST;
				break;
			case "October":
				enumMonth = MonthOfSale.OCTOBER;
				break;
			default:			//to avoid assigning null to instance variable monthOfSale
				throw new Exception("Unsupported input");
		}
		return enumMonth;
	}
	
	/**
	*This methods passes String as an argument and then returns CityOfSale
	* @param String
	 */
	private CityOfSale toEnumCityOfSale(String city) throws Exception{
		CityOfSale enumCity = null;
		switch(city){
			case "Izmir":
				enumCity = CityOfSale.IZMIR;
				break;
			case "Istanbul":
				enumCity = CityOfSale.ISTANBUL;
				break;
			case "Ankara":
				enumCity = CityOfSale.ANKARA;
				break;
			default:			//to avoid assigning null to instance variable cityOfSale
				throw new Exception("Unsupported input");
		}
		return enumCity;
	}

	/**
	*This methods passes String as an argument and then returns ProductionYear
	* @param String
	 */
	private ProductionYear toEnumProductionYear(int year) throws Exception{
		ProductionYear enumYear = null;
		if (2001 <= year & year <= 2008){
			enumYear = ProductionYear.year2001_2008;
		}else if(2012 <= year & year <=2017){
			enumYear = ProductionYear.year2012_2017;
		}else if(2018 <= year & year <=2022){
			enumYear = ProductionYear.year2018_2022;
		}
		else{//to avoid assigning null to instance variable ProductionYear
			throw new Exception("Unsupported input");
		}
		return enumYear;
	}
	

	public String getvehicleID(){
		return vehicleID;
	}

	public void setVehicleID(String vehicleID){
		this.vehicleID = vehicleID;
	}
	
	public MonthOfSale getMonthOfSale() {
		return new Vehicle(this).monthOfSale;
	}

	public void setMonthOfSale(MonthOfSale monthOfSale){
		this.monthOfSale = monthOfSale;
	}

	public double getSctValue() {
		return sctValue;
	}

	public void setSctValue(double sctValue){
		this.sctValue = sctValue;
	}

	public CityOfSale getCityOfSale() {
		return new Vehicle(this).cityOfSale;
	}
	public void setCityOfSale(CityOfSale cityOfSale){
		this.cityOfSale = cityOfSale;
	}

	public ProductionYear getProductionYear() {
		return new Vehicle(this).productionYear;
	}
	public int getProductionYearInt(){
		return year;
	}
	public void setProductionYear(ProductionYear productionYear){
		this.productionYear = productionYear;
	}

	public double getVat(){
		return vat;
	}

	public void setVat(double vat){
		this.vat = vat;
	}

	public double getTotalPrice(){
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice){
		this.totalPrice = totalPrice;
	}
		
	
	public String toString() {  
		return  "vehicleID:" + vehicleID + ", Month:" + monthOfSale.months + ", City:" + cityOfSale.city 
				+ ", Production Year:" + year;
	}
	
	public boolean equals(Object obj){
		if (obj == null)
			return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Vehicle otherVehicle = (Vehicle) obj;
			return vehicleID.equals(otherVehicle.vehicleID);
		}
	}
	}
	


	
	
	
	

