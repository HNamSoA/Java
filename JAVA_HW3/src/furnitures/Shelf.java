package furnitures;

import java.util.ArrayList;
import java.util.Map;

import material.Material;

public class Shelf extends Furniture{

    public Shelf(String furnitureCode, Map<String, ArrayList<Material>> furnitureParts) {
        super(furnitureCode, furnitureParts);
    }

    public Shelf(Shelf shelf) {
        super(shelf);
    }

    @Override
    public double getIncome() {
        return getFurnitureCost()*280/100;
    }

    

    @Override
    public Shelf clone() {
        return new Shelf(this);
    }
    
}
