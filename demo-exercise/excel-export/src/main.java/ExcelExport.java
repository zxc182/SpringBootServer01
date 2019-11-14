package main.java;

/**
 * exlcel导出
 */
public class ExcelExport {

    public static void main(String[] args) {
        People people  = new People();
        people.setId(131);
        change(people);
        System.out.println(people.toString());

    }

    public static void change(People people){

        people.setId(3535);
    }
}
