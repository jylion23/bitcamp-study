package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

// 1. 배열 변수로 여러 프로젝트 정보 처리
// 2. 반복문을 사용
public class App2 {

  public static void main(String[] args) {

    Scanner keyboardScan = new Scanner(System.in);

    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] title = new String[LENGTH];
    String[] content = new String[LENGTH];
    Date[] startDate = new Date[LENGTH];
    Date[] endDate = new Date[LENGTH];
    String[] owner = new String[LENGTH];
    String[] members = new String[LENGTH];

    int size = 0;

    System.out.println("[프로젝트]");

    for(int i = 0 ; i < LENGTH; i++ )
      System.out.print("번호? ");
    no [i] = keyboardScan.nextInt();
    keyboardScan.nextLine(); // 번호 뒤에 남아 있는 줄바꿈 코드를 제거한다.

    System.out.print("프로젝트명? ");
    title [i]= keyboardScan.nextLine();

    System.out.print("내용? ");
    content [i] = keyboardScan.nextLine();

    System.out.print("시작일? ");
    startDate [i] = Date.valueOf(keyboardScan.nextLine());

    System.out.print("종료일? ");
    endDate [i] = Date.valueOf(keyboardScan.nextLine());

    System.out.print("만든이? ");
    owner [i] = keyboardScan.nextLine();

    System.out.print("팀원? ");
    members [i] = keyboardScan.nextLine();

    keyboardScan.close();

    System.out.println("--------------------------------");

    System.out.printf("번호: %d\n", no);
    System.out.printf("프로젝트명: %s\n", title);
    System.out.printf("내용: %s\n", content);
    System.out.printf("시작일: %s\n", startDate);
    System.out.printf("종료일: %s\n", endDate);
    System.out.printf("만든이: %s\n", owner);
    System.out.printf("팀원: %s\n", members);
  }
}
//package com.eomcs.pms;
//
//import java.sql.Date;
//import java.util.Scanner;
//
//public class App2 {
//
//  public static void main(String[] args) {
//    System.out.println("[프로젝트]");
//
//    Scanner keyboardScan = new Scanner(System.in);
//
//    // 최대 100개의 프로젝트 정보를 저장할 메모리 준비
//    // => 배열의 크기를 미리 변수에 저장하여 사용한다.
//    // => 나중에 배열의 크기를 바꾸기 쉽다.

//    
//    for (int i = 0; i < LENGTH; i++) {
//      System.out.print("번호? ");
//      no[i] = Integer.valueOf(keyboardScan.nextLine());
//
//      System.out.print("프로젝트명? ");
//      title[i] = keyboardScan.nextLine();
//
//      System.out.print("내용? ");
//      content[i] = keyboardScan.nextLine();
//
//      System.out.print("시작일? ");
//      startDate[i] = Date.valueOf(keyboardScan.nextLine());
//
//      System.out.print("종료일? ");
//      endDate[i] = Date.valueOf(keyboardScan.nextLine());
//
//      System.out.print("만든이? ");
//      owner[i] = keyboardScan.nextLine();
//
//      System.out.print("팀원? ");
//      members[i] = keyboardScan.nextLine();
//
//      size++;
//      System.out.println(); // 빈 줄 출력
//
//      System.out.print("계속 입력하시겠습니까?(y/N) ");
//      String str = keyboardScan.nextLine();
//      if (!str.equalsIgnoreCase("y")) {
//        break;
//      }
//      System.out.println(); // 빈 줄 출력
//    }
//
//    keyboardScan.close();
//
//    System.out.println("--------------------------------");
//
//
//    for (int i = 0; i < size; i++) {
//      // 번호, 프로젝트명, 시작일, 종료일, 만든이
//      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
//          no[i], title[i], startDate[i], endDate[i], owner[i]);
//    }
//  }
//}
