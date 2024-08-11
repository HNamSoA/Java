package domain;

/**
* This is the sales object with its getters.
* @author Hasan Basri Erdoğan 280201002
* @author Serhat Eren Taş 280201020
* @author Osman Çelik 280201053
* @author Kerem Buğra Kasal 280201005  
 */

public class Sales{
    private String id;
    private Customer customer;
    private Product product;
    private String salesDate;
    private double salesPrice;

    public Sales() {
        id = null;
        customer = null;
        product = null;
        salesDate = null;
        salesPrice = 0;
    }
    
    /**
     * This is the fully constructor method
     * @param id
     * @param customer
     * @param product
     * @param salesDate
     */
    public Sales(String id, Customer customer, Product product, String salesDate) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.salesDate = salesDate;
        this.salesPrice = product.getPrice()+((product.getRate()/5)*100)*product.getNumberOfReviews();   
    }
    
    /**
     * This is the copy constructor of sales type in order to avoid privacy leak.
     * This method creates new copy of customer and prodcut object and assign them.
     * @param originalSalesObject
     */
    public Sales(Sales originalSalesObject) {
        this.id = originalSalesObject.id;
        this.customer = new Customer(originalSalesObject.customer);
        this.product = new Product(originalSalesObject.product);
        this.salesDate = originalSalesObject.salesDate;
        this.salesPrice = originalSalesObject.salesPrice;
    }

    /**
     * @return String
     */
    public String getId(){
        return id;
    }

    /**
     * @return Customer
     */
    public Customer getCustomer(){
        return customer;
    }

    /**
     * @return Product
     */
    public Product getProduct(){
        return product;
    }

    /**
     * @return String
     */
    public String getSalesDate(){
        return salesDate;
    }

    /**
     * @return double
     */
    public double getSalesPrice(){
        return salesPrice;
    }

    /**
     * @return double
     */
    public double getProfit(){
        return salesPrice-product.getPrice();
    }

    
}