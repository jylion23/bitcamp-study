package com.eomcs.basic.ex10;

public class Exam0110 {
  public static void main(String[] args) {
    long millis = System.currentTimeMillis();
    System.out.println(millis);

    new java.util.Date(millis);
    java.sql.Date d = new java.sql.Date(millis);
    System.out.println(d.toString());
  }
}
