package org.example;

public class LongestProject {
    private int id;
    private String startDate;
    private String finishDate;

    public LongestProject(int id, String startDate, String finishDate) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public int getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }
}
