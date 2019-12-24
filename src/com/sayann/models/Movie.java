package com.sayann.models;

import java.util.List;

public class Movie {
  public String name;
  public String directorName;
  public int releaseYear;
  public double rating;
  public List<String> genre;

  public Movie(String name, String directorName, int releaseYear, double rating, List<String> genre) {
    this.name = name;
    this.directorName = directorName;
    this.releaseYear = releaseYear;
    this.rating = rating;
    this.genre = genre;
  }

  @Override public String toString() {
    return "Movie{" +
        "name='" + name + '\'' +
        ", directorName='" + directorName + '\'' +
        ", releaseYear=" + releaseYear +
        ", rating=" + rating +
        '}';
  }
}
