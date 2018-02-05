package ru.tsconsulting.secondtask.lines;

public class LineTwoValues {
    private int id;
    private String valueFirst;
    private  String valueSecond;

    public LineTwoValues(int id, String valueFirst, String valueSecond) {
        this.id = id;
        this.valueFirst = valueFirst;
        this.valueSecond = valueSecond;
    }

    public LineTwoValues(String valueFirst) {
        this.valueFirst = valueFirst;
    }

    public LineTwoValues(String valueFirst, String valueSecond) {
        this.valueFirst = valueFirst;
        this.valueSecond = valueSecond;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValueFirst(String valueFirst) {
        this.valueFirst = valueFirst;
    }

    public void setValueSecond(String valueSecond) {
        this.valueSecond = valueSecond;
    }

    public int getId() {
        return id;
    }

    public String getValueFirst() {
        return valueFirst;
    }

    public String getValueSecond() {
        return valueSecond;
    }

}
