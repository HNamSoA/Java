package domain;

/**
* This class hold one dimensional product array.
* @author Hasan Basri Erdoğan 280201002
* @author Serhat Eren Taş 280201020
* @author Osman Çelik 280201053
* @author Kerem Buğra Kasal 280201005 
 */
public class Supplier {
    
    private Product[] productArray;

    public Supplier(){
        productArray = null;
    }

    /**
     * This is fully constructor.
     * @param array
     */
    public Supplier(Product[] array) {
        this.productArray = array;
    }
    
    /**
     * This is copy constructor to avoid privacy leak.
     * This copy constructor creates new copy of product objects and store them in a new array.
     * @param originalSupplier
     */
    public Supplier(Supplier originalSupplier) {
        Product[] originalProductArray = originalSupplier.getProductArray();
        int lengthOfOrignalArrayProductArray = originalProductArray.length;
        productArray = new Product[lengthOfOrignalArrayProductArray];
        for(int i = 0; i < lengthOfOrignalArrayProductArray ;i++) {
            if( originalProductArray[i] == null) {
                break;
            }
            this.productArray[i] = new Product(originalProductArray[i]);
        }
    }

    /**
     * @return Product[]
     */
    public Product[] getProductArray() {
        return productArray;
    }
}


 





    
