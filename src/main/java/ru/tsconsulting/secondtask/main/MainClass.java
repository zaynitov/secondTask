package ru.tsconsulting.secondtask.main;

import ru.tsconsulting.secondtask.lines.LineOfTable;
import ru.tsconsulting.secondtask.lines.LineTwoValues;
import ru.tsconsulting.secondtask.readandwrite.PrintInFile;
import ru.tsconsulting.secondtask.readandwrite.ReadingFiles;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("Input data is incorrect");
            System.exit(1);
        }

        ReadingFiles readingFile = new ReadingFiles();
        List<LineOfTable> firstFile = readingFile.read(args[0]);
        List<LineOfTable> secFile = readingFile.read(args[1]);

        PrintInFile printFiles = new PrintInFile();




        printFiles.printInFile(resultArrayList(firstFile, secFile),args[2]);
        printFiles.printInFile(resultLinkedList(sortList(firstFile),
                sortList(secFile)),args[3]);
        printFiles.printInFile(resultHashMap(firstFile, secFile),args[4]);
    }

    public static List<LineTwoValues> resultArrayList(List<LineOfTable> firstList,
                                                      List<LineOfTable> secondList) {
        List<LineTwoValues> resultArrayList = new ArrayList<>();
        for (LineOfTable lineOfTableFirst : firstList) {
            for (LineOfTable lineOfTableSecond : secondList) {
                if (lineOfTableFirst.getId() == lineOfTableSecond.getId()) {
                    resultArrayList.add(new LineTwoValues(lineOfTableFirst.getId(), lineOfTableFirst.getValue(),
                            lineOfTableSecond.getValue()));

                }

            }
        }
        return resultArrayList;

    }

    public static LinkedList<LineTwoValues> resultLinkedList(LinkedList<LineOfTable> firstList,
                                                             LinkedList<LineOfTable> secondList) {

        LinkedList<LineTwoValues> resultLinkedList = new LinkedList<>();

        ListIterator<LineOfTable> firstListIterator = firstList.listIterator();
        ListIterator<LineOfTable> secListIterator = secondList.listIterator();

        List<String> listOfValues = new ArrayList<>();

        LineOfTable firstLine = firstListIterator.next();
        LineOfTable secondLine = secListIterator.next();

        LineOfTable firstLineNext = firstLine;
        LineOfTable secLineNext = secondLine;

        while (firstListIterator.hasNext() || secListIterator.hasNext()) {
            if (firstLine.getId() == secondLine.getId()) {
                //add smth
                listOfValues.add(secondLine.getValue());
                while (secListIterator.hasNext()) {
                    secLineNext = secListIterator.next();
                    if (secLineNext.getId() == secondLine.getId()) {
                        listOfValues.add(secLineNext.getValue());
                    } else {
                        break;
                    }

                }
                putValuesRes(resultLinkedList, firstLine.getValue(), listOfValues, firstLine.getId());
                while (firstListIterator.hasNext()) {
                    firstLineNext = firstListIterator.next();
                    if (firstLineNext.getId() == firstLine.getId()) {
                        putValuesRes(resultLinkedList, firstLineNext.getValue(), listOfValues, firstLineNext.getId());
                    } else {
                        listOfValues.clear();
                        break;
                    }
                }
            } else if (firstLine.getId() < secondLine.getId()) {
                secLineNext = secondLine;
                while ((firstListIterator.hasNext())) {
                    firstLineNext = firstListIterator.next();

                    if (firstLineNext.getId() == secondLine.getId()) {
                        break;
                    }
                }
            } else if (firstLine.getId() > secondLine.getId()) {
                firstLineNext = firstLine;
                while ((secListIterator.hasNext())) {
                    secLineNext = secListIterator.next();
                    if (secLineNext.getId() == firstLine.getId()) {
                        break;
                    }
                }
            }
            firstLine = firstLineNext;
            secondLine = secLineNext;
        }

        if ((firstLine.getId() == secondLine.getId()) &&
                (resultLinkedList.getLast().getId() != firstLine.getId())) {
            resultLinkedList.add(new LineTwoValues(firstLine.getId(), firstLine.getValue(),
                    secondLine.getValue()));
        }
        return resultLinkedList;
    }

    public static LinkedList<LineOfTable> sortList(List<LineOfTable> listToSort) {
        LinkedList<LineOfTable> resultList = new LinkedList();

        resultList.addAll(listToSort);

        Collections.sort(resultList, new Comparator<LineOfTable>() {
            @Override
            public int compare(LineOfTable o1, LineOfTable o2) {
                return (o1.getId() - o2.getId());
            }
        });
        return resultList;
    }

    public static void putValuesRes(List<LineTwoValues> resultLinkedList, String leftValue,
                                    List<String> listOfValues, int id) {

        for (String rightValue : listOfValues) {
            resultLinkedList.add(new LineTwoValues(id, leftValue, rightValue));
        }
    }

    public static Map<Integer, List<LineTwoValues>> resultHashMap(List<LineOfTable> firstList, List<LineOfTable> secondList) {
        Map<Integer, List<String>> mapFirst = new HashMap<>();
        Map<Integer, List<String>> mapSecond = new HashMap<>();
        Map<Integer, List<LineTwoValues>> resultMap = new HashMap<>();

        putArrayListInHashMap(firstList, mapFirst);
        putArrayListInHashMap(secondList, mapSecond);

        for (Integer keyID : mapFirst.keySet()) {
            if (mapSecond.containsKey(keyID)) {
                putMixValuesToMap(resultMap, mapFirst.get(keyID), mapSecond.get(keyID), keyID);
            }
        }
        return resultMap;
    }

    public static void putArrayListInHashMap(List<LineOfTable> firstList, Map<Integer, List<String>> resultMap) {
        for (LineOfTable lineOfTable : firstList) {
            if (resultMap.containsKey(lineOfTable.getId())) {
                resultMap.get(lineOfTable.getId()).add(lineOfTable.getValue());
            } else {
                List<String> listOfLines = new ArrayList<>();
                listOfLines.add(lineOfTable.getValue());
                resultMap.put(lineOfTable.getId(), listOfLines);
            }

        }

    }

    public static void putMixValuesToMap(Map<Integer, List<LineTwoValues>> resultMap, List<String> leftList,
                                         List<String> rightList, int id) {

        for (String leftValue : leftList) {

            for (String rightValue : rightList) {

                if (!resultMap.containsKey(id)) {
                    List<LineTwoValues> valuesInMap = new ArrayList<>();
                    valuesInMap.add(new LineTwoValues(leftValue, rightValue));
                    resultMap.put(id, valuesInMap);
                } else {
                    resultMap.get(id).add(new LineTwoValues(leftValue, rightValue));
                }

            }
        }
    }


}




