package furnitures;

import java.util.ArrayList;
import java.util.Map;

import material.Material;

public class Wardrobe extends Furniture {


    public Wardrobe(String furnitureCode, Map<String, ArrayList<Material>> furnitureParts) {
        super(furnitureCode, furnitureParts);
    }

    public Wardrobe(Wardrobe wardrobe) {
        super(wardrobe);
    }

    @Override
    public double getIncome() {
       return getFurnitureCost()*320/100;
    }

    @Override
    public Wardrobe clone() {
        return new Wardrobe(this);
    }
    
}
