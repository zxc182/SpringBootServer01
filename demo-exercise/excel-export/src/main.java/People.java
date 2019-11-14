package main.java;

public class People {

    private int id;

    private String suername;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuername() {
        return suername;
    }

    public void setSuername(String suername) {
        this.suername = suername;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", suername='" + suername + '\'' +
                '}';
    }
}
