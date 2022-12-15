package Day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day11Part2 {

    public static void main(String[] args) {
        List<List<Double>> monkeys = new ArrayList<>();
        Double[] inspectCount = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};


        List<Double> monkey0 = new ArrayList<>();
        Double[] m0items = {93.0, 54.0, 69.0, 66.0, 71.0};
        monkey0.addAll(Arrays.asList(m0items));
        monkeys.add(monkey0);

        List<Double> monkey1 = new ArrayList<>();
        Double[] m1items = {89.0, 51.0, 80.0, 66.0};
        monkey1.addAll(Arrays.asList(m1items));
        monkeys.add(monkey1);

        List<Double> monkey2 = new ArrayList<>();
        Double[] m2items = {90.0, 92.0, 63.0, 91.0, 96.0, 63.0, 64.0};
        monkey2.addAll(Arrays.asList(m2items));
        monkeys.add(monkey2);

        List<Double> monkey3 = new ArrayList<>();
        Double[] m3items = {65.0, 77.0};
        monkey3.addAll(Arrays.asList(m3items));
        monkeys.add(monkey3);

        List<Double> monkey4 = new ArrayList<>();
        Double[] m4items = {76.0, 68.0, 94.0};
        monkey4.addAll(Arrays.asList(m4items));
        monkeys.add(monkey4);

        List<Double> monkey5 = new ArrayList<>();
        Double[] m5items = {86.0, 65.0, 66.0, 97.0, 73.0, 83.0};
        monkey5.addAll(Arrays.asList(m5items));
        monkeys.add(monkey5);

        List<Double> monkey6 = new ArrayList<>();
        Double[] m6items = {78.0};
        monkey6.addAll(Arrays.asList(m6items));
        monkeys.add(monkey6);

        List<Double> monkey7 = new ArrayList<>();
        Double[] m7items = {89.0, 57.0, 59.0, 61.0, 87.0, 55.0, 55.0, 88.0};
        monkey7.addAll(Arrays.asList(m7items));
        monkeys.add(monkey7);

        Double worryGcf = (double) (7 * 19 * 13 * 3 * 2 * 11 * 17 * 5);

        for(int round = 0; round<10000; round++){
            for (int i=0; i<monkeys.get(0).size(); ++i){
                Double worry = monkeys.get(0).get(i);
                worry = worry *3;
//                worry = Math.floorDiv(worry ,3);
                worry = worry%worryGcf;
                if (worry%7 == 0){
                    monkeys.get(7).add(worry);
                }else{
                    monkeys.get(1).add(worry);
                }
                ++ inspectCount[0];
            }
            monkeys.get(0).removeAll(monkeys.get(0));

            for (int i=0; i<monkeys.get(1).size(); ++i){
                Double worry = monkeys.get(1).get(i);
                worry = worry *17;
//                worry = Math.floorDiv(worry ,3);
                worry = worry%worryGcf;

                if (worry%19 == 0){
                    monkeys.get(5).add(worry);
                }else{
                    monkeys.get(7).add(worry);
                }
                ++ inspectCount[1];
            }
            monkeys.get(1).removeAll(monkeys.get(1));

            for (int i=0; i<monkeys.get(2).size(); ++i){
                Double worry = monkeys.get(2).get(i);
                worry = worry + 1;
//                worry = Math.floorDiv(worry ,3);
                worry = worry%worryGcf;

                if (worry%13 == 0){
                    monkeys.get(4).add(worry);
                }else{
                    monkeys.get(3).add(worry);
                }
                ++ inspectCount[2];
            }
            monkeys.get(2).removeAll(monkeys.get(2));

            for (int i=0; i<monkeys.get(3).size(); ++i){
                Double worry = monkeys.get(3).get(i);
                worry = worry +2;
//                worry = Math.floorDiv(worry ,3);
                worry = worry%worryGcf;

                if (worry%3 == 0){
                    monkeys.get(4).add(worry);
                }else{
                    monkeys.get(6).add(worry);
                }
                ++ inspectCount[3];
            }
            monkeys.get(3).removeAll(monkeys.get(3));

            for (int i=0; i<monkeys.get(4).size(); ++i){
                Double worry = monkeys.get(4).get(i);
                worry = worry * worry;
//                worry = Math.floorDiv(worry ,3);
                worry = worry%worryGcf;

                if (worry%2 == 0){
                    monkeys.get(0).add(worry);
                }else{
                    monkeys.get(6).add(worry);
                }
                ++ inspectCount[4];
            }
            monkeys.get(4).removeAll(monkeys.get(4));


            for (int i=0; i<monkeys.get(5).size(); ++i){
                Double worry = monkeys.get(5).get(i);
                worry = worry +8;
//                worry = Math.floorDiv(worry ,3);
                worry = worry%worryGcf;

                if (worry%11 == 0){
                    monkeys.get(2).add(worry);
                }else{
                    monkeys.get(3).add(worry);
                }
                ++ inspectCount[5];
            }
            monkeys.get(5).removeAll(monkeys.get(5));


            for (int i=0; i<monkeys.get(6).size(); ++i){
                Double worry = monkeys.get(6).get(i);
                worry = worry +6;
//                worry = Math.floorDiv(worry ,3);
                worry = worry%worryGcf;

                if (worry%17 == 0){
                    monkeys.get(0).add(worry);
                }else{
                    monkeys.get(1).add(worry);
                }
                ++ inspectCount[6];
            }
            monkeys.get(6).removeAll(monkeys.get(6));

            for (int i=0; i<monkeys.get(7).size(); ++i){
                Double worry = monkeys.get(7).get(i);
                worry = worry +7;
//                worry = Math.floorDiv(worry ,3);
                worry = worry%worryGcf;

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
        Double answer = inspectCount[0] *inspectCount[1];
        System.out.println(answer.longValue());
    }
}