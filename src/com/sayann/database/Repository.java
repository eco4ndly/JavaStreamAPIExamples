package com.sayann.database;

import com.sayann.models.Movie;
import com.sayann.models.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Repository {
  public static List<Movie> getMoviesList() {
    List<Movie> mList = new ArrayList<>();
    mList.add(new Movie("Reservoir Dogs", "Quintin tarantino", 1998, 9.6, Arrays.asList("Comedy", "Action")));
    mList.add(new Movie("Django Unchanged", "Quintin tarantino", 2015, 8.0, Arrays.asList("Drama", "Comedy")));
    mList.add(new Movie("Bajirao Mastani", "Sanjay Leela Bhansali", 2017, 8.5, Arrays.asList("Drama", "Period")));
    mList.add(new Movie("3 Idiots", "Raju Hirani", 2008, 9.0, Arrays.asList("Drama", "Comedy")));
    mList.add(new Movie("Munnabhai MBBS", "Raju Hirani", 2005, 8.4, Arrays.asList("Drama", "Comedy", "Social")));
    mList.add(new Movie("Baishe Srabon", "Srijit Mukherjee", 2012, 9.5, Arrays.asList("Thriller", "Drama")));
    mList.add(new Movie("Kontho", "Sibu", 2019, 9.1, Arrays.asList("Social", "Drama")));
    mList.add(new Movie("Chotusone", "Srijit Mukherjee", 2015, 8.9, Arrays.asList("Thriller", "Drama")));
    mList.add(new Movie("Once Upon a time in Hollywood", "Quintin tarantino", 2019, 7.5, Arrays.asList("Drama", "Comedy")));
    return mList;
  }

  public static List<Student> getStudentsList() {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("Sayan Porya", 10, 17, 99.99, Arrays.asList("Bengali", "English", "Math", "Physics")));
    studentList.add(new Student("Ravindar Jadeja", 12, 20, 79.98, Arrays.asList("Hindi", "English", "History", "Sanskrit")));
    studentList.add(new Student("Ritabrato Sen", 9, 17, 82.50, Arrays.asList("Bengali", "Chemistry", "Math", "Geography")));
    studentList.add(new Student("Albert Einstein", 11, 18, 100, Arrays.asList("Astrophysics", "English", "Math", "Physics")));
    studentList.add(new Student("Frankestin", 10, 17, 99.99, Arrays.asList("Anatomy", "English", "Math", "Chemistry")));
    studentList.add(new Student("Alia Bhat", 7, 14, 59.2, Arrays.asList("GK", "Indian History", "Hindi", "ENglish")));
    studentList.add(new Student("Harish Robert", 5, 11, 70.6, Arrays.asList("Music", "English", "History", "Geography")));
    studentList.add(new Student("Tapan Midda", 12, 20, 42.45, Arrays.asList("Eng. Math", "English", "Chemistry", "Physics")));
    studentList.add(new Student("Jeff Bezos", 10, 17, 75.25, Arrays.asList("Business Studies", "Money Tree", "English", "Statistics")));
    return studentList;
  }
}
