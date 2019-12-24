package com.sayann.stream;

import com.sayann.database.Repository;
import com.sayann.models.Movie;
import com.sayann.models.Student;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
  static List<Student> students = Repository.getStudentsList();

  public static void main(String[] args) {
    System.out.println("Choose one option\n"
        + "1. For-Each\n"
        + "2. Filter\n"
        + "3. Map Example\n"
        + "4. Peek Example\n"
        + "5. Min Max\n"
        + "6. Flat Map Example");

    Scanner input = new Scanner(System.in);
    int option = input.nextInt();

    switch (option) {
      case 1:
        forEachExample(students);
        break;
      case 2:
        filterExample();
        break;
      case 3:
        mapExample();
        break;
      case 4:
        peekExample();
      case 5:
        findMaxAndMinUsingStreamApi();
        break;
      case 6:
        flatMapExample();
        break;
      default:
        System.out.println("Invalid selection");
    }
  }

  public static void forEachExample(List<Student> studentList) {
    System.out.println("Prints each item from the list");
    studentList.forEach(student -> {
      System.out.println(student.toString());
    });
  }

  /**
   * filters and prints students from the list with age more than 15
   */
  public static void filterExample() {
    System.out.println("Filters and prints students from the list with age more than 15");
    List<Student> ll = students.stream()
        .filter(student -> student.age > 15)
        .collect(Collectors.toList());
    forEachExample(ll);
  }

  public static void mapExample() {
    System.out.println("Calculates and prints the average mark of all students");
    List<Double> avMS = students
        .stream()
        .map(student -> student.avMark)
        .collect(Collectors.toList());
    double totalMarks = avMS
        .stream()
        .mapToDouble(mark -> mark)
        .sum();
    System.out.println("Average mark is " + totalMarks/students.size());
  }

  public static void peekExample() {
    System.out.println("Making named upper case using peek function");
    List<String> names = students
        .stream()
        .peek(student -> student.name = student.name.toUpperCase())
        .peek(System.out::println)
        .map(student -> student.name)
        .collect(Collectors.toList());

    System.out.println(names);
  }


  public static void findMaxAndMinUsingStreamApi() {
    System.out.println("Find the student with min age");
    Student minAgeFolk = students
        .stream()
        .min(Comparator.comparingInt(s -> s.age))
        .orElse(null);
    System.out.println("Min age guy is " + minAgeFolk);
    System.out.println("***************************\n\n");

    System.out.println("Finding the genius with max marks");
    Student genius = students.stream()
        .max(Comparator.comparingDouble(s -> s.avMark))
        .orElse(null);
    System.out.println("The genius guy is " + genius);
  }

  public static void flatMapExample() {
    System.out.println("Printing subjects and the number of students "
        + "pursuing the subject using stream api");

    Stream<SubjectStudent> ssStream = Repository.getStudentsList().stream()
       .flatMap(student -> student.subjects
           .stream()
           .map(subject -> new SubjectStudent(subject, student.name))
           .collect(Collectors.toList()).stream()
       );

    Map<String, Long> result = ssStream.collect(
        Collectors.groupingBy(subjectStudent -> subjectStudent.subjectName, Collectors.counting())
    );
    System.out.println("********************************************");
    System.out.println("Subject Name\t||\tNo. Of Students Studying");
    System.out.println("********************************************");
    result.forEach((k, v) -> System.out.println(k + "\t||\t" + v));
  }

  static class SubjectStudent {
    String subjectName, studentName;

    public SubjectStudent(String subjectName, String studentName) {
      this.subjectName = subjectName;
      this.studentName = studentName;
    }
  }
}
