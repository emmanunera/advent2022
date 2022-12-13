package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day6 {

    public static void main(String[] args) {



        try {
            File myObj = new File(System.getProperty("user.dir") + "\\src\\day6\\d6input.txt");
            Scanner myReader = new Scanner(myObj);
            int answer = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().strip();
                //Part 1
//                for (int i = 4; i < data.length(); ++i){
//                    Set<Character> chars = new HashSet<Character>();
//                    chars.add(data.charAt(i-4));
//                    chars.add(data.charAt(i-3));
//                    chars.add(data.charAt(i-2));
//                    chars.add(data.charAt(i-1));
//                    if (chars.size()==4){
//                        answer = i;
//                        break;
//                    }
//                }

                // Part2
                for (int i = 14; i < data.length(); ++i){
                    Set<Character> chars = new HashSet<Character>();
                    chars.add(data.charAt(i-14));
                    chars.add(data.charAt(i-13));
                    chars.add(data.charAt(i-12));
                    chars.add(data.charAt(i-11));
                    chars.add(data.charAt(i-10));
                    chars.add(data.charAt(i-9));
                    chars.add(data.charAt(i-8));
                    chars.add(data.charAt(i-7));
                    chars.add(data.charAt(i-6));
                    chars.add(data.charAt(i-5));
                    chars.add(data.charAt(i-4));
                    chars.add(data.charAt(i-3));
                    chars.add(data.charAt(i-2));
                    chars.add(data.charAt(i-1));
                    if (chars.size()==14){
                        answer = i;
                        break;
                    }
                }

            }
            myReader.close();


            System.out.println(answer);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}