package ru.tsconsulting.SecondTask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadingFiles {
    public List<LineOfTable> read(String fileName) {
        List<LineOfTable> result = new ArrayList<>();

        try (BufferedReader reder = new BufferedReader(new InputStreamReader
                (new FileInputStream(fileName), "windows-1251"))) {
            String line = reder.readLine();
            String[] title = line.split("\\s+");//do smth here
            while ((line = reder.readLine()) != null) {
                String[] dataForOneLine = line.split("\\s+");
                if (dataForOneLine.length != 2 || dataForOneLine[0] == null || dataForOneLine[1] == null ||
                        dataForOneLine[0].equals("") || dataForOneLine[1].equals("")) {
                    System.out.println("You have incorrect data input. Please change it");
                    break;
                }

                result.add(new LineOfTable(Integer.parseInt(dataForOneLine[0]), dataForOneLine[1]));
            }

        } catch (IOException e) {
            System.out.println("I'm Sorry, i didn't find a file");
        }
        return result;

    }
}