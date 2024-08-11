package fileio;
import java.io.*;
import java.util.ArrayList;

import domain.vehicle.Vehicle;
import domain.vehicle.automobile.automobiletype.*;
import domain.vehicle.bicycle.Bicycle;
import domain.vehicle.pickupTruck.PickupTruck;

/**
 * 
 * This class is used to read and write data from and to files.
 * @author Hasan Basri Erdoğan 280201002
 * @author Serhat Eren Taş 280201020
 * @author Osman Çelik 280201053
 * @author Kerem Buğra Kasal 280201005
 *
 */
public class FileIO {
    /**
     * This method is used to read data from a file and return an ArrayList of Vehicles.
     * @return ArrayList<Vehicle>
     */
public static ArrayList<Vehicle> getVehicles() {
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    try{
        
        BufferedReader customerFileReader = new BufferedReader(new FileReader("src/HW2_SoldVehicles.csv"));
        String line = customerFileReader.readLine() ;
        while (line != null){  
            String[] lineArray = line.split(",") ;
            switch(lineArray[0].split("")[0]){
                
                case "B":
                Bicycle a = new Bicycle(lineArray[0], lineArray[1], lineArray[2], Integer.parseInt(lineArray[3]), lineArray[4], lineArray[5], Double.parseDouble(lineArray[6]));
                vehicles.add(a);
                break;
                case "P":
                PickupTruck b = new PickupTruck(lineArray[0], lineArray[1], lineArray[2], Integer.parseInt(lineArray[3]), lineArray[4], lineArray[5], Double.parseDouble(lineArray[6]));
                vehicles.add(b);
                break;
                case "H":
                Hatchback c = new Hatchback(lineArray[0], lineArray[1], lineArray[2], Integer.parseInt(lineArray[3]), lineArray[4], Double.parseDouble(lineArray[5]), Double.parseDouble(lineArray[6]));
                vehicles.add(c);
                break;
                case "S":
                Sedan d = new Sedan(lineArray[0], lineArray[1], lineArray[2], Integer.parseInt(lineArray[3]), lineArray[4], Double.parseDouble(lineArray[5]), Double.parseDouble(lineArray[6]));
                vehicles.add(d);
                break;
                case "M":
                Minivan e = new Minivan(lineArray[0], lineArray[1], lineArray[2], Integer.parseInt(lineArray[3]), Integer.parseInt(lineArray[4]), Double.parseDouble(lineArray[5]), Double.parseDouble(lineArray[6]));
                vehicles.add(e);
                break;

            } 
            
            line = customerFileReader.readLine() ;
        }
        
        customerFileReader.close();
    }catch (FileNotFoundException e){
        System.out.println("File not found");
        System.exit(0);
    }

    catch (IOException ioe){
        System.out.println("Error reading from file");
        System.exit(0);
    }
    
    return vehicles;
}


}

