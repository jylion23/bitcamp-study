package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;


//1) 회원 데이터를 입력 받는 코드를 별도의 메서드로 분리한다.
// => addMember() 메서드 정의 및 회원 등록 코드를 가져오기
// => main()과 addMember()가 서로 공유하는 변수는 클래스 변수로 만든다.
//2) 입력된 회원 데이터의 목록을 출력하는 코드를 별도의 메서드로 분리한다.
// => listMembers() 메서드 정의 및 관련된 코드를 가져오기
//3) 프로젝트 데이터를 입력 받는 코드를 별도의 메서드로 분리한다.
// => addProject() 메서드 정의 및 관련 코드를 가져오기
// => main()과 addProject()가 서로 공유하는 변수는 클래스 변수로 만든다.
//4) 입력된 프로젝트 데이터의 목록을 출력하는 코드를 별도의 메서드로 분리한다.
// => listProjects() 메서드 정의 및 관련된 코드를 가져오기
//5) 작업 데이터를 입력 받는 코드를 별도의 메서드로 분리한다.
// => addTask() 메서드 정의 및 관련 코드를 가져오기
// => main()과 addTask()가 서로 공유하는 변수는 클래스 변수로 만든다.
//6) 입력된 작업 데이터의 목록을 출력하는 코드를 별도의 메서드로 분리한다.
// => listTasks() 메서드 정의 및 관련된 코드를 가져오기
//7) 사용자로부터 값을 입력받는 코드를 별도의 메서드로 분리
//  => prompt() 메서드를 정의하고 관련된 코드를 가져오기
//8) 명령어뿐만 아니라 사용자로부터 입력을 받는 기능을 prompt()로부터 처리한다.
//9) prompt()가 작업한 결과를 클래스 변수에 담지말고 호출자에게 리턴
//10) prompt()의 기능 세분화
//11) promtString(), promptInt(), promptDate() 메서드의 코드를 정리한다.


public class App_02 {
  //

  static Scanner keyboardScan = new Scanner(System.in);

  // 회원 정보
  static final int LENGTH = 100;
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] password = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static Date[] registeredDate = new Date[LENGTH];
  static int size = 0;

  // 프로젝트 정보
  static final int PROJECT_LENGTH = 1000;
  static int[] pNo = new int[PROJECT_LENGTH];
  static String[] pTitle = new String[PROJECT_LENGTH];
  static String[] pContent = new String[PROJECT_LENGTH];
  static Date[] pStartDate = new Date[PROJECT_LENGTH];
  static Date[] pEndDate = new Date[PROJECT_LENGTH];
  static String[] pOwner = new String[PROJECT_LENGTH];
  static String[] pMembers = new String[PROJECT_LENGTH];
  static int pSize = 0;

  //작업 정보
  static final int TASK_LENGTH = 100;
  static int[] tNo = new int[TASK_LENGTH];
  static String[] tContent = new String[TASK_LENGTH];
  static Date[] tDeadline = new Date[TASK_LENGTH];
  static String[] tOwner = new String[TASK_LENGTH];
  static int[] tStatus = new int[TASK_LENGTH];
  static int tSize = 0;

  // 사용자가 입력한 값을 보관하는 변수

  public static void main(String[] args) {

    while (true) {
      String input = promptString("명령> ");


      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        //     메서드로 분리한 코드를 실행하기 
        addMember();

      } else if (input.equals("/member/list")) {
        listMember();

      }  else if (input.equals("/project/add")) {
        addProject();

      }  else if (input.equals("/project/list")) {
        listProjects();

      }  else if (input.equals("/task/add")) {
        taskAdd();

      }else if (input.equals("/task/list")) {
        taskList();
      }else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    keyboardScan.close();
  }



  static void addMember() {
    System.out.println("[회원 등록]");

    //    prompt("번호? ");
    //    no[size] = Integer.parseInt(input);

    no[size] = promptInt("번호? ");
    name[size] = promptString("이름? ");
    email[size] = promptString("이메일? ");
    password[size] = promptString("암호? ");
    photo[size] = promptString("사진? ");
    tel[size] = promptString("전화? ");
    registeredDate[size] = new Date(System.currentTimeMillis());

    size++;

  }

  static void listMember() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      // 번호, 이름, 이메일, 전화, 가입일
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          no[i], name[i], email[i], tel[i], registeredDate[i]);
    }
  }


  static void addProject() {
    System.out.println("[프로젝트 등록]");

    pNo[pSize] = promptInt("번호? ");
    pTitle[pSize] = promptString("프로젝트명? ");
    pContent[pSize] = promptString("내용? ");
    pStartDate[pSize] = promptDate("시작일? ");
    pEndDate[pSize] = promptDate("종료일? ");
    pOwner[pSize] = promptString("만든이? ");
    pMembers[pSize] = promptString("팀원? ");

    pSize++;
  }

  static void listProjects() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < pSize; i++) {
      // 번호, 프로젝트명, 시작일, 종료일, 만든이 
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          pNo[i], pTitle[i], pStartDate[i], pEndDate[i], pOwner[i]);
    }
  }

  static void taskAdd() {
    System.out.println("[작업 등록]");

    tNo[tSize] = promptInt("작업 번호? ");
    tContent[tSize] = promptString("내용? ");
    tDeadline[tSize] = promptDate("마감일? ");

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    tStatus[tSize] = promptInt("> ");
    tOwner[tSize] = promptString("담당자? ");

    tSize++;
  }

  static void taskList() {
    System.out.println("[작업 목록]");


    for (int i = 0; i < tSize; i++) {
      String stateLabel = null;
      switch (tStatus[i]) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }
      // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          tNo[i], tContent[i], tDeadline[i], stateLabel, tOwner[i]);
    }
  }

  //  prompt();
  /* 
   *
   *
   *
   *
   *
   */

  //  사용자로부터 문자열을 입력받는 기능 수행

  static String promptString(String title) {
    System.out.print(title); 
    return keyboardScan.nextLine();
  }
  static int promptInt(String title) {
    return Integer.parseInt(promptString(title));
  }
  static Date promptDate(String title) {
    return Date.valueOf(promptString(title));
  }

}
