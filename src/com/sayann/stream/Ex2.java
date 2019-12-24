package com.sayann.stream;

import com.sayann.database.Repository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Find the number of genres of each director's movies: Map<String(director), Map<String(genre), Long(number)>>
 *   you have movie list in hand
 */
public class Ex2 {
  public static void main(String[] args) {
    Stream<DirectorGenre> directorGenreList = Repository.getMoviesList()
        .stream()
        .flatMap(movie -> movie.genre
            .stream()
            .map(genre -> new DirectorGenre(movie.directorName, genre))
            .collect(Collectors.toList()).stream()
        );

    Map<String, Map<String, Long>> thMap = directorGenreList.collect(
        Collectors.groupingBy(directorGenre -> directorGenre.director, Collectors.groupingBy(directorGenre -> directorGenre.genre, Collectors.counting()))
    );

    thMap.forEach((k, v) -> {
      System.out.println("Director: " + k);
      v.forEach((k1, v1) -> System.out.println("\tGenre: " + k1 + ", Count: " + v1));
    });
  }

  public static class DirectorGenre {
    public String director, genre;

    public DirectorGenre(String director, String genre) {
      this.director = director;
      this.genre = genre;
    }
  }
}
