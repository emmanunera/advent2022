package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day8 {

    public static void main(String[] args) {



        try {
            File myObj = new File(System.getProperty("user.dir") + "\\src\\day8\\d8input.txt");
            Scanner myReader = new Scanner(myObj);
            List<String> dataInput = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().strip();
                dataInput.add(data);
            }
            myReader.close();

            Integer[][] map = new Integer[dataInput.size()][dataInput.get(1).length()];
            for(int x=0; x<dataInput.size(); ++x){
                for (int y=0; y<dataInput.get(1).length(); ++y){
                    map[x][y] = Integer.parseInt(String.valueOf(dataInput.get(x).charAt(y)));
                }
            }

            //part1
//            int visibleCount = 0;
//
//            for(int vert=0; vert<dataInput.size(); ++vert){
//                for (int hor=0; hor<dataInput.get(1).length(); ++hor){
//                    if ((vert==0 || hor == 0) || (vert==dataInput.size()-1 || hor==dataInput.get(1).length()-1)){
//                        ++visibleCount;
//                    }else{
//                        //left check vert should stay
//                        boolean leftVisible = true;
//                        for (int i=0; i<hor; ++i){
//                            if (map[vert][i] >= map[vert][hor]) {
//                                leftVisible = false;
//                                break;
//                            }
//                        }
//                        //right check vert should stay
//                        boolean rightVisible = true;
//
//                        for (int i=dataInput.get(1).length()-1; i>hor; --i){
//                            if (map[vert][i] >= map[vert][hor]) {
//                                rightVisible = false;
//                                break;
//                            }
//                        }
//
//                        //top check hor should stay
//                        boolean topVisible = true;
//                        for (int i=0; i<vert; ++i){
//
//                            if (map[i][hor] >= map[vert][hor]) {
//                                topVisible = false;
//                                break;
//                            }
//                        }
//                        //bot check vert should stay
//                        boolean botVisible = true;
//
//                        for (int i=dataInput.get(1).length()-1; i>vert; --i){
//                            if (map[i][hor] >= map[vert][hor]) {
//                                botVisible = false;
//                                break;
//                            }
//                        }
//                        if ((leftVisible||rightVisible)||(topVisible||botVisible)){
//                            ++visibleCount;
//
//                        }
//                    }
//                }
//            }
//            System.out.println(dataInput.size());
//            System.out.println(dataInput.get(1).length());
//            System.out.println(visibleCount);

            //part2
            int maxScore = 0;

            for(int vert=0; vert<dataInput.size(); ++vert){
                for (int hor=0; hor<dataInput.get(1).length(); ++hor){
                    int scenicScore = 0;
                    int leftScore = 0;
                    int rightScore = 0;
                    int topScore = 0;
                    int botScore = 0;


                    if ((vert==0 || hor == 0) || (vert==dataInput.size()-1 || hor==dataInput.get(1).length()-1)){
                        scenicScore = 0;
                    }else{
                        //left check vert should stay
                        for (int i=hor-1; i>=0; --i){
                            ++leftScore;
                            if (map[vert][i] >= map[vert][hor]) {
                                break;
                            }
                        }
                        //right check vert should stay

                        for (int i=hor+1; i<dataInput.get(1).length(); ++i){
                            ++rightScore;

                            if (map[vert][i] >= map[vert][hor]) {
                                break;
                            }
                        }

                        //top check hor should stay

                        for (int i=vert-1; i>=0; --i){
                            ++topScore;

                            if (map[i][hor] >= map[vert][hor]) {
                                break;
                            }
                        }
                        //bot check vert should stay

                        for (int i=vert+1; i<dataInput.size(); ++i){
                            ++botScore;

                            if (map[i][hor] >= map[vert][hor]) {
                                break;
                            }
                        }

                    }
                    scenicScore = topScore * botScore * leftScore * rightScore;
                    if (scenicScore > 0) {
                        System.out.println("This is tree" + vert + hor);
                        System.out.println(scenicScore);
                        System.out.println(topScore + " " + botScore + " " + leftScore + " " + rightScore);
                    }

                    if (scenicScore > maxScore){
                        maxScore = scenicScore;
                    }
                }

            }
            System.out.println(maxScore);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}