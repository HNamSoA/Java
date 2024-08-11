package furnitures;

import java.util.ArrayList;
import java.util.Map;

import material.Material;

public class Table extends Furniture{

    public Table(String furnitureCode, Map<String, ArrayList<Material>> furnitureParts) {
        super(furnitureCode, furnitureParts);
    }

    public Table(Table table) {
        super(table);
    }



    @Override
    public double getIncome() {
        return getFurnitureCost()*3;
    }

    @Override
    public Table clone() {
        return new Table(this);
    }
    
}
