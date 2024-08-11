package domain.enums;
public enum Items{
    BoxOfMilks("Box of milk",5,11,"Countable","M1"),BoxOfWater("Box of water",1,3,"Countable","W1"),BoxOfOil("Box of oil",20,45,"Countable","O1"),Sugar("Sugar",13,25,"Uncountable","S1"),Flour("Flour",5,12,"Uncountable","F1"),Pasta("Pasta",12,28,"Uncountable","P1"),Rice("Rice",16,32,"Uncountable","R1");
    private String name;
    private int cost;
    private int price;
    private String countability;
    private String itemCode;

    Items(String name,int cost,int price,String countability,String itemCode){
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.countability = countability;
        this.itemCode = itemCode;
    }

    /**
     * This method is used to search item by item code
     * @param itemCode
     * @return
     */
    public static Items searchItem(String itemCode){
        for(Items item : Items.values()){
            if(item.getItemCode().equals(itemCode)){
                return item;
            }
        }
        return null;
    }

    public String getName(){
        return name;
    }

    public int getCost(){
        return cost;
    }

    public int getPrice(){
        return price;
    }

    public String getCountability(){
        return countability;
    }

    public String getItemCode(){
        return itemCode;
    }
}


