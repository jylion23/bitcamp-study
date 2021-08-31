// Stack 의 Iterator 와 Deque의 Iterator 의 차이점
package com.eomcs.basic.ex05;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Exam0220 {

  public static void main(String[] args) {
    ArrayDeque <String> stack = new ArrayDeque<>();
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    // stack 클래스와는 다르게 Deque 구현체의 Iterator는
    // stack 방식(LIFO)으로 데이터를 꺼낸다.
    // 결론!
    // - Iterator 를 통해 데이터를 꺼낼 때 stack 의 특성을 그대로 유지하고싶다면
    // Stack 클래스 대신 ArrayDeque 클래스를 사용하라
    Iterator<String> iterator = stack.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    // Iterator 설계 기법의 목적
    // 데이터 조회 방식(LIFO, FILO)에 상관없이
    // 일관된 방법으로 데이터를 조회할 수 있게 도와준다
    // - 즉 stack 처럼 입력 역순으로 꺼내든,
    // queue 처럼 입력 순으로 꺼내든 상관업이
    // 개발자는 hasNext(), next() 라는 동일한 메서드를 사용하여
    // 데이터를 조회한다.
  }

}

