package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {

        try {
            File myObj = new File(System.getProperty("user.dir") + "\\src\\day4\\d4input.txt");
            Scanner myReader = new Scanner(myObj);
            int lineCount = 0;
            int totalScore = 0;

            int elf1Start = 0;
            int elf1End = 0;
            int elf2Start = 0;
            int elf2End = 0;


            while (myReader.hasNextLine()) {
                ++lineCount;
                String data = myReader.nextLine();
                String elf1 = data.split(",")[0];
                String elf2 = data.split(",")[1];

                elf1Start = Integer.parseInt(elf1.split("-")[0]);
                elf1End = Integer.parseInt(elf1.split("-")[1]);
                elf2Start = Integer.parseInt(elf2.split("-")[0]);
                elf2End = Integer.parseInt(elf2.split("-")[1]);

                //Part1
                // elf1 contains all elf2 numbers or elf2 contains all elf1 numbers
//                if (((elf1Start<=elf2Start)&&(elf1End>=elf2End))||((elf2Start<=elf1Start)&&(elf2End>=elf1End))){
//                    totalScore = totalScore+1;
//                }

                //Part2
                // if elf2 start is within elf1 range or elf2 end is within elf1 range or vice versa
                if ( (((elf1Start<=elf2Start)&&(elf2Start<=elf1End))||((elf1Start<=elf2End)&&(elf2End<=elf1End)))||
                        (((elf2Start<=elf1Start)&&(elf1Start<=elf2End))||((elf2Start<=elf1End)&&(elf1End<=elf2End)))){
                    totalScore = totalScore+1;
                }

            }
            System.out.println(totalScore);
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}