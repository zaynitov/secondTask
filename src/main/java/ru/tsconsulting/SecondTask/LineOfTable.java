package ru.tsconsulting.SecondTask;

public class LineOfTable{
    private Integer id;
    private String value;


    public LineOfTable(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {

return id+value;    }


    public String getValue() {
        return value;
    }

    public Integer getId() {
        return id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
