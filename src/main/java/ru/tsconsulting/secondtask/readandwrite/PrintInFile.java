package ru.tsconsulting.secondtask.readandwrite;

import ru.tsconsulting.secondtask.lines.LineTwoValues;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class PrintInFile {
    public void printInFile(List<LineTwoValues> lineOfTables, String fileName) {

        try (FileOutputStream f = new FileOutputStream((fileName))) {
            System.setOut(new PrintStream(f, true, "UTF-8"));

            System.out.printf("%-10s", "ID");
            System.out.printf("%-10s", "A.VALUE");
            System.out.printf("%-10s", "B.VALUE");
            System.out.print("\n");

            for (LineTwoValues list : lineOfTables) {
                System.out.printf("%-10s", list.getId());
                System.out.printf("%-10s", list.getValueFirst());
                System.out.printf("%-10s", list.getValueSecond());
                System.out.print("\n");
            }
            System.out.print("\n");

        } catch (IOException e) {
            System.out.println("We have some problems with output file");
        }


    }

    public void printInFile(Map<Integer, List<LineTwoValues>> mapOfLines, String fileName) {
        try (FileOutputStream f = new FileOutputStream((fileName))) {
            System.setOut(new PrintStream(f, true, "UTF-8"));

            System.out.printf("%-10s", "ID");
            System.out.printf("%-10s", "A.VALUE");
            System.out.printf("%-10s", "B.VALUE");
            System.out.print("\n");

            for (Map.Entry<Integer, List<LineTwoValues>> entry : mapOfLines.entrySet()) {

                for (LineTwoValues lineTwoValues : entry.getValue()) {
                    System.out.printf("%-10s", entry.getKey());
                    System.out.printf("%-10s", lineTwoValues.getValueFirst());
                    System.out.printf("%-10s", lineTwoValues.getValueSecond());
                    System.out.print("\n");

                }
            }
            System.out.print("\n");


        } catch (IOException e) {
            System.out.println("We have some problems with output file");
        }


    }
}
