package ru.tsconsulting.SecondTask;

public class LineOfTable{
    private Integer id;
    private String value;
    private String valueRight;

    public String getValueRight() {
        return valueRight;
    }

    public void setValueRight(String valueRight) {
        this.valueRight = valueRight;
    }

    public LineOfTable(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {

return id+value+valueRight;    }

    public LineOfTable(Integer id, String value, String valueRight) {
        this.id = id;
        this.value = value;
        this.valueRight = valueRight;
    }

    public String getValue() {
        return value;
    }

    public LineOfTable(String value, String valueRight) {
        this.value = value;
        this.valueRight = valueRight;
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
