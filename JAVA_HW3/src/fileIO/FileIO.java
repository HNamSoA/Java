package fileIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    public static final ArrayList<ArrayList<String>> MANUFACTURER_1_FURNITURES = readData("src/DataFiles/Manufacturer1Furnitures.csv");
    public static final ArrayList<ArrayList<String>> MANUFACTURER_2_FURNITURES = readData("src/DataFiles/Manufacturer2Furnitures.csv");
    public static final ArrayList<ArrayList<String>> MANUFACTURER_1_MATERIALS = readData("src/DataFiles/Manufacturer1Materials.csv");
    public static final ArrayList<ArrayList<String>> MANUFACTURER_2_MATERIALS = readData("src/DataFiles/Manufacturer2Materials.csv");
    public static final ArrayList<ArrayList<String>> RAW_MATERIAL_PROPERTIES = readData("src/DataFiles/RawMaterialProperties.csv");
    public static final ArrayList<ArrayList<String>> VENDOR_POSSESSIONS = readData("src/DataFiles/VendorPossessions.csv");
    public static final ArrayList<ArrayList<String>> FURNITURE_PARTS = readData("src/DataFiles/FurnitureParts.csv");

public static ArrayList<ArrayList<String>> readData(String fileName) {
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                ArrayList<String> line = new ArrayList<String>();
                String[] values = scanner.nextLine().split(",");
                for (String value : values) {
                    line.add(value);
                }
                data.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;}
}
