package domain.salesrecord;

import java.io.*;
import java.util.ArrayList;

import domain.vehicle.Vehicle;
import domain.vehicle.automobile.automobiletype.Hatchback;
import domain.vehicle.automobile.automobiletype.Minivan;
import domain.vehicle.automobile.automobiletype.Sedan;
import domain.vehicle.bicycle.Bicycle;
import domain.vehicle.pickupTruck.PickupTruck;
import fileio.FileIO;

/**
 * 
 * This class contains some method to getting input from user and then display the list of sales records that user wants.
 * @author Hasan Basri Erdoğan 280201002
 * @author Serhat Eren Taş 280201020
 * @author Osman Çelik 280201053
 * @author Kerem Buğra Kasal 280201005
 *
 */

public class SalesRecord {
    /**
     * This method is used to get input from user and then display the list of sales records that user wants.
     */
    public static void runApp(){
        while (true){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 100; i++) {
            System.out.print("*");
        }
        System.out.println("\n\nPlease press,\n");
        System.out.println("1 to see all sold vehicle list");
        System.out.println("2 to see sold sedan list");
        System.out.println("3 to see sold hatchback list");
        System.out.println("4 to see sold minivan list");
        System.out.println("5 to see sold pickup truck list");
        System.out.println("6 to see sold bicycle list");
        System.out.print("Please enter your choice:");
        try {
            int i = Integer.parseInt(input.readLine());
            System.out.println(i);
            switch(i){
                case 1:
               for(Vehicle elm: FileIO.getVehicles()){
                    System.out.println(elm.toString());
                } 
                break;
                case 2:
                for (Sedan elm : getSedanList()){
                    System.out.println(elm.toString());
                }
                break;
                case 3:
                for(Hatchback elm : getHatchbackList()){
                    System.out.println(elm.toString());
                }
                break;
                case 4:
                for(Minivan elm : getMinivanList()){
                    System.out.println(elm.toString());
                }
                break;
                case 5:
                for(PickupTruck elm : getPickupTruckList()){
                    System.out.println(elm.toString());
                }
                break;
                case 6:
                for(Bicycle elm : getBicycleList()){
                    System.out.println(elm.toString());
                }
                break;
                default:
                System.out.println("\nWRONG INPUT\n");
                break;
            }
        } catch (IOException e) {
            System.out.println("\nWRONG INPUT\n");
            continue;
        }
        catch (NumberFormatException e){
            System.out.println("\nWRONG INPUT\n");
            continue;
        }
        
        }
        
    }

    /**
     * This method is used to get the list of sold sedan.
     * @return ArrayList<Sedan>
     */
    public static ArrayList<Sedan> getSedanList(){
        ArrayList<Sedan> sedanList = new ArrayList<Sedan>();
        for(Vehicle elm: FileIO.getVehicles()){
            if(elm instanceof Sedan){
                sedanList.add((Sedan)elm);
            }
        }
        return sedanList;

    }
    /**
     * This method is used to get the list of sold hatchback.
     * @return ArrayList<Hatchback>
     */
    public static ArrayList<Hatchback> getHatchbackList(){
        ArrayList<Hatchback> hatchbackList = new ArrayList<Hatchback>();
        for(Vehicle elm: FileIO.getVehicles()){
            if(elm instanceof Hatchback){
                hatchbackList.add((Hatchback)elm);
            }
        }
        return hatchbackList;

    }

    /**
     * This method is used to get the list of sold minivan.
     * @return ArrayList<Minivan>
     */
    public static ArrayList<Minivan> getMinivanList(){
        ArrayList<Minivan> minivanList = new ArrayList<Minivan>();
        for(Vehicle elm: FileIO.getVehicles()){
            if(elm instanceof Minivan){
                minivanList.add((Minivan)elm);
            }
        }
        return minivanList;

    }

    /**
     * This method is used to get the list of sold pickup truck.
     * @return ArrayList<PickupTruck>
     */
    public static ArrayList<PickupTruck> getPickupTruckList(){
        ArrayList<PickupTruck> pickupTruckList = new ArrayList<PickupTruck>();
        for(Vehicle elm: FileIO.getVehicles()){
            if(elm instanceof PickupTruck){
                pickupTruckList.add((PickupTruck)elm);
            }
        }
        return pickupTruckList;

    }
    /**
     * This method is used to get the list of sold bicycle.
     * @return ArrayList<Bicycle>
     */
    public static ArrayList<Bicycle> getBicycleList(){
        ArrayList<Bicycle> bicycleList = new ArrayList<Bicycle>();
        for(Vehicle elm: FileIO.getVehicles()){
            if(elm instanceof Bicycle){
                bicycleList.add((Bicycle)elm);
            }
        }
        return bicycleList;

    }
}