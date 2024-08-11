package furnitures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import material.Material;

public abstract class Furniture implements IFurniture {
    private String furnitureCode;
    private String furnitureName;
    private Map<String, ArrayList<Material>> furnitureParts;
    private int cost;
    private double furnitureQuality;
   
    
    
        
    

    public Furniture(String furnitureCode, Map<String,ArrayList<Material>> furnitureParts){
        this.furnitureCode = furnitureCode;
        this.furnitureName = nameAssigning();
        this.furnitureParts = furnitureParts;
        this.cost = costCalculator();
        this.furnitureQuality = qualityCalculator();
    }

    public Furniture(Furniture furniture) {
        this.furnitureCode = furniture.furnitureCode;
        this.furnitureName = furniture.furnitureName;
        this.furnitureParts = cloneMap(furniture.furnitureParts);
        this.cost = furniture.cost;
        this.furnitureQuality = furniture.furnitureQuality;
    }

    private int costCalculator(){
        int total = 0;
        for(String key: furnitureParts.keySet()){
            for(Material element : furnitureParts.get(key)){
                total+= element.getMaterialCost();
                
            }
        }
        return total;
    }

    private double qualityCalculator(){
        double total = 0;
        double totalVolume = 0;
        for(String key: furnitureParts.keySet()){
            for(Material element : furnitureParts.get(key)){
                total+= element.getMaterialQuality()*element.getVolume();
                totalVolume += element.getVolume();
            }
        }
        return total/totalVolume;
    }
    
    
    @Override
    public String getFurnitureCode() {
        
        return furnitureCode;
    }

    @Override
    public String getFurnitureName() {
        
        return furnitureName;
    }

    @Override
    public int getFurnitureCost() {
       
        return cost;
    }

    @Override
    public double getFurnitureQuality() {
        return furnitureQuality;
    }

    @Override
    public abstract double getIncome();

        
    @Override
    public String getFurnitureMaterial() {
      
        return null;
    }
    @Override
    public Map<String, ArrayList<Material>> getFurnitureParts() {
       
        return null;
    }

    public abstract Furniture clone();


    private String nameAssigning() {
        for (NameOfFurniture element: NameOfFurniture.values()){
            if(element.toString().equals(furnitureCode)){
                return element.nameOfTheFurniture;            }
        }
        System.out.println("wrong code");
        System.exit(0);
        return null;
    }
    public Map<String, ArrayList<Material>> cloneMap(Map<String, ArrayList<Material>> map){

        Map<String, ArrayList<Material>> clone = new HashMap<String, ArrayList<Material>>();
        for(String key: map.keySet()){
            ArrayList<Material> temp = new ArrayList<Material>();
            for(Material element: map.get(key)){
                temp.add(element.clone());
            }
            clone.put(key, temp);
        }
        return clone;
        
    }

    @Override
    public String toString() {
        return "Furniture [furnitureCode=" + furnitureCode + ", furnitureName=" + furnitureName + ", furnitureParts="
                + furnitureParts + ", cost=" + cost + ", furnitureQuality=" + furnitureQuality + "]";
    }
    
}
