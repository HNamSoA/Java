package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileIO {
    public static Queue<ArrayList<String>> commands = readCommands();
    
    

    private static Queue<ArrayList<String>> readCommands(){
        
        Queue<ArrayList<String>> commands = new ArrayDeque<>();
        try (Scanner scanner = new Scanner(new File("src/fileIO/ExampleCommands.csv"))) {
            while(scanner.hasNextLine()){
                ArrayList<String> command = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(scanner.nextLine(),",");
                while(st.hasMoreTokens()){
                    command.add(st.nextToken());
                }
                commands.add(command);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return commands;
    }
    
}

