package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        try {
            File myObj = new File(System.getProperty("user.dir") + "\\src\\day2\\d2input.txt");
            Scanner myReader = new Scanner(myObj);
            int totalScore = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                char opponent = data.charAt(0);
                char player = data.charAt(2);
                int shapeScore = 0;
                int winScore = 0;
                // P1
//                if (opponent == 'A') {
//                    if (player == 'X') {
//                        shapeScore = 1;
//                        winScore = 3;
//                    } else if (player == 'Y') {
//                        shapeScore = 2;
//                        winScore = 6;
//                    } else if (player == 'Z') {
//                        shapeScore = 3;
//                        winScore = 0;
//                    }
//                } else if (opponent == 'B') {
//                    if (player == 'X') {
//                        shapeScore = 1;
//                        winScore = 0;
//                    } else if (player == 'Y') {
//                        shapeScore = 2;
//                        winScore = 3;
//                    } else if (player == 'Z') {
//                        shapeScore = 3;
//                        winScore = 6;
//                    }
//                } else if (opponent == 'C') {
//                    if (player == 'X') {
//                        shapeScore = 1;
//                        winScore = 6;
//                    } else if (player == 'Y') {
//                        shapeScore = 2;
//                        winScore = 0;
//                    } else if (player == 'Z') {
//                        shapeScore = 3;
//                        winScore = 3;
//                    }
//                }

                //P2
                if (opponent == 'A') {
                    if (player == 'X') {
                        shapeScore = 3;
                        winScore = 0;
                    } else if (player == 'Y') {
                        shapeScore = 1;
                        winScore = 3;
                    } else if (player == 'Z') {
                        shapeScore = 2;
                        winScore = 6;
                    }
                } else if (opponent == 'B') {
                    if (player == 'X') {
                        shapeScore = 1;
                        winScore = 0;
                    } else if (player == 'Y') {
                        shapeScore = 2;
                        winScore = 3;
                    } else if (player == 'Z') {
                        shapeScore = 3;
                        winScore = 6;
                    }
                } else if (opponent == 'C') {
                    if (player == 'X') {
                        shapeScore = 2;
                        winScore = 0;
                    } else if (player == 'Y') {
                        shapeScore = 3;
                        winScore = 3;
                    } else if (player == 'Z') {
                        shapeScore = 1;
                        winScore = 6;
                    }
                }
                totalScore = totalScore + shapeScore + winScore;
            }
            System.out.println(totalScore);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}