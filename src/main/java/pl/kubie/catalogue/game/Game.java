package pl.kubie.catalogue.game;

import java.time.LocalDate;

class Game {

  private final String name;
  private final String type;
  private final String comment;
  private final double rate;
  private final LocalDate date;

  Game(String name, String type, String comment, double rate, LocalDate date) {
    this.name = name;
    this.type = type;
    this.comment = comment;
    this.rate = rate;
    this.date = date;
  }

  Game(String name, String type, String comment, double rate) {
    this(name, type, comment, rate, LocalDate.now());
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getComment() {
    return comment;
  }

  public double getRate() {
    return rate;
  }

  public LocalDate getDate() {
    return date;
  }
}
