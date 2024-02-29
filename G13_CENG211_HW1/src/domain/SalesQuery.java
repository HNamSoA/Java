package domain;

import fileIO.FileIO;

/**
* This class creates objects and use them in the requıred methods.
*@author Hasan Basri Erdoğan 280201002
* @author Serhat Eren Taş 280201020
* @author Osman Çelik 280201053
* @author Kerem Buğra Kasal 280201005 
 */
public class SalesQuery{

    private final static Customer[] CUSTOMER = fileIO.FileIO.customerReader("src/dataFiles/Customers.csv");
      
    private final static Supplier SUPPLIER1 = new Supplier(FileIO.productReader("src/dataFiles/S1_Products.csv"));
    private final static Sales[] SALES1 = fileIO.FileIO.salesReader("src/dataFiles/S1_Sales.csv", CUSTOMER, SUPPLIER1.getProductArray()); 
    
    private final static Supplier SUPPLIER2 = new Supplier(FileIO.productReader("src/dataFiles/S2_Products.csv"));
    private final static Sales[] SALES2 = fileIO.FileIO.salesReader("src/dataFiles/S2_Sales.csv", CUSTOMER, SUPPLIER2.getProductArray());

    private final static Supplier SUPPLIER3 = new Supplier(FileIO.productReader("src/dataFiles/S3_Products.csv"));
    private final static Sales[] SALES3 = fileIO.FileIO.salesReader("src/dataFiles/S3_Sales.csv", CUSTOMER, SUPPLIER3.getProductArray());
    
    private final static SalesManagement SALES_MANAGEMENT = new SalesManagement(SALES1, SALES2, SALES3);// sales1 for supplier 1 ,sales2 for supplier 2,sales 3 for supplier 3
    
    /**
     * This method invoke public methods.
     */
    public static void runApp(){
       mostProfitableSale();
       mostExpensiveProduct();
       customerPurchasesTheMostProduct();
       totalProfit();
       theLeastProfitProductOfS1();
    }

    /**
     * prints the most profitable sales among the three suppliers
     */
    private static void mostProfitableSale(){
        SalesManagement SalesManagementCopy = new SalesManagement(SALES_MANAGEMENT);
        Sales mostProfitableSales =SalesManagementCopy.getSalesArray()[0][0];
        for(Sales[] arr:SalesManagementCopy.getSalesArray()){
            for(Sales sale:arr){
                if(sale == null){
                    break;
                }
                if(sale.getProfit()>mostProfitableSales.getProfit()){
                    mostProfitableSales = sale;
                }
            }
        }
        System.out.printf("1)" +mostProfitableSales.getProduct().toString()+" -> %.2f TL Profit%n",mostProfitableSales.getProfit());    
    }
    
/**
 * This method prints most expensive product in terms of sales price among the all products.
 */
  private static void mostExpensiveProduct(){ 
        SalesManagement SalesManagementCopy = new SalesManagement(SALES_MANAGEMENT);
        Sales mostExpensiveSale = SalesManagementCopy.getSalesArray()[0][0];
        for(Sales[] arr:SalesManagementCopy.getSalesArray()){
            for(Sales sale:arr){
                if(sale == null){
                    break;
                }
                if(sale.getSalesPrice()>mostExpensiveSale.getSalesPrice()){
                    mostExpensiveSale = sale;
                }
            }}
            System.out.printf("2)" +mostExpensiveSale.getProduct().toString()+" -> with sale price %.2f\n",mostExpensiveSale.getSalesPrice());
    }

  /**
   * This method prints the customer which purchases the most product.
   */
    private static void customerPurchasesTheMostProduct(){
        int purchaseCount = 0;
        int tempCount = 0;
        Customer mostPurchasingCustomer = new Customer(CUSTOMER[0]);
        Sales[][] salesManagementArrayCopy = new SalesManagement(SALES_MANAGEMENT).getSalesArray();
        
        for(Customer c : CUSTOMER){
            if (c == null){
                break;
            }
            for(Sales[] arr:salesManagementArrayCopy){
                for(Sales sale:arr){
                    if(sale == null){
                        break;
                    }
                    if(c.getId().equals(sale.getCustomer().getId())){
                        tempCount++;
                    }
                }
            }
            if(tempCount > purchaseCount){
                purchaseCount = tempCount;
                mostPurchasingCustomer = c;
            }
            
                tempCount = 0;
        }
        System.out.printf("3)"+mostPurchasingCustomer.toString()+" -> with %d purchases\n",purchaseCount);
    }

    /**
     * This method prints the total profits among the all sales.
     */
    private static void totalProfit(){
        double totalProfit = 0;
        Sales[][] salesManagementCopy = new SalesManagement(SALES_MANAGEMENT).getSalesArray();
        for(Sales[] arr:salesManagementCopy){
            for(Sales sale:arr){
                if(sale == null){
                    break;
                }
                totalProfit += sale.getProfit();
            }
        }
        System.out.printf("4) Total Profit: %.2f TL\n",totalProfit);
    }

    /**
     * This method prints the the least profit product of s1
     */
    private static void theLeastProfitProductOfS1(){
        Sales[][] salesManagementCopy = new SalesManagement(SALES_MANAGEMENT).getSalesArray();
        Sales leastProfitableSale = salesManagementCopy[0][0];
        for(Sales sale:salesManagementCopy[0]){
            if(sale == null){
                break;
            }
            if(sale.getProfit()<leastProfitableSale.getProfit()){
                leastProfitableSale = sale;
            }
        }
        System.out.printf("5)" +leastProfitableSale.getProduct().toString()+" -> with %.2f TL Profit",leastProfitableSale.getProfit());
    }
    

    
    




}