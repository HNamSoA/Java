package domain;

import java.util.ArrayList;
import java.util.Map;

import furnitures.Furniture;

public class PrintMethods{
    public static void qualityRangePrinter(ArrayList<Furniture> list){
        int badQuality = 0;
        int normalQuality = 0;
        int goodQuality = 0;
        int veryGoodQuality = 0;
        int perfectQuality = 0;
        for(Furniture element : list){
            double furnitureQuality = element.getFurnitureQuality();
            if(furnitureQuality != 0){
                if(furnitureQuality < 92) {
                    badQuality++;
                }
                else if(furnitureQuality >= 92 && furnitureQuality <=94){
                    normalQuality++;
                }
                else if(furnitureQuality >= 94 && furnitureQuality <=96){
                    goodQuality++; 
                }
                else if(furnitureQuality >= 96 && furnitureQuality <=98){
                    veryGoodQuality++;
                }
                else{
                perfectQuality++;
                }
            }
        }
        System.out.print(list.get(0).getFurnitureName()+":"+" Bad Qlt: " +badQuality+ " ,Normal Qlt: "+normalQuality+" ,Good Qlt: "+goodQuality+" ,Very Good Qlt: "+ veryGoodQuality+" ,Perfect Qlt: "+ perfectQuality);
    }

    public static void earningPrinter(ArrayList<Furniture> list){
        double earning = 0;
        for(Furniture element : list)
        {   
            earning += element.getIncome()-element.getFurnitureCost();
        }
        System.out.printf(" ,Earning: %.0f₺\n", earning);
    }

    public static void totalExpenseAndIncomePrinter(Map<String,ArrayList<Furniture>> allProducedFurniture ){
        int totalIncome = 0;
        int totalCost = 0;
        for(ArrayList<Furniture> list : allProducedFurniture.values()){
            for(Furniture object : list){
                totalIncome += object.getIncome();
                totalCost += object.getFurnitureCost();
            }
        }
        System.out.println("\nTotalExpense: "+totalCost +"\n");
        System.out.println("TotalIncome: "+ totalIncome+ "\n");
    }

    public static void printUnproducedFurnitures(Map<String, Integer> map){
        System.out.println("Unproduced Furnitures: \n");
        for(String name: map.keySet()){
            System.out.print(map.get(name)+" "+ name+", ");
        }
        System.out.println("\n");
    }
}

    

