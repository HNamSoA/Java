package domain;

/**
* This is the product object with its getters.
* @author Hasan Basri Erdoğan 280201002
* @author Serhat Eren Taş 280201020
* @author Osman Çelik 280201053
* @author Kerem Buğra Kasal 280201005  
 */
public class Product {
    private String id;
    private String title;
    private float rate;
    private int numberOfReviews;
    private float price;

    public Product() {
        id = null;
        title = null;
        rate = 0;
        numberOfReviews = 0;
        price = 0;
    }
    /**
     * This is the fully constructor method
     * @param id
     * @param title
     * @param rate
     * @param numberOfReviews
     * @param price
     */
    public Product(String id, String title, float rate, int numberOfReviews, float price) {
        // It is preventitive if statement to avoid unexpected input.
        if (rate>5){
            System.out.println("Rate can not be greater than 5");
            System.exit(0);
        }
        else{
            this.id = id;
            this.title = title;
            this.rate = rate;
            this.numberOfReviews = numberOfReviews;
            this.price = price;
        }
    }
    /**
     * This is copy constructor of product type in order to avoid privacy leak.
     * because primitive types and String class immutable we can call them directly
     * @param originalProduct
     */
    public Product(Product originalProduct) {
       this.id = originalProduct.id;
       this.title = originalProduct.title;
       this.rate = originalProduct.rate;
       this.numberOfReviews = originalProduct.numberOfReviews;
       this.price = originalProduct.price;
    }
    /**
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * @return String
     */
    public String getTitle(){
        return title;
    }

    /**
     * @return double
     */
    public double getRate(){
        return rate;
    }

    /**
     * @return int
     */
    public int getNumberOfReviews(){
        return numberOfReviews;
    }

    /**
     * @return double
     */
    public double getPrice(){
        return price;
    }

    /**
     * It is the method to get product's all information.
     * @return String
     */
    public String toString(){
        return " "+id+" "+title+" "+rate+" "+numberOfReviews+" "+price;
    }
    
}