package com.sayann.models;

import java.util.List;

public class Student {
  public String name;
  public int _class;
  public int age;
  public double avMark;
  public List<String> subjects;
  public Student(String name, int _class, int age, double avMark, List<String> subjects) {
    this.name = name;
    this._class = _class;
    this.age = age;
    this.avMark = avMark;
    this.subjects = subjects;
  }

  @Override public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", _class=" + _class +
        ", age=" + age +
        ", avMark=" + avMark +
        '}';
  }
}
