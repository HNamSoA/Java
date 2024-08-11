package manufacturer;

import java.util.ArrayList;

import domain.*;
import material.Material;


public class ManufacturerB extends Manufacturer {

	
	public ManufacturerB(ArrayList<ArrayList<String>> MANUFACTURER_MATERIALS, ArrayList<ArrayList<String>> MANUFACTURER_FURNITURES){
		super(MANUFACTURER_MATERIALS, MANUFACTURER_FURNITURES);
		waitingLine = new FIFOList<WaitingLineObject>();
		notProducedFurnitures = new FIFOList<WaitingLineObject>();
	}
	

	public void buyMaterialsByDay(int day, Vendor vendor){
		if(day>0 && vendor != null) {
			String key;
        	int amount;
        	for (int i= 1;  i<super.getManufaturerMaterials().get(day-1).size(); i+=2){
        		key = getManufaturerMaterials().get(day-1).get(i);
        		amount = Integer.parseInt(getManufaturerMaterials().get(day-1).get(i+1));
        		if(!inventory.containsKey(key)) {
        			inventory.put(key, new LIFOList<Material>());
        		}
        		for(int j = 0; j < amount; j++) {
        			inventory.get(key).add(vendor.sell(key));
        		}
        			
        	}
        }else {
        	System.out.println("numberOfDay to produce furniture is negative");
        	System.exit(0);
        }
    }
}
