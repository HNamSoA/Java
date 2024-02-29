package domain;
/**
* This is the customer object with its getters.
* @author Hasan Basri Erdoğan 280201002
* @author Serhat Eren Taş 280201020
* @author Osman Çelik 280201053
* @author Kerem Buğra Kasal 280201005  
 */
public class Customer {
    private String id;
    private String name;
    private String email;
    private String country;
    private String adress;

    public Customer() {
        id = null;
        name = null;
        email = null; 
        country = null;
        adress = null;
    }

    /**
     * This is the fully constructor method.
     * @param id
     * @param name
     * @param email
     * @param country
     * @param adress
     */
    public Customer(String id, String name, String email, String country, String adress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.adress = adress;
    }
    
    
    /**
     * This is copy constructor of customer type in order to avoid privacy leak.
     * because primitive types and String class immutable we can call them directly
     * @param originalObject
     */
    public Customer(Customer originalObject) {
      this.id = originalObject.id;
      this.name = originalObject.name;
      this.email = originalObject.email;
      this.country = originalObject.country;
      this.adress = originalObject.adress;
    }

    
    /**
     * @return String
     */
    public String getId(){
        return id;
    }

    /**
     * @return String
     */
    public String getName(){
        return name;
    }
    
    /**
     * @return String
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * @return String
     */
    public String getCountry(){
        return country;
    }
    
    /**
     * @return String
     */
    public String getAdress(){
        return adress;
    }
    
    /**
     * It is the method to get customer's all information.
     * @return String
     */
    public String toString(){
        return " "+id+" "+name+" "+email+" "+country+" "+adress;
    }
}

