// Stack 과 Deque 
package com.eomcs.basic.ex05;

import java.util.ArrayDeque;
import java.util.Stack;

public class Exam0210 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    //Deque 인터페이스
    // - "Double ended queue" 의 약자이다
    // 즉 앞, 뒤 모두 양방향에서 값을 넣고 꺼낼 수 있다.
    // - 그래서 queue 로도 stack 으로도 사용할 수 있다

    // - stack queue 둘 다 사 용할 수 있도록 queue 와 stack 사용법을 모두 정의한 인터페이스

    ArrayDeque <String> stack1 = new ArrayDeque<>();
    // push() - 스택의 맨 마지막에 값을 추가한다.
    stack1.push("aaa");
    stack1.push("bbb");
    stack1.push("ccc");
    // 다음과 같이 
    while (!stack1.isEmpty()) {
      System.out.println(stack1.pop());
    }
  }

}

