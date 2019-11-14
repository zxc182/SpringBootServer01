package main.java;

/**
 * 保存表头信息
 */
public class ExcelHeaderInfo {
    //该表头多占位置的首行
    private int firstRow;

    //lastRow：该表头所占位置的尾行
    private int lastRow;

    //firstCol：该表头所占位置的首列
    private int firstCol;

    //lastCol：该表头所占位置的尾行
    private int lastCol;

    //title：该表头的名称
    private String title;

    public ExcelHeaderInfo(int firstRow, int lastRow, int firstCol, int lastCol, String title) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.firstCol = firstCol;
        this.lastCol = lastCol;
        this.title = title;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public int getFirstCol() {
        return firstCol;
    }

    public void setFirstCol(int firstCol) {
        this.firstCol = firstCol;
    }

    public int getLastCol() {
        return lastCol;
    }

    public void setLastCol(int lastCol) {
        this.lastCol = lastCol;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
