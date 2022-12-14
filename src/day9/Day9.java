package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day9 {

    public static void main(String[] args) {



        try {
            File myObj = new File(System.getProperty("user.dir") + "\\src\\day9\\d9input.txt");
            Scanner myReader = new Scanner(myObj);

            int uCurrent = 0;
            int uMax = 0;
            int uMin = 0;
            int rCurrent = 0;
            int rMax = 0;
            int rMin = 0;
            //get the size of the box
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().strip();
                if (data.split(" ")[0].equals("U")){
                    uCurrent = uCurrent + Integer.parseInt(data.split(" ")[1]);
                }
                else if (data.split(" ")[0].equals("D")){
                    uCurrent = uCurrent - Integer.parseInt(data.split(" ")[1]);
                }
                else if (data.split(" ")[0].equals("L")){
                    rCurrent = rCurrent - Integer.parseInt(data.split(" ")[1]);
                }
                else if (data.split(" ")[0].equals("R")){
                    rCurrent = rCurrent + Integer.parseInt(data.split(" ")[1]);
                }

                if(uCurrent>uMax){
                    uMax = uCurrent;
                } else if (rCurrent>rMax){
                    rMax = rCurrent;
                }
                if(uCurrent< uMin){
                    uMin = uCurrent;
                } else if (rCurrent<rMin){
                    rMin = rCurrent;
                }
            }

            System.out.println("Mins  is moving to " + uMin + " " + rMin);


            myReader.close();

            Integer [][] trail = new Integer[uMax+Math.abs(uMin)+3][rMax + Math.abs(rMin)+3];

            for (Integer[] integers : trail) {
                Arrays.fill(integers, 0);
            }

            Integer headR = Math.abs(rMin)+1;
            Integer headU = uMax;

            Integer tailR = headR;
            Integer tailU = headU;

            Integer prevHeadR = headR;
            Integer prevHeadU = headU;

            Scanner myReader2 = new Scanner(myObj);
            while (myReader2.hasNextLine()) {
                String data = myReader2.nextLine().strip();
                String direction = data.split(" ")[0];
                trail[tailU][tailR] = 1;

                Integer amount = Integer.parseInt(data.split(" ")[1]);
                for (int i = 0; i<amount; ++i){
                    prevHeadR = headR;
                    prevHeadU = headU;
                    trail[tailU][tailR] = 1;
                    if (direction.equals("U")){
                        headU = headU-1;
                    } else if (direction.equals("D")){
                        headU = headU+1;
                    } else if (direction.equals("R")){
                        headR = headR+1;
                    }else if (direction.equals("L")){
                        headR = headR-1;
                    }

                    if (!((tailR-1<=headR && headR <=tailR+1)&&(tailU-1<=headU && headU <=tailU+1))){
                        System.out.println("tail is moving to " + prevHeadU + " " + prevHeadR);
                        tailR = prevHeadR;
                        tailU = prevHeadU;
                        trail[tailU][tailR] = 1;
                    }
                }

            }
            int answer = 0;
            for (Integer[] row: trail){
                for (Integer cell: row){
                    if (cell == 1){
                        ++answer;
                    }
                }
            }
            myReader2.close();
            System.out.println("The answer is " + answer);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}