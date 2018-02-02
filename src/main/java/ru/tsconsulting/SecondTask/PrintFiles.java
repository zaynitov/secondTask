package ru.tsconsulting.SecondTask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintFiles {
    public void printInFile(List<LineTwoValues> lineOfTables) {
        int count=0;
        System.out.printf("%-10s", "ID");
        System.out.printf("%-10s", "A.VALUE");
        System.out.printf("%-10s", "B.VALUE");
        System.out.print("\n");

        for (LineTwoValues list : lineOfTables) {
            System.out.printf("%-10s", list.getId());
            System.out.printf("%-10s", list.getValueFirst());
            System.out.printf("%-10s", list.getValueSecond());
            System.out.print("\n");
            count++;
        }
        System.out.print("\n");
        System.out.println(count);

    }

    public void printInFile(Map<Integer, List<LineTwoValues>> mapOfLines) {
        System.out.printf("%-10s", "ID");
        System.out.printf("%-10s", "A.VALUE");
        System.out.printf("%-10s", "B.VALUE");
        System.out.print("\n");
        int count=0;

        for (Map.Entry<Integer, List<LineTwoValues>> entry : mapOfLines.entrySet()) {

            for (LineTwoValues lineTwoValues : entry.getValue()) {
                System.out.printf("%-10s", entry.getKey());
                System.out.printf("%-10s", lineTwoValues.getValueFirst());
                System.out.printf("%-10s", lineTwoValues.getValueSecond());
                System.out.print("\n");
                count++;

            }
        }
        System.out.print("\n");
        System.out.println(count);

    }


}
