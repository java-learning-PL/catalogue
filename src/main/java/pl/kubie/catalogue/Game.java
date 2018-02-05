package pl.kubie.catalogue;

import java.time.LocalDate;

public class Game {
    private String name;
    private double rate;
    private String type;
    private String comment;
    private LocalDate date;


    public Game(String name, String type,String comment, double rate) {
        this.name = name;
        this.rate = rate;
        this.date = LocalDate.now();
        this.comment = comment;
        System.out.println(this.date);

    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public String getType() {
        return type;
    }

    public double getRate() {
        return rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
