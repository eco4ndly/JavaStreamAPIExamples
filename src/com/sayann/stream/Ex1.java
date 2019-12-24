package com.sayann.stream;

import com.sayann.database.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find the number of movies of each director
 */
public class Ex1 {
  public static void main(String[] args) {
    System.out.println("Find the number of movies of each director");

    //pragmaticSolution();

    usingPureStream();

  }

  public static void pragmaticSolution() {
    System.out.println("With Pragmatic solution");
    Map<String, Integer> dirMap = new HashMap<>();

    Repository.getMoviesList().forEach(movie -> {
      if(dirMap.containsKey(movie.directorName)) {
        int curNum = dirMap.get(movie.directorName);
        curNum++;
        dirMap.put(movie.directorName, curNum);
      } else {
        dirMap.put(movie.directorName, 1);
      }
    });

    System.out.println(dirMap);
  }

  public static void usingPureStream() {
    System.out.println("With pure stream apis");

    Map<String, Long> dirMap = Repository.getMoviesList().stream()
        .map(movie -> movie.directorName)
        .collect(Collectors.groupingBy(movie -> movie, Collectors.counting()));
    dirMap.entrySet().forEach(System.out::println);
  }
}
