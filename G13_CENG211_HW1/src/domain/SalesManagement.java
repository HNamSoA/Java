package domain;
/**
* This class holds multidimensional arrays of sales which represents each supplier' s sales.
* @author Hasan Basri Erdoğan 280201002
* @author Serhat Eren Taş 280201020
* @author Osman Çelik 280201053
* @author Kerem Buğra Kasal 280201005 
 */
public class SalesManagement {
    private Sales[][] salesArray = new Sales[3][];
    /**
     * This is the fully constructor.
     * @param array1
     * @param array2
     * @param array3
     */
    SalesManagement(Sales[] array1, Sales[] array2, Sales[] array3) {
        this.salesArray[0] = array1;  //supplier1
        this.salesArray[1] = array2;  //supplier2
        this.salesArray[2] = array3;  //supplier3
    }
    /**
     * This is the copy contructor to avoid privacy leak.
     * This copy constructor creates new copy of sale object for each supplier.
     * @param originalObject
     */
    SalesManagement(SalesManagement originalObject){
       for(int i = 0; i < 3; i++) {
           int y = 0;
           this.salesArray[i] = new Sales[originalObject.getSalesArray()[i].length];
           for(Sales originalSalesObject: originalObject.getSalesArray()[i]) {
               if(originalSalesObject == null) {
                   break;
               }
               this.salesArray[i][y] = new Sales(originalSalesObject);
               y++;   
           }
       }
    }
    /**
     * @return Sales[][]
     */
    public Sales[][] getSalesArray() {
        return salesArray;
    }
}
