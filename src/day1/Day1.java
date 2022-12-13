package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        try {
            File myObj = new File(System.getProperty("user.dir") + "\\src\\day1\\d1input.txt");
            Scanner myReader = new Scanner(myObj);
            int elfTotal = 0;
            List<Integer> elvesCal = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals("")) {
                    System.out.println("Next Elf");
                    elvesCal.add(elfTotal);
                    elfTotal = 0;
                } else {
                    elfTotal = elfTotal + Integer.parseInt(data);
                    System.out.println(Integer.parseInt(data));
                }
            }

            Collections.sort(elvesCal);
            Collections.reverse(elvesCal);


            System.out.println("top elves");
            System.out.println(elvesCal.get(0));
            System.out.println(elvesCal.get(1));
            System.out.println(elvesCal.get(2));
            System.out.println(elvesCal.get(0)+elvesCal.get(1)+elvesCal.get(2));


            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}