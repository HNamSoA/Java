package manufacturer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import domain.IList;
import domain.Vendor;
import material.Material;
import furnitures.Shelf;
import furnitures.Table;
import furnitures.Wardrobe;
import furnitures.Furniture;
import furnitures.FurnitureParts;


public abstract class Manufacturer implements IManufacturer {
    Map<String, IList<Material>> inventory;
    IList<WaitingLineObject> waitingLine;
    IList<WaitingLineObject>  notProducedFurnitures;
    private final ArrayList<ArrayList<String>> MANUFACTURER_MATERIALS;
    private final ArrayList<ArrayList<String>> MANUFACTURER_FURNITURES;


    
    public Manufacturer( ArrayList<ArrayList<String>> MANUFACTURER_MATERIALS, ArrayList<ArrayList<String>> MANUFACTURER_FURNITURES) {
        this.MANUFACTURER_MATERIALS = MANUFACTURER_MATERIALS;
        this.MANUFACTURER_FURNITURES = MANUFACTURER_FURNITURES;
        inventory = new HashMap<String, IList<Material>>();
    }

    public ArrayList<ArrayList<String>> getManufaturerMaterials(){
    	return  MANUFACTURER_MATERIALS;
    }
    
    @Override
    public Map<String, IList<Material>> getInventory(){
        return inventory;
    }

    public IList<WaitingLineObject> getWaitingLine(){
        return waitingLine.clone();
    }



    @Override
    public abstract void buyMaterialsByDay(int day, Vendor vendor);

    public void addFurnituresToWaitingLineByDay(int day){

        ArrayList<String> listOfFurniturePair =  MANUFACTURER_FURNITURES.get(day-1);
        for(int i =1; i< listOfFurniturePair.size(); i+=2 ){
            WaitingLineObject object = new WaitingLineObject(listOfFurniturePair.get(i), Integer.parseInt(listOfFurniturePair.get(i+1)));
            waitingLine.add(object);
        }
    }

    private boolean furnitureMaterialChecker(String code){
        for(String materialName :FurnitureParts.furnitureParts.get(code).keySet()){
            if(FurnitureParts.furnitureParts.get(code).get(materialName) > inventory.get(materialName).size()){
                return false;
            }
         }
         return true;
    }
    
    @Override
    public void produceFurnitures(Map<String,ArrayList<Furniture>> producedFurnitures) {
        int size2 = notProducedFurnitures.size();

        for(int i = 0; i< size2; i++){
            waitingLine.add(notProducedFurnitures.remove());
        }
        int size = waitingLine.size();
        for(int i = 0; i< size; i++){
            while(waitingLine.seek().getNumberOfFurnitures() > 0){
                if(furnitureMaterialChecker(waitingLine.seek().getFurnitureCode())){
                    Map<String,ArrayList<Material>> furnitureParts = new HashMap<String,ArrayList<Material>>();
                    for(String materialName :FurnitureParts.furnitureParts.get(waitingLine.seek().getFurnitureCode()).keySet()){
                        ArrayList<Material> materialList = new ArrayList<Material>();
                        for(int j = 0; j< FurnitureParts.furnitureParts.get(waitingLine.seek().getFurnitureCode()).get(materialName); j++){
                            materialList.add(inventory.get(materialName).remove());
                        }
                        furnitureParts.put(materialName, materialList);
                    }

                    switch(waitingLine.seek().getFurnitureCode().substring(0,2)){
                        case "TB":
                            Table table = new Table(waitingLine.seek().getFurnitureCode(),furnitureParts);
                            if(!producedFurnitures.containsKey(table.getFurnitureName())){
                                producedFurnitures.put(table.getFurnitureName(), new ArrayList<Furniture>());
                            }
                            producedFurnitures.get(table.getFurnitureName()).add(table);
                            break;
                        case "WD":
                            Wardrobe wardrobe = new Wardrobe(waitingLine.seek().getFurnitureCode(),furnitureParts);
                            if(!producedFurnitures.containsKey(wardrobe.getFurnitureName())){
                                producedFurnitures.put(wardrobe.getFurnitureName(), new ArrayList<Furniture>());
                            }
                            producedFurnitures.get(wardrobe.getFurnitureName()).add(wardrobe);
                                break;
                        case "SH":
                        Shelf shelf = new Shelf(waitingLine.seek().getFurnitureCode(),furnitureParts);
                        if(!producedFurnitures.containsKey(shelf.getFurnitureName())){
                            producedFurnitures.put(shelf.getFurnitureName(), new ArrayList<Furniture>());
                        }
                        producedFurnitures.get(shelf.getFurnitureName()).add(shelf);
                    }
                    waitingLine.seek().reducerNumberOfFurnitures();
                    if(waitingLine.seek().getNumberOfFurnitures() == 0){
                        waitingLine.remove();
                        break;
                    }
                   
                }else{
                    notProducedFurnitures.add(waitingLine.remove());
                    break;
                }
            }
        }
        
    }

    public Map<String, Integer> getUnproducedFurnitures(){
        Map<String, Integer> unproducedFurnitures = new HashMap<String, Integer>();
        int size = notProducedFurnitures.size();
        IList<WaitingLineObject> tempList = notProducedFurnitures.clone();
        for(int i = 0; i< size; i++){
            String name = tempList.seek().getName();
            Integer number = tempList.seek().getNumberOfFurnitures();
            if(!unproducedFurnitures.containsKey(name)){
                unproducedFurnitures.put(name, number);
            }else{
                unproducedFurnitures.put(name, unproducedFurnitures.get(name)+number);
            }
            tempList.remove();
            if(tempList.size() == 0){
                break;
            }
        }
        return unproducedFurnitures;
    }

    public Map<String, IList<Material>> cloneMap(Map<String, IList<Material>> map){
    	Map<String, IList<Material>> clone = new HashMap<String, IList<Material>>();
    	for(Map.Entry<String, IList<Material>> entry : map.entrySet()) {
    		clone.put(entry.getKey(), entry.getValue().clone());
    	}
    	return clone;
    }
    
  
    
 
}
