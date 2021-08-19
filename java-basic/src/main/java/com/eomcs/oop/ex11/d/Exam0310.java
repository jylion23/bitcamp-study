// 인스턴스 메서드에 정의된 local class : 변수 접근
package com.eomcs.oop.ex11.d;

class D {

  void m1() {
    int a = 100;
    int b = 200;

    class X {

      // 로컬 클래스는 바깥 메서드(m1())의 로컬 변수(a,b)의 값을 저장할 필드를 자동으로 추가한다.
      // 1. 다음과 같이 컴파일 할 때 그 값을 저장할 필드(a)를 자동으로 추가한다.
      // 사용하는 변수에 대해서만 필드를 생성한다.
      // 로컬 변수 b는 사용하지 않기 때문에 b 값을 받을 필드는 생성하지 않는다.
      // int a ;
      // D outer;
      //      
      // 2. 로컬 클래스의 객체를 생성할 때 그 값을 사용할 수 있도록
      //생성자에 파라미터를 추가한다.
      //        public X(D Outer, int a) {
      //          this.a = a;
      //    }
      // .class 파일의 코드:
      //      class com.eomcs.oop.ex11.d.D$1X {
      //
      //        int v3; <== 로컬 클래스의 인스턴스 필드
      //        final synthetic com.eomcs.oop.ex11.d.D this$0;  <== 바깥 클래스의 인스턴스 주소 저장
      //        private final synthetic int val$v2; <== 바깥 메서드의 로컬 변수 저장
      //
      void f1() {
        //  그래서 다음과 같이 
        //  로컬 클래스에서는 자기것처럼 사용한다.
        System.out.println(a); // m1() 에 선언된 로컬 변수를 가리킨다
      }
    }

    X obj = new X();
    obj.f1();
  }

  static void m2() {
    int a = 100;
    int b = 200;

    class X {
      void f1() {
        System.out.println(b); 
      }
    }
  }
}

public class Exam0310 {

  public static void main(String[] args) {
    D obj = new D();
    obj.m1();
  }

}
