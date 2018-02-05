package pl.kubie.catalogue.game;

import java.time.LocalDate;

class Game {

  private final String name;
  private final double rate;
  private final String type;
  private final String comment;
  private final LocalDate date;

  Game(String name, String type, String comment, double rate) {
    this.name = name;
    this.type = type;
    this.rate = rate;
    this.date = LocalDate.now();
    this.comment = comment;
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

}
