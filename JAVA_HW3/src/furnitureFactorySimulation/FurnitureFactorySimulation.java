package furnitureFactorySimulation;
import furnitures.Furniture;
import manufacturer.Manufacturer;
import manufacturer.ManufacturerA;
import manufacturer.ManufacturerB;
import material.MaterialProperties;
import material.Material;
import fileIO.FileIO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import domain.*;

public class FurnitureFactorySimulation implements IFurnitureFactorySimulation{

    @Override
    public void runSimulation() {
        Vendor vendor = vendorFiller();
        Manufacturer manufacturerA = new ManufacturerA(FileIO.MANUFACTURER_1_MATERIALS,FileIO.MANUFACTURER_1_FURNITURES);
        ManufacturerB manufacturerB = new ManufacturerB(FileIO.MANUFACTURER_2_MATERIALS,FileIO.MANUFACTURER_2_FURNITURES);
        for(int i = 1 ; i <=3 ; i++){
            System.out.println("Day: " + i + "\n\n");
           

            manufacturerPrinter(i, manufacturerA, vendor);
            manufacturerPrinter(i, manufacturerB, vendor);

        }

    }

    public void manufacturerPrinter(int day, Manufacturer manufacturerType, Vendor vendor){
           
            manufacturerType.buyMaterialsByDay(day, vendor);
            manufacturerType.addFurnituresToWaitingLineByDay(day);
            Map<String,ArrayList<Furniture>> producedFurnitures = new HashMap<String,ArrayList<Furniture>>();
            manufacturerType.produceFurnitures(producedFurnitures);
            for(String key : producedFurnitures.keySet()){
                PrintMethods.qualityRangePrinter(producedFurnitures.get(key));
                PrintMethods.earningPrinter(producedFurnitures.get(key));
            }
            PrintMethods.totalExpenseAndIncomePrinter(producedFurnitures);
            PrintMethods.printUnproducedFurnitures(manufacturerType.getUnproducedFurnitures());

        }

    private Vendor vendorFiller(){
        ArrayList<MaterialProperties>  propertiesList = new ArrayList<MaterialProperties>();
        ArrayList<Material> materialList = new ArrayList<Material>();

        for(ArrayList<String> list : FileIO.RAW_MATERIAL_PROPERTIES){
            propertiesList.add(new MaterialProperties(list.get(0),Integer.parseInt(list.get(1)),Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3)), Integer.parseInt(list.get(4))));
        }
        for(ArrayList<String> list : FileIO.VENDOR_POSSESSIONS){
            materialList.add(materialCreator(list, propertiesList));
       } 
       return new Vendor(materialList);
    }

    private Material materialCreator(ArrayList<String> listOfVendorPossesions, ArrayList<MaterialProperties> listOfMaterialProperties){
        for(MaterialProperties element : listOfMaterialProperties){
            if(element.getCode().equals(listOfVendorPossesions.get(0))){
                return new Material(listOfVendorPossesions.get(0),Integer.parseInt(listOfVendorPossesions.get(1)), element);
            }
        }
        System.out.println("unmatched code of material properties and code of material");
        System.exit(0);
        return null;
    }
    
    
    
}