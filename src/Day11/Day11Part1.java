package Day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day11Part1 {

    public static void main(String[] args) {
        List<List<Integer>> monkeys = new ArrayList<>();
        Integer[] inspectCount = {0,0,0,0,0,0,0,0,};


        List<Integer> monkey0 = new ArrayList<>();
        Integer[] m0items = {93, 54, 69, 66, 71};
        monkey0.addAll(Arrays.asList(m0items));
        monkeys.add(monkey0);

        List<Integer> monkey1 = new ArrayList<>();
        Integer[] m1items = {89, 51, 80, 66};
        monkey1.addAll(Arrays.asList(m1items));
        monkeys.add(monkey1);

        List<Integer> monkey2 = new ArrayList<>();
        Integer[] m2items = {90, 92, 63, 91, 96, 63, 64};
        monkey2.addAll(Arrays.asList(m2items));
        monkeys.add(monkey2);

        List<Integer> monkey3 = new ArrayList<>();
        Integer[] m3items = {65, 77};
        monkey3.addAll(Arrays.asList(m3items));
        monkeys.add(monkey3);

        List<Integer> monkey4 = new ArrayList<>();
        Integer[] m4items = {76, 68, 94};
        monkey4.addAll(Arrays.asList(m4items));
        monkeys.add(monkey4);

        List<Integer> monkey5 = new ArrayList<>();
        Integer[] m5items = {86, 65, 66, 97, 73, 83};
        monkey5.addAll(Arrays.asList(m5items));
        monkeys.add(monkey5);

        List<Integer> monkey6 = new ArrayList<>();
        Integer[] m6items = {78};
        monkey6.addAll(Arrays.asList(m6items));
        monkeys.add(monkey6);

        List<Integer> monkey7 = new ArrayList<>();
        Integer[] m7items = {89, 57, 59, 61, 87, 55, 55, 88};
        monkey7.addAll(Arrays.asList(m7items));
        monkeys.add(monkey7);

        for(int round = 0; round<20; round++){
            for (int i=0; i<monkeys.get(0).size(); ++i){
                Integer worry = monkeys.get(0).get(i);
                worry = worry *3;
                worry = Math.floorDiv(worry ,3);
                if (worry%7 == 0){
                    monkeys.get(7).add(worry);
                }else{
                    monkeys.get(1).add(worry);
                }
                ++ inspectCount[0];
            }
            monkeys.get(0).removeAll(monkeys.get(0));

            for (int i=0; i<monkeys.get(1).size(); ++i){
                Integer worry = monkeys.get(1).get(i);
                worry = worry *17;
                worry = Math.floorDiv(worry ,3);
                if (worry%19 == 0){
                    monkeys.get(5).add(worry);
                }else{
                    monkeys.get(7).add(worry);
                }
                ++ inspectCount[1];
            }
            monkeys.get(1).removeAll(monkeys.get(1));

            for (int i=0; i<monkeys.get(2).size(); ++i){
                Integer worry = monkeys.get(2).get(i);
                worry = worry + 1;
                worry = Math.floorDiv(worry ,3);
                if (worry%13 == 0){
                    monkeys.get(4).add(worry);
                }else{
                    monkeys.get(3).add(worry);
                }
                ++ inspectCount[2];
            }
            monkeys.get(2).removeAll(monkeys.get(2));

            for (int i=0; i<monkeys.get(3).size(); ++i){
                Integer worry = monkeys.get(3).get(i);
                worry = worry +2;
                worry = Math.floorDiv(worry ,3);
                if (worry%3 == 0){
                    monkeys.get(4).add(worry);
                }else{
                    monkeys.get(6).add(worry);
                }
                ++ inspectCount[3];
            }
            monkeys.get(3).removeAll(monkeys.get(3));

            for (int i=0; i<monkeys.get(4).size(); ++i){
                Integer worry = monkeys.get(4).get(i);
                worry = worry * worry;
                worry = Math.floorDiv(worry ,3);
                if (worry%2 == 0){
                    monkeys.get(0).add(worry);
                }else{
                    monkeys.get(6).add(worry);
                }
                ++ inspectCount[4];
            }
            monkeys.get(4).removeAll(monkeys.get(4));


            for (int i=0; i<monkeys.get(5).size(); ++i){
                Integer worry = monkeys.get(5).get(i);
                worry = worry +8;
                worry = Math.floorDiv(worry ,3);
                if (worry%11 == 0){
                    monkeys.get(2).add(worry);
                }else{
                    monkeys.get(3).add(worry);
                }
                ++ inspectCount[5];
            }
            monkeys.get(5).removeAll(monkeys.get(5));


            for (int i=0; i<monkeys.get(6).size(); ++i){
                Integer worry = monkeys.get(6).get(i);
                worry = worry +6;
                worry = Math.floorDiv(worry ,3);
                if (worry%17 == 0){
                    monkeys.get(0).add(worry);
                }else{
                    monkeys.get(1).add(worry);
                }
                ++ inspectCount[6];
            }
            monkeys.get(6).removeAll(monkeys.get(6));

            for (int i=0; i<monkeys.get(7).size(); ++i){
                Integer worry = monkeys.get(7).get(i);
                worry = worry +7;
                worry = Math.floorDiv(worry ,3);
                if (worry%5 == 0){
                    monkeys.get(2).add(worry);
                }else{
                    monkeys.get(5).add(worry);
                }
                ++ inspectCount[7];
            }
            monkeys.get(7).removeAll(monkeys.get(7));
        }
        System.out.println(Arrays.toString(inspectCount));
        Arrays.sort(inspectCount, Collections.reverseOrder());
        System.out.println(Arrays.toString(inspectCount));
        System.out.println(inspectCount[0]*inspectCount[1]);
    }
}