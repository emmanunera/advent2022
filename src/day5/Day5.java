package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Day5 {

    //Part1
//    public static void main(String[] args) {
//
//        try {
//            File myObj = new File(System.getProperty("user.dir") + "\\src\\day5\\d5input.txt");
//            Scanner myReader = new Scanner(myObj);
//
//            String answer = "";
//
//            List<Stack<Character>> stacks = new ArrayList<>();
//            Stack <Character> stack1 = new Stack<>();
//            stack1.push('D');
//            stack1.push('H');
//            stack1.push('N');
//            stack1.push('Q');
//            stack1.push('T');
//            stack1.push('W');
//            stack1.push('B');
//            stack1.push('V');
//            stacks.add(stack1);
//
//            Stack <Character> stack2 = new Stack<>();
//            stack2.push('D');
//            stack2.push('W');
//            stack2.push('B');
//            stacks.add(stack2);
//
//            Stack <Character> stack3 = new Stack<>();
//            stack3.push('T');
//            stack3.push('S');
//            stack3.push('Q');
//            stack3.push('W');
//            stack3.push('J');
//            stack3.push('C');
//            stacks.add(stack3);
//
//            Stack <Character> stack4 = new Stack<>();
//            stack4.push('F');
//            stack4.push('J');
//            stack4.push('R');
//            stack4.push('N');
//            stack4.push('Z');
//            stack4.push('T');
//            stack4.push('P');
//            stacks.add(stack4);
//
//            Stack <Character> stack5 = new Stack<>();
//            stack5.push('G');
//            stack5.push('P');
//            stack5.push('V');
//            stack5.push('J');
//            stack5.push('M');
//            stack5.push('S');
//            stack5.push('T');
//            stacks.add(stack5);
//
//            Stack <Character> stack6 = new Stack<>();
//            stack6.push('B');
//            stack6.push('W');
//            stack6.push('F');
//            stack6.push('T');
//            stack6.push('N');
//            stacks.add(stack6);
//
//            Stack <Character> stack7 = new Stack<>();
//            stack7.push('B');
//            stack7.push('L');
//            stack7.push('D');
//            stack7.push('Q');
//            stack7.push('F');
//            stack7.push('H');
//            stack7.push('V');
//            stack7.push('N');
//            stacks.add(stack7);
//
//            Stack <Character> stack8 = new Stack<>();
//            stack8.push('H');
//            stack8.push('P');
//            stack8.push('F');
//            stack8.push('R');
//            stacks.add(stack8);
//
//            Stack <Character> stack9 = new Stack<>();
//            stack9.push('Z');
//            stack9.push('S');
//            stack9.push('M');
//            stack9.push('B');
//            stack9.push('L');
//            stack9.push('N');
//            stack9.push('P');
//            stack9.push('H');
//            stacks.add(stack9);
//
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                int repeat = Integer.parseInt(data.split(" ")[1]);
//                int toPop = Integer.parseInt(data.split(" ")[3]) -1;
//                int pushTo = Integer.parseInt(data.split(" ")[5]) -1;
//
//                for(int i = 0; i < repeat; ++i){
//                    Character item = stacks.get(toPop).pop();
//                    stacks.get(pushTo).push(item);
//                }
//            }
//            myReader.close();
//
//            for (Stack<Character> stack: stacks){
//                answer = answer.concat(Character.toString(stack.peek()));
//            }
//            System.out.println(answer);
//
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {

//        String word1 = "qwerty";
//        String word2 = "yow";
//
//        System.out.println(word1.substring(word1.length()-2));
//        System.out.println(word2.concat(word1.substring(word1.length()-2)));

        String answer = "";
        String[] stacks = {"DHNQTWVB","DWB","TSQWJC","FJRNZTP","GPVJMST","BWFTN","BLDQFHVN","HPFR","ZSMBLNPH"};

        try {
            File myObj = new File(System.getProperty("user.dir") + "\\src\\day5\\d5input.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int repeat = Integer.parseInt(data.split(" ")[1]);
                int toPop = Integer.parseInt(data.split(" ")[3]) -1;
                int pushTo = Integer.parseInt(data.split(" ")[5]) -1;

                stacks[pushTo] = stacks[pushTo].concat(stacks[toPop].substring(stacks[toPop].length()-repeat));
                stacks[toPop] = stacks[toPop].substring(0,stacks[toPop].length()-repeat );
            }
            myReader.close();

            for (String stack: stacks){
                answer= answer.concat(stack.substring(stack.length()-1));
            }
            System.out.println(answer);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}