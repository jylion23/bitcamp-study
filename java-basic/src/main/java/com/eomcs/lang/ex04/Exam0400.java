package com.eomcs.lang.ex04;

import java.sql.Date;

//# 변수의 종류
//- 자바 원시 타입의 값을 저장하는 변수와 메모리 주소를 저장하는 변수가 있다.
//- 자바 원시 타입 변수(primitive variable)
//    정수, 부동소수점, 논리, 문자코드의 값을
//- 레퍼런스 변수(referece variable)
//    자바 원시 타입의 값을 제외한 모든 값
//
public class Exam0400 {
  public static void main(String[] args) {
    //자바 원시 데이터 타입 변수
    //- 정수
    byte b;  // 1바이트 크기의 메모리
    short s; // 2바이트 크기의 메모리 
    int i;   // 4바이트 크기의 메모리 
    long l;  // 8바이트 크기의 메모리

    //- 부동소수
    float f;   // 4바이트 크기의 메모리
    double d;  // 8바이트 크기의 메모리

    //- 문자코드
    char c;  // 2바이트 크기의 메모리

    //- 논리
    boolean bool;  // 자바 언어 명세서에는 메모리의 크기가 정의되어 있지 않다. 다만 JVM 명세서에는 int 로 다룬다고 나와있다.

    //레퍼런스 변수
    String str; // 자바 언어 명세서에는 메모리의 크기가 정의되어 있지 않다. 메모리 주소를 저장할 만큼 큰 크기
    Date date;  // 자바 언어 명세서에는 메모리의 크기가 정의되어 있지 않다. 메모리 주소를 저장할 만큼 큰 크기
  }
}

// 메모리 크기에 따라 저장할 수 있는 값의 범위
// 1) primitive data type (원시 데이터 타입)
// - 정수
//   - byte   : 1byte 메모리 (-128 ~ 127)
//   - short  : 2byte 메모리 (-32768 ~ 32767)
//   - int    : 4byte 메모리 (약 -21억 ~ 21억)
//   - long   : 8byte 메모리 (약 -922경 ~ 922경)
// - 부동소수점
//   - float  : 4byte 메모리 (유효자릿수 7자리)
//   - double : 8byte 메모리 (유효자릿수 15자리)
// - 문자
//   - char   : 2byte 메모리 (0 ~ 65535). UCS-2 코드 값 저장.
// - 논리값
//   - boolean : JVM에서 4 바이트 int 메모리를 사용한다.
//               배열일 경우 1 바이트 byte 메모리를 사용한다.
//
// 2) reference(레퍼런스)
//    데이터가 저장된 메모리의 주소를 저장하는 메모리.
// - 문자열(주소)
//   - String : 문자열이 저장된 메모리의 주소를 저장한다.
//              프로그래밍 입문 단계에서는 그냥 문자열을 저장하는 메모리로 생각하라!
// - 날짜(주소)
//   - Date : 날짜 값이 저장된 메모리의 주소를 저장한다.
//            프로그래밍 입문 단계에서는 그냥 날짜를 저장하는 메모리로 생각하라!
// - 레퍼런스에 대한 자세한 사항은 추후에 자세히 설명할 것이다.
