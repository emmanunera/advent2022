package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day7 {

    public static void main(String[] args) {



        try {
            File myObj = new File(System.getProperty("user.dir") + "\\src\\day7\\d7input.txt");
            Scanner myReader = new Scanner(myObj);
            Map<String, Integer> dirs = new HashMap<String, Integer>();

            String path = "root";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().strip();
                System.out.println(data);
                if (data.split(" ")[0].equals("$")){
                    if (data.split(" ")[1].equals("ls")){
                        System.out.println("listing");
                    }
                    else if (data.split(" ")[2].equals("/")){
                        dirs.put(path,0);
                    }
                    else if((data.split(" ")[1].equals("cd")) && (data.split(" ")[2].equals(".."))){
                        path = path.substring(0,path.lastIndexOf("-"));
                        System.out.println("going up to " + path);
                    }
                    else if((data.split(" ")[1].equals("cd")) && !(data.split(" ")[2].equals(".."))){
                        path = path.concat("-" + data.split(" ")[2]);
                        System.out.println("new path is " + path);

                    }

                } else {
                    if (data.split(" ")[0].equals("dir")){
                        dirs.put(path.concat("-" + data.split(" ")[1]),0);
                    } else if (isNumeric(data.split(" ")[0])){
                        String temp = path;
                        int dashCount = 0;
                        for(int i=0; i<temp.length(); i++) {
                            if(temp.charAt(i) == '-') {
                                dashCount++;}
                        }

                        for(int i=0; i <= dashCount; ++i){
                            System.out.println("key is "+ temp);
                            dirs.put(temp, dirs.get(temp)+Integer.parseInt(data.split(" ")[0]));
                            if(temp.lastIndexOf("-")> 0){
                                temp = temp.substring(0,temp.lastIndexOf("-"));
                            }
                        }
                    }
                }
            }
            myReader.close();
            int p1answer = 0;
            for (String key: dirs.keySet()){
                if(dirs.get(key) <= 100000){
                    System.out.println(key);
                    System.out.println(dirs.get(key));
                    p1answer = p1answer + dirs.get(key);
                }
            }
            System.out.println(p1answer);

            System.out.println("");
            System.out.println("The unused space is:");
            System.out.println(70000000 - dirs.get("root"));

            System.out.println("The needed space is:");
            System.out.println(30000000-(70000000 - dirs.get("root")));

            int need = 30000000-(70000000 - dirs.get("root"));
            int diff = 70000000;
            int sizeAnswer = 0;
            for (String key: dirs.keySet()){
                if (dirs.get(key)-need < diff && dirs.get(key)-need > 0){
                    sizeAnswer = dirs.get(key);
                    diff = dirs.get(key)-need;
                }
            }

            System.out.println("The part2 answer is:");
            System.out.println(sizeAnswer);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void mainx(String[] args) {
        String path = "test-hello-world";
        System.out.println(path.substring(0,path.lastIndexOf("-")));
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}