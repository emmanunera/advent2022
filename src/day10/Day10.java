package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day10 {

    public static void main(String[] args) {



        try {
            File myObj = new File(System.getProperty("user.dir") + "\\src\\day10\\d10input.txt");
            Scanner myReader = new Scanner(myObj);

            int lineItem = 0;
            int xValue = 1;
            List<Integer> xValues = new ArrayList<Integer>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().strip();
//                System.out.println(data);

                if (data.split(" ")[0].equals("noop")){
                    xValues.add(xValue);
                }else if(data.split(" ")[0].equals("addx")){
                    xValues.add(xValue);
                    xValues.add(xValue);
                    xValue = xValue + Integer.parseInt(data.split(" ")[1]);
                }

            }
            System.out.println(xValues.size());
            int sum = (xValues.get(19)*20) + (xValues.get(59)*60) + (xValues.get(99)*100) + (xValues.get(139)*140) + (xValues.get(179)*180) + (xValues.get(219)*220);

            myReader.close();

            //Part 2
            for(int i = 0; i < xValues.size(); ++i){
//                System.out.println(String.valueOf(i) +" " + xValues.get(i));
                if (xValues.get(i)-1<= i%40 && i%40 <=xValues.get(i)+1){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
                if(i%40 == 39){
                    System.out.println();
                }

            }

            //Part1 Answer
            System.out.println(sum);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}