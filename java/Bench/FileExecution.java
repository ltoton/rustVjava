package Bench;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileExecution {

    public static void run() {
        try {
            //Read file
            Scanner scanner = new Scanner(new File("data.txt"));
            List<String> data = new ArrayList<>();
            while(scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
            scanner.close();

            //Write file
            FileWriter writer = new FileWriter("output.txt");
            for(String str: data) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (Exception e) {
        }
    }
}