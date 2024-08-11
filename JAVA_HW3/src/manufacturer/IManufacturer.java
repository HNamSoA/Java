package manufacturer;

import java.util.ArrayList;
import java.util.Map;

import domain.IList;
import domain.Vendor;
import furnitures.Furniture;
import material.Material;

public interface IManufacturer {
    public Map<String, IList<Material>> getInventory();


    public void buyMaterialsByDay(int numberOfDay, Vendor vendor);
    
    
    public void produceFurnitures(Map<String,ArrayList<Furniture>> producedFurnitures);

    
}
