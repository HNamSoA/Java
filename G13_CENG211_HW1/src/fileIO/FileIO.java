package fileIO;
import domain.*;
import java.io.*;
import java.util.StringTokenizer;
/**
* This is our FileIO class. This class reads all the documents in dataFiles folder by using related methods.
@author Hasan Basri Erdoğan 280201002
* @author Serhat Eren Taş 280201020
* @author Osman Çelik 280201053
* @author Kerem Buğra Kasal 280201005  
*/

public class FileIO{
    
    
    
    
/**
 * This method reads customer file that is given by user by using BufferedReader, 
 * and returns an array of customer objects.
 * @param filePath
 * @return Customer[]
 */
  
    public static Customer[] customerReader(String filePath) {
        Customer[] customerArr = null;
        try {
            BufferedReader customerFileReader = new BufferedReader(new FileReader(filePath));
            int arraySize = numberOfLines(customerFileReader);
            customerArr= new Customer[arraySize];
            
            String id, name, email, country, adress;
            int index = 0;
            
            String line = customerFileReader.readLine() ; 
            while (line != null) {
                StringTokenizer tokens = new StringTokenizer(line,",");
                id = tokens.nextToken() ;
                name = tokens.nextToken() ;
                email = tokens.nextToken() ;
                country = tokens.nextToken() ;
                adress = tokens.nextToken() ;
                Customer customer = new Customer(id, name, email, country,adress);           
                customerArr[index] = customer;
                index++;
                line = customerFileReader.readLine() ;
            }   
            customerFileReader.close();
        }catch(FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }catch(IOException e) {
            System.out.println(e);
            System.exit(0);
        }
        return customerArr;
    }
    
    
    /**
     * This method reads products file that is given by user by using BufferedReader, 
     * and returns an array of customer objects.
     * @param filePath
     * @return Product[]
     */
    
    public static Product[] productReader(String filePath){
        Product[] productArr = null;
    
    try{
        BufferedReader productFileReader = new BufferedReader(new FileReader(filePath));
        int arraySize = numberOfLines(productFileReader);
        productArr = new Product[arraySize];
        String id, title;
        float rate, price;
        int numberOfReviews, index = 0;
        
        String line = productFileReader.readLine() ;
        while (line != null){  
            StringTokenizer tokens = new StringTokenizer(line, ",");
            id = tokens.nextToken() ;
            title = tokens.nextToken() ;
            rate =Float.parseFloat(tokens.nextToken()) ;
            numberOfReviews = Integer.parseInt(tokens.nextToken()) ;
            price = Float.parseFloat(tokens.nextToken()) ;
            Product product = new Product(id,title,rate,numberOfReviews,price);           
            productArr[index] = product;
            index++;
            line = productFileReader.readLine() ;
        }
        
        productFileReader.close();
    }catch (FileNotFoundException e){
        System.out.println(e);
        System.exit(0);
    }
    
    catch (IOException ioe){
        System.out.println(ioe);
        System.exit(0);
    }
    return productArr;}

    
    /**
     * This method reads sales files which is given by user, 
     * and matches customers and products with the sales by using their IDs
     * @param filePath
     * @return Sales[]
     */

    public static Sales[] salesReader(String filePath,Customer[] customerArr, Product[] productArr){
        Sales[] salesArr = null;
    
    try{
        
        BufferedReader salesFileReader = new BufferedReader(new FileReader(filePath));
        int arraySize = numberOfLines(salesFileReader);
        salesArr = new Sales[arraySize];
        String id;
        Customer customer ;
        Product product ;
        String salesDate ;
        
        int index = 0;
        String line = salesFileReader.readLine() ;
        while (line != null){  
            StringTokenizer tokens = new StringTokenizer(line, ",");
            id = tokens.nextToken() ;
            customer = searchCustomer(tokens.nextToken(), customerArr) ;
            product = searchProduct(tokens.nextToken(),productArr) ;
            salesDate = tokens.nextToken() ;
            Sales sales = new Sales(id, customer, product, salesDate);           
            salesArr[index] = sales;
            index++;
            line = salesFileReader.readLine() ;
        }
        
        salesFileReader.close();
    }catch (FileNotFoundException e){
        System.out.println("File Customers not found");
        System.exit(0);
    }
    
    catch (IOException ioe){
        System.out.println("Error reading from file sales");
        System.exit(0);
    }
    return salesArr;}

//------------------------------------------ helper methods -----------------------------------------

    /*
    * It is a helper method to match customer and sale by using customer IDs, 
    * after that initializes sale object's customer field.  
    */
    private static Customer searchCustomer(String customerId, Customer[] customerArr){
        Customer customer = null;
        for(int i=0; i<customerArr.length; i++){
            if(customerId.equals(customerArr[i].getId())){
                customer = customerArr[i];
                break;
            }
        }
        return customer;
    }

    
    /*
    * It is a helper method to match product and sale by using product IDs, 
    * after that initializes sale object's product field.  
    */
    private static Product searchProduct(String productId, Product[] productArr){
        Product product = null;
        for(int i=0; i< productArr.length; i++){
            if(productId.equals(productArr[i].getId())){
                product = productArr[i];
                break;
            }
        }
        return product;
    }
      
      
    /*
    * It is a helper method that counts the number of lines in the any given data file and returns number of lines.
    */  
    private static int numberOfLines(BufferedReader file) throws IOException {
          int countNumberOfLines = 0;
          while (file.readLine() != null ) {
              if(countNumberOfLines == 0) {// to avoid storing the titles in the array we marked second line
                  file.mark(10000); //marks the current position to get back after learning how many line we read
              }
              countNumberOfLines ++;
          }
          file.reset();
          return countNumberOfLines;
    }
}       