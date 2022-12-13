package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
//        Character hello = 'A';
//        System.out.println((int)hello-38);
        try {
            File myObj = new File(System.getProperty("user.dir") + "\\src\\day3\\d3input.txt");
            Scanner myReader = new Scanner(myObj);
            int lineCount = 0;
            int totalScore = 0;
            String elf1 = "";
            String elf2 = "";
            String elf3 = "";

            while (myReader.hasNextLine()) {
                ++lineCount;
                String data = myReader.nextLine();
                //Part1
//                String bag1 = data.substring(0,data.length()/2);
//                String bag2 = data.substring((data.length()/2));
//                Day3 d = new Day3();
//                for (int i = 0; i < bag1.length(); ++i){
//                    if (bag2.contains(Character.toString(bag1.charAt(i)))){
//                        System.out.println(bag1.charAt(i));
//                        totalScore = totalScore + d.getCharScore(bag1.charAt(i));
//                        break;
//                    }
//                }


                //Part2
                Day3 d = new Day3();

                if (lineCount%3 == 1){
                    elf1 = data.strip();
                }else if (lineCount%3 == 2){
                    elf2 = data.strip();
                }else if (lineCount%3 == 0){
                    elf3 = data.strip();
                    for (int i = 0; i < elf1.length(); ++i){
                        if (elf2.contains(Character.toString(elf1.charAt(i))) && elf3.contains(Character.toString(elf1.charAt(i)))){
                            System.out.println(elf1);
                            System.out.println(elf2);
                            System.out.println(elf3);

                            System.out.println(elf1.charAt(i));
                            totalScore = totalScore + d.getCharScore(elf1.charAt(i));
                            break;
                        }
                    }
                    elf1 = "";
                    elf2 = "";
                    elf3 = "";
                }
            }
            System.out.println(totalScore);
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public int getCharScore(char input){
        if (Character.isLowerCase(input)){
            return (int)input -96;
        }else if (Character.isUpperCase(input)){
            return (int)input -38;
        }
        return 0;
    }
}