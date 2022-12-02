//I feel really gross about this. I'm storing the values loaded from the file in a map, but then iterating
//over the map to get the largest number anyway.. I hate that. But, this is what I know :)

package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, Integer>caloryMap = new HashMap<>();
        try {
            loadFile(caloryMap);
            int mostCalories = 0;
            for (int i = 1; i < caloryMap.size(); i++) {
                if (mostCalories < caloryMap.get(i)) {
                    mostCalories = caloryMap.get(i);
                }
            }
            System.out.println(mostCalories);
        } catch (Exception e) {
            System.out.println(e);
        }

        //load everything from the file
        //sum every group and put into a map
        //use an incrementer to track the elf holding the calories
        //start incrementer from 1
        //get the largest number


    }

    public static void loadFile(HashMap<Integer, Integer> caloryMap) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("CaloryCarrier.txt");
        Scanner scan = new Scanner(fis);
        int elf = 1;
        while (scan.hasNext()) {
            String calories = scan.nextLine();
            if (calories.isBlank()) {
                elf++;
                continue;
            }
            Integer caloriesInInt = Integer.parseInt(calories);
            caloryMap.merge(elf, caloriesInInt, Integer::sum);
        }
    }
}
